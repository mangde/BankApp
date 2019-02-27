/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.config.interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import com.nuance.him.config.interestconfig.InterestServiceConfig;
import com.nuance.him.service.account.AccountService;
import com.nuance.him.service.account.InterestCalculatorService;
import static org.testng.Assert.assertNotNull;

/**
 * test class of interestCalculatorService bean.
 */
@ContextConfiguration(classes = InterestServiceConfig.class)
public class InterestServiceConfigTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private InterestCalculatorService interestCalculatorService;
    @Autowired
    private AccountService accountService;

    /**
     * Tests the interestCalculatorService bean.
     */
    @Test
    public void testInterestServices() {
        assertNotNull(interestCalculatorService);
        assertNotNull(accountService);
    }
}
