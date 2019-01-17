/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.dao.transaction;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.nuance.him.dao.daoexception.TransferDaoException;
import com.nuance.him.model.transaction.TransferAmount;
import java.util.Date;
import java.util.List;

/**
 * implements {@link TransferDao}.
 */
public class TransferDaoImpl implements TransferDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String getTransferAmount;
    private final String getTransactionHistory;

    /**
     * constructor of {@link TransferDaoImpl}.
     *
     * @param namedParameterJdbcTemplate instance of {@link NamedParameterJdbcTemplate}
     * @param getTransferAmount query for transfer amount
     * @param getTransactionHistory query for getTransaction Details
     */
    public TransferDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, String getTransferAmount, String getTransactionHistory) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.getTransferAmount = getTransferAmount;
        this.getTransactionHistory = getTransactionHistory;
    }

    @Override
    public int transferAmount(TransferAmount transferAmount) throws TransferDaoException {
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            MapSqlParameterSource paramSource = mapParameterSource(transferAmount);
            namedParameterJdbcTemplate.update(getTransferAmount, paramSource, holder);
            return holder.getKey().intValue();
        }
        catch (DataAccessException e) {
            throw new TransferDaoException("Failed to transfer amount", e);
        }
    }

    @Override
    public List<TransferAmount> getTransactionHistory(int accountNumber) throws TransferDaoException {
        try {
            SqlParameterSource accNumber = new MapSqlParameterSource("accNumber", accountNumber);
            return namedParameterJdbcTemplate.query(getTransactionHistory, accNumber, new TransactionMapper());
        }
        catch (DataAccessException e) {
            throw new TransferDaoException("Failed to display TransferAmount details", e);
        }
    }

    /**
     * method to map sqlParameter.
     *
     * @param transferAmount instance of class {@link TransferAmount}
     * @param currentBalance currentBalanceFromAc
     * @return instance of {@link MapSqlParameterSource}
     */
    private MapSqlParameterSource mapParameterSource(TransferAmount transferAmount) {
        java.util.Date date = new Date();
        Object param = new java.sql.Timestamp(date.getTime());
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("dateTime", param);
        paramSource.addValue("amount", transferAmount.getAmount());
        paramSource.addValue("accFrom", transferAmount.getAccIdFrom());
        paramSource.addValue("accTo", transferAmount.getAccIdTo());
        paramSource.addValue("description", transferAmount.getDescription());
        return paramSource;
    }
}
