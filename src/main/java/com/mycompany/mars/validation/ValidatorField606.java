package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field100;
import com.mycompany.mars.data.Field600;
import com.mycompany.mars.data.Field606;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptySubField;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2;
import com.mycompany.mars.validation.common.ValidatorNoRepeatSubField;
import java.util.ArrayList;

public class ValidatorField606 extends TransferValidator<Field606>{
    @Override
    public boolean validate(ValidatorContext context, Field606 field606) {
        if (field606 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "606")
                    .on(field606.getI1(), new ValidatorI1())
                    .on(field606.getI2(), new ValidatorI2())
                    .on(field606.getA(), new ValidatorEmptySubField("Основная рубрика", "606a"))
                    .on(field606.getA(), new ValidatorNoRepeatSubField("606", "a"))
                    .doValidate().result(toComplex());
            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
