/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.config.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.nuance.him.config.customerconfig.CustomerDaoConfig;
import com.nuance.him.dao.customer.CustomerDao;

/**
 * Tests for CustomerDaoConfiguration.
 */
@ContextConfiguration(classes = CustomerDaoConfig.class)
public class CustomerDaoConfigTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private CustomerDao customerDao;

    /**
     * Tests the CustomerDao bean.
     */
    @Test
    public void testCustomerDao() {
        Assert.assertNotNull(customerDao);
    }
}
