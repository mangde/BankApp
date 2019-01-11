/*
 * COPYRIGHT: Copyright (c) 2018 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.service.customer;

import org.springframework.stereotype.Service;
import com.nuance.him.dao.customer.CustomerDAO;
import com.nuance.him.dao.daoexception.CustomerDaoException;
import com.nuance.him.model.customermodel.Customer;
import com.nuance.him.service.serviceexception.CustomerServiceException;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerServiceImpl(CustomerDAO customerDao) {

        this.customerDAO = customerDao;
    }



    @Override
    public int addCustomer(Customer customer) throws CustomerServiceException {
        try {
            return customerDAO.addCustomer(customer);
        }
        catch (CustomerDaoException e) {
            throw new CustomerServiceException(e.getMessage(), e);
        }
    }
    @Override
    public List<Customer> getAllCustomers() throws CustomerServiceException {
        try {
            return customerDAO.getAllCustomers();
        } catch (CustomerDaoException e) {
            throw new CustomerServiceException(e.getMessage(),e);
        }
    }
}
