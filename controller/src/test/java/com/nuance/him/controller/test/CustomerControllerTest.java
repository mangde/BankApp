/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.controller.test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nuance.him.controller.customer.CustomerController;
import com.nuance.him.model.customermodel.Customer;
import com.nuance.him.service.customer.CustomerService;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test Class for {@link CustomerController}
 */
@WebAppConfiguration
@TestPropertySource(value = { "classpath:application.properties" })
@ContextConfiguration(classes = TestControllerConfig.class)
public class CustomerControllerTest extends AbstractTestNGSpringContextTests {

    private static final String BASE_URL = "baseURL";
    private static final String ADD_CUSTOMER = "Customer.addCustomer";
    private static final String SELECT_ALL_CUSTOMER = "Customer.SelectAllCustomer";
    @Value("${" + BASE_URL + "}")
    private String bankURL;
    /**
     * add customer url
     */
    @Value("${" + ADD_CUSTOMER + "}")
    private String getAddCustomer;
    @Value("${" + SELECT_ALL_CUSTOMER + "}")
    private String getSelectAllCustomer;
    @Mock
    private CustomerService customerService;
    private MockMvc mockMvc;
    private Customer customer;
    List<Customer> customers;
    /**
     * WebApplicationContext to TestNG cases.
     */
    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * Initial Setup
     */
    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * Test {@link CustomerController {@link #ADD_CUSTOMER}}for successful adding a customer
     *
     * @throws Exception exception
     */
    @Test
    public void testAddCustomer() throws Exception {
        when(customerService.addCustomer(customer)).thenReturn(1);

        mockMvc.perform(MockMvcRequestBuilders.post(bankURL + getAddCustomer).param("name", "yogesh").param("phone", "954595854").param("address", "pune").param("city", "pune")).andExpect(status().isCreated());

    }

    /**
     * test display customer method
     *
     * @throws Exception exception
     */
    @Test
    public void testDisplayCustomers() throws Exception {
        when(customerService.getAllCustomers()).thenReturn(customers);

        this.mockMvc.perform(MockMvcRequestBuilders.get(bankURL + getSelectAllCustomer)).andExpect(status().isOk());
    }
}
