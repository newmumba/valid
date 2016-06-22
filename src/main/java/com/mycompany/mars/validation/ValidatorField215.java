package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field215;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2;

public class ValidatorField215 extends TransferValidator<Field215> {
    
    @Override
    public boolean validate(ValidatorContext context, Field215 field215) {
        if (field215 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                .putAttribute2Context("fieldName", "215")
                .on(field215.getI1(), new ValidatorI1())
                .on(field215.getI2(), new ValidatorI2())
                .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }   
}
