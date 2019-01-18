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
    public AccountServiceImpl(final AccountDao accountDAO) {
        accountDao = accountDAO;
    }

    @Override
    public int addAccount(final Account account) throws AccountServiceException {
        try {
            return accountDao.addAccount(account);
        }
        catch (final AccountDaoException accountDaoException) {
            throw new AccountServiceException("exception in service", accountDaoException);
        }
    }

    @Override
    public double depositeAmount(final int accountNumber, final double amount) throws AccountServiceException {
        try {
            final double currentBalance = amount + getCurrentBalance(accountNumber);
            return accountDao.depositeAmount(accountNumber, currentBalance);
        }
        catch (final AccountDaoException accountDaoException) {
            throw new AccountServiceException("exception in service deposite amount", accountDaoException);
        }
    }

    @Override
    public double getCurrentBalance(final int accountNumber) throws AccountServiceException {
        try {
            return accountDao.getCurrentBalance(accountNumber);
        }
        catch (final AccountDaoException accountDaoException) {
            throw new AccountServiceException("exception in service getCurrentBalance", accountDaoException);
        }
    }

    @Override
    public Account getAccountDetail(final int accountNumber) throws AccountServiceException {
        try {
            return accountDao.getAccountDetail(accountNumber);
        }
        catch (final AccountDaoException accountDaoException) {
            throw new AccountServiceException("exception in service getAccountDetail", accountDaoException);
        }
    }

    @Override
    public double withDrawAmount(final int accountNumber, final double amount) throws AccountServiceException {
        try {
            final double currentAvailableBalance = accountDao.getCurrentBalance(accountNumber);
            if (currentAvailableBalance < amount) {
                throw new InsufficientBalanceException("insufficient balance ");
            }
            final double availableBalance = currentAvailableBalance - amount;
            accountDao.withDrawAmount(accountNumber, availableBalance);
            return availableBalance;
        }
        catch (final AccountDaoException accountDaoException) {
            throw new AccountServiceException("exception in service withDrawAmount", accountDaoException);
        }
        catch (final InsufficientBalanceException insufficientBalanceException) {
            throw new AccountServiceException("insufficient Balance Exception", insufficientBalanceException);
        }
    }
}
