package com.bean_utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.beanutils.LazyDynaClass;
import org.apache.commons.beanutils.LazyDynaBean;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.MutableDynaClass;

import java.io.IOException;
import java.util.Map;

public class JsonSchemaToBean {

    private static final ImmutableMap<String, Class> JAVA_STRING_TO_CLASS =
            ImmutableMap.<String, Class>builder()
                    .put("STRING", String.class)
                    .put("INTEGER", Integer.class)
                    .build();

    public MutableDynaClass createClass(Map<String, String> atrributes){

        MutableDynaClass dynaClass = new LazyDynaClass();

        for (Map.Entry<String, String> entry : atrributes.entrySet()){
            dynaClass.add(entry.getKey(), JAVA_STRING_TO_CLASS.get(entry.getValue()));
        }
        return dynaClass;
    }


    public static void main(String[] args) throws IOException {

        // simple schema
        String jsonSchema = "{\"name\":\"STRING\", \"age\":\"INTEGER\"}";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> schema = mapper.readValue(jsonSchema, Map.class);

        // create dyna class
        JsonSchemaToBean jsonSchemaToBean = new JsonSchemaToBean();
        MutableDynaClass dynaClass = jsonSchemaToBean.createClass(schema);

        // test
        DynaBean dynaBean = new LazyDynaBean(dynaClass);
        dynaBean.set("name", "byam");
        dynaBean.set("age", 28);

        System.out.println("name: " + dynaBean.get("name"));
        System.out.println("age: " + dynaBean.get("age"));
    }
}
