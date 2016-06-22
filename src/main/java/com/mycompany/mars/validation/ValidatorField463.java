package com.mycompany.mars.validation;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.mycompany.mars.data.Field463;
import com.mycompany.mars.validation.common.TransferValidator;
import com.mycompany.mars.validation.common.ValidatorEmptySubField;
import com.mycompany.mars.validation.common.ValidatorI1;
import com.mycompany.mars.validation.common.ValidatorI2;
import java.util.ArrayList;
import java.util.Calendar;

public class ValidatorField463 extends TransferValidator<Field463>{
    @Override
    public boolean validate(ValidatorContext context, Field463 field463) {
        if (field463 != null) {
            ComplexResult ret = FluentValidator.checkAll().failOver()
                    .putAttribute2Context("fieldName", "463")
                    .on(field463.getI1(), new ValidatorI1())
                    .on(field463.getI2(), new ValidatorI2())
                    .onEach(field463.getD(), new Validator463d())
                    .on(field463.getS1(), new Validator463s1())
                    .on(field463.getD(), new ValidatorEmptySubField("Год издания", "463d"))
                    .on(field463.getA(), new ValidatorEmptySubField("N журнала", "463a"))
                    .on(field463.getV(), new ValidatorEmptySubField("Страницы публикации статьи", "463v"))
                    .doValidate().result(toComplex());

            return TransferErrors(context, ret);
        }
        return TransferErrors(context, null);
    }
    
    public class Validator463d extends TransferValidator<String> {

        @Override
        public boolean validate(ValidatorContext context, String field463d) {
            
            Calendar calendar = Calendar.getInstance();
            if (field463d != null) {
                try {
                    Integer intField463d = Integer.valueOf(field463d);
                    int year = calendar.get(Calendar.YEAR);
                    if(intField463d < 1990 || field463d.length() != 4  || intField463d > year+1){
                        context.addError(ValidationError.create("Неверно заполненная дата или ее отсутствие \"Год издания\" (463d)")
                                .setErrorCode(1)
                                .setField(context.getAttribute("fieldName", String.class))
                                .setInvalidValue(field463d));
                        return false;
                    } 
                } catch (NumberFormatException e) {
                    context.addError(ValidationError.create("Неверно заполненная дата или ее отсутствие \"Год издания\" (463d)")
                                .setErrorCode(1)
                                .setField(context.getAttribute("fieldName", String.class))
                                .setInvalidValue(field463d));
                    return false;
                }
            }
            return true;
        }
    }
    
    public class Validator463s1 extends TransferValidator<ArrayList<String>> {

        @Override
        public boolean validate(ValidatorContext context, ArrayList<String> field463s1) {
            Boolean error = false;
            Boolean subField210 = false;
            if (field463s1 != null) {
                for (String iter : field463s1) {
                    String subNum = iter.substring(0, 3);
                    if (!"001".equals(subNum) && iter.length() != 5) {
                        context.addError(ValidationError.create("Ошибка формирования встроенного поля (более 2-х индикаторов поля \"" + subNum + "\")")
                                .setErrorCode(1)
                                .setField(context.getAttribute("fieldName", String.class))
                                .setInvalidValue(iter));
                        error = true;
                    }
                    if("210".equals(subNum)) subField210 = true;
                }
                if(!subField210){
                    context.addError(ValidationError.create("Отсутствует поле \"Год издания\" (463d)")
                            .setErrorCode(1)
                            .setField(context.getAttribute("fieldName", String.class))
                            .setInvalidValue(""));
                    return false;
                }
            }
            if(!error){
                return true;
            }else{
                return false;
            }
            
        }
    }
}
