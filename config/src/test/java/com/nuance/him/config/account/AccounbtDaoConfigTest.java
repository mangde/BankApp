/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */
package com.nuance.him.config.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import com.nuance.him.config.accountConfig.AccountDaoConfig;
import com.nuance.him.dao.account.AccountDAO;
import static org.junit.Assert.assertNotNull;
@ContextConfiguration(classes = { AccountDaoConfig.class})
public class AccounbtDaoConfigTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AccountDAO accountDAO;

    /**
     * for bean class of accountDao
     */
    @Test
    public void testAccountDao() {
        assertNotNull(accountDAO);
    }
}
