package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field610;
import com.mycompany.mars.data.Field700;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptySubField;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2;
import com.mycompany.mars.validation.common.ValidatorI2Small;
import com.mycompany.mars.validation.common.ValidatorNoRepeatSubField;

public class ValidatorField700 extends TransferValidator<Field700>{
    @Override
    public boolean validate(ValidatorContext context, Field700 field700) {
        if (field700 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "700")
                    .on(field700.getI1(), new ValidatorI1())
                    .on(field700.getI2(), new ValidatorI2Small("01"))
                    .on(field700.getA(), new ValidatorNoRepeatSubField("700", "a"))
                    .on(field700.getA(), new ValidatorEmptySubField("Фамилия автора", "700a"))
                    .on(field700.getB(), new ValidatorNoRepeatSubField("700", "b"))
                    .on(field700.getB(), new ValidatorEmptySubField("Инициалы автора", "700b"))
                    .on(field700.getS4(), new ValidatorEmptySubField("Код отношения", "7004"))
                    .doValidate().result(toComplex());
            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
