/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.dao.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nuance.him.dao.customer.CustomerDao;
import com.nuance.him.dao.customer.CustomerDaoImpl;
import com.nuance.him.model.customermodel.Customer;
import java.util.List;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Test class {@link CustomerDaoImplTest}.
 */
@Transactional
@ContextConfiguration(classes = BankDatabaseTest.class)
@TestPropertySource("classpath:sql-queries.xml")
public class CustomerDaoImplTest extends AbstractTransactionalTestNGSpringContextTests {

    private static final String INSERT_CUSTOMER = "addCustomer";
    private static final String INSERT_CUSTOMER_ADDRESS = "addAddress";
    private static final String SELECT_ALL_CUSTOMER = "selectAllCustomers";
    private static final String NAME = "yogi";
    private static final long PHONE = 9545090850L;
    private static final String ADDRESS = "Mumbai";
    private static final String CITY = "Mumbai";
    @Value("${" + CustomerDaoImplTest.INSERT_CUSTOMER + "}")
    private String insertCustomer;
    @Value("${" + CustomerDaoImplTest.INSERT_CUSTOMER_ADDRESS + "}")
    private String insertAddress;
    @Value("${" + CustomerDaoImplTest.SELECT_ALL_CUSTOMER + "}")
    private String getSelectAll;
    private CustomerDao customerDao;
    private Customer customer;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * Initial setup.
     */
    @BeforeMethod
    public void setUp() {
        customerDao = new CustomerDaoImpl(namedParameterJdbcTemplate, insertCustomer, insertAddress, getSelectAll);
        customer = new Customer(CustomerDaoImplTest.NAME, CustomerDaoImplTest.PHONE, CustomerDaoImplTest.ADDRESS, CustomerDaoImplTest.CITY);
    }

    /**
     * testAddCustomer.
     *
     * @throws Exception exception
     */
    @Test
    @Transactional
    public void testAddCustomer() throws Exception {
        assertNotNull(customerDao);
        int customerId = customerDao.addCustomer(customer);
        assertNotEquals(0, customerId);
    }

    /**
     * test DisplayCustomer.
     *
     * @throws Exception exception
     */
    @Test
    @Transactional
    public void testDisplayCustomer() throws Exception {
        assertNotNull(customerDao);
        List<Customer> customers = customerDao.getAllCustomers();
        assertNotNull(customers, "customer list Should Not null");
    }
}
