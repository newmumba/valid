package com.mycompany.mars;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataParser {
    public String parse(JSONObject json){
        JSONObject core = new JSONObject();
        JSONObject record = (JSONObject) json.get("record");

        if (json.get("syntax") != null) {
            JSONArray fieldSyntaxArray = new JSONArray();
            fieldSyntaxArray.add(parseUnit(json.get("syntax")));
            core.put("syntax", fieldSyntaxArray);
        }

        if (record != null) {
            if (record.get("l") != null) {
                JSONArray fieldLArray = new JSONArray();
                fieldLArray.add(parseUnit(record.get("l")));
                core.put("l", fieldLArray);
            }

            JSONArray cf = (JSONArray) record.get("cf");
            if (cf != null) {
                for (Iterator it = cf.iterator(); it.hasNext();) {
                    JSONObject field = (JSONObject) it.next();
                    if (field.get("tag") != null) {
                        JSONArray fieldCfTypeArray = new JSONArray();
                        fieldCfTypeArray.add(parseCf(field));
                        core.put(field.get("tag"), fieldCfTypeArray);
                    } else {
                        System.err.println("Error in TestDataGenerator1");
                    }
                }
            }

            JSONArray df = (JSONArray) record.get("df");
            if (df != null) {
                for (Iterator it = df.iterator(); it.hasNext();) {
                    JSONObject field = (JSONObject) it.next();
                    if (field.get("tag") != null) {
                        JSONArray fildeArr = new JSONArray();
                        if (core.containsKey(field.get("tag"))) {
                            fildeArr = (JSONArray) core.get(field.get("tag"));
                        }
                        fildeArr.add(parseDf(field));
                        core.put(field.get("tag"), fildeArr);
                    } else {
                        System.err.println("Error in TestDataGenerator1");
                    }
                }
            }
        }
        return core.toString();
    }
        
    private Map parseDf(JSONObject data) {
        Map field = new HashMap<>();
        field.put("i1", data.get("i1"));
        field.put("i2", data.get("i2"));
        JSONArray sf = (JSONArray) data.get("sf");
        for (Iterator it = sf.iterator(); it.hasNext();) {
            JSONObject subField = (JSONObject) it.next();
            if (subField.get("id") != null) {
                JSONArray subArr = new JSONArray();
                if(field.containsKey(subField.get("id"))){   
                    subArr = (JSONArray) field.get(subField.get("id"));
                }
                subArr.add(subField.get("d"));
                field.put(subField.get("id"), subArr);
            } else {
                System.err.println("Error in TestDataGenerator1");
            }
        }
        return field;
    }
    
    private Map parseCf(JSONObject data) {
        Map field = new HashMap<>();
        JSONArray subArr = new JSONArray();
        subArr.add(data.get("d"));
        field.put("value", subArr);
        return field;
    }
    
    private Map parseUnit(Object data) {
        Map field = new HashMap<>();
        JSONArray subArr = new JSONArray();
        subArr.add((String) data);
        field.put("value", subArr);
        return field;
    }
}
