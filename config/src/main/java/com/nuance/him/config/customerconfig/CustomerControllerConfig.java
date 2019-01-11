/*
 * COPYRIGHT: Copyright (c) 2018 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.config.customerconfig;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import com.nuance.him.controller.customer.CustomerController;
import com.nuance.him.service.customer.CustomerService;
import static org.springframework.util.Assert.notNull;

@Configuration
@Import(CustomerServiceConfig.class)
public class CustomerControllerConfig {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
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
        log.info("setting up CustomerController  bean");
        return new CustomerController(customerService);
    }

    /**
     * bean  property resource
     * @return bean
     */

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

