package com.jackson.app;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonToPojo {

    public static class MyValue {
        public String name;
        public int age;
    }

    public static void main( String[] args ) throws IOException {

        // prepare json
        String jsonString = "{\"name\":\"Bya\", \"age\":28}";

        // create mapper
        ObjectMapper mapper = new ObjectMapper();

        // json to POJO
        MyValue value = mapper.readValue(jsonString, MyValue.class);

        System.out.println( value.age );
        System.out.println( value.name );
    }

}
