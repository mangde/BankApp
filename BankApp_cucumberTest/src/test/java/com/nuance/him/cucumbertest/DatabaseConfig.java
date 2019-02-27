/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.cucumbertest;

import javax.sql.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Database connection configuration.
 */
@Configuration
@PropertySource("classpath:test.properties")
public class DatabaseConfig {

    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.driver}")
    private String driverClass;
    @Value("${jdbc.user}")
    private String userName;

    @Value("${jdbc.password}")
    private String password;



    /**
     * Factory for DataSource providing database connection details.
     *
     * @return dataSource
     */
    @Bean
    public org.apache.tomcat.jdbc.pool.DataSource dataSource() {
        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setDriverClassName(driverClass);
        poolProperties.setDefaultAutoCommit(false);
        poolProperties.setMaxActive(10);
        poolProperties.setMaxIdle(10);
        poolProperties.setTestOnBorrow(true);
        poolProperties.setValidationQuery("1");
        poolProperties.setValidationInterval(30000);
        poolProperties.setTestWhileIdle(true);
        poolProperties.setTimeBetweenEvictionRunsMillis(60000);
        poolProperties.setRemoveAbandoned(true);
        poolProperties.setRemoveAbandonedTimeout(600);
        poolProperties.setAccessToUnderlyingConnectionAllowed(true);
        poolProperties.setMaxWait(500000);
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource(poolProperties);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
      return dataSource;
    }


    /**
     * @param dataSource instance of dataSource
     * @return bean of {@link NamedParameterJdbcTemplate}
     */
    @Bean
    @Qualifier("dataSource")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(final DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * bean for {@link org.springframework.transaction.annotation.Transactional}.
     *
     * @return instance of {@link PlatformTransactionManager}
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * crating bean for accessing values form property file.
     *
     * @return propertySource Bean
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
