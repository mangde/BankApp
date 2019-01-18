/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.service;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nuance.him.dao.account.AccountDao;
import com.nuance.him.dao.daoexception.AccountDaoException;
import com.nuance.him.model.accountmodel.Account;
import com.nuance.him.service.account.AccountService;
import com.nuance.him.service.account.AccountServiceImpl;
import com.nuance.him.service.serviceexception.AccountServiceException;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atMost;
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
        final int result = accountService.addAccount(account);
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
            final int result = accountService.addAccount(account);
        }
        catch (final AccountServiceException accountServiceException) {
            assertEquals(AccountDaoException.class, accountServiceException.getCause().getClass());
            Mockito.verify(accountDAO).addAccount(any(Account.class));
            throw accountServiceException;
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
        final double result = accountService.getCurrentBalance(ACCOUNT_NUMBER);
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
            final double result = accountService.getCurrentBalance(ACCOUNT_NUMBER);
        }
        catch (final AccountServiceException accountServiceException) {
            assertEquals(AccountDaoException.class, accountServiceException.getCause().getClass());
            Mockito.verify(accountDAO).getCurrentBalance(anyInt());
            throw accountServiceException;
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
        when(accountDAO.getCurrentBalance(anyInt())).thenReturn(BALANCE);
        final double result = accountService.depositeAmount(ACCOUNT_NUMBER, AMOUNT);
        assertNotNull(result);
        Mockito.verify(accountDAO).depositeAmount(anyInt(), anyDouble());
        Mockito.verify(accountDAO).getCurrentBalance(anyInt());
    }

    /**
     * test exception thrown by method depositAmount.
     *
     * @throws Exception {@link AccountServiceException}
     */
    @Test(expectedExceptions = AccountServiceException.class)
    public void testDepositException() throws Exception {
        doThrow(AccountDaoException.class).when(accountDAO).getCurrentBalance(anyInt());
        doThrow(AccountDaoException.class).when(accountDAO).depositeAmount(anyInt(), anyDouble());
        try {
            final double result = accountService.depositeAmount(ACCOUNT_NUMBER, AMOUNT);
        }
        catch (final AccountServiceException accountServiceException) {
            assertEquals(AccountDaoException.class, accountServiceException.getCause().getClass());
            Mockito.verify(accountDAO).getCurrentBalance(anyInt());
            Mockito.verify(accountDAO, atMost(2)).depositeAmount(anyInt(), anyDouble());
            throw accountServiceException;
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
        final Account result = accountService.getAccountDetail(ACCOUNT_NUMBER);
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
            final Account result = accountService.getAccountDetail(ACCOUNT_NUMBER);
        }
        catch (final AccountServiceException accountServiceException) {
            assertEquals(AccountDaoException.class, accountServiceException.getCause().getClass());
            Mockito.verify(accountDAO).getAccountDetail(anyInt());
            throw accountServiceException;
        }
    }

    /**
     * test  method withDraw.
     *
     * @throws Exception {@link AccountServiceException}
     */
    @Test
    public void testWithdraw() throws Exception {
        when(accountDAO.getCurrentBalance(anyInt())).thenReturn(BALANCE);
        when(accountDAO.withDrawAmount(anyInt(), anyDouble())).thenReturn(BALANCE);
        final double result = accountService.withDrawAmount(ACCOUNT_NUMBER, AMOUNT);
        assertNotNull(result);
        Mockito.verify(accountDAO).getCurrentBalance(anyInt());
        Mockito.verify(accountDAO).withDrawAmount(anyInt(), anyDouble());
    }

    /**
     * test exception thrown by method withDraw.
     *
     * @throws Exception {@link AccountServiceException}
     */
    @Test(expectedExceptions = AccountServiceException.class)
    public void testWithDrawAmountException() throws Exception {
        doThrow(AccountDaoException.class).when(accountDAO).withDrawAmount(anyInt(), anyDouble());
        doThrow(AccountDaoException.class).when(accountDAO).getCurrentBalance(anyInt());
        try {
            final double balance = accountService.getCurrentBalance(ACCOUNT_NUMBER);
            final double result = accountService.withDrawAmount(ACCOUNT_NUMBER, AMOUNT);
        }
        catch (final AccountServiceException accountServiceException) {
            assertEquals(AccountDaoException.class, accountServiceException.getCause().getClass());
            Mockito.verify(accountDAO).getCurrentBalance(anyInt());
            Mockito.verify(accountDAO, atMost(2)).withDrawAmount(anyInt(), anyDouble());
            throw accountServiceException;
        }
    }
}
