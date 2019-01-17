/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
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

    private final String ADD_ACCOUNT;
    private final String GET_ACC_TYPE_ID;
    private final String GET_BALANCE;
    private final String DEPOSITE_AMOUNT;
    private final String GET_ACC_DETAIL;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * constructor of class {@link AccountDaoImpl}.
     *
     * @param jdbcTemplate {@link NamedParameterJdbcTemplate}
     * @param getAddAccount query for addAccount
     * @param getGetAccTypeId query for getAccountTypeId form account type
     * @param getBalance query for check current available balance
     * @param getDeposite query for deposite amount
     * @param accountDetail query for getAccountDetails
     */
    public AccountDaoImpl(NamedParameterJdbcTemplate jdbcTemplate, String getAddAccount, String getGetAccTypeId, String getBalance, String getDeposite, String accountDetail) {
        namedParameterJdbcTemplate = jdbcTemplate;
        ADD_ACCOUNT = getAddAccount;
        GET_ACC_TYPE_ID = getGetAccTypeId;
        GET_BALANCE = getBalance;
        DEPOSITE_AMOUNT = getDeposite;
        GET_ACC_DETAIL = accountDetail;
    }

    @Override
    public int addAccount(Account account) throws AccountDaoException {
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource getAccTypeId = new MapSqlParameterSource("type", account.getType());
            int accTypeId = namedParameterJdbcTemplate.queryForObject(GET_ACC_TYPE_ID, getAccTypeId, Integer.class).intValue();
            MapSqlParameterSource paramSourceAcc = mapParameterSource(account, accTypeId);
            namedParameterJdbcTemplate.update(ADD_ACCOUNT, paramSourceAcc, holder);
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
        paramDeposite.addValue("newBalance", newBalance);
        namedParameterJdbcTemplate.update(DEPOSITE_AMOUNT, paramDeposite);
        return newBalance;
    }

    @Override
    public double getCurrentBalance(int accountNumber) throws AccountDaoException {
        try {
            SqlParameterSource namedParameters = new MapSqlParameterSource("accNumber", accountNumber);
            return namedParameterJdbcTemplate.queryForObject(GET_BALANCE, namedParameters, Double.class);
        }
        catch (DataAccessException e) {
            throw new AccountDaoException("failed to getCurrent balance", e);
        }
    }

    @Override
    public Account getAccountDetail(int accountNumber) throws AccountDaoException {
        try {
            SqlParameterSource namedParameters = new MapSqlParameterSource("accNumber", accountNumber);
            return namedParameterJdbcTemplate.queryForObject(GET_ACC_DETAIL, namedParameters, new AccountMapper());
        }
        catch (DataAccessException e) {
            throw new AccountDaoException("failed to getAccountDetails ", e);
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
