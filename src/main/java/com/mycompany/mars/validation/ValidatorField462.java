package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field461;
import com.mycompany.mars.data.Field462;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2;

public class ValidatorField462 extends TransferValidator<Field462>{
    
    @Override
    public boolean validate(ValidatorContext context, Field462 field462) {
        if (field462 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "462")
                    .on(field462.getI1(), new ValidatorI1())
                    .on(field462.getI2(), new ValidatorI2())
                    .onEach(field462.getE(), new Validator462e())
                    .onEach(field462.getS1(), new Validator462s1())
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
    
    public class Validator462e extends TransferValidator<String> {

        @Override
        public boolean validate(ValidatorContext context, String field462e) {
            if (!"журнал в журнале".equals(field462e)) {
                context.addError(ValidationError.create("Во встроенном поле 200 (подполе \"e\") поля 462 должно быть \"журнал в журнале\" (с маленькой буквы)")
                        .setErrorCode(1)
                        .setField(context.getAttribute("fieldName", String.class))
                        .setInvalidValue(field462e));
                return false;
            }
            return true;
        }
    }
    
    public class Validator462s1 extends TransferValidator<String> {
        
        @Override
        public boolean validate(ValidatorContext context, String field462s1) {
            if (field462s1 != null) {
                String subNum = field462s1.substring(0, 3);
                if (!"001".equals(subNum) && field462s1.length() != 5) {
                    context.addError(ValidationError.create("Ошибка формирования встроенного поля (более 2-х индикаторов поля \"" + subNum + "\")")
                            .setErrorCode(1)
                            .setField(context.getAttribute("fieldName", String.class))
                            .setInvalidValue(field462s1));
                    return false;
                }
            }
            return true;
        }
    }
}
