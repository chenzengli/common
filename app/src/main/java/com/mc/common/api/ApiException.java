package com.mc.common.api;

/**
 * Created by momologo on 2017/11/1.
 *
 * @author momologo
 */

public class ApiException extends Exception {
    private String message;

    private String code;

    private Throwable throwable;

    public ApiException(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public ApiException(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", throwable=" + throwable.toString() +
                '}';
    }
}
