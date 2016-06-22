package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field801;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2;

public class ValidatorField801 extends TransferValidator<Field801>{
    
    @Override
    public boolean validate(ValidatorContext context, Field801 field801) {
        if (field801 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "801")
                    .on(field801.getI1(), new ValidatorI1())
                    .on(field801.getI2(), new ValidatorI2())
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
    
}
