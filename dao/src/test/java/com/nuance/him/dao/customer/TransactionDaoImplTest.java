/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */
package com.nuance.him.dao.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nuance.him.dao.transaction.TransactionDao;
import com.nuance.him.dao.transaction.TransactionDaoImpl;
import com.nuance.him.model.transaction.Transaction;
import java.util.List;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

/**
 * {@link TransactionDaoImplTest}.
 */
@TestPropertySource("classpath:sql-queries.xml")
@ContextConfiguration(classes = BankDatabaseTest.class)
@Transactional
public class TransactionDaoImplTest extends AbstractTestNGSpringContextTests {

    private static final String TRANSFER_AMOUNT = "transfer";
    private static final String UPDATE_BALANCE = "updateBalance";
    private static final String TRANSACTION_HISTORY = "transactionHistory";
    private static final double AMOUNT = 500;
    private static final int FROM_ACC = 1;
    private static final int TO_ACC = 3;
    private static final String DESCRIPTION = "Loan";
    private static final double CURRENT_BALANCE = 1000;
    @Value("${" + TRANSFER_AMOUNT + "}")
    private String getTransferAmount;
    @Value("${" + UPDATE_BALANCE + "}")
    private String getUpdateBalance;
    @Value("${" + TRANSACTION_HISTORY + "}")
    private String getTransactionHistory;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private Transaction transaction;
    private TransactionDao transactionDAO;

    /**
     * initial setup for test.
     */
    @BeforeMethod
    public void setUp() {
        transactionDAO = new TransactionDaoImpl(namedParameterJdbcTemplate, getTransferAmount, getUpdateBalance, getTransactionHistory);
        transaction = new Transaction(FROM_ACC, TO_ACC, AMOUNT, DESCRIPTION);
    }

    /**
     * test TransferAmount.
     *
     * @throws Exception exception
     */
    @Test
    @Transactional
    public void testTransferAmount() throws Exception {
        assertNotNull(transactionDAO);
        int transactionId = transactionDAO.transferAmount(transaction, CURRENT_BALANCE);
        assertNotEquals(0, transactionId);
    }

    /**
     * test Transaction statement.
     *
     * @throws Exception exception
     */
    @Test
    @Transactional
    public void testTransactionHistory() throws Exception {
        assertNotNull(transactionDAO);
        List<Transaction> transactions = transactionDAO.getTransactionHistory(FROM_ACC);
        assertNotNull(transactions, "transactions sholud not null");
    }
}
