/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.config.transactionconfig;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.nuance.him.config.BankDatabaseConfig;
import com.nuance.him.dao.transaction.TransferDao;
import com.nuance.him.dao.transaction.TransferDaoImpl;
import static org.springframework.util.Assert.notNull;

/**
 * {@link TransferAmountDaoConfig}.
 */
@Configuration
@Import(BankDatabaseConfig.class)
@PropertySource("classpath:sql-queries.xml")
public class TransferAmountDaoConfig {

    private static final String TRANSFER_AMOUNT = "transfer";
    private static final String TRANSACTION_HISTORY = "transactionHistory";
    @Value("${" + TRANSFER_AMOUNT + "}")
    private String getTransferAmount;
    @Value("${" + TRANSACTION_HISTORY + "}")
    private String getTransactionHistory;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * Validates namedParameterJdbcTemplate and database queries.
     */
    @PostConstruct
    public void postConstruct() {
        notNull(namedParameterJdbcTemplate, "missing bean namedParameterJdbcTemplate");
        notNull(getTransferAmount, "missing getTransferAmount query");
        notNull(getTransactionHistory, "missing getTransactionHistory query");
    }

    /**
     * bean for transactionDAO.
     *
     * @return TransactionDAOImpl
     */
    @Bean
    public TransferDao transactionDAO() {
        return new TransferDaoImpl(namedParameterJdbcTemplate, getTransferAmount, getTransactionHistory);
    }
}
