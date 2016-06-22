package com.mycompany.mars;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.mycompany.mars.data.Fill;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import static com.baidu.unbiz.fluentvalidator.ResultCollectors.toComplex;
import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.mycompany.mars.data.Result;
import com.mycompany.mars.data.ResultSimple;
import com.mycompany.mars.validation.ValidatorFields;
import com.ols.ruslan.junimarc.Record;
import com.ols.ruslan.junimarc.exceptions.MarcException;
import com.ols.ruslan.junimarc.iso2709.MarcReader;
import com.ols.ruslan.junimarc.iso2709.MarcStreamReader;
import com.ols.ruslan.junimarc.json.JsonWriter;
import com.ols.ruslan.junimarc.xml.RuslanXmlReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.simple.parser.ParseException;
import static org.junit.Assert.fail;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Mars {

    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException, ParserConfigurationException, SAXException {
        
        RusmarcDeserializer rusmarcDeserializer = new RusmarcDeserializer();
        
        //получение тестовых данных
        TestDataGenerator1 testDataGenerator = new TestDataGenerator1();
        String testData = testDataGenerator.getData();
        //заполнение Rusmarc тестовыми данными
        Fill fill = rusmarcDeserializer.parse(testData);
   
        ComplexResult ret = FluentValidator.checkAll().failOver()
                .on(fill, new ValidatorFields())
                .doValidate().result(toComplex());
       
        System.out.println(ret);
        if(ret.isSuccess()){
            System.out.println(ret);
            System.out.println("Ошибок нет.");
        }else{
            System.out.println("Имеются ошибки.");
            for(ValidationError error : ret.getErrors()){
                System.out.println(error.getErrorCode() + ". " + error.getInvalidValue() + ":\n\t" + error.getErrorMsg() );
            }
        }
//        System.out.println(result.getErrors().size());
        
 //       RuslanXmlReader reader = new RuslanXmlReader();
//        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><record syntax=\"1.2.840.10003.5.28\"><leader><length>00635</length><status>n</status><type>a</type><leader07>m</leader07><leader08> </leader08><leader09>a</leader09><indicatorCount>2</indicatorCount><identifierLength>2</identifierLength><dataBaseAddress>00205</dataBaseAddress><leader17>3</leader17><leader18>i</leader18><leader19> </leader19><entryMap>450 </entryMap></leader><field id=\"001\">RU\\SPSTU\\books\\5962</field><field id=\"005\">20040426153817.0</field><field id=\"100\"><indicator id=\"1\"> </indicator><indicator id=\"2\"> </indicator><subfield id=\"a\">19991022d1983    k  y1engb50      ba</subfield></field><field id=\"105\"><indicator id=\"1\"> </indicator><indicator id=\"2\"> </indicator><subfield id=\"a\">y            </subfield></field><field id=\"200\"><indicator id=\"1\">1</indicator><indicator id=\"2\"> </indicator><subfield id=\"a\">The captain`s diary</subfield><subfield id=\"e\">England in Australia and New Zealand 1982-83</subfield></field><field id=\"210\"><indicator id=\"1\"> </indicator><indicator id=\"2\"> </indicator><subfield id=\"a\">London</subfield><subfield id=\"c\">Willow</subfield><subfield id=\"d\">1983</subfield></field><field id=\"215\"><indicator id=\"1\"> </indicator><indicator id=\"2\"> </indicator><subfield id=\"a\">187 p.</subfield></field><field id=\"620\"><indicator id=\"1\"> </indicator><indicator id=\"2\"> </indicator><subfield id=\"d\">London</subfield></field><field id=\"686\"><indicator id=\"1\"> </indicator><indicator id=\"2\"> </indicator><subfield id=\"2\">rubbk</subfield><subfield id=\"a\">75.572</subfield></field><field id=\"700\"><indicator id=\"1\"> </indicator><indicator id=\"2\">1</indicator><subfield id=\"a\">Willis</subfield><subfield id=\"b\">B.</subfield></field><field id=\"701\"><indicator id=\"1\"> </indicator><indicator id=\"2\">1</indicator><subfield id=\"a\">Lee</subfield><subfield id=\"b\">A.</subfield></field><field id=\"801\"><indicator id=\"1\"> </indicator><indicator id=\"2\">0</indicator><subfield id=\"a\">RU</subfield><subfield id=\"b\">19013582</subfield><subfield id=\"c\">19991022</subfield><subfield id=\"g\">PSBO</subfield></field><field id=\"801\"><indicator id=\"1\"> </indicator><indicator id=\"2\">2</indicator><subfield id=\"a\">RU</subfield><subfield id=\"b\">19013582</subfield><subfield id=\"c\">20040426</subfield><subfield id=\"g\">PSBO</subfield></field><field id=\"998\"><indicator id=\"1\"> </indicator><indicator id=\"2\"> </indicator><subfield id=\"a\">Thcadi83LWilWill</subfield></field><field id=\"999\"><indicator id=\"1\"> </indicator><indicator id=\"2\"> </indicator><subfield id=\"a\">СПбГПУ</subfield><subfield id=\"b\">ИМОП</subfield><subfield id=\"e\">-1/19960131</subfield><subfield id=\"h\">ББК 75</subfield><subfield id=\"i\">W69</subfield><subfield id=\"p\">58738</subfield><subfield id=\"u\">1,00</subfield><subfield id=\"v\">1</subfield><subfield id=\"y\">0000372660</subfield></field></record>";
        
//        String testData1;
//        testData1 = "{\"syntax\":\"rusmarc\"}";
//        MarsValidator v = new MarsValidator();
//        Result r = new Result();
//        r = v.validate(testData1);

        
//        try {
//                MarcReader usr = new MarcStreamReader(new FileInputStream(
//                                "test_records/usmarc_ruslan.mrc"));
//                JsonWriter jw = new JsonWriter();
//                while (usr.hasNext()) {
//                    //System.out.println(jw.toJson(usr.next()));
//                    
//                    //заполнение Rusmarc тестовыми данными
//                    Fill fill1 = rusmarcDeserializer.parse(testData);
//
//                    ComplexResult ret1 = FluentValidator.checkAll().failOver()
//                            .on(fill1, new ValidatorFields())
//                            .doValidate().result(toComplex());
//                            System.out.println(fill.getField001().get(0).getValue());
//                    
//                }
//        } catch (FileNotFoundException | MarcException e) {
//                e.printStackTrace();
//                System.err.println(e.getMessage());
//        }
    }
}