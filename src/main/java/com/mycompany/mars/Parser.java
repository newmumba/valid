package com.mycompany.mars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public Map parse(String data) {
        
        Map field = new HashMap<String, ArrayList>();
        String[] subfield = data.split("\\$");
        
        //Часть поля до первого подполя (знака $)
        if (subfield[0].length() == 2) {
            field.put("i1", subfield[0].substring(0, 1));
            field.put("i2", subfield[0].substring(1, 2));
        } else if(subfield[0].length() == 1){
            field.put("i1", subfield[0]);
        } else if(subfield[0].length() > 2){
            field.put("i0", subfield[0]);
        }
        
        //Обработка подполей
        for (int i = 1; i < subfield.length; i++) {
            ArrayList value = new ArrayList();
            
            if(field.containsKey(subfield[i].substring(0, 1))){
                value = (ArrayList) field.get(subfield[i].substring(0, 1));
            }
            value.add(subfield[i].substring(1, subfield[i].length()));
            field.put(subfield[i].substring(0, 1), value);
            
        }
        return field;
    }
}
