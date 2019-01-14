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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.nuance.him.config.BankDatabaseConfig;
import com.nuance.him.controller.customer.CustomerController;
import com.nuance.him.dao.customer.CustomerDAO;
import com.nuance.him.dao.customer.CustomerDAOImpl;
import static org.springframework.util.Assert.notNull;

@Configuration
@Import(BankDatabaseConfig.class)
@PropertySource("classpath:sql-queries.xml")
public class CustomerDaoConfig {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    private static final String INSERT_CUSTOMER = "addCustomer";
    private static final String INSERT_CUST_ADDRESS = "addAddress";
    private static final String SELECT_ALL_CUSTOMERS = "selectAllCustomers";
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Value("${" + CustomerDaoConfig.INSERT_CUSTOMER + "}")
    private String insertCustomer;
    @Value("${" + CustomerDaoConfig.INSERT_CUST_ADDRESS + "}")
    private String insertAddress;
    @Value("${" + CustomerDaoConfig.SELECT_ALL_CUSTOMERS + "}")
    private String selectAllCustomers;

    /**
     * Validates jdbcTemplate and database queries.
     */
    @PostConstruct
    public void postConstruct() {
        notNull(this.jdbcTemplate, "missing bean jdbcTemplate");
        notNull(CustomerDaoConfig.INSERT_CUSTOMER, "null value : INSERT_CUSTOMER");
        notNull(CustomerDaoConfig.INSERT_CUST_ADDRESS, "null value : INSERT_CUST_ADDRESS");
        notNull(CustomerDaoConfig.SELECT_ALL_CUSTOMERS, "null value : SELECT_ALL_CUSTOMERS");
    }

    /**
     * Factory for CustomerDao.
     *
     * @return CustomerDaoImpl object
     */
    @Bean
    public CustomerDAO customerDao() {
        log.info("setting up CustomerDao bean");
        return new CustomerDAOImpl(this.jdbcTemplate, this.insertCustomer, this.insertAddress,selectAllCustomers);
    }


}
