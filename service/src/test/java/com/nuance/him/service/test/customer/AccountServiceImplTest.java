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
import com.nuance.him.dao.account.AccountDao;
import com.nuance.him.dao.daoexception.AccountDaoException;
import com.nuance.him.model.accountmodel.Account;
import com.nuance.him.service.test.account.AccountService;
import com.nuance.him.service.test.account.AccountServiceImpl;
import com.nuance.him.service.test.serviceexception.AccountServiceException;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * implement {@link AccountService}.
 */
public class AccountServiceImplTest {

    private static final String ACC_TYPE = "saving";
    private static final double BALANCE = 500;
    private static final int CUSTOMER_ID = 1;
    private static final int ACCOUNT_NUMBER = 3;
    private static final double AMOUNT = 500;
    @Mock
    private AccountDao accountDAO;
    private AccountService accountService;
    private Account account;

    /**
     * initial setup.
     */
    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        accountService = new AccountServiceImpl(accountDAO);
        account = new Account(ACC_TYPE, BALANCE, CUSTOMER_ID);
    }

    /**
     * test OpenAccount method.
     *
     * @throws Exception exception
     */
    @Test
    public void testOpenAccount() throws Exception {
        when(accountDAO.addAccount(any(Account.class))).thenReturn(1);
        int result = accountService.addAccount(account);
        assertNotNull(result);
        Mockito.verify(accountDAO).addAccount(any(Account.class));
    }

    /**
     * test exception thrown by method openAccount.
     *
     * @throws Exception {@link AccountServiceException}
     */
    @Test(expectedExceptions = AccountServiceException.class)
    public void testOpenAccountException() throws Exception {
        doThrow(AccountDaoException.class).when(accountDAO).addAccount(any(Account.class));
        try {
            int result = accountService.addAccount(account);
        }
        catch (AccountServiceException e) {
            assertEquals(AccountDaoException.class, e.getCause().getClass());
            Mockito.verify(accountDAO).addAccount(any(Account.class));
            throw e;
        }
    }

    /**
     * test method getCurrentAvailable balance.
     *
     * @throws Exception {@link AccountServiceException}
     */
    @Test
    public void testGetBalance() throws Exception {
        when(accountDAO.getCurrentBalance(anyInt())).thenReturn(BALANCE);
        double result = accountService.getCurrentBalance(ACCOUNT_NUMBER);
        assertNotNull(result);
        Mockito.verify(accountDAO).getCurrentBalance(anyInt());
    }

    /**
     * test exception thrown by method GetCurrentBalance.
     *
     * @throws Exception {@link AccountServiceException}
     */
    @Test(expectedExceptions = AccountServiceException.class)
    public void testGetBalanceException() throws Exception {
        doThrow(AccountDaoException.class).when(accountDAO).getCurrentBalance(anyInt());
        try {
            double result = accountService.getCurrentBalance(ACCOUNT_NUMBER);
        }
        catch (AccountServiceException e) {
            assertEquals(AccountDaoException.class, e.getCause().getClass());
            Mockito.verify(accountDAO).getCurrentBalance(anyInt());
            throw e;
        }
    }

    /**
     * test  method depositeAmount.
     *
     * @throws Exception {@link AccountServiceException}
     */
    @Test
    public void testDeposite() throws Exception {
        when(accountDAO.depositeAmount(anyInt(), anyDouble())).thenReturn(BALANCE);
        double result = accountService.depositeAmount(ACCOUNT_NUMBER, AMOUNT);
        assertNotNull(result);
        Mockito.verify(accountDAO).depositeAmount(anyInt(), anyDouble());
    }

    /**
     * test exception thrown by method depositAmount.
     *
     * @throws Exception {@link AccountServiceException}
     */
    @Test(expectedExceptions = AccountServiceException.class)
    public void testDepositException() throws Exception {
        doThrow(AccountDaoException.class).when(accountDAO).depositeAmount(anyInt(), anyDouble());
        try {
            double result = accountService.depositeAmount(ACCOUNT_NUMBER, AMOUNT);
        }
        catch (AccountServiceException e) {
            assertEquals(AccountDaoException.class, e.getCause().getClass());
            Mockito.verify(accountDAO).depositeAmount(anyInt(), anyDouble());
            throw e;
        }
    }

    /**
     * test method getAccountDetails.
     *
     * @throws Exception {@link AccountServiceException}
     */
    @Test
    public void testGetAccountDetail() throws Exception {
        when(accountDAO.getAccountDetail(anyInt())).thenReturn(account);
        Account result = accountService.getAccountDetail(ACCOUNT_NUMBER);
        assertNotNull(result);
        Mockito.verify(accountDAO).getAccountDetail(anyInt());
    }

    /**
     * test exception thrown by method GetAccountDetails.
     *
     * @throws Exception {@link AccountServiceException}
     */
    @Test(expectedExceptions = AccountServiceException.class)
    public void testGetAccountDetailException() throws Exception {
        doThrow(AccountDaoException.class).when(accountDAO).getAccountDetail(anyInt());
        try {
            Account result = accountService.getAccountDetail(ACCOUNT_NUMBER);
        }
        catch (AccountServiceException e) {
            assertEquals(AccountDaoException.class, e.getCause().getClass());
            Mockito.verify(accountDAO).getAccountDetail(anyInt());
            throw e;
        }
    }
}
