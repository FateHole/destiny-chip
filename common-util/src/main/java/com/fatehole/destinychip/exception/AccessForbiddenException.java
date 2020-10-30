package com.fatehole.destinychip.exception;

/**
 * 用户未登录，非法访问受保护资源所抛出的异常
 * @author FateCat
 * @version 2020-10-07-20:25
 */
public class AccessForbiddenException extends RuntimeException {

    private static final long serialVersionUID = 4857364875874625L;

    public AccessForbiddenException() {
        super();
    }

    public AccessForbiddenException(String message) {
        super(message);
    }

    public AccessForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessForbiddenException(Throwable cause) {
        super(cause);
    }

    protected AccessForbiddenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
