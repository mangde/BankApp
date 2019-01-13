/*
 * COPYRIGHT: Copyright (c) 2018 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.config.customerconfig;

import com.nuance.him.controller.customer.CustomerController;
import com.nuance.him.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.PostConstruct;

import static org.springframework.util.Assert.notNull;

@Configuration
@Import(CustomerServiceConfig.class)
public class CustomerControllerConfig {

    @Autowired
    private CustomerService customerService;

    /**
     * Validate the variables.
     */
    @PostConstruct
    public void postConstruct() {
        notNull(customerService, "missing bean customerServices");
    }

    /**
     * creating controller bean
     * @return bean controller
     */
    @Bean
    public CustomerController customerController() {
       return new CustomerController(customerService);
    }

    /**
     * bean  property resource
     * @return bean
     */

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

