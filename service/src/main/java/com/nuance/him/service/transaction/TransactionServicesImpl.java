/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */

package com.nuance.him.service.transaction;

import com.nuance.him.dao.transaction.TransactionDAO;

public class TransactionServicesImpl implements TransactionServices {
    private final  TransactionDAO transactionDAO;

    public TransactionServicesImpl(TransactionDAO transactionDAO) {
        this.transactionDAO=transactionDAO;
    }
}
