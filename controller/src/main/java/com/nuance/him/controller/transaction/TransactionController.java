/*
 *
 *   COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *    Warning: This product is protected by United States copyright law.  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 *
 */
package com.nuance.him.controller.transaction;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.nuance.him.controller.exception.CustomErrorType;
import com.nuance.him.model.accountmodel.Account;
import com.nuance.him.model.transaction.Transaction;
import com.nuance.him.service.test.account.AccountService;
import com.nuance.him.service.test.serviceexception.AccountServiceException;
import com.nuance.him.service.test.serviceexception.TransactionServiceException;
import com.nuance.him.service.test.transaction.TransactionServices;
import java.util.List;
import java.util.Set;

/**
 * TransactionController class.
 */
@RestController
@RequestMapping("${baseURL}")
@Validated
public class TransactionController {

    private static final String TRANSFER_AMOUNT = "/transferAmount";
    private static final String TRANSACTION_HISTORY = "/transactionHistory";
    private final TransactionServices transactionServices;
    private final AccountService accountService;

    /**
     * constructor of class {@link TransactionController}.
     *
     * @param transactionServices instance of class {@link TransactionServices}
     * @param accountService instance of class {@link AccountService}
     */
    public TransactionController(TransactionServices transactionServices, AccountService accountService) {
        this.transactionServices = transactionServices;
        this.accountService = accountService;
    }

    /**
     * Request method for transfer Amount form one account to another.
     *
     * @param accountFrom Debit Account Number
     * @param accIdTo Credit Account Number
     * @param amount Amount to be Transfer
     * @param description message
     * @return transactionId
     */
    @RequestMapping(value = TransactionController.TRANSFER_AMOUNT, method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Transaction> transferAmountApi(@RequestParam("accFrom") @Min(value = 1, message = "Account number Not empty") int accountFrom,
        @RequestParam("accTo") @Min(1) int accIdTo,
        @RequestParam("amount") @Min(1) @Digits(integer = 6, fraction = 2, message = "check input amount should fraction up to 2 digits") double amount,
        @RequestParam("description") String description) {
        double currentBalanceFromAc;
        try {
            Account account = accountService.getAccountDetail(accIdTo);
        }
        catch (AccountServiceException e) {
            return new ResponseEntity(new CustomErrorType("Credit Account Not found AccountNumber: " + accIdTo), HttpStatus.NOT_FOUND);
        }
        try {
            currentBalanceFromAc = accountService.getCurrentBalance(accountFrom);
            if (currentBalanceFromAc < amount) {
                return new ResponseEntity(new CustomErrorType("Insufficiant balance to transfer, current Balance" + currentBalanceFromAc), HttpStatus.EXPECTATION_FAILED);
            }
        }
        catch (AccountServiceException e) {
            return new ResponseEntity(new CustomErrorType("Debit Account Not found AccountNumber: " + accountFrom), HttpStatus.NOT_FOUND);
        }
        try {
            Transaction transaction = new Transaction(accountFrom, accIdTo, amount, description);
            int transactionId = transactionServices.transferAmount(transaction, currentBalanceFromAc);
            accountService.depositeAmount(accIdTo, amount);
            return new ResponseEntity("Transaction successfully  TransactionId: " + transactionId, HttpStatus.CREATED);
        }
        catch (TransactionServiceException e) {
            return new ResponseEntity(new CustomErrorType("Error in  Transfer Amount "),
                HttpStatus.EXPECTATION_FAILED);
        }
        catch (AccountServiceException e) {
            return new ResponseEntity(new CustomErrorType("error  in Update deposite amount"),
                HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Transaction History Method.
     *
     * @param accNumber accountNumber
     * @return List of transactions
     */
    @RequestMapping(value = TRANSACTION_HISTORY, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity transactionHistory(@RequestParam("accNumber") int accNumber) {
        try {
            List<Transaction> transactions = transactionServices.getTransactionHistory(accNumber);
            return new ResponseEntity(transactions, HttpStatus.OK);
        }
        catch (TransactionServiceException t) {
            return new ResponseEntity(new CustomErrorType("Error in  Transfer Amount "),
                HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Handle Validation Exception.
     *
     * @param exception exception
     * @return exception message
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handle(ConstraintViolationException exception) {
        String message = "";
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            message += violation.getMessage().concat(";");
        }
        return message;
    }
}