/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.dao.customer;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

/**
 * Test class to connection of database.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class BankDatabaseTest {

    @Value("${dataSource.url}")
    private String url;

    /**
     * bean for read properties file.
     *
     * @return bean
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * Data source bean.
     *
     * @return the data source
     */
    @Bean
    public DataSource dataSource() {
        SQLServerDataSource ds = null;
        try {
            ds = new SQLServerDataSource();
            ds.setURL(url);
            ds.getConnection();
        }
        catch (SQLServerException e) {
            e.toString();
        }
        return ds;
    }

    /**
     * bean for jdbcConnection.
     *
     * @param dataSource instance of dataSource
     * @return jdbcConnection
     */
    @Bean
    @Qualifier("dataSource")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * bean for read  transaction rollback.
     *
     * @return bean
     */
    @Bean
    PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
