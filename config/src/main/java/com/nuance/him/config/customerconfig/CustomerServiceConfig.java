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
import com.nuance.him.controller.customer.CustomerController;
import com.nuance.him.dao.customer.CustomerDAO;
import com.nuance.him.service.customer.CustomerService;
import com.nuance.him.service.customer.CustomerServiceImpl;
import static org.apache.commons.lang3.Validate.notNull;

/**
 * Configuration for CustomerServices.
 */
@Configuration
@Import(CustomerDaoConfig.class)
public class CustomerServiceConfig {
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerDAO customerDao;

    /**
     * Validate the variables.
     */
    @PostConstruct
    public void postConstruct() {
        notNull(this.customerDao, "missing bean customerDao");
    }

    /**
     * Factory for CustomerServices.
     *
     * @return CustomerServicesImpl object
     */
    @Bean
    public CustomerService customerService() {
        log.info("setting up Service bean");

        return new CustomerServiceImpl(this.customerDao);
    }
}
