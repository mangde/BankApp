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
import org.testng.Assert;
import org.testng.annotations.Test;
import com.nuance.him.config.transactionConfig.TransactionDaoConfig;
import com.nuance.him.dao.transaction.TransactionDao;

/**
 * {@link TransactionDaoConfigTest}.
 */
@ContextConfiguration(classes = TransactionDaoConfig.class)
public class TransactionDaoConfigTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TransactionDao transactionDAO;

    /**
     * for bean class of transactionDao.
     */
    @Test
    public void testTransactionDao() {
        Assert.assertNotNull(transactionDAO);
    }
}
