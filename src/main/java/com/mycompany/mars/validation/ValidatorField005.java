package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field005;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptySubField;
import com.mycompany.mars.validation.common.ValidatorNoNullSubField;
import com.mycompany.mars.validation.common.ValidatorNoRepeatSubField;

public class ValidatorField005 extends TransferValidator<Field005>{
    
    @Override
    public boolean validate(ValidatorContext context, Field005 field005) {
        if (field005 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "005")
                    .on(field005.getValue(), new ValidatorEmptySubField("value", "005"))
                    .on(field005.getValue(), new ValidatorNoRepeatSubField("005", "value"))
                    .onEach(field005.getValue(), new ValidatorNoNullSubField("005", ""))
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
