package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field702;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptySubField;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2Small;

public class ValidatorField702 extends TransferValidator<Field702>{
   
    @Override
    public boolean validate(ValidatorContext context, Field702 field702) {
        if (field702 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "702")
                    .on(field702.getI1(), new ValidatorI1())
                    .on(field702.getI2(), new ValidatorI2Small("01"))
                    .on(field702.getA(), new ValidatorEmptySubField("Фамилия автора", "702a"))
                    .on(field702.getB(), new ValidatorEmptySubField("Инициалы автора", "702b"))
                    .on(field702.getS4(), new ValidatorEmptySubField("Код отношения", "7024"))
                    .doValidate().result(toComplex());
            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
