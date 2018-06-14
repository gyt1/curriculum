package com.hp.curriculum.model.exception.enumerate;

/**
 * @author Administrator
 * @date 2018/6/9
 */
public class EnumValueOutOfBounds extends EnumException {

    public EnumValueOutOfBounds() {
        super();
    }

    public EnumValueOutOfBounds(String message) {
        super(message);
    }

    public EnumValueOutOfBounds(String message, Throwable cause) {
        super(message, cause);
    }

    public EnumValueOutOfBounds(Throwable cause) {
        super(cause);
    }

    protected EnumValueOutOfBounds(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
