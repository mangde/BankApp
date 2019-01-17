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
import com.nuance.him.model.transaction.Transaction;
import com.nuance.him.service.test.account.AccountService;
import com.nuance.him.service.test.transaction.TransactionServices;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * {@link TransactionControllerTest} test class.
 */
@WebAppConfiguration
@TestPropertySource("classpath:application.properties")
@ContextConfiguration(classes = TestControllerConfig.class)
public class TransactionControllerTest extends AbstractTestNGSpringContextTests {

    private static final String BASE_URL = "baseURL";
    private static final String TRANSFER_AMOUNT = "Transaction.transferAmount";
    private static final String TRANSACTION_HISTORY = "Transaction.history";
    private static final String AMOUNT = "500";
    private static final String FROM_ACC = "1";
    private static final String TO_ACC = "3";
    private static final String DESCRIPTION = "Loan";
    private static final double CURRENT_BALANCE = 1000;
    private static final int ACC_NUMBER = 1;
    @Value("${" + TRANSFER_AMOUNT + "}")
    private String getTransferAmount;
    @Value("${" + BASE_URL + "}")
    private String bankURL;
    @Value("${" + TRANSACTION_HISTORY + "}")
    private String getTransactionHistory;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Mock
    private TransactionServices transactionServices;
    @Autowired
    private AccountService accountService;
    private MockMvc mockMvc;
    private Transaction transaction;

    /**
     * Initial Setup.
     */
    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * Test Transfer Amount_Method controller.
     *
     * @throws Exception exception
     */
    @Test
    public void testTransferAmount() throws Exception {
        when(transactionServices.transferAmount(any(Transaction.class), anyDouble())).thenReturn(1);
        when(accountService.getCurrentBalance(anyInt())).thenReturn(CURRENT_BALANCE);
        mockMvc.perform(MockMvcRequestBuilders.post(bankURL + getTransferAmount)
            .param("accFrom", FROM_ACC)
            .param("accTo", TO_ACC)
            .param("amount", AMOUNT)
            .param("description", DESCRIPTION)).andExpect(status().isCreated());
    }

    /**
     * test method getTransactionHistory.
     *
     * @throws Exception exception
     */
    @Test
    public void testTransactionHistory() throws Exception {
        when(transactionServices.getTransactionHistory(anyInt())).thenReturn(anyListOf(Transaction.class));
        mockMvc.perform(MockMvcRequestBuilders.get(bankURL + getTransactionHistory)
            .param("accNumber", FROM_ACC)).andExpect(status().isOk());
    }
}
