package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field215;
import com.mycompany.mars.data.Field225;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2;
import com.mycompany.mars.validation.common.ValidatorNoRepeatSubField;

public class ValidatorField225 extends TransferValidator<Field225>{
    @Override
    public boolean validate(ValidatorContext context, Field225 field225) {
        if (field225 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "225")
                    .on(field225.getI1(), new ValidatorI1())
                    .on(field225.getI2(), new ValidatorI2())
                    .on(field225.getA(), new ValidatorNoRepeatSubField("225", "a"))
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
