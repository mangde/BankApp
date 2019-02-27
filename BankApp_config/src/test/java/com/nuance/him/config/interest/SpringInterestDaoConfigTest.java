/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.config.interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.nuance.him.config.interestconfig.InterestDaoConfig;
import com.nuance.him.dao.account.SpringInterestCalcDao;

/**
 * Test InterestCalcDaoConfig Class.
 */
@ContextConfiguration(classes = InterestDaoConfig.class)
public class SpringInterestDaoConfigTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private SpringInterestCalcDao springInterestCalcDao;

    /**
     * customer  bean class of accountDao.
     */
    @Test
    public void testInterestCalcDao() {
        Assert.assertNotNull(springInterestCalcDao);
    }
}
