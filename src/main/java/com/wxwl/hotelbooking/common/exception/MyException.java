package com.wxwl.hotelbooking.common.exception;

public class MyException extends RuntimeException{
    private String exCode;
    private String msg;

    public MyException() {
        super();
    }

    public MyException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public MyException(String message, String exCode, String msg) {
        super();
        this.exCode = exCode;
        this.msg = msg;
    }

    public String getExCode() {
        return exCode;
    }

    public String getMsg() {
        return msg;
    }
}
