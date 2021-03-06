/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.config.interestconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import com.nuance.him.controller.account.InterestController;
import com.nuance.him.service.account.InterestCalculatorService;

/**
 * Account Config controller class.
 */
@Configuration
@Import(InterestServiceConfig.class)

public class InterestControllerConfig {

    @Autowired
    private InterestCalculatorService interestCalculatorService;

    /**
     * bean  property resource for read properties file.
     *
     * @return bean
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * creating controller bean.
     *
     * @return bean controller
     */
    @Bean
    public InterestController interestCcntroller() {
        return new InterestController(interestCalculatorService);
    }


}
