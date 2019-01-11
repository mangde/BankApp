/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.config.accountConfig;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.nuance.him.config.BankDatabaseConfig;
import com.nuance.him.dao.account.AccountDAO;
import com.nuance.him.dao.account.AccountDAOImpl;
import static org.springframework.util.Assert.notNull;

@Configuration
@Import(BankDatabaseConfig.class)
@PropertySource("classpath:sql-queries.xml")
public class AccountDaoConfig {

    private static final String ADD_ACCOOUNT = "addAccount";
    private static final String GET_ACCTYPE_ID = "getAccTypeId";

    @Value("${" + ADD_ACCOOUNT + "}")
    private String getAddAccoount;

    @Value("${" + GET_ACCTYPE_ID + "}")
    public String getGetAcctypeId;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * Validates jdbcTemplate and database queries.
     */
    @PostConstruct
    public void postConstruct() {
        notNull(this.jdbcTemplate, "missing bean jdbcTemplate");
        notNull(getAddAccoount,"missing addAccount query");
        notNull(getGetAcctypeId,"missing getAccTypeId");
    }

    @Bean
    public AccountDAO accountDAO() {
        return new AccountDAOImpl(jdbcTemplate,getAddAccoount,getGetAcctypeId);
    }
}
