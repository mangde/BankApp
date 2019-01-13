package com.nuance.him.service.account;

import com.nuance.him.dao.account.AccountDAO;
import com.nuance.him.dao.daoexception.AccountDAOException;
import com.nuance.him.model.accountmodel.Account;
import com.nuance.him.service.serviceexception.AccountServiceException;

public class AccountServiceImpl implements AccountService {

    private final AccountDAO accountDAO;
    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO=accountDAO;
    }

    @Override
    public int addAccount( Account account) throws AccountServiceException {
        try{
            return accountDAO.addAccount(account);
        }catch (AccountDAOException a){
            throw new AccountServiceException("exception in service",a);
        }
    }
}
