/*
 *
 *  * COPYRIGHT: Copyright (c) 2019 by Nuance Communications, Inc.
 *  *  Warning: This product is protected by United States copyright law.
  *  Unauthorized use or duplication of this software, in whole or in part, is prohibited.
 *  *
 *
 */

package com.nuance.him.service.serviceexception;

/**
 * Exception class for {@link TransactionServiceException}
 */
public class TransactionServiceException extends Exception {
    private static final String MESSAGE = "";

    /**
     * Constructor.
     *
     * @param MESSAGE message for the exception
     * @param cause exception
     */
    public TransactionServiceException(String MESSAGE, Throwable cause) {
        super(MESSAGE, cause);
    }

    /**
     * Gets the exception messages.
     */
    @Override
    public String getMessage() {
        return TransactionServiceException.MESSAGE;
    }

}
