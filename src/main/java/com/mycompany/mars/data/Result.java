package com.mycompany.mars.data;

import java.util.ArrayList;

public class Result {
    private boolean isSuccess;
    private ArrayList<ResultError> errors;

    public boolean IsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public ArrayList<ResultError> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<ResultError> errors) {
        this.errors = errors;
    }
}