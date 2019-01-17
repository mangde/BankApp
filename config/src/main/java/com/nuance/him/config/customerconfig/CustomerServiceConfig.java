/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.config.customerconfig;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.nuance.him.dao.customer.CustomerDao;
import com.nuance.him.service.test.customer.CustomerService;
import com.nuance.him.service.test.customer.CustomerServiceImpl;
import static org.apache.commons.lang3.Validate.notNull;

/**
 * Configuration for CustomerServices.
 */
@Configuration
@Import(CustomerDaoConfig.class)
public class CustomerServiceConfig {

    @Autowired
    private CustomerDao customerDao;

    /**
     * Validate the variables.
     */
    @PostConstruct
    public void postConstruct() {
        notNull(customerDao, "missing bean customerDao");
    }

    /**
     * Factory for CustomerServices.
     *
     * @return CustomerServicesImpl object
     */
    @Bean
    public CustomerService customerService() {
        return new CustomerServiceImpl(customerDao);
    }
}
