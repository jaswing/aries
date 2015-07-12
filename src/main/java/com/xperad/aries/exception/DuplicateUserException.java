package com.xperad.aries.exception;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/05/23
 */
public class DuplicateUserException extends Exception {

    public DuplicateUserException() {
    }

    public DuplicateUserException(String message) {
        super(message);
    }

    public DuplicateUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateUserException(Throwable cause) {
        super(cause);
    }

    public DuplicateUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
