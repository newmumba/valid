package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field101;
import com.mycompany.mars.data.Field102;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptySubField;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2;
import com.mycompany.mars.validation.common.ValidatorNoNullSubField;

public class ValidatorField102 extends TransferValidator<Field102>  
{
    @Override
    public boolean validate(ValidatorContext context, Field102 field102) {
        if (field102 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "102")
                    .on(field102.getI1(), new ValidatorI1())
                    .on(field102.getI2(), new ValidatorI2())
                    .on(field102.getA(), new ValidatorEmptySubField("Страна публикации", "102a"))
                    .onEach(field102.getA(), new ValidatorNoNullSubField("102", "a"))
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
