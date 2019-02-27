/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.config.transaction;
import com.nuance.him.config.accountconfig.AccountControllerConfig;
import com.nuance.him.config.transactionconfig.TransferAmountControllerConfig;
import com.nuance.him.controller.transaction.TransferAmountController;
import com.nuance.him.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNotNull;

/**
 * {@link TransferAmountControllerConfig} Test class.
 */
@ContextConfiguration(classes = { TransferAmountControllerConfig.class, AccountControllerConfig.class })
public class TransferAmountControllerConfigTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TransferAmountController transferAmountController;
    @Autowired
    private AccountService accountService;

    /**
     * {@link TransferAmountController} accountService bean testing.
     */
    @Test
    public void testAccountDAO() {
        assertNotNull(transferAmountController);
        assertNotNull(accountService);
    }
}
