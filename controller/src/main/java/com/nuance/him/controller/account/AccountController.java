/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.controller.account;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.nuance.him.controller.exception.CustomErrorType;
import com.nuance.him.model.accountmodel.Account;
import com.nuance.him.service.test.account.AccountService;
import com.nuance.him.service.test.serviceexception.AccountServiceException;
import java.util.Set;

/**
 * Account controller.
 */
@RestController
@RequestMapping("${baseURL}")
@Validated
public class AccountController {

    private static final String OPEN_ACCOUNT = "/addAccount";
    private static final String GET_BALANCE = "/getBalance";
    private static final String DEPOSITE_AMOUNT = "/deposite";
    private static final String ACCOUNT_DETAILS = "/accountDetail";
    private final AccountService accountService;

    /**
     * Constructor for initialize accountService.
     *
     * @param accountService instance of {@link AccountService}
     */
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Request Method for Open New Account.
     *
     * @param type account type
     * @param balance opening Balance
     * @param customerId customer id
     * @return AccountId with status CREATED.
     */
    @RequestMapping(value = AccountController.OPEN_ACCOUNT, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addNewAccount(@RequestParam("type") @NotEmpty @Pattern(regexp = "[a-z A-z]+", message = "AccountType should contain Alphabets only") String type,
        @RequestParam("balance") @Digits(integer = 6, fraction = 2, message = "wrong balance inputs") double balance,
        @RequestParam("customerId") @Min(value = 0, message = "customer Id Should not empty") int customerId) {
        try {
            int accountId = accountService.addAccount(new Account(type, balance, customerId));
            return new ResponseEntity("Customer Account  is Open successfully\n customer Account ID: "
                + accountId, HttpStatus.CREATED);
        }
        catch (AccountServiceException e) {
            return new ResponseEntity(new CustomErrorType("Error in  Add customer Account "),
                HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Request Method Fro check current balance.
     *
     * @param accNumber account Number
     * @return Current Available Balance
     */
    @RequestMapping(value = GET_BALANCE, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getCurrentBalance(@RequestParam("accNumber") int accNumber) {
        try {
            double currentbalance = accountService.getCurrentBalance(accNumber);
            return new ResponseEntity("Current Available Balance is : "
                + currentbalance, HttpStatus.OK);
        }
        catch (AccountServiceException e) {
            return new ResponseEntity(new CustomErrorType("current balance exception"),
                HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    /**
     * Request Method for Deposite Amount.
     *
     * @param accNumber account Number to be credited
     * @param amount Amount
     * @return new Updated Balance
     */
    @RequestMapping(value = DEPOSITE_AMOUNT, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity deposite(@RequestParam("accNumber") int accNumber, @RequestParam("amount") @Digits(integer = 6, fraction = 2, message = "wrong balance inputs") double amount) {
        try {
            double newBalance = accountService.depositeAmount(accNumber, amount);
            return new ResponseEntity("Amount deposited successfully \n Current Available Balance is : " + newBalance, HttpStatus.OK);
        }
        catch (AccountServiceException e) {
            return new ResponseEntity(new CustomErrorType("Failed to Deposite balance "),
                HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    /**
     * Check Account Details.
     *
     * @param accNumber Account Number
     * @return Account Details
     */
    @RequestMapping(value = ACCOUNT_DETAILS, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<Account> getAccountDetails(@RequestParam("accNumber") int accNumber) {
        try {
            Account account = accountService.getAccountDetail(accNumber);
            return new ResponseEntity("Account Details : " + account, HttpStatus.OK);
        }
        catch (AccountServiceException e) {
            return new ResponseEntity(new CustomErrorType("Account Not Found"),
                HttpStatus.NOT_FOUND);
        }
    }

    /**
     * handle validation.
     *
     * @param exception constraint voilation exception
     * @return exeptio message
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
