/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.dao.account;

import com.nuance.him.dao.daoexception.AccountDaoException;
import com.nuance.him.model.accountmodel.Account;

/**
 * AccountDAO interface.
 */
public interface AccountDao {

    /**
     * Add Account.
     *
     * @param account instance of {@link Account}
     * @return account number
     * @throws AccountDaoException exception
     */
    int addAccount(Account account) throws AccountDaoException;

    /**
     * Deposite amount into account.
     *
     * @param accountNumber account number
     * @param amount total amount to be deposited
     * @return successful deposited message
     * @throws AccountDaoException exception
     */
    double depositeAmount(int accountNumber, double amount) throws AccountDaoException;

    /**
     * get Balance.
     *
     * @param accountNumber account number
     * @return current balance
     * @throws AccountDaoException exception
     */
    double getCurrentBalance(int accountNumber) throws AccountDaoException;

    /**
     * Get Account details.
     *
     * @param accountNumber accNumber
     * @return instance of {@link Account}
     * @throws AccountDaoException exception
     */
    Account getAccountDetail(int accountNumber) throws AccountDaoException;
}
