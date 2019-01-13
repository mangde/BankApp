/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.dao.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.nuance.him.dao.daoexception.AccountDAOException;
import com.nuance.him.model.accountmodel.Account;
import com.nuance.him.model.accountmodel.AccountType;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAOImpl implements AccountDAO {

    private static final Logger log = LoggerFactory.getLogger(AccountDAOImpl.class);
    private final String ADD_ACCOUNT;
    private final String GET_ACC_TYPE_ID;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AccountDAOImpl(NamedParameterJdbcTemplate jdbcTemplate, String getAddAccount, String getGetAccTypeId) {
        this.namedParameterJdbcTemplate = jdbcTemplate;
        ADD_ACCOUNT = getAddAccount;
        GET_ACC_TYPE_ID = getGetAccTypeId;
    }

    @Override
    public int addAccount(Account account) throws AccountDAOException {
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            MapSqlParameterSource paramAccTypeId = new MapSqlParameterSource();
            SqlParameterSource namedParameters = new MapSqlParameterSource("type", account.getType());
            // namedParameterJdbcTemplate.query(GET_ACCTYPE_ID,new AccountTypeMapper());
           // paramAccTypeId.addValue("type", account.getType());




            int accTypeId = namedParameterJdbcTemplate.queryForObject(GET_ACC_TYPE_ID, namedParameters, Integer.class).intValue();

            MapSqlParameterSource paramSourceAcc = new MapSqlParameterSource();
            paramSourceAcc.addValue("accTypeId", accTypeId);
            paramSourceAcc.addValue("balance", account.getBalance());
            paramSourceAcc.addValue("customerId", account.getCustomerId());
            namedParameterJdbcTemplate.update(ADD_ACCOUNT, paramSourceAcc, holder);
            return holder.getKey().intValue();
        }
        catch (DataAccessException e) {
            log.error("error in Add ACC DAO ", e.getCause());
            throw new AccountDAOException("Failed to add Account ", e);
        }
    }

    private AccountType toAccountType(ResultSet resultSet)throws SQLException {
                return  new AccountType(resultSet.getInt("AccTypeId"),resultSet.getString("AccTypeDesc"));
    }


}
