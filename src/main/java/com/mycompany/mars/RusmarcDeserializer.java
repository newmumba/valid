package com.mycompany.mars;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.mycompany.mars.data.Fill;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class RusmarcDeserializer {
    public Fill parse(String json) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        //игнорируем ошибки, в случае отсутствия полей в объектах.
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Fill rusmarc = mapper.reader(Fill.class).readValue(json);
        return rusmarc;
    }  

}