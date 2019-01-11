/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.controller.test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.nuance.him.controller.customer.CustomerController;
import com.nuance.him.service.customer.CustomerService;

/**
 * class for creating controller bean testing testController
 */
@Configuration
@PropertySource("classpath:application.properties")
@EnableWebMvc
public class TestControllerConfig {

    private static final Logger log = LoggerFactory.getLogger(TestControllerConfig.class);
    @Mock
    private CustomerService customerService;

    /**
     * creating {@link CustomerController} bean
     * @return controller bean
     */
    @Bean
    public CustomerController customerController() {
        log.info("setting up test  CustomerController  bean");
        MockitoAnnotations.initMocks(this);
        return new CustomerController(customerService);
    }

    /**
     * crating bean for accesing values form property file
     * @return propertySource Bean
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

