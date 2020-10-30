package com.fatehole.destinychip.exception;

/**
 * 保存或更新时检测到账号名重复所抛的异常
 * @author FateCat
 * @version 2020-10-10-20:57
 */
public class LoginAccountAlreadyInUserForUpdateException extends RuntimeException {

    private static final long serialVersionUID = 32498444365756L;

    public LoginAccountAlreadyInUserForUpdateException() {
        super();
    }

    public LoginAccountAlreadyInUserForUpdateException(String message) {
        super(message);
    }

    public LoginAccountAlreadyInUserForUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAccountAlreadyInUserForUpdateException(Throwable cause) {
        super(cause);
    }

    protected LoginAccountAlreadyInUserForUpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
