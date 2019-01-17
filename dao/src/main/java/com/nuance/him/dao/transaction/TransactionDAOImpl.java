/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */
package com.nuance.him.dao.transaction;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.nuance.him.dao.daoexception.TransactionDaoException;
import com.nuance.him.model.transaction.Transaction;
import java.util.Date;
import java.util.List;

/**
 * implements {@link TransactionDao}.
 */
public class TransactionDaoImpl implements TransactionDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String TRANSFER_AMOUNT;
    private final String UPDATE_DEBIT_ACC_BALANCE;
    private final String TRANSACTION_HISTORY;

    /**
     * constructor of {@link TransactionDaoImpl}.
     *
     * @param namedParameterJdbcTemplate instance of {@link NamedParameterJdbcTemplate}
     * @param getTransferAmount query for transfer amount
     * @param getUpdateBalance query for update debit account
     * @param  getTransactionHistory query for getTransaction Details
     */
    public TransactionDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, String getTransferAmount, String getUpdateBalance, String getTransactionHistory) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        TRANSFER_AMOUNT = getTransferAmount;
        UPDATE_DEBIT_ACC_BALANCE = getUpdateBalance;
        TRANSACTION_HISTORY = getTransactionHistory;
    }

    @Override
    public int transferAmount(Transaction transaction, double currentBalanceFromAc) throws TransactionDaoException {
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            MapSqlParameterSource paramSource = mapParameterSource(transaction, currentBalanceFromAc);
            namedParameterJdbcTemplate.update(TRANSFER_AMOUNT, paramSource, holder);
            namedParameterJdbcTemplate.update(UPDATE_DEBIT_ACC_BALANCE, paramSource);
            return holder.getKey().intValue();
        }
        catch (DataAccessException e) {
            throw new TransactionDaoException("Failed to transfer amount", e);
        }
    }

    @Override
    public List<Transaction> getTransactionHistory(int accountNumber) throws TransactionDaoException {
        try {
            SqlParameterSource accNumber = new MapSqlParameterSource("accNumber", accountNumber);
            return namedParameterJdbcTemplate.query(TRANSACTION_HISTORY, accNumber, new TransactionMapper());
        }
        catch (DataAccessException e) {
            throw new TransactionDaoException("Failed to display Transaction details", e);
        }
    }

    /**
     * method to map sqlParameter.
     *
     * @param transaction instance of class {@link Transaction}
     * @return instance of {@link MapSqlParameterSource}
     * @param currentBalance currentBalanceFromAc
     */
    private MapSqlParameterSource mapParameterSource(Transaction transaction, double currentBalance) {
        java.util.Date date = new Date();
        Object param = new java.sql.Timestamp(date.getTime());
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        double newBalanceDebitAc = currentBalance - transaction.getAmount();
        paramSource.addValue("dateTime", param);
        paramSource.addValue("amount", transaction.getAmount());
        paramSource.addValue("accFrom", transaction.getAccIdFrom());
        paramSource.addValue("accTo", transaction.getAccIdTo());
        paramSource.addValue("description", transaction.getDescription());
        paramSource.addValue("newBalance", newBalanceDebitAc);
        paramSource.addValue("accNumber", transaction.getAccIdFrom());
        return paramSource;
    }
}
