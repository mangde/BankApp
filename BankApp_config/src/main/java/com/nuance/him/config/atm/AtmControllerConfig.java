/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.config.atm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import com.nuance.him.controller.atm.AtmController;
import com.nuance.him.service.atm.AtmService;

/**
 * Account Config controller class.
 */
@Configuration
@Import(AtmServiceConfig.class)

public class AtmControllerConfig {

    @Autowired
    private AtmService atmService;

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
    public AtmController atmController() {
        return new AtmController(atmService);
    }


}
