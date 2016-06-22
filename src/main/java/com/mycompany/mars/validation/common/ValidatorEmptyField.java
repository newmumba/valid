package com.mycompany.mars.validation.common;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import java.util.ArrayList;

public class ValidatorEmptyField<T> extends ValidatorHandler<T> implements com.baidu.unbiz.fluentvalidator.Validator<T>{
    private String field;
    
    public ValidatorEmptyField(String field){
        this.field = field;
    }
    
    @Override
    public boolean validate(ValidatorContext context, T subfield) {
        if (subfield == null) {
            context.addError(ValidationError.create("Должно быть хотя бы 1 поле " + field)
                    .setErrorCode(0)
                    .setField(field)
                    .setInvalidValue(null));
            return false;
        }
        return true;
    }
}
