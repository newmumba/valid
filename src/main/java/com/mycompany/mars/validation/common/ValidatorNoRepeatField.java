package com.mycompany.mars.validation.common;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import java.util.ArrayList;

public class ValidatorNoRepeatField<T> extends ValidatorHandler<ArrayList<T>> implements com.baidu.unbiz.fluentvalidator.Validator<ArrayList<T>>{
    private final String fieldNum;

    public ValidatorNoRepeatField(String fieldNum) {
        this.fieldNum = fieldNum;
    }

    @Override
    public boolean validate(ValidatorContext context, ArrayList<T> field) {
        if (field != null) {
            if (field.size() != 1) {
                context.addError(ValidationError.create("Поле " + fieldNum + " в записи не повторяется")
                        .setErrorCode(0)
                        .setField(fieldNum)
                        .setInvalidValue(null));
                return false;
            }
        }
        return true;
    }
}
