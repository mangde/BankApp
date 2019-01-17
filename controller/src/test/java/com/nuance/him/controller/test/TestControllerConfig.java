/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.controller.test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.nuance.him.controller.account.AccountController;
import com.nuance.him.controller.customer.CustomerController;
import com.nuance.him.controller.transaction.TransactionController;
import com.nuance.him.service.test.account.AccountService;
import com.nuance.him.service.test.account.AccountServiceImpl;
import com.nuance.him.service.test.customer.CustomerService;
import com.nuance.him.service.test.transaction.TransactionServices;

/**
 * class for creating controller bean for  testing testController.
 */
@Configuration
@EnableWebMvc
public class TestControllerConfig {

    @Mock
    private CustomerService customerService;
    @Mock
    private TransactionServices transactionServices;

    /**
     * crating bean for accessing values form property file.
     *
     * @return propertySource Bean
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * accountService bean.
     *
     * @return accountService
     */
    @Bean
    public AccountService accountService() {
        return Mockito.mock(AccountServiceImpl.class);
    }

    /**
     * creating {@link CustomerController} bean.
     *
     * @return controller bean
     */
    @Bean
    public CustomerController customerController() {
        MockitoAnnotations.initMocks(this);
        return new CustomerController(customerService);
    }

    /**
     * creating {@link AccountController bean}.
     *
     * @return AccountService bean
     */
    @Bean
    public AccountController accountController() {
        MockitoAnnotations.initMocks(this);
        return new AccountController(accountService());
    }

    /**
     * Setting bean for testing {@link TransactionController}.
     *
     * @return transactionServices bean
     */
    @Bean
    public TransactionController transactionController() {
        MockitoAnnotations.initMocks(this);
        return new TransactionController(transactionServices, accountService());
    }
}

