/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.*
 * Warning: This product is protected by United States copyright law.
 * Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */

package com.nuance.him.dao.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import com.nuance.him.model.customermodel.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper to display the table rows mapping them to the objects.
 */
public class CustomerMapper implements RowMapper<Customer> {
    private static final Logger log = LoggerFactory.getLogger(CustomerMapper.class);

    /**
     * Maps table row to the Customer object.
     *
     * @param rs     result set
     * @param rowNum current row number
     * @return customer
     * @throws SQLException SQLException
     */
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer(rs.getString("name"), rs.getLong("phone"),
                rs.getString("address1"), rs.getString("city"));
        customer.setId(rs.getInt("customerId"));
        return customer;
    }
}
