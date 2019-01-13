/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.dao.customer;

import com.nuance.him.dao.daoexception.CustomerDaoException;
import com.nuance.him.model.customermodel.Customer;
import java.util.List;

public interface CustomerDAO {

    /**
     * To add the customer model to table.
     *
     * @param customer object of the Customer class
     * @return int 1 if the customer model is added else 0
     * @throws CustomerDaoException exception thrown by the JdbcTemplate update method
     */
    int addCustomer(Customer customer) throws CustomerDaoException;

    /**
     * get all customer
     * @return list of customers
     * @throws CustomerDaoException exception
     */
    List<Customer> getAllCustomers() throws CustomerDaoException;
}
