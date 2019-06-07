
package com.nuance.him.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.nuance.him.config.accountconfig.AccountControllerConfig;
import com.nuance.him.config.atm.AtmControllerConfig;
import com.nuance.him.config.customerconfig.CustomerControllerConfig;
import com.nuance.him.config.interestconfig.InterestControllerConfig;
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
    @Import({ CustomerControllerConfig.class, AccountControllerConfig.class, TransferAmountControllerConfig.class, AtmControllerConfig.class, InterestControllerConfig.class })
    public static class Config {}
}
