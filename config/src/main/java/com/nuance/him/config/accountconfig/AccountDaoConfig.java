/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.config.accountconfig;

import com.nuance.him.config.BankDatabaseConfig;
import com.nuance.him.dao.account.AccountDAO;
import com.nuance.him.dao.account.AccountDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.annotation.PostConstruct;

import static org.springframework.util.Assert.notNull;

@Configuration
@Import(BankDatabaseConfig.class)
@PropertySource("classpath:sql-queries.xml")
public class AccountDaoConfig {

    private static final String ADD_ACCOUNT = "addAccount";
    private static final String GET_ACC_TYPE_ID = "getAccTypeId";

    @Value("${" + AccountDaoConfig.ADD_ACCOUNT + "}")
    private String getAddAccount;

    @Value("${" + AccountDaoConfig.GET_ACC_TYPE_ID + "}")
    private String getGetAccTypeId;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * Validates namedParameterJdbcTemplate and database queries.
     */
    @PostConstruct
    public void postConstruct() {
        notNull(this.namedParameterJdbcTemplate, "missing bean namedParameterJdbcTemplate");
        notNull(getAddAccount,"missing addAccount query");
        notNull(getGetAccTypeId,"missing getAccTypeId");
    }

    @Bean
    public AccountDAO accountDAO() {
        return new AccountDAOImpl(namedParameterJdbcTemplate,getAddAccount,getGetAccTypeId);
    }
}
