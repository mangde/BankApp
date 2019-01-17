package com.nuance.him.dao.customer;/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nuance.him.dao.account.AccountDao;
import com.nuance.him.dao.account.AccountDaoImpl;
import com.nuance.him.model.accountmodel.Account;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

/**
 * test class for {@link AccountDao}.
 */
@TestPropertySource("classpath:sql-queries.xml")
@ContextConfiguration(classes = BankDatabaseTest.class)
@Transactional
public class AccountDaoImplTest extends AbstractTransactionalTestNGSpringContextTests {

    private static final String OPEN_ACCOUNT = "addAccount";
    private static final String GET_BALANCE = "getBalance";
    private static final String DEPOSITE_AMOUNT = "depositeAmount";
    private static final String ACCOUNT_DETAILS = "accountDetail";
    private static final String ACC_TYPE = "saving";
    private static final double BALANCE = 5025;
    private static final int CUSTOMER_ID = 1;
    private static final int ACCOUNT_NUMBER = 3;
    private static final double AMOUNT = 500;
    private final String ACCOUNT_TYPE_ID = "getAccTypeId";
    @Value("${" + OPEN_ACCOUNT + "}")
    private String getOpenAccount;
    @Value("${" + ACCOUNT_TYPE_ID + "}")
    private String getAccType;
    @Value("${" + GET_BALANCE + "}")
    private String getGetBalance;
    @Value("${" + DEPOSITE_AMOUNT + "}")
    private String getDepositeAmount;
    @Value("${" + ACCOUNT_DETAILS + "}")
    private String getAccountDetails;
    private AccountDao accountDAO;
    private Account account;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * initial setup.
     */
    @BeforeMethod
    public void setUp() {
        accountDAO = new AccountDaoImpl(namedParameterJdbcTemplate, getOpenAccount, getAccType, getGetBalance, getDepositeAmount, getAccountDetails);
        account = new Account(ACC_TYPE, BALANCE, CUSTOMER_ID);
    }

    /**
     * test open New Account.
     *
     * @throws Exception exception
     */
    @Test
    @Transactional
    public void testOpenAccount() throws Exception {
        assertNotNull(accountDAO);
        int accId = accountDAO.addAccount(account);
        assertNotEquals(0, accId);
    }

    /**
     * test Current Available balance.
     *
     * @throws Exception exception
     */
    @Test
    @Transactional
    public void testGetBalance() throws Exception {
        assertNotNull(accountDAO);
        double balance = accountDAO.getCurrentBalance(ACCOUNT_NUMBER);
        assertNotNull(balance);
    }

    /**
     * test Deposite amount.
     *
     * @throws Exception exception
     */
    @Test
    @Transactional
    public void testDeposite() throws Exception {
        assertNotNull(accountDAO);
        double balance = accountDAO.depositeAmount(ACCOUNT_NUMBER, AMOUNT);
        assertNotEquals(0, balance);
    }

    /**
     * test AccountDetails.
     *
     * @throws Exception exception
     */
    @Test
    @Transactional
    public void testGetAccountDetails() throws Exception {
        assertNotNull(accountDAO);
        Account account = accountDAO.getAccountDetail(ACCOUNT_NUMBER);
        assertNotNull(account);
    }
}
