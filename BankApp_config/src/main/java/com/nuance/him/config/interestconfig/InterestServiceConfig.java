/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.config.interestconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.nuance.him.config.accountconfig.AccountServiceConfig;
import com.nuance.him.dao.account.SpringInterestCalcDao;
import com.nuance.him.service.account.AccountService;
import com.nuance.him.service.account.AccountServiceImpl;
import com.nuance.him.service.account.InterestCalculatorService;
import com.nuance.him.service.account.InterestCalculatorServiceImpl;

/**
 * AccountServiceConfig class.
 */
@Configuration
@Import({InterestDaoConfig.class, AccountServiceConfig.class})
@EnableTransactionManagement
public class InterestServiceConfig {

    @Autowired
    private SpringInterestCalcDao springInterestCalcDao;
    @Autowired
    private AccountService accountService;

    /**
     * {@link AccountService}.
     *
     * @return bean {@link AccountServiceImpl}
     */
    @Bean
    public InterestCalculatorService interestCalculatorService() {
        return new InterestCalculatorServiceImpl(springInterestCalcDao,accountService);
    }
}
