/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.* COPYRIGHT: Copyright (c) 2018 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
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

    public CustomerDAOImpl(NamedParameterJdbcTemplate jdbcTemplate, String insertCustomer, String insertAddress,String getAllCustomer) {

        namedParameterJdbcTemplate = jdbcTemplate;
        INSERT_CUSTOMER = insertCustomer;
        INSERT_ADDRESS = insertAddress;
        SELECT_ALL_CUSTOMER=getAllCustomer;

    }

    @Override
    public int addCustomer(Customer customer) throws CustomerDaoException {
        KeyHolder holder = new GeneratedKeyHolder();
        MapSqlParameterSource paramSourcecust = new MapSqlParameterSource();
        paramSourcecust.addValue("name", customer.getName());
        paramSourcecust.addValue("phone", customer.getPhone());
           try {

          namedParameterJdbcTemplate.update(this.INSERT_CUSTOMER, paramSourcecust, holder);
               int customerId=holder.getKey().intValue();

               MapSqlParameterSource paramSourceaddresss = new MapSqlParameterSource();
               paramSourceaddresss.addValue("address", customer.getAddress());
               paramSourceaddresss.addValue("city", customer.getCity());
               paramSourceaddresss.addValue("customerId", customerId);
               this.namedParameterJdbcTemplate.update(this.INSERT_ADDRESS, paramSourceaddresss);
            return holder.getKey().intValue();
        }
        catch (DataAccessException e) {
               log.error("error in AddDAO ",e.getCause() );
            throw new CustomerDaoException("Failed to add customer ", e);
        }
    }

    @Override
    public List<Customer> getAllCustomers() throws CustomerDaoException {
        try{

            return namedParameterJdbcTemplate.query(SELECT_ALL_CUSTOMER,new CustomerMapper());
        } catch (DataAccessException e) {
            throw new CustomerDaoException("Failed to display customer details",e);
        }
    }
}
