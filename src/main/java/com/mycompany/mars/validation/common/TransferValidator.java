package com.mycompany.mars.validation.common;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;


public abstract class TransferValidator<T> extends ValidatorHandler<T> implements com.baidu.unbiz.fluentvalidator.Validator<T> {
    public boolean TransferErrors(ValidatorContext context, ComplexResult result) {
        if (result != null) {
            if (!result.isSuccess()) {
                for(ValidationError validErr : result.getErrors()){
                    context.addError(validErr);
                }
                return false;
            }
        }
        return true;
    }
}