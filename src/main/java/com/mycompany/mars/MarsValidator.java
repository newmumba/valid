package com.mycompany.mars;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.mycompany.mars.data.Fill;
import com.mycompany.mars.data.ResultSimple;
import com.mycompany.mars.validation.ValidatorFields;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MarsValidator {
    public MarsValidator() {}
    
    public ResultSimple validate(String json) throws ParseException, IOException{
        DataParser dataParser = new DataParser();
        RusmarcDeserializer rusmarcDeserializer = new RusmarcDeserializer();
        //Result result = new Result();
        ResultSimple result = new ResultSimple();
        
        JSONObject jsonObj = (JSONObject) new JSONParser().parse(json);
        String jsonStr = dataParser.parse(jsonObj);
        
        Fill fill = rusmarcDeserializer.parse(jsonStr);
        
        ComplexResult ret = FluentValidator.checkAll().failOver()
                .on(fill, new ValidatorFields())
                .doValidate().result(toComplex());
       
        if(ret.isSuccess()){
            result.setIsSuccess(true);
            result.setErrors(null);
        }else{
            result.setIsSuccess(false);
            //ArrayList<ResultError> errorArray = new ArrayList<>();
            ArrayList<String> errorArray = new ArrayList<>();
            for (ValidationError retError : ret.getErrors()) {
                //ResultError resultError;
                //resultError = new ResultError(retError.getErrorCode() ,retError.getErrorMsg(), retError.getField(), "");
                //errorArray.add(resultError);
                errorArray.add(retError.getErrorMsg());
            }
            
            result.setErrors(errorArray);
        }
        return result;

    }
}
