package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field225;
import com.mycompany.mars.data.Field300;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2;
import com.mycompany.mars.validation.common.ValidatorNoRepeatSubField;

public class ValidatorField300 extends TransferValidator<Field300>{
    
    @Override
    public boolean validate(ValidatorContext context, Field300 field300) {
        if (field300 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "300")
                    .on(field300.getI1(), new ValidatorI1())
                    .on(field300.getI2(), new ValidatorI2())
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
