/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.dao.customer;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.nuance.him.dao.daoexception.CustomerDaoException;
import com.nuance.him.model.customermodel.Customer;
import java.util.List;

/**
 * implements CustomerDao.
 */
public class CustomerDaoImpl implements CustomerDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String insertCustomer;
    private final String insertAddress;
    private final String getAllCustomer;

    /**
     * constructor of { CustomerDaoImpl}.
     *
     * @param namedParameterJdbcTemplate instance of {@link NamedParameterJdbcTemplate}
     * @param insertCustomer query for insert customer
     * @param insertAddress query for insert address
     * @param getAllCustomer query for get all customer record
     */
    public CustomerDaoImpl(final NamedParameterJdbcTemplate namedParameterJdbcTemplate, final String insertCustomer, final String insertAddress, final String getAllCustomer) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.insertCustomer = insertCustomer;
        this.insertAddress = insertAddress;
        this.getAllCustomer = getAllCustomer;
    }

    @Override
    public int addCustomer(final Customer customer) throws CustomerDaoException {
        final KeyHolder holder = new GeneratedKeyHolder();
        final MapSqlParameterSource paramSourceCustomer = mapSqlParameterSource(customer);
        try {
            namedParameterJdbcTemplate.update(insertCustomer, paramSourceCustomer, holder);
            customer.setId(holder.getKey().intValue());
            final MapSqlParameterSource paramSourceAddress = mapSqlParameterSource(customer);
            namedParameterJdbcTemplate.update(insertAddress, paramSourceAddress);
            return holder.getKey().intValue();
        }
        catch (final DataAccessException dataAccessException) {
            throw new CustomerDaoException("Failed to add customer ", dataAccessException);
        }
    }

    @Override
    public List<Customer> getAllCustomers() throws CustomerDaoException {
        try {
            return namedParameterJdbcTemplate.query(getAllCustomer, new CustomerMapper());
        }
        catch (final DataAccessException dataAccessException) {
            throw new CustomerDaoException("Failed to display customer details", dataAccessException);
        }
    }

    /**
     * {@link org.springframework.jdbc.core.SqlParameter } mapper method.
     *
     * @param customer instance of class {@link Customer}
     * @return paramSource
     */
    private MapSqlParameterSource mapSqlParameterSource(final Customer customer) {
        final MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("name", customer.getName());
        paramSource.addValue("phone", customer.getPhone());
        paramSource.addValue("address", customer.getAddress());
        paramSource.addValue("city", customer.getCity());
        paramSource.addValue("customerId", customer.getId());
        return paramSource;
    }
}

