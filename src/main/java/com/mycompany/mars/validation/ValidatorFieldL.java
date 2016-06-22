package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.FieldL;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptySubField;
import com.mycompany.mars.validation.common.ValidatorNoNullSubField;
import com.mycompany.mars.validation.common.ValidatorNoRepeatSubField;

public class ValidatorFieldL extends TransferValidator<FieldL>{
    
    @Override
    public boolean validate(ValidatorContext context, FieldL fieldL) {
        if (fieldL != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "L")
                    .on(fieldL.getValue(), new ValidatorEmptySubField("value", "L"))
                    .on(fieldL.getValue(), new ValidatorNoRepeatSubField("L", "value"))
                    .onEach(fieldL.getValue(), new ValidatorNoNullSubField("L", ""))
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
