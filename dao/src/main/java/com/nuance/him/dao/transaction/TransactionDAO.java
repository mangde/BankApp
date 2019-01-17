/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */
package com.nuance.him.dao.transaction;

import com.nuance.him.dao.daoexception.TransactionDaoException;
import com.nuance.him.model.transaction.Transaction;
import java.util.List;

public interface TransactionDao {

    /**
     * transfer amount to self or other account.
     *
     * @param transaction instance of class {@link Transaction} hold values
     * @param currentBalanceFromAc current available balance of debit account
     * @return success or failure message
     * @throws TransactionDaoException daoException
     */
    int transferAmount(Transaction transaction, double currentBalanceFromAc) throws TransactionDaoException;

    /**
     * Transaction history.
     *
     * @param accountNumber accNo
     * @return list of transaction record
     * @throws TransactionDaoException daoException
     */
    List<Transaction> getTransactionHistory(int accountNumber) throws TransactionDaoException;
}
