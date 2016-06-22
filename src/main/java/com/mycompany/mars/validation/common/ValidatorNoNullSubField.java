package com.mycompany.mars.validation.common;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

public class ValidatorNoNullSubField extends ValidatorHandler<String> implements com.baidu.unbiz.fluentvalidator.Validator<String>{
    private final String field;
    private final String subField;
    
    public ValidatorNoNullSubField(String field, String subField) {
        this.field = field;
        this.subField = subField;
    }
    
    @Override
    public boolean validate(ValidatorContext context, String subfield) {
        if(subfield == null || "".equals(subfield)) {
            context.addError(ValidationError.create("Подполе " + subField + " поля " + field + " не может быть пустым")
                    .setErrorCode(1)
                    .setField(field)
                    .setInvalidValue(subfield));
            return false;
        }
        return true;
    }
}