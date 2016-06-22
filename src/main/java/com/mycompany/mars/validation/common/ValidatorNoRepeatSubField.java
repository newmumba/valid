package com.mycompany.mars.validation.common;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import java.util.ArrayList;

public class ValidatorNoRepeatSubField extends ValidatorHandler<ArrayList<String>> implements com.baidu.unbiz.fluentvalidator.Validator<ArrayList<String>>{
    private final String field;
    private final String subField;
    
    public ValidatorNoRepeatSubField(String field, String subField) {
        this.field = field;
        this.subField = subField;
    }
    
    @Override
    public boolean validate(ValidatorContext context, ArrayList<String> subfield) {
        if (subfield != null) {
            if(subfield.size() != 1){
               context.addError(ValidationError.create("Подполе \"" + subField + "\" поля " + field + " не может повторяться (" + field + subField + ")")
                        .setErrorCode(0)
                        .setField(field)
                        .setInvalidValue(null));
                return false; 
            }       
        }
        return true;
    }
}
