/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.config.accountconfig;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.nuance.him.config.BankDatabaseConfig;
import com.nuance.him.dao.account.AccountDao;
import com.nuance.him.dao.account.AccountDaoImpl;
import static org.springframework.util.Assert.notNull;

/**
 * AccountDao {@link Configuration}.
 */
@Configuration
@Import(BankDatabaseConfig.class)
@PropertySource("classpath:sql-queries.xml")
public class AccountDaoConfig {

    private static final String ADD_ACCOUNT = "addAccount";
    private static final String GET_ACC_TYPE_ID = "getAccTypeId";
    private static final String GET_BALANCE = "getBalance";
    private static final String DEPOSITE_AMOUNT = "depositeAmount";
    private static final String ACCOUNT_DETAIL = "accountDetail";
    private static final String WITHDRAW_AMOUNT = "withDraw";
    /**
     * get values of Query AddNewAccount.
     */
    @Value("${" + AccountDaoConfig.ADD_ACCOUNT + "}")
    private String getAddAccount;
    /**
     * get values of Query AccountTypeId.
     */
    @Value("${" + AccountDaoConfig.GET_ACC_TYPE_ID + "}")
    private String getGetAccTypeId;
    /**
     * get values of Query getBalance.
     */
    @Value("${" + AccountDaoConfig.GET_BALANCE + "}")
    private String getGetBalance;
    /**
     * get value of Query deposite Amount.
     */
    @Value("${" + AccountDaoConfig.DEPOSITE_AMOUNT + "}")
    private String getDepositeAmount;
    /**
     * get value of query AccountDetails.
     */
    @Value("${" + AccountDaoConfig.ACCOUNT_DETAIL + "}")
    private String getAccountDetail;
    @Value("${" + WITHDRAW_AMOUNT + "}")
    private String getWithdrawAmount;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * Validates namedParameterJdbcTemplate and database queries.
     */
    @PostConstruct
    public void postConstruct() {
        notNull(namedParameterJdbcTemplate, "missing bean namedParameterJdbcTemplate");
        notNull(getAddAccount, "missing addAccount query");
        notNull(getGetAccTypeId, "missing getAccTypeId");
        notNull(getGetBalance, "missing getBalance Bean");
        notNull(getDepositeAmount, "missing getDepositeAmount");
        notNull(getAccountDetail, "missing getAccountDetail");
        notNull(getWithdrawAmount, "missing getWithdrawAmount query");
    }

    /**
     * bean for {@link AccountDao}.
     *
     * @return AccountDAOImpl
     */
    @Bean
    public AccountDao accountDAO() {
        return new AccountDaoImpl(namedParameterJdbcTemplate, getAddAccount, getGetAccTypeId, getGetBalance, getDepositeAmount, getAccountDetail, getWithdrawAmount);
    }
}
