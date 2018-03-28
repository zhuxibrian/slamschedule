package com.rw.slamschedule.exception;

public class RwException extends Exception {

    private String data;

    public RwException(String message, String data) {
        super(message);
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
