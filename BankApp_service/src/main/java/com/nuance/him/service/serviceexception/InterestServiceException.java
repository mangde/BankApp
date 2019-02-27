package com.nuance.him.service.serviceexception;

/**
 * handle service exception of InterestService.
 */
public class InterestServiceException extends Exception {

    private static final String MESSAGE = "";

    /**
     * Constructor.
     *
     * @param MESSAGE message for the exception
     * @param cause exception
     */
    public InterestServiceException(final String MESSAGE, final Throwable cause) {
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
