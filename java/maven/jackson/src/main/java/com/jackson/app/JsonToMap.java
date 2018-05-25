package com.jackson.app;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class JsonToMap {

    public static void main( String[] args ) throws IOException {

        // prepare json
        String jsonString = "{\"name\":\"Bya\", \"age\":28}";

        // create mapper
        ObjectMapper mapper = new ObjectMapper();

        // json to map
        Map<String, String> keyValue = mapper.readValue(jsonString, Map.class);

        System.out.println(keyValue.keySet());
        System.out.println(keyValue.values());
    }

}
