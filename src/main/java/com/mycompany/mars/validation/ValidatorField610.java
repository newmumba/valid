package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field610;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptySubField;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2;
import com.mycompany.mars.validation.common.ValidatorNoRepeatSubField;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorField610 extends TransferValidator<Field610>{
    @Override
    public boolean validate(ValidatorContext context, Field610 field610) {
        if (field610 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "610")
                    .on(field610.getI1(), new ValidatorI1())
                    .on(field610.getI2(), new ValidatorI2())
                    .on(field610.getA(), new ValidatorNoRepeatSubField("610", "a"))
                    .on(field610.getA(), new ValidatorEmptySubField("подполе \"a\"", "610"))
                    .onEach(field610.getA(), new Validator610a())
                    .doValidate().result(toComplex());
            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
    
    public class Validator610a extends TransferValidator<String> {

        @Override
        public boolean validate(ValidatorContext context, String field610a) {
            if (field610a != null) {
                Pattern p = Pattern.compile("^.$");
                Matcher m = p.matcher(field610a);
                if (m.matches()) {
                    context.addError(ValidationError.create("Недопустимый символ (; ) в подполе \"a\" поля 610")
                            .setErrorCode(1)
                            .setField(context.getAttribute("fieldName", String.class))
                            .setInvalidValue(field610a));
                    return false;
                  
                }
            }
            return true;
        }
    }
}
