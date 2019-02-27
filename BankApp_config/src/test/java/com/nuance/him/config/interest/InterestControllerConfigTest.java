/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.config.interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import com.nuance.him.config.interestconfig.InterestControllerConfig;
import com.nuance.him.controller.account.InterestController;
import static org.testng.Assert.assertNotNull;

/**
 * TestInterestControllerConfig bean class.
 */
@ContextConfiguration(classes = InterestControllerConfig.class)
public class InterestControllerConfigTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private InterestController interestController;

    /**
     * test  bean creation.
     */
    @Test
    public void testInterestController() {
        assertNotNull(interestController);
    }


}
