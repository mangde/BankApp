
package com.nuance.him.config.accountconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import com.nuance.him.controller.account.AccountController;
import com.nuance.him.service.account.AccountService;

/**
 * Account Config controller class.
 */
@Configuration
@Import(AccountServiceConfig.class)
public class AccountControllerConfig {

    @Autowired
    private AccountService accountService;


    /**
     * creating controller bean.
     *
     * @return bean controller
     */
    @Bean
    public AccountController accountController() {
        return new AccountController(accountService);
    }

    /**
     * bean  property resource.
     *
     * @return bean
     */
    @Bean
    @Primary
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


}
