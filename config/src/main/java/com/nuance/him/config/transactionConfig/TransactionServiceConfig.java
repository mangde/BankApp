/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law.
 *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *
 */
package com.nuance.him.config.transactionConfig;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.nuance.him.dao.transaction.TransactionDao;
import com.nuance.him.service.test.transaction.TransactionServices;
import com.nuance.him.service.test.transaction.TransactionServicesImpl;
import static org.apache.commons.lang3.Validate.notNull;

/**
 * {@link TransactionServiceConfig}.
 */
@Configuration
@Import(TransactionDaoConfig.class)
public class TransactionServiceConfig {

    @Autowired
    private TransactionDao transactionDAO;

    /**
     * Validate the variables.
     */
    @PostConstruct
    public void postConstruct() {
        notNull(transactionDAO, "missing bean transactionDAO");
    }

    /**
     * bean For {@link TransactionServices}.
     *
     * @return TransactionServicesImpl
     */
    @Bean
    public TransactionServices transactionServices() {
        return new TransactionServicesImpl(transactionDAO);
    }
}
