/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications.
 * Warning: This product is protected by United States copyright law.
 * Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.dao.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.nuance.him.dao.daoexception.CustomerDaoException;
import com.nuance.him.model.customermodel.Customer;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private static final Logger log = LoggerFactory.getLogger(CustomerDAOImpl.class);
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String INSERT_CUSTOMER;
    private final String INSERT_ADDRESS;
    private final String SELECT_ALL_CUSTOMER;

    public CustomerDAOImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                           String insertCustomer, String insertAddress, String getAllCustomer) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        INSERT_CUSTOMER = insertCustomer;
        INSERT_ADDRESS = insertAddress;
        SELECT_ALL_CUSTOMER = getAllCustomer;
    }

    @Override
    public int addCustomer(Customer customer) throws CustomerDaoException {
        KeyHolder holder = new GeneratedKeyHolder();
        MapSqlParameterSource paramSourceCustomer = new MapSqlParameterSource();
        paramSourceCustomer.addValue("name", customer.getName());
        paramSourceCustomer.addValue("phone", customer.getPhone());
        try {

            namedParameterJdbcTemplate.update(this.INSERT_CUSTOMER, paramSourceCustomer, holder);
            int customerId = holder.getKey().intValue();

            MapSqlParameterSource paramSourceAddress = new MapSqlParameterSource();
            paramSourceAddress.addValue("address", customer.getAddress());
            paramSourceAddress.addValue("city", customer.getCity());
            paramSourceAddress.addValue("customerId", customerId);
            this.namedParameterJdbcTemplate.update(this.INSERT_ADDRESS, paramSourceAddress);
            return holder.getKey().intValue();
        } catch (DataAccessException e) {
            CustomerDAOImpl.log.error("error in AddDAO ", e.getCause());
            throw new CustomerDaoException("Failed to add customer ", e);
        }
    }

    @Override
    public List<Customer> getAllCustomers() throws CustomerDaoException {
        try {
            return namedParameterJdbcTemplate.query(SELECT_ALL_CUSTOMER, new CustomerMapper());
        } catch (DataAccessException e) {
            throw new CustomerDaoException("Failed to display customer details", e);
        }
    }
}
