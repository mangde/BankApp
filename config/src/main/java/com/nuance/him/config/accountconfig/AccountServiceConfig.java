/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.config.accountconfig;

import com.nuance.him.dao.account.AccountDAO;
import com.nuance.him.service.account.AccountService;
import com.nuance.him.service.account.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

import static org.apache.commons.lang3.Validate.notNull;

@Configuration
@Import(AccountDaoConfig.class)
public class AccountServiceConfig {


    @Autowired
    private AccountDAO accountDAO;

    /**
     * Validate the variables.
     */
    @PostConstruct
    public void postConstruct() {
        notNull(this.accountDAO, "missing bean accountDAO");
    }

@Bean
    public AccountService accountService(){
        return new AccountServiceImpl(accountDAO);
}

}
