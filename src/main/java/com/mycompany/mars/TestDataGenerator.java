package com.mycompany.mars;

import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TestDataGenerator {
    
    public String getData(){
        JSONObject core = new JSONObject();
        JSONArray arr225 = new JSONArray();
        JSONArray arr327 = new JSONArray();
        JSONArray arr461 = new JSONArray();
        JSONArray arr462 = new JSONArray();
        JSONArray arr463 = new JSONArray();
        JSONArray arr517 = new JSONArray();
        JSONArray arr600 = new JSONArray();
        JSONArray arr601 = new JSONArray();
        JSONArray arr606 = new JSONArray();
        JSONArray arr610 = new JSONArray();
        JSONArray arr700 = new JSONArray();
        JSONArray arr701 = new JSONArray();
        JSONArray arr702 = new JSONArray();
        JSONArray arr710 = new JSONArray();
        JSONArray arr711 = new JSONArray();
        JSONArray arr712 = new JSONArray();
        
        core.put("100", "##$a20160511d2016####|||y0rusy");
        core.put("101", "11$arus");
        core.put("102", "##$aRU");
        core.put("200", "#1$aНалогоплательщики вместо инициирования судебных разбирательств предпочитают применять правовую позицию, доводимую до них налоговыми органами$fЕлена Владимировна Суворова$gбеседовали Е. В. Орлова, Н. И. Попова$b[Текст]$e26.03.1942-27.03.2015$e27.03.1942-27.03.2015");
        core.put("215", "##$c3 фото");
        
        arr225.add("1#$aПерсона номера");
        arr225.add("1#$aПерсона номера123");
        core.put("225", arr225);
        
        arr327.add("1#$aЗаглавие / Автор");
        core.put("327", arr327);
        
        arr461.add("#0$1011  $a2071-5250$12001 $aНалоговая политика и практика");
        core.put("461", arr461);
        
        arr462.add("#0$eжурнал в журнале");
        core.put("462", arr462);
        
        arr463.add("#0$12001 $a№ 4$vС. 31-35$1210  $d2015");
        core.put("463", arr463);

        arr517.add("1#$aТрадиционные формы налогового контроля");
        core.put("517", arr517);
        
        arr600.add("#1$aБельцони");
        core.put("600", arr600);
        
        arr601.add("12$aРоссийский государственный гуманитарный университет$2AR-MARS");
        core.put("601", arr601);
        
        arr606.add("##$aЭтнология$2AR-MARS");
        arr606.add("##$aТеория этнологии$yКазанское Поволжье$2AR-MARS$yРоссия");
        core.put("606", arr606);
        
        arr610.add("0#$aдроны");
        arr610.add("0#$aИнтернет;");
        core.put("610", arr610);
        
        arr700.add("#1$aНеклюдов$bС. Ю.$cдоктор филологических наук$6z01712$4460");
        core.put("700", arr700);
        
        arr701.add("#1$aСтрельцова$bЕ. П.$6z01712$4070");
        arr701.add("#1$aУланова$bА. Ю.$6z02712$4070");
        core.put("701", arr701);
        
        arr702.add("#1$aТрефилова$bО. В.$cАвтор публикации$6z01712$4220");
        core.put("702", arr702);
        
        arr710.add("02$aРоссийская книжная палата$bПрезидент$fРос. акад. наук");
        core.put("710", arr710);
        
        arr711.add("02$aРоссийская книжная палата$bПрезидент$fРос. акад. наук");
        core.put("711", arr711);
        
        arr712.add("02$aНаучный центр здоровья детей$6z01701$cМосква");
        arr712.add("02$aНаучный центр здоровья детей$6z07701$cМосква");
        core.put("712", arr712);
        
        Parser parser = new Parser();
        Set<String> keys = core.keySet();
        for (String key : keys) {
            Object value = core.get(key);
            try {
                JSONArray array = (JSONArray) value;
                JSONArray newArray = new JSONArray();
                for (Object str : array) {
                    if (str instanceof String) {
                        newArray.add(parser.parse((String) str));
                    }
                }
                core.put(key, newArray);
            } catch (Exception e) {
                String str = (String) value;
                core.put(key, parser.parse(str));
            }
        }
        return core.toString();
    }
}
