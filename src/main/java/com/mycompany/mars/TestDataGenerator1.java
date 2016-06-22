package com.mycompany.mars;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestDataGenerator1 {
    
    public String getData() throws FileNotFoundException, ParseException, IOException{
        
        JSONObject json = (JSONObject) new JSONParser().parse(new FileReader("e:\\Учеба\\~12\\Mars\\Mars\\data.json"));
        DataParser dataParser = new DataParser();
        return dataParser.parse(json);
    }
}