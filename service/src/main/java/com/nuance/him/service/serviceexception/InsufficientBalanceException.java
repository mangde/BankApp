/*
 *
 *  COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  Warning: This product is protected by United States copyright law. Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 * /
 *
 */
package com.nuance.him.service.serviceexception;

public class InsufficientBalanceException extends Exception {

    private static String MESSAGE;

    public InsufficientBalanceException(String insufficientBalance) {
        MESSAGE = insufficientBalance;
    }

    /**
     * Gets the exception messages.
     */
    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
