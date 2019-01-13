/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.dao.account;

import com.nuance.him.dao.daoexception.AccountDAOException;
import com.nuance.him.model.accountmodel.Account;

public interface AccountDAO {

    /**
     * Add Account
     * @param account instance of {@link Account}
     * @return account number
     * @throws AccountDAOException exception
     */
    int addAccount(Account account) throws AccountDAOException;
}
