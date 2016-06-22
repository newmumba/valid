package com.mycompany.mars.data;

import java.util.ArrayList;

public class ResultSimple {
    private boolean isSuccess;
    private ArrayList<String> errors;

    public boolean isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public ArrayList<String> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }
}
