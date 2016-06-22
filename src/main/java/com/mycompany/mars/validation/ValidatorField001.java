package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field001;
import com.mycompany.mars.data.Field100;
import com.mycompany.mars.data.Field101;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptySubField;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2;
import com.mycompany.mars.validation.common.ValidatorNoNullSubField;
import com.mycompany.mars.validation.common.ValidatorNoRepeatSubField;

public class ValidatorField001 extends TransferValidator<Field001>{

    @Override
    public boolean validate(ValidatorContext context, Field001 field001) {
        if (field001 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "001")
                    .on(field001.getValue(), new ValidatorEmptySubField("value", "001"))
                    .on(field001.getValue(), new ValidatorNoRepeatSubField("001", "value"))
                    .onEach(field001.getValue(), new ValidatorNoNullSubField("001", ""))
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
