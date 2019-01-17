/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.dao.account;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.nuance.him.dao.daoexception.AccountDaoException;
import com.nuance.him.model.accountmodel.Account;

/**
 * Implementation of interface AccountDao.
 */
public class AccountDaoImpl implements AccountDao {

    private final String getAddAccount;
    private final String getGetAccTypeId;
    private final String getBalance;
    private final String getDeposite;
    private final String accountDetail;
    private final String withDraw;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * constructor of class {@link AccountDaoImpl}.
     *
     * @param namedParameterJdbcTemplate {@link NamedParameterJdbcTemplate}
     * @param getAddAccount query for addAccount
     * @param getGetAccTypeId query for getAccountTypeId form account type
     * @param getBalance query for check current available balance
     * @param getDeposite query for deposite amount
     * @param accountDetail query for getAccountDetails
     */
    public AccountDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, String getAddAccount, String getGetAccTypeId, String getBalance, String getDeposite, String accountDetail, String getWithDraw) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.getAddAccount = getAddAccount;
        this.getGetAccTypeId = getGetAccTypeId;
        this.getBalance = getBalance;
        this.getDeposite = getDeposite;
        this.accountDetail = accountDetail;
        withDraw = getWithDraw;
    }

    @Override
    public int addAccount(Account account) throws AccountDaoException {
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource getAccTypeId = new MapSqlParameterSource("type", account.getType());
            int accTypeId = namedParameterJdbcTemplate.queryForObject(getGetAccTypeId, getAccTypeId, Integer.class).intValue();
            MapSqlParameterSource paramSourceAcc = mapParameterSource(account, accTypeId);
            namedParameterJdbcTemplate.update(getAddAccount, paramSourceAcc, holder);
            return holder.getKey().intValue();
        }
        catch (DataAccessException e) {
            throw new AccountDaoException("Failed to add Account ", e);
        }
    }

    @Override
    public double depositeAmount(int accountNumber, double amount) throws AccountDaoException {
        double newBalance = amount + getCurrentBalance(accountNumber);
        MapSqlParameterSource paramDeposite = new MapSqlParameterSource();
        paramDeposite.addValue("accNumber", accountNumber);
        paramDeposite.addValue("balance", newBalance);
        namedParameterJdbcTemplate.update(getDeposite, paramDeposite);
        return newBalance;
    }

    @Override
    public double getCurrentBalance(int accountNumber) throws AccountDaoException {
        try {
            SqlParameterSource namedParameters = new MapSqlParameterSource("accNumber", accountNumber);
            return namedParameterJdbcTemplate.queryForObject(getBalance, namedParameters, Double.class);
        }
        catch (DataAccessException e) {
            throw new AccountDaoException("failed to getCurrent balance", e);
        }
    }

    @Override
    public Account getAccountDetail(int accountNumber) throws AccountDaoException {
        try {
            SqlParameterSource namedParameters = new MapSqlParameterSource("accNumber", accountNumber);
            return namedParameterJdbcTemplate.queryForObject(accountDetail, namedParameters, new AccountMapper());
        }
        catch (DataAccessException e) {
            throw new AccountDaoException("failed to getAccountDetails ", e);
        }
    }

    @Override
    public double withDrawAmount(int accountNumber, double amount) throws AccountDaoException {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("balance", amount);
        paramSource.addValue("accNumber", accountNumber);
        try {
            return namedParameterJdbcTemplate.update(withDraw, paramSource);
        }
        catch (DataAccessException e) {
            throw new AccountDaoException("failed to withDrawAmount ", e);
        }
    }

    /**
     * method  map sql parameter foe add account.
     *
     * @param account instance of class {@link Account}
     * @param Id accountTypeId
     * @return paramSource
     */
    private MapSqlParameterSource mapParameterSource(Account account, int Id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("accTypeId", Id);
        paramSource.addValue("balance", account.getBalance());
        paramSource.addValue("customerId", account.getCustomerId());
        return paramSource;
    }
}
