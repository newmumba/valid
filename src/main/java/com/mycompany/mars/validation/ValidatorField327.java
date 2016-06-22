package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field225;
import com.mycompany.mars.data.Field327;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI1Small;
import com.mycompany.mars.validation.common.ValidatorI2;

public class ValidatorField327 extends TransferValidator<Field327>{
    
    @Override
    public boolean validate(ValidatorContext context, Field327 field327) {
        if (field327 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "327")
                    .on(field327.getI1(), new ValidatorI1Small("01"))
                    .on(field327.getI2(), new ValidatorI2())
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
