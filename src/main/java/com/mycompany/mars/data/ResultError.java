package com.mycompany.mars.data;

public class ResultError {
    private int errorCode;
    private String errorMsg;
    private String field;
    private String invalidValue;

    public ResultError(int errorCode, String errorMsg, String field, String invalidValue) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.field = field;
        this.invalidValue = invalidValue;
    }

    public ResultError() {
    }
    
    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(String invalidValue) {
        this.invalidValue = invalidValue;
    }
}
