/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.nuance.him.config.accountconfig.AccountControllerConfig;
import com.nuance.him.config.customerconfig.CustomerControllerConfig;
import com.nuance.him.config.transactionconfig.TransferAmountControllerConfig;

/**
 * Start point for application.
 */
@Import(BankMainApp.Config.class)
@SpringBootApplication
public class BankMainApp {

    /**
     * @param args method arguments String array.
     */
    public static void main(final String[] args) {
        SpringApplication.run(BankMainApp.class, args);
    }

    /**
     * Aggregates all application Spring config into one.
     */
    @Configuration
    @Import({ CustomerControllerConfig.class, AccountControllerConfig.class, TransferAmountControllerConfig.class })
    public static class Config {}
}
