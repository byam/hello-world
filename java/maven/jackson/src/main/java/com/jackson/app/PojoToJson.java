package com.jackson.app;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class PojoToJson {

    public static class MyValue {
        public String name;
        public int age;
    }

    public static void main( String[] args ) throws IOException {

        // create mapper
        ObjectMapper mapper = new ObjectMapper();

        MyValue value = new MyValue();
        value.age = 28;
        value.name = "Bya";

        String jsonString = mapper.writeValueAsString(value);
        System.out.println(jsonString);
    }
}
