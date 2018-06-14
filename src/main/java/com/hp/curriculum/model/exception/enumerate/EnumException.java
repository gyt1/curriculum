package com.hp.curriculum.model.exception.enumerate;

/**
 * @author Administrator
 * @date 2018/6/9
 */
public class EnumException extends Exception {

    EnumException() {
        super();
    }

    EnumException(String message) {
        super(message);
    }

    EnumException(String message, Throwable cause) {
        super(message, cause);
    }

    EnumException(Throwable cause) {
        super(cause);
    }

    EnumException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
