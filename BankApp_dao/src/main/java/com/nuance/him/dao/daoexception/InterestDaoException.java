package com.nuance.him.dao.daoexception;

/**
 * Handle InterestDaoException.
 */
public class InterestDaoException extends Exception {

    private static final String MESSAGE = "";

    /**
     * Constructor.
     *
     * @param MESSAGE message for the exception
     * @param cause exception
     */
    public InterestDaoException( final String MESSAGE, final Throwable cause) {
        super(MESSAGE, cause);
    }

    /**
     * Gets the exception messages.
     */
    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
