/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.service.account;

import com.nuance.him.dao.account.AccountDao;
import com.nuance.him.dao.daoexception.AccountDaoException;
import com.nuance.him.model.accountmodel.Account;
import com.nuance.him.service.serviceexception.AccountServiceException;
import com.nuance.him.service.serviceexception.InsufficientBalanceException;

/**
 * {@link AccountService} implementation.
 */
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    /**
     * {@link AccountDao }constructor.
     *
     * @param accountDAO instance of {@link AccountDao}
     */
    public AccountServiceImpl(AccountDao accountDAO) {
        accountDao = accountDAO;
    }

    @Override
    public int addAccount(Account account) throws AccountServiceException {
        try {
            return accountDao.addAccount(account);
        }
        catch (AccountDaoException a) {
            throw new AccountServiceException("exception in service", a);
        }
    }

    @Override
    public double depositeAmount(int accountNumber, double amount) throws AccountServiceException {
        try {
            return accountDao.depositeAmount(accountNumber, amount);
        }
        catch (AccountDaoException e) {
            throw new AccountServiceException("exception in service deposite amount", e);
        }
    }

    @Override
    public double getCurrentBalance(int accountNumber) throws AccountServiceException {
        try {
            return accountDao.getCurrentBalance(accountNumber);
        }
        catch (AccountDaoException e) {
            throw new AccountServiceException("exception in service getCurrentBalance", e);
        }
    }

    @Override
    public Account getAccountDetail(int accountNumber) throws AccountServiceException {
        try {
            return accountDao.getAccountDetail(accountNumber);
        }
        catch (AccountDaoException e) {
            throw new AccountServiceException("exception in service getAccountDetail", e);
        }
    }

    @Override
    public double withDrawAmount(int accountNumber, double amount) throws AccountServiceException {
        try {
            double currentAvailableBalance = accountDao.getCurrentBalance(accountNumber);
            if (currentAvailableBalance < amount) {
                throw new InsufficientBalanceException("insufficient balance ");
            }
            double availableBalance = currentAvailableBalance - amount;
            accountDao.withDrawAmount(accountNumber, availableBalance);
            return availableBalance;
        }
        catch (AccountDaoException e) {
            throw new AccountServiceException("exception in service withDrawAmount", e);
        }
        catch (InsufficientBalanceException e) {
            throw new AccountServiceException("insufficient Balance Exception", e);
        }
    }
}
