package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field014;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptySubField;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2;
import com.mycompany.mars.validation.common.ValidatorNoNullSubField;
import com.mycompany.mars.validation.common.ValidatorNoRepeatSubField;

public class ValidatorField014 extends TransferValidator<Field014>{
    @Override
    public boolean validate(ValidatorContext context, Field014 field014) {
        if (field014 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "014")
                    .on(field014.getI1(), new ValidatorI1())
                    .on(field014.getI2(), new ValidatorI2())
                    .on(field014.getA(), new ValidatorEmptySubField("Код статьи", "014a"))
                    .onEach(field014.getA(), new ValidatorNoNullSubField("014", "a"))
                    .on(field014.getS2(), new ValidatorEmptySubField("Код системы", "0142"))
                    .onEach(field014.getS2(), new ValidatorNoNullSubField("014", "2"))
                    .on(field014.getS2(), new ValidatorNoRepeatSubField("014", "2"))
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }

    private void ValidatorEmptySubField() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
