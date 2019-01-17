/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.config.transactionConfig;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import com.nuance.him.controller.transaction.TransactionController;
import com.nuance.him.service.test.account.AccountService;
import com.nuance.him.service.test.transaction.TransactionServices;
import static org.springframework.util.Assert.notNull;

/**
 * {@link TransactionController} configuration.
 */
@Configuration
@Import(TransactionServiceConfig.class)
public class TransactionControllerConfig {

    @Autowired
    private TransactionServices transactionService;
    @Autowired
    private AccountService accountService;

    /**
     * bean  property resource.
     *
     * @return bean
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * Validate the variables.
     */
    @PostConstruct
    public void postConstruct() {
        notNull(transactionService, "missing bean transactionService");
        notNull(accountService, "missing bean accountService");
    }

    /**
     * creating TransactionController bean.
     *
     * @return bean transactionController
     */
    @Bean
    public TransactionController transactionController() {
        return new TransactionController(transactionService, accountService);
    }

    /**
     * bean for validation.
     *
     * @return validation bean
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
