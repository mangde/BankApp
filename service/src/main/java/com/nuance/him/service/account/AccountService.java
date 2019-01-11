/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.service.account;

import com.nuance.him.model.accountmodel.Account;
import com.nuance.him.service.serviceexception.AccountServiceException;

public interface AccountService {

    /**
     * Add new customer account
     * @param account instance of {@link Account}
     * @return account number
     * @throws AccountServiceException
     */
    int addAccount(Account account)throws AccountServiceException;
}
