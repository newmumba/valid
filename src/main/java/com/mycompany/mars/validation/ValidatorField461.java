package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field461;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptySubField;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorField461 extends TransferValidator<Field461>{
    
    @Override
    public boolean validate(ValidatorContext context, Field461 field461) {
        if (field461 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "461")
                    .on(field461.getI1(), new ValidatorI1())
                    .on(field461.getI2(), new ValidatorI2())
                    .onEach(field461.getA(), new Validator461a())
                    .on(field461.getA(), new ValidatorEmptySubField("Название источника", "461a"))
                    .onEach(field461.getI(), new Validator461i())
                    .onEach(field461.getD(), new Validator461d())
                    .onEach(field461.getS1(), new Validator461s1())
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
    
    public class Validator461a extends TransferValidator<String> {
        
        @Override
        public boolean validate(ValidatorContext context, String field461a) {
            if (field461a != null && (field461a.contains("Сер.") || field461a.contains("Серия"))) {
                context.addError(ValidationError.create("Название источника: Номер серии записывается в подполе \"h\", Название серии - в подполе \"i\"")
                        .setErrorCode(1)
                        .setField(context.getAttribute("fieldName", String.class))
                        .setInvalidValue(field461a));
                return false; 
            }
            return true;
        }
    }
    
    public class Validator461s1 extends TransferValidator<String> {

        @Override
        public boolean validate(ValidatorContext context, String field461s1) {
            if (field461s1 != null) {
                String subNum = field461s1.substring(0, 3);
                if(!"001".equals(subNum) && field461s1.length() != 5){
                    context.addError(ValidationError.create("Ошибка формирования встроенного поля (более 2-х индикаторов поля \"" + subNum + "\")")
                            .setErrorCode(1)
                            .setField(context.getAttribute("fieldName", String.class))
                            .setInvalidValue(field461s1));
                    return false;
                }
            }
            return true;
        }
    }
    
    public class Validator461d extends TransferValidator<String> {

        @Override
        public boolean validate(ValidatorContext context, String field461d) {
            if (field461d != null) {
                context.addError(ValidationError.create("Год издания источника указывается в 463 поле")
                        .setErrorCode(1)
                        .setField(context.getAttribute("fieldName", String.class))
                        .setInvalidValue(field461d));
                return false;
            }
            return true;
        }
    }
    
    public class Validator461i extends TransferValidator<String> {

        @Override
        public boolean validate(ValidatorContext context, String field461i) {
            if (field461i != null) {
                Pattern p = Pattern.compile("^[C|с]ер[ ]{0,}[0-9]{1,}$");
                Matcher m = p.matcher(field461i);
                if (!m.matches()) {
                    context.addError(ValidationError.create("Название источника: Номер серии записывается в подполе \"h\", Название серии - в подполе \"i\"")
                            .setErrorCode(1)
                            .setField(context.getAttribute("fieldName", String.class))
                            .setInvalidValue(field461i));
                    return false;
                }
            }
            return true;
        }
    }
}
