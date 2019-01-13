/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law.
  *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */

package com.nuance.him.controller.transaction;

import com.nuance.him.service.transaction.TransactionServices;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
private final TransactionServices transactionServices;
    public TransactionController(TransactionServices transactionServices) {
        this.transactionServices = transactionServices;
    }
}
