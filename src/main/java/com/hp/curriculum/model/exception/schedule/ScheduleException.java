package com.hp.curriculum.model.exception.schedule;

/**
 * @author Administrator
 * @date 2018/6/13
 */
public class ScheduleException extends Exception {

    public ScheduleException() {
    }

    public ScheduleException(String message) {
        super(message);
    }

    public ScheduleException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScheduleException(Throwable cause) {
        super(cause);
    }

    public ScheduleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
