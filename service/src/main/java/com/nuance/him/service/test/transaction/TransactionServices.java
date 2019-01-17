/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */
package com.nuance.him.service.test.transaction;

import com.nuance.him.model.transaction.Transaction;
import com.nuance.him.service.test.serviceexception.TransactionServiceException;
import java.util.List;

/**
 * {@link TransactionServices}.
 */
public interface TransactionServices {

    /**
     * transfer amount to self or other account.
     *
     * @param transaction instance of class {@link Transaction} hold values
     * @param currentBalanceFromAc currentBalanceFromAc
     * @return success or failure message
     * @throws TransactionServiceException serviceException
     */
    int transferAmount(Transaction transaction, double currentBalanceFromAc) throws TransactionServiceException;

    /**
     * Get Transaction detail of account.
     *
     * @param accountNumber accountId
     * @return List of  transaction History
     * @throws TransactionServiceException serviceException
     */
    List<Transaction> getTransactionHistory(int accountNumber) throws TransactionServiceException;
}
