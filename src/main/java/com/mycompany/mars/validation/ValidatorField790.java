package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field790;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2;

public class ValidatorField790 extends TransferValidator<Field790>{
    
    @Override
    public boolean validate(ValidatorContext context, Field790 field790) {
        if (field790 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "790")
                    .on(field790.getI1(), new ValidatorI1())
                    .on(field790.getI2(), new ValidatorI2())
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
    
}
