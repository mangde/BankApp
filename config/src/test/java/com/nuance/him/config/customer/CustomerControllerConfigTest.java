/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.* COPYRIGHT:
 * Warning: This product is protected by United States copyright law.
 * Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */


package com.nuance.him.config.customer;

import com.nuance.him.config.customerconfig.CustomerControllerConfig;
import com.nuance.him.controller.customer.CustomerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Tests for controller bean.
 */
@ContextConfiguration(classes = CustomerControllerConfig.class)
public class  CustomerControllerConfigTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private CustomerController customerController;

    /**
     * Tests the CustomerDao bean.
     */
    @Test
    public void testCustomerDao() {
        Assert.assertNotNull(customerController);
    }
}
