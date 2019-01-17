/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */
package com.nuance.him.service.test.transaction;

import com.nuance.him.dao.daoexception.TransactionDaoException;
import com.nuance.him.dao.transaction.TransactionDao;
import com.nuance.him.model.transaction.Transaction;
import com.nuance.him.service.test.serviceexception.TransactionServiceException;
import java.util.List;

/**
 * {@link TransactionServices}.
 */
public class TransactionServicesImpl implements TransactionServices {

    /**
     * instance of {@link TransactionDao}.
     */
    private final TransactionDao transactionDAO;

    /**
     * Constructor of {@link TransactionServicesImpl}.
     *
     * @param transactionDAO instance of {@link TransactionDao}
     */
    public TransactionServicesImpl(TransactionDao transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @Override
    public int transferAmount(Transaction transaction, double currentBalanceFromAc) throws TransactionServiceException {
        try {
            return transactionDAO.transferAmount(transaction, currentBalanceFromAc);
        }
        catch (TransactionDaoException e) {
            throw new TransactionServiceException("serviceException in transaction", e);
        }
    }

    @Override
    public List<Transaction> getTransactionHistory(int accountNumber) throws TransactionServiceException {
        try {
            return transactionDAO.getTransactionHistory(accountNumber);
        }
        catch (TransactionDaoException e) {
            throw new TransactionServiceException("serviceException in transaction", e);
        }
    }
}

