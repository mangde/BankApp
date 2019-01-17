/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */
package com.nuance.him.service.test.account;

import com.nuance.him.dao.account.AccountDao;
import com.nuance.him.dao.daoexception.AccountDaoException;
import com.nuance.him.model.accountmodel.Account;
import com.nuance.him.service.test.serviceexception.AccountServiceException;

/**
 * {@link AccountService} implementation.
 */
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDAO;

    /**
     * {@link AccountDao }constructor.
     *
     * @param accountDAO instance of {@link AccountDao}
     */
    public AccountServiceImpl(AccountDao accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public int addAccount(Account account) throws AccountServiceException {
        try {
            return accountDAO.addAccount(account);
        }
        catch (AccountDaoException a) {
            throw new AccountServiceException("exception in service", a);
        }
    }

    @Override
    public double depositeAmount(int accountNumber, double amount) throws AccountServiceException {
        try {
            return accountDAO.depositeAmount(accountNumber, amount);
        }
        catch (AccountDaoException e) {
            throw new AccountServiceException("exception in service deposite amount", e);
        }
    }

    @Override
    public double getCurrentBalance(int accountNumber) throws AccountServiceException {
        try {
            return accountDAO.getCurrentBalance(accountNumber);
        }
        catch (AccountDaoException e) {
            throw new AccountServiceException("exception in service getCurrentBalance", e);
        }
    }

    @Override
    public Account getAccountDetail(int accountNumber) throws AccountServiceException {
        try {
            return accountDAO.getAccountDetail(accountNumber);
        }
        catch (AccountDaoException e) {
            throw new AccountServiceException("exception in service getAccountDetail", e);
        }
    }
}
