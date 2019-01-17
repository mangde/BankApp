/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */
package com.nuance.him.service.test.customer;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nuance.him.dao.customer.CustomerDao;
import com.nuance.him.dao.daoexception.CustomerDaoException;
import com.nuance.him.model.customermodel.Customer;
import com.nuance.him.service.test.serviceexception.CustomerServiceException;
import java.util.List;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Customer Service Test.
 */
public class CustomerServiceImplTest {

    private static final String NAME = "Yo";
    private static final long PHONE = 9545090850L;
    private static final String ADDRESS = "pune";
    private static final String CITY = "pune";
    @Mock
    private CustomerDao customerDao;
    private CustomerService customerService;
    private Customer customer;
    private List<Customer> customers;

    /**
     * initial setup.
     */
    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(customerDao);
        customer = new Customer(CustomerServiceImplTest.NAME, CustomerServiceImplTest.PHONE, CustomerServiceImplTest.ADDRESS, CustomerServiceImplTest.CITY);
    }

    /**
     * Test AddCustomer.
     *
     * @throws Exception exception
     */
    @Test
    public void testAddCustomer() throws Exception {
        when(customerDao.addCustomer(any(Customer.class))).thenReturn(1);
        int result = customerService.addCustomer(customer);
        assertNotNull(result);
        Mockito.verify(customerDao).addCustomer(any(Customer.class));
    }

    /**
     * Test AddCustomer Exception.
     *
     * @throws Exception {@link CustomerServiceException}
     */
    @Test(expectedExceptions = CustomerServiceException.class)
    public void testAddCustomerException() throws Exception {
        doThrow(CustomerDaoException.class).when(customerDao).addCustomer(any(Customer.class));
        try {
            int result = customerService.addCustomer(customer);
        }
        catch (CustomerServiceException e) {
            assertEquals(CustomerDaoException.class, e.getCause().getClass());
            Mockito.verify(customerDao).addCustomer(customer);
            throw e;
        }
    }

    /**
     * test Display customer.
     *
     * @throws Exception exception
     */
    @Test
    public void testDisplayCustomer() throws Exception {
        when(customerDao.getAllCustomers()).thenReturn(customers);
        assertEquals(customers, customerService.getAllCustomers(), "Actual Different then expected");
        Mockito.verify(customerDao).getAllCustomers();
    }

    /**
     * Test Exception thrown by method testDisplayCustomerException.
     *
     * @throws Exception {@link CustomerServiceException}
     */
    @Test(expectedExceptions = CustomerServiceException.class)
    public void testDisplayCustomerException() throws Exception {
        doThrow(CustomerDaoException.class).when(customerDao).getAllCustomers();
        try {
            customerService.getAllCustomers();
        }
        catch (CustomerServiceException e) {
            assertEquals(CustomerDaoException.class, e.getCause().getClass(), "Exception mismatch");
            Mockito.verify(customerDao).getAllCustomers();
            throw e;
        }
    }
}
