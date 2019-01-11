package com.nuance.him.service.customer;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nuance.him.dao.customer.CustomerDAO;
import com.nuance.him.dao.daoexception.CustomerDaoException;
import com.nuance.him.model.customermodel.Customer;
import com.nuance.him.service.serviceexception.CustomerServiceException;
import java.util.List;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CustomerServiceImplTest {

    @Mock
    private CustomerDAO customerDAO;
    private CustomerService customerService;
    private Customer customer;
    private List<Customer> customers;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(customerDAO);
        customer = new Customer("yogesh", 9545090850l, "pune", "pune");
    }

    @Test
    public void testAddCustomer() throws Exception {
        when(customerDAO.addCustomer(customer)).thenReturn(1);
        int result = customerService.addCustomer(customer);
        assertNotNull(result);
        Mockito.verify(customerDAO).addCustomer(customer);
    }

    @Test(expectedExceptions = CustomerServiceException.class)
    public void testAddCustomerException() throws Exception {
        doThrow(CustomerDaoException.class).when(customerDAO).addCustomer(customer);
        try {
            int result = customerService.addCustomer(customer);
        }
        catch (CustomerServiceException e) {
            assertEquals(CustomerDaoException.class, e.getCause().getClass());
            Mockito.verify(customerDAO).addCustomer(customer);
            throw e;
        }
    }

    @Test
    public void testDisplayCustomer() throws Exception {
        when(customerDAO.getAllCustomers()).thenReturn(customers);
        assertEquals(customers, customerService.getAllCustomers(), "Actual Different then expected");
        Mockito.verify(customerDAO).getAllCustomers();
    }

    @Test(expectedExceptions = CustomerServiceException.class)
    public void testDisplayCustomerException() throws Exception {
        doThrow(CustomerDaoException.class).when(customerDAO).getAllCustomers();
        try {
            customerService.getAllCustomers();
        }
        catch (CustomerServiceException e) {
            assertEquals(CustomerDaoException.class, e.getCause().getClass(), "Exception mismatch");
            Mockito.verify(customerDAO).getAllCustomers();
            throw e;
        }
    }
}
