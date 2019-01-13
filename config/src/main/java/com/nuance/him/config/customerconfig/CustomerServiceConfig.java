/*
 * COPYRIGHT: Copyright (c) 2018 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.config.customerconfig;

import com.nuance.him.dao.customer.CustomerDAO;
import com.nuance.him.service.customer.CustomerService;
import com.nuance.him.service.customer.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

import static org.apache.commons.lang3.Validate.notNull;

/**
 * Configuration for CustomerServices.
 */
@Configuration
@Import(CustomerDaoConfig.class)
public class CustomerServiceConfig {

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

        return new CustomerServiceImpl(this.customerDao);
    }
}
