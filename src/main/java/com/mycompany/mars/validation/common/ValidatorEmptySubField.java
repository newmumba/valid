package com.mycompany.mars.validation.common;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import java.util.ArrayList;

public class ValidatorEmptySubField extends ValidatorHandler<ArrayList<String>> implements com.baidu.unbiz.fluentvalidator.Validator<ArrayList<String>>{

    private String nameField;
    private String numberField;
            
    public ValidatorEmptySubField(String nameField, String numberField) {
        this.nameField = nameField;
        this.numberField = numberField;
    }
    
    @Override
    public boolean validate(ValidatorContext context, ArrayList<String> subfield) {
        if (subfield == null) {
                context.addError(ValidationError.create("Отсутствует поле \"" + nameField + "\" (" + numberField + ").")
                        .setErrorCode(0)
                        .setField(numberField)
                        .setInvalidValue(null));
                return false;
        }
        return true;
    }
}
