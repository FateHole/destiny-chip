package com.fatehole.destinychip.exception;

/**
 * 保存或更新时检测到账号名重复所抛的异常
 * @author FateCat
 * @version 2020-10-10-20:57
 */
public class LoginAccountAlreadyInUserException extends RuntimeException {

    private static final long serialVersionUID = 3249806570283756L;

    public LoginAccountAlreadyInUserException() {
        super();
    }

    public LoginAccountAlreadyInUserException(String message) {
        super(message);
    }

    public LoginAccountAlreadyInUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAccountAlreadyInUserException(Throwable cause) {
        super(cause);
    }

    protected LoginAccountAlreadyInUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
