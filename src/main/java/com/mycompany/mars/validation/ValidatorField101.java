package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field101;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptySubField;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI1Small;
import com.mycompany.mars.validation.common.ValidatorI2;
import com.mycompany.mars.validation.common.ValidatorNoNullSubField;

public class ValidatorField101 extends TransferValidator<Field101> {
    
    @Override
    public boolean validate(ValidatorContext context, Field101 field101) {
        if (field101 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "101")
                    .on(field101.getI1(), new ValidatorI1Small("01"))
                    .on(field101.getI2(), new ValidatorI2())
                    .on(field101.getA(), new ValidatorEmptySubField("Язык текста", "101a"))
                    .onEach(field101.getA(), new ValidatorNoNullSubField("101", "a"))
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
