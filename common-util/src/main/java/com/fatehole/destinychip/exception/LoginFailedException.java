package com.fatehole.destinychip.exception;

/**
 * 登陆失败后抛出的异常
 * @author FateCat
 * @version 2020-10-07-17:04
 */
public class LoginFailedException extends RuntimeException {

    private static final long serialVersionUID = 2934623894623874625L;

    public LoginFailedException() {
        super();
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }

    protected LoginFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
