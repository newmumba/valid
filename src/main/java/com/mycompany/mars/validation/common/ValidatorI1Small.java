package com.mycompany.mars.validation.common;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorI1Small extends ValidatorHandler<String> implements com.baidu.unbiz.fluentvalidator.Validator<String>{
    private String value;
    
    public ValidatorI1Small(String value) {
        this.value = value;
    }
    
    @Override
    public boolean validate(ValidatorContext context, String subfield) {
        String fieldName = context.getAttribute("fieldName", String.class);
        if (subfield == null) {
            context.addError(ValidationError.create("В поле " + fieldName + " индикатор 1 отсутствует.")
                    .setErrorCode(1)
                    .setField(fieldName)
                    .setInvalidValue(subfield));
            return false;
        } else {
            Pattern p;
            String Message;
            if("01".equals(value)){
                p = Pattern.compile("^([0-1])$");
                Message = "В поле " + fieldName + " значение 1-го индикатора может быть 0 или 1.";
            }else if("12".equals(value))
            {
                p = Pattern.compile("^([1-2])$");
                Message = "В поле " + fieldName + " значение 1-го индикатора может быть 1 или 2.";
            }else
            {
                p = Pattern.compile("^([1])$");
                Message = "В поле " + fieldName + " значение 1-го индикатора может быть 1.";
            }
            Matcher m = p.matcher(subfield);
            if (!m.matches()) {
                context.addError(ValidationError.create(Message)
                        .setErrorCode(1)
                        .setField(fieldName)
                        .setInvalidValue(subfield));
                return false;
            }
            return true;
        }
    }
}
