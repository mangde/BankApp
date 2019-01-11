/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
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
    private final String ADD_ACCOOUNT;
    private final String GET_ACCTYPE_ID;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public AccountDAOImpl(NamedParameterJdbcTemplate jdbcTemplate, String getAddAccoount, String getGetAcctypeId) {
        this.namedParameterJdbcTemplate = jdbcTemplate;
        ADD_ACCOOUNT = getAddAccoount;
        GET_ACCTYPE_ID = getGetAcctypeId;
    }

    @Override
    public int addAccount(Account account) throws AccountDAOException {
        log.info("inside ac dao");
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            MapSqlParameterSource paramAccTypeId = new MapSqlParameterSource();
            SqlParameterSource namedParameters = new MapSqlParameterSource("type", account.getType());
            // namedParameterJdbcTemplate.query(GET_ACCTYPE_ID,new AccountTypeMapper());
           // paramAccTypeId.addValue("type", account.getType());

         /*  List<AccountType> accountTypes = namedParameterJdbcTemplate.query(GET_ACCTYPE_ID,new MapSqlParameterSource("type", account.getType()), (resultSet, i) -> {
                    return toAccountType(resultSet);
                })*/;


            int acctypeId = namedParameterJdbcTemplate.queryForObject(GET_ACCTYPE_ID, namedParameters, Integer.class);
            log.info("getting accTypeId ac dao");

            MapSqlParameterSource paramSourceAcc = new MapSqlParameterSource();
            paramSourceAcc.addValue("accTypeId", acctypeId);
            paramSourceAcc.addValue("balance", account.getBalance());
            paramSourceAcc.addValue("customerId", account.getCustomerId());
            namedParameterJdbcTemplate.update(ADD_ACCOOUNT, paramSourceAcc, holder);
            return holder.getKey().intValue();
        }
        catch (DataAccessException e) {
            log.error("error in Add ACCDAO ", e.getCause());
            throw new AccountDAOException("Failed to add Account ", e);
        }
    }

    private AccountType toAccountType(ResultSet resultSet)throws SQLException {
        AccountType accountType= new AccountType();
        accountType.setAccTypeId(resultSet.getInt(1));
        accountType.setAccTypeDesc(resultSet.getString(2));
        return accountType;
    }


}
