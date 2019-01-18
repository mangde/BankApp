/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.service.customer;

import com.nuance.him.dao.customer.CustomerDao;
import com.nuance.him.dao.daoexception.CustomerDaoException;
import com.nuance.him.model.customermodel.Customer;
import com.nuance.him.service.serviceexception.CustomerServiceException;
import java.util.List;

/**
 * implements {@link CustomerService}.
 */
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    /**
     * constructor of {@link CustomerServiceImpl}.
     *
     * @param customerDao instance of CustomerDao.
     */
    public CustomerServiceImpl(final CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public int addCustomer(final Customer customer) throws CustomerServiceException {
        try {
            return customerDao.addCustomer(customer);
        }
        catch (final CustomerDaoException customerDaoException) {
            throw new CustomerServiceException(customerDaoException.getMessage(), customerDaoException);
        }
    }

    @Override
    public List<Customer> getAllCustomers() throws CustomerServiceException {
        try {
            return customerDao.getAllCustomers();
        }
        catch (final CustomerDaoException customerDaoException) {
            throw new CustomerServiceException(customerDaoException.getMessage(), customerDaoException);
        }
    }
}
