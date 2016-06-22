package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field327;
import com.mycompany.mars.data.Field330;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI1Small;
import com.mycompany.mars.validation.common.ValidatorI2;

public class ValidatorField330 extends TransferValidator<Field330>{
    
    @Override
    public boolean validate(ValidatorContext context, Field330 field330) {
        if (field330 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "330")
                    .on(field330.getI1(), new ValidatorI1())
                    .on(field330.getI2(), new ValidatorI2())
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
