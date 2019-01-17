/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.config.transactionConfig;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import com.nuance.him.config.accountconfig.AccountServiceConfig;
import com.nuance.him.controller.transaction.TransferAmountController;
import com.nuance.him.service.transaction.TransferAmountService;
import static org.springframework.util.Assert.notNull;

/**
 * {@link TransferAmountController} configuration.
 */
@Configuration
@Import({ TransferAmountServiceConfig.class, AccountServiceConfig.class })
public class TransferAmountControllerConfig {

    @Autowired
    private TransferAmountService transactionService;

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
    }

    /**
     * creating TransferAmountController bean.
     *
     * @return bean transactionController
     */
    @Bean
    public TransferAmountController transactionController() {
        return new TransferAmountController(transactionService);
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
