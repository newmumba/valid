package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.FieldSyntax;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptySubField;
import com.mycompany.mars.validation.common.ValidatorNoNullSubField;
import com.mycompany.mars.validation.common.ValidatorNoRepeatSubField;

public class ValidatorFieldSyntax extends TransferValidator<FieldSyntax>{
    
    @Override
    public boolean validate(ValidatorContext context, FieldSyntax fieldSyntax) {
        if (fieldSyntax != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "Syntax")
                    .on(fieldSyntax.getValue(), new ValidatorEmptySubField("value", "Syntax"))
                    .on(fieldSyntax.getValue(), new ValidatorNoRepeatSubField("Syntax", "value"))
                    .onEach(fieldSyntax.getValue(), new ValidatorNoNullSubField("Syntax", ""))
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
