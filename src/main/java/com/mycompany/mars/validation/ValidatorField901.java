package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field901;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2;

public class ValidatorField901  extends TransferValidator<Field901>{
    
    @Override
    public boolean validate(ValidatorContext context, Field901 field901) {
        if (field901 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "901")
                    .on(field901.getI1(), new ValidatorI1())
                    .on(field901.getI2(), new ValidatorI2())
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
    
}
