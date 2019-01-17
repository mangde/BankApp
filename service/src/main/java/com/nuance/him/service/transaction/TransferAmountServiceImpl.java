/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.service.transaction;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.nuance.him.dao.daoexception.TransferDaoException;
import com.nuance.him.dao.transaction.TransferDao;
import com.nuance.him.model.transaction.TransferAmount;
import com.nuance.him.service.account.AccountService;
import com.nuance.him.service.serviceexception.AccountServiceException;
import com.nuance.him.service.serviceexception.TransferAmountServiceException;
import java.util.List;

/**
 * {@link TransferAmountService}.
 */
public class TransferAmountServiceImpl implements TransferAmountService {

    /**
     * instance of {@link TransferDao}.
     */
    private final TransferDao transferDAO;
    private final AccountService accountService;

    /**
     * Constructor of {@link TransferAmountServiceImpl}.
     *
     * @param transferDAO instance of {@link TransferDao}
     */
    public TransferAmountServiceImpl(TransferDao transferDAO, AccountService accountService) {
        this.transferDAO = transferDAO;
        this.accountService = accountService;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
    @Override
    public int transferAmount(TransferAmount transferAmount) throws TransferAmountServiceException {
        try {
            try {
                accountService.getAccountDetail(transferAmount.getAccIdTo());
                accountService.withDrawAmount(transferAmount.getAccIdFrom(), transferAmount.getAmount());
                accountService.depositeAmount(transferAmount.getAccIdTo(), transferAmount.getAmount());
            }
            catch (AccountServiceException e) {
                throw new TransferAmountServiceException(" AccountServiceException in transferAmount ", e);
            }
            return transferDAO.transferAmount(transferAmount);
        }
        catch (TransferDaoException e) {
            throw new TransferAmountServiceException("serviceException in transferAmount", e);
        }
    }

    @Override
    public List<TransferAmount> getTransactionHistory(int accountNumber) throws TransferAmountServiceException {
        try {
            return transferDAO.getTransactionHistory(accountNumber);
        }
        catch (TransferDaoException e) {
            throw new TransferAmountServiceException("serviceException in transaction", e);
        }
    }
}

