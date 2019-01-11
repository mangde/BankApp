/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.controller.account;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.nuance.him.controller.exception.CustomErrorType;
import com.nuance.him.model.accountmodel.Account;
import com.nuance.him.service.account.AccountService;
import com.nuance.him.service.serviceexception.AccountServiceException;

@RestController
@PropertySource(value = { "classpath:application.properties" })
@RequestMapping(value = "${baseURL}")
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
    private static final String ADD_ACCOOUNT = "/addAccount";
    private AccountService accountService;

    /**
     * Constructor for initialize accountService
     *
     * @param accountService instance of {@link AccountService}
     */
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = ADD_ACCOOUNT, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Account> addNewAccount(@Valid @RequestParam("type") @Min(5) String type, @RequestParam("balance") @Valid @Min(5) double balance, @Valid @RequestParam("customerId") @Min(5) int customerId) {
        try {
            Account account = new Account(type, balance, customerId);
            log.info("controller add account{}", account);
            int accountId = accountService.addAccount(account);
            return new ResponseEntity("Customer Account  is Open successfully\n customer Account ID: " + accountId, HttpStatus.CREATED);
        }
        catch (NumberFormatException nfe) {
            return new ResponseEntity(new CustomErrorType(nfe.getCause().getMessage()), HttpStatus.BAD_REQUEST);
        }
        catch (AccountServiceException e) {
            return new ResponseEntity(new CustomErrorType("Error in  Add customer Account "), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
