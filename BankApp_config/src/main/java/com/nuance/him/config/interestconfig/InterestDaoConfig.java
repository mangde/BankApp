/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.config.interestconfig;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.nuance.him.config.DatabaseConfig;
import com.nuance.him.dao.account.SpringInterestCalDaoImpl;
import com.nuance.him.dao.account.SpringInterestCalcDao;
import com.nuance.him.dao.atm.SpringAtmDao;
import static org.springframework.util.Assert.notNull;

/**
 * SpringAccountDao {@link Configuration}.
 */
@Configuration
@Import(DatabaseConfig.class)
@PropertySource("classpath:sql-queries.xml")
@EnableTransactionManagement
public class InterestDaoConfig {

    private static final String CAL_MONTHLY_INTEREST = "calMonthlyInterest";

    @Value("${" + CAL_MONTHLY_INTEREST + "}")
    private String getCalMonthlyInterest;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * Validates namedParameterJdbcTemplate and database queries.
     */
    @PostConstruct
    public void postConstruct() {
        notNull(getCalMonthlyInterest, "missing monthlyInterest  query");
    }

    /**
     * bean for {@link SpringAtmDao}.
     *
     * @return AtmDaoImpl
     */
    @Bean
    public SpringInterestCalcDao springInterestCalcDao() {
        return new SpringInterestCalDaoImpl(namedParameterJdbcTemplate, getCalMonthlyInterest);
    }
}
