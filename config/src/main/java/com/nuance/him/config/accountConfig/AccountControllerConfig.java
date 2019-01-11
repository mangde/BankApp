/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.config.accountConfig;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import com.nuance.him.controller.account.AccountController;
import com.nuance.him.service.account.AccountService;
import static org.springframework.util.Assert.notNull;

@Configuration
@Import(AccountServiceConfig.class)
@PropertySource("classpath:application.properties")
public class AccountControllerConfig {
    private static final Logger log = LoggerFactory.getLogger(AccountControllerConfig.class);

    @Autowired
    private AccountService accountService;


    /**
     * Validate the variables.
     */
    @PostConstruct
    public void postConstruct() {
        notNull(accountService, "missing bean accountService");
    }

    /**
     * creating controller bean
     * @return bean controller
     */
    @Bean
    public AccountController accountController() {
        log.info("setting up AccountController  bean");
        return new AccountController(accountService);
    }

    /**
     * bean  property resource
     * @return bean
     */

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
