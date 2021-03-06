/*
 * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 * Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 */
package com.nuance.him.config.transactionconfig;

import com.nuance.him.config.accountconfig.AccountServiceConfig;
import com.nuance.him.dao.transaction.SpringTransferDao;
import com.nuance.him.service.account.AccountService;
import com.nuance.him.service.transaction.TransferAmountService;
import com.nuance.him.service.transaction.TransferAmountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * {@link TransferAmountServiceConfig}.
 */
@Configuration
@Import({ TransferAmountDaoConfig.class, AccountServiceConfig.class })
public class TransferAmountServiceConfig {

    @Autowired
    private SpringTransferDao springTransferDAO;
    @Autowired
    private AccountService accountService;

    /**
     * bean For {@link TransferAmountService}.
     *
     * @return TransferAmountServiceImpl
     */
    @Bean
    public TransferAmountService transactionServices() {
        return new TransferAmountServiceImpl(springTransferDAO, accountService);
    }
}
