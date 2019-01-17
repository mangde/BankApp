/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */
package com.nuance.him.config.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import com.nuance.him.config.accountconfig.AccountControllerConfig;
import com.nuance.him.config.transactionConfig.TransactionControllerConfig;
import com.nuance.him.controller.transaction.TransactionController;
import com.nuance.him.service.test.account.AccountService;
import static org.testng.Assert.assertNotNull;

/**
 * {@link TransactionControllerConfig} Test class.
 */
@ContextConfiguration(classes = { TransactionControllerConfig.class, AccountControllerConfig.class })
public class TransactionControllerConfigTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TransactionController transactionController;
    @Autowired
    private AccountService accountService;

    /**
     * {@link TransactionController} accountService bean testing.
     */
    @Test
    public void testAccountDAO() {
        assertNotNull(transactionController);
        assertNotNull(accountService);
    }
}
