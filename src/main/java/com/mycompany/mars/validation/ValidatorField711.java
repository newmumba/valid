package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field710;
import com.mycompany.mars.data.Field711;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorI1Small;
import com.mycompany.mars.validation.common.ValidatorI2Small;

public class ValidatorField711 extends TransferValidator<Field711>{
    @Override
    public boolean validate(ValidatorContext context, Field711 field711) {
        if (field711 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "711")
                    .on(field711.getI1(), new ValidatorI1Small("01"))
                    .on(field711.getI2(), new ValidatorI2Small("12"))
                    .doValidate().result(toComplex());
            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
