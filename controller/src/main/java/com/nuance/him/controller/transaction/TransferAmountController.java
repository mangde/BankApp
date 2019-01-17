/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
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
import com.nuance.him.model.transaction.TransferAmount;
import com.nuance.him.service.serviceexception.TransferAmountServiceException;
import com.nuance.him.service.transaction.TransferAmountService;
import java.util.List;
import java.util.Set;

/**
 * TransferAmountController class.
 */
@RestController
@RequestMapping("${baseURL}")
@Validated
public class TransferAmountController {

    private static final String TRANSFER_AMOUNT = "/transferAmount";
    private static final String TRANSACTION_HISTORY = "/transactionHistory";
    private final TransferAmountService transferAmountService;

    /**
     * constructor of class {@link TransferAmountController}.
     *
     * @param transferAmountService instance of class {@link TransferAmountService}
     * @param accountService
     */
    public TransferAmountController(TransferAmountService transferAmountService) {
        this.transferAmountService = transferAmountService;
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
    @RequestMapping(value = TRANSFER_AMOUNT, method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<TransferAmount> transferAmountApi(@RequestParam("accFrom") @Min(value = 1, message = "Account number Not empty") int accountFrom,
        @RequestParam("accTo") @Min(1) int accIdTo,
        @RequestParam("amount") @Min(1) @Digits(integer = 6, fraction = 2, message = "check input amount should fraction up to 2 digits") double amount,
        @RequestParam("description") String description) {
        try {
            TransferAmount transferAmount = new TransferAmount(accountFrom, accIdTo, amount, description);
            int transactionId = transferAmountService.transferAmount(transferAmount);
            return new ResponseEntity("TransferAmount successfully  TransactionId: " + transactionId, HttpStatus.CREATED);
        }
        catch (TransferAmountServiceException e) {
            return new ResponseEntity(new CustomErrorType(" transfer Amount failed " + e.getCause().getMessage()),
                HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * TransferAmount History Method.
     *
     * @param accNumber accountNumber
     * @return List of transactions
     */
    @RequestMapping(value = TRANSACTION_HISTORY, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<TransferAmount> transactionHistory(@RequestParam("accNumber") int accNumber) {
        try {
            List<TransferAmount> transferAmounts = transferAmountService.getTransactionHistory(accNumber);
            return new ResponseEntity(transferAmounts, HttpStatus.OK);
        }
        catch (TransferAmountServiceException t) {
            return new ResponseEntity(new CustomErrorType("getting transfer history failed "),
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
