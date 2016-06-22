package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field700;
import com.mycompany.mars.data.Field701;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptySubField;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2Small;
import com.mycompany.mars.validation.common.ValidatorNoRepeatSubField;

public class ValidatorField701 extends TransferValidator<Field701>{
    @Override
    public boolean validate(ValidatorContext context, Field701 field701) {
        if (field701 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "701")
                    .on(field701.getI1(), new ValidatorI1())
                    .on(field701.getI2(), new ValidatorI2Small("01"))
                    .on(field701.getA(), new ValidatorEmptySubField("Фамилия автора", "701a"))
                    .on(field701.getB(), new ValidatorEmptySubField("Инициалы автора", "701b"))
                    .on(field701.getS4(), new ValidatorEmptySubField("Код отношения", "7014"))
                    .doValidate().result(toComplex());
            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
