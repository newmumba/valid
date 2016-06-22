package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field200;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptySubField;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI1Small;
import com.mycompany.mars.validation.common.ValidatorI2;

public class ValidatorField200 extends TransferValidator<Field200> {
    
    @Override
    public boolean validate(ValidatorContext context, Field200 field200) {
        if (field200 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                .putAttribute2Context("fieldName", "200")
                .on(field200.getI1(), new ValidatorI1Small("1"))
                .on(field200.getI2(), new ValidatorI2())
                .on(field200.getA(), new ValidatorEmptySubField("Заглавие публикации", "200a"))
                .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}