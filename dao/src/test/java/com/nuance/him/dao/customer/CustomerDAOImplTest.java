/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.dao.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nuance.him.model.customermodel.Customer;
import java.util.List;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

@Transactional
@ContextConfiguration(classes = {BankDatabaseConfigTest.class})
@TestPropertySource(value = { "classpath:sql-queries.xml" })
public class CustomerDAOImplTest extends AbstractTransactionalTestNGSpringContextTests {
    private static final String INSERT_CUSTOMER = "addCustomer";
    private static final String INSERT_CUST_ADDRESS = "addAddress";
    private static final String SELECT_ALL_CUSTOMER = "selectAllCustomers";


    @Value("${" + INSERT_CUSTOMER + "}")
    private String insertCustomer;

    @Value("${" + INSERT_CUST_ADDRESS + "}")
    private String insertAddress;
    @Value("${" + SELECT_ALL_CUSTOMER + "}")
    private String getSelectAll;

    private CustomerDAO customerDAO;
    private Customer customer;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @BeforeMethod
    public void setUp()  {
        customerDAO=new CustomerDAOImpl(jdbcTemplate,insertCustomer,insertAddress,getSelectAll);
        customer = new Customer("yogesh",9545090850l,"pune","pune");

    }

    @Test
    @Transactional
    public void testAddCustomer() throws Exception {
        assertNotNull(customerDAO);
        int custid=customerDAO.addCustomer(customer);
        assertNotEquals(0,custid);
    }

    @Test
    @Transactional
    public void testDisplayCustomer()throws Exception{
        assertNotNull(customerDAO);
        List<Customer> customers=customerDAO.getAllCustomers();
        assertNotNull(customers,"customer list Should Not null" );

    }
}
