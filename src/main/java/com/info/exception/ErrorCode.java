package com.info.exception;

public enum ErrorCode {

    ERR_400_00("40000", "Employee id should be greater than zero.");

    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
