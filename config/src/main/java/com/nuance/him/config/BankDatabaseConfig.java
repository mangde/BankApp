/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.config;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BankDatabaseConfig {

    @Value("${dataSource:url}")
    private String url;

    /**
     * Data source bean.
     *
     * @return the data source
     */
    @Bean
    private DataSource dataSource() {
        SQLServerDataSource ds = null;
        try {
            // Establish the connection.
            ds = new SQLServerDataSource();
            ds.setURL(this.url);
            ds.getConnection();
        }
        catch (SQLServerException e) {
            e.toString();
        }
        return ds;
    }

    /**
     *
     * @param dataSource instance of dataSource
     * @return bean of {@link NamedParameterJdbcTemplate}
     */
    @Bean
    @Qualifier("dataSource")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * bean for {@link org.springframework.transaction.annotation.Transactional}
     * @return instance of {@link PlatformTransactionManager}
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(this.dataSource());
    }


}
