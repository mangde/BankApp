/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
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
import com.nuance.him.model.accountmodel.Account;
import com.nuance.him.service.test.account.AccountService;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class of {@link com.nuance.him.controller.account.AccountController}.
 */
@WebAppConfiguration
@TestPropertySource("classpath:application.properties")
@ContextConfiguration(classes = TestControllerConfig.class)
public class AccountControllerTest extends AbstractTestNGSpringContextTests {

    private static final String BASE_URL = "baseURL";
    private static final String OPEN_ACCOUNT = "Account.addAccount";
    private static final String DEPOSITE_AMOUNT = "Account.depositeAmount";
    private static final String GET_BALANCE = "Account.getBalance";
    private static final String GET_ACCOUNT_DETAIL = "Account.AccountDetail";
    private static final String ACC_TYPE = "saving";
    private static final String BALANCE = "5025";
    private static final String CUSTOMER_ID = "1";
    private static final String ACCOUNT_NO = "2";
    private static final String AMOUNT = "500";
    private static final Double NEW_BALANCE = 2541.23;
    @Value("${" + BASE_URL + "}")
    private String bankURL;
    @Value("${" + OPEN_ACCOUNT + "}")
    private String getOpenAccount;
    @Value("${" + DEPOSITE_AMOUNT + "}")
    private String getDepositeAmount;
    @Value("${" + GET_BALANCE + "}")
    private String getGetBalance;
    @Value("${" + GET_ACCOUNT_DETAIL + "}")
    private String getGetAccountDetail;
    @Mock
    private AccountService accountService;
    private MockMvc mockMvc;
    private Account account;
    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * Initial Setup.
     */
    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * customer Open Account method.
     *
     * @throws Exception exception
     */
    @Test
    public void testOpenAccount() throws Exception {
        when(accountService.addAccount(any(Account.class))).thenReturn(1);
        mockMvc.perform(MockMvcRequestBuilders.post(bankURL + getOpenAccount)
            .param("type", ACC_TYPE)
            .param("balance", BALANCE)
            .param("customerId", CUSTOMER_ID)).andExpect(status().isCreated());
    }

    /**
     * test BadRequest parameter validation.
     *
     * @throws Exception BadRequest
     */
    @Test
    public void testOpenAccountValidation() throws Exception {
        when(accountService.addAccount(any(Account.class))).thenReturn(1);
        mockMvc.perform(MockMvcRequestBuilders.post(bankURL + getOpenAccount)
            .param("type", "saving123")
            .param("balance", "huihh")
            .param("customerId", CUSTOMER_ID)).andExpect(status().isBadRequest());
    }

    /**
     * customer DepositAmount.
     *
     * @throws Exception exception
     */
    @Test
    public void testDepositeAmount() throws Exception {
        when(accountService.depositeAmount(anyInt(), anyDouble())).thenReturn(NEW_BALANCE);
        mockMvc.perform(MockMvcRequestBuilders.post(bankURL + getDepositeAmount)
            .param("accNumber", ACCOUNT_NO)
            .param("amount", AMOUNT)).andExpect(status().isOk());
    }

    /**
     * customer Check current available balance.
     *
     * @throws Exception exception
     */
    @Test
    public void testGetBalance() throws Exception {
        when(accountService.getCurrentBalance(anyInt())).thenReturn(NEW_BALANCE);
        mockMvc.perform(MockMvcRequestBuilders.get(bankURL + getGetBalance)
            .param("accNumber", ACCOUNT_NO)).andExpect(status().isOk());
    }

    /**
     * customer Check AccountDetails.
     *
     * @throws Exception exception
     */
    @Test
    public void testGetAccountDetail() throws Exception {
        when(accountService.getAccountDetail(anyInt())).thenReturn(account);
        mockMvc.perform(MockMvcRequestBuilders.get(bankURL + getGetAccountDetail)
            .param("accNumber", ACCOUNT_NO)).andExpect(status().isOk());
    }
}
