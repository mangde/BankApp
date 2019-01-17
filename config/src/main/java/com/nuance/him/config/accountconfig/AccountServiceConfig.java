/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.config.accountconfig;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.nuance.him.dao.account.AccountDao;
import com.nuance.him.service.test.account.AccountService;
import com.nuance.him.service.test.account.AccountServiceImpl;
import static org.apache.commons.lang3.Validate.notNull;

/**
 * AccountServiceConfig class.
 */
@Configuration
@Import(AccountDaoConfig.class)
public class AccountServiceConfig {

    @Autowired
    private AccountDao accountDAO;

    /**
     * Validate the variables.
     */
    @PostConstruct
    public void postConstruct() {
        notNull(accountDAO, "missing bean accountDAO");
    }

    /**
     * {@link AccountService}.
     *
     * @return bean {@link AccountServiceImpl}
     */
    @Bean
    public AccountService accountService() {
        return new AccountServiceImpl(accountDAO);
    }
}
