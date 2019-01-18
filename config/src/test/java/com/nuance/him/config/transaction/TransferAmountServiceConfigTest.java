/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.config.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.nuance.him.config.transactionconfig.TransferAmountServiceConfig;
import com.nuance.him.service.transaction.TransferAmountService;

/**
 * {@link TransferAmountServiceConfigTest}.
 */
@ContextConfiguration(classes = TransferAmountServiceConfig.class)
public class TransferAmountServiceConfigTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TransferAmountService transferAmountService;

    /**
     * Tests the transferAmountService bean.
     */
    @Test
    public void testTransactionServices() {
        Assert.assertNotNull(transferAmountService);
    }
}
