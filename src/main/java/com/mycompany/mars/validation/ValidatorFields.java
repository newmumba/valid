package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Fill;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptyField;
import com.mycompany.mars.validation.common.ValidatorNoRepeatField;

public class ValidatorFields extends TransferValidator<Fill> {
    @Override
    public boolean validate(ValidatorContext context, Fill fill) {
        if (fill != null) {
            ComplexResult ret;
            ret = FluentValidator.checkAll().failOver()
                    //обычная проверка для каждого поля
                    .onEach(fill.getFieldL(), new ValidatorFieldL())
                    .onEach(fill.getFieldSyntax(), new ValidatorFieldSyntax())
                    .onEach(fill.getField001(), new ValidatorField001())
                    .onEach(fill.getField005(), new ValidatorField005())
                    .onEach(fill.getField100(), new ValidatorField100())
                    .onEach(fill.getField101(), new ValidatorField101())
                    .onEach(fill.getField102(), new ValidatorField102())
                    .onEach(fill.getField200(), new ValidatorField200())
                    .onEach(fill.getField215(), new ValidatorField215())
                    .onEach(fill.getField225(), new ValidatorField225())
                    .onEach(fill.getField327(), new ValidatorField327())
                    .onEach(fill.getField461(), new ValidatorField461())
                    .onEach(fill.getField462(), new ValidatorField462())
                    .onEach(fill.getField463(), new ValidatorField463())
                    .onEach(fill.getField517(), new ValidatorField517())
                    .onEach(fill.getField600(), new ValidatorField600())
                    .onEach(fill.getField601(), new ValidatorField601())
                    .onEach(fill.getField606(), new ValidatorField606())
                    .onEach(fill.getField610(), new ValidatorField610())
                    .onEach(fill.getField700(), new ValidatorField700())
                    .onEach(fill.getField701(), new ValidatorField701())
                    .onEach(fill.getField702(), new ValidatorField702())
                    .onEach(fill.getField710(), new ValidatorField710())
                    .onEach(fill.getField711(), new ValidatorField711())
                    .onEach(fill.getField712(), new ValidatorField712())
                    
                    //праверка на неповторение полей
                    .on(fill.getFieldL(), new ValidatorNoRepeatField("L"))
                    .on(fill.getFieldSyntax(), new ValidatorNoRepeatField("Syntax"))
                    .on(fill.getField001(), new ValidatorNoRepeatField("001"))
                    .on(fill.getField005(), new ValidatorNoRepeatField("005"))
                    .on(fill.getField327(), new ValidatorNoRepeatField("327"))
                    .on(fill.getField461(), new ValidatorNoRepeatField("461"))
                    .on(fill.getField700(), new ValidatorNoRepeatField("700"))
                    
                    //проверка на наличие поля
                    .on(fill.getFieldL(), new ValidatorEmptyField("L"))
                    .on(fill.getFieldSyntax(), new ValidatorEmptyField("Syntax"))
                    .on(fill.getField001(), new ValidatorEmptyField("001"))
                    .on(fill.getField005(), new ValidatorEmptyField("005"))
                    .on(fill.getField610(), new ValidatorEmptyField("610"))
                    .doValidate().result(toComplex());
            
            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
}
