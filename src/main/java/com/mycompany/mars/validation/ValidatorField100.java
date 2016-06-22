package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field100;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptySubField;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2;
import com.mycompany.mars.validation.common.ValidatorNoNullSubField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorField100 extends TransferValidator<Field100> {
    
    @Override
    public boolean validate(ValidatorContext context, Field100 field100) {
        if(field100 != null){
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "100")
                    .on(field100.getI1(), new ValidatorI1())
                    .on(field100.getI2(), new ValidatorI2())
                    .onEach(field100.getA(), new Validator100a())
                    .on(field100.getA(), new ValidatorEmptySubField("Данные общей обработки", "100а"))
                    .onEach(field100.getA(), new ValidatorNoNullSubField("100", "a"))
                    .doValidate().result(toComplex());
            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
    
    
    public class Validator100a extends TransferValidator<String> {

        @Override
        public boolean validate(ValidatorContext context, String field100a) {
            if(field100a != null){
                //Pattern p = Pattern.compile("^[0-9]{8}[d,j]([0-9]{4}|#{4})([0-9]{4}|#{4}| )(\\|{3}|a##|de#|e##)[yabcdz#][01](rusy)(.{4})?(.{4})?(ca|ba|##)?$");
                Pattern p = Pattern.compile("^[0-9]{8}[d,j]([0-9]{4}|#{4})([0-9]{4}|#{4}| )(\\|{3}|a##|de#|e##)[yabcdz#][01](rusy)(.{8})?(ca|ba|##|a)?$");
                Matcher m = p.matcher(field100a);
                if (!m.matches()) {
                    context.addError(ValidationError.create("Подполе а поля 100 не верно.")
                            .setErrorCode(1)
                            .setField(context.getAttribute("fieldName", String.class))
                            .setInvalidValue(field100a));
                    return false;
                }
            }
            return true;
        }
    }
}


