/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.controller.account;

import com.nuance.him.controller.exception.CustomErrorType;
import com.nuance.him.model.accountmodel.Account;
import com.nuance.him.service.account.AccountService;
import com.nuance.him.service.serviceexception.AccountServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@SuppressWarnings({"Annotation", "PublicMethodWithoutLogging"})
@RestController
@PropertySource(value = { "classpath:application.properties" })
@RequestMapping(value = "${baseURL}")
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
    private static final String ADD_ACCOUNT = "/addAccount";
    private final AccountService accountService;

    /**
     * Constructor for initialize accountService
     *
     * @param accountService instance of {@link AccountService}
     */
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = AccountController.ADD_ACCOUNT, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Account> addNewAccount(@Valid @RequestParam("type") @Min(5) String type,
                                                 @RequestParam("balance") @Valid @Min(5) double balance,
                                                 @Valid @RequestParam("customerId") @Min(5) int customerId) {
        try {
            int accountId = accountService.addAccount(new Account(type, balance, customerId));
            return new ResponseEntity("Customer Account  is Open successfully\n customer Account ID: "
                    + accountId, HttpStatus.CREATED);
        }
        catch (NumberFormatException nfe) {
            return new ResponseEntity(new CustomErrorType(nfe.getCause().getMessage()), HttpStatus.BAD_REQUEST);
        }
        catch (AccountServiceException e) {
            return new ResponseEntity(new CustomErrorType("Error in  Add customer Account "),
                    HttpStatus.EXPECTATION_FAILED);
        }
    }
}
