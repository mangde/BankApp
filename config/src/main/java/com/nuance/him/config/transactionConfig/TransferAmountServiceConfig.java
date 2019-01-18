/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.config.transactionconfig;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.nuance.him.config.accountconfig.AccountServiceConfig;
import com.nuance.him.dao.transaction.TransferDao;
import com.nuance.him.service.account.AccountService;
import com.nuance.him.service.transaction.TransferAmountService;
import com.nuance.him.service.transaction.TransferAmountServiceImpl;
import static org.apache.commons.lang3.Validate.notNull;

/**
 * {@link TransferAmountServiceConfig}.
 */
@Configuration
@Import({ TransferAmountDaoConfig.class, AccountServiceConfig.class })
public class TransferAmountServiceConfig {

    @Autowired
    private TransferDao transferDAO;
    @Autowired
    private AccountService accountService;

    /**
     * Validate the variables.
     */
    @PostConstruct
    public void postConstruct() {
        notNull(transferDAO, "missing bean transferDAO");
        notNull(accountService, "missing bean accountService");
    }

    /**
     * bean For {@link TransferAmountService}.
     *
     * @return TransferAmountServiceImpl
     */
    @Bean
    public TransferAmountService transactionServices() {
        return new TransferAmountServiceImpl(transferDAO, accountService);
    }
}
