package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field710;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI1Small;
import com.mycompany.mars.validation.common.ValidatorI2Small;
import com.mycompany.mars.validation.common.ValidatorNoRepeatSubField;

public class ValidatorField710 extends TransferValidator<Field710>{
    @Override
    public boolean validate(ValidatorContext context, Field710 field710) {
        if (field710 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "710")
                    .on(field710.getI1(), new ValidatorI1Small("01"))
                    .on(field710.getI2(), new ValidatorI2Small("12"))
                    .doValidate().result(toComplex());
            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
