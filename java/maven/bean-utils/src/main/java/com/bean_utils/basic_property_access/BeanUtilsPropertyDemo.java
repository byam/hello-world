package com.bean_utils.basic_property_access;

import org.apache.commons.beanutils.PropertyUtils;
import java.util.ArrayList;
import java.util.List;

public class BeanUtilsPropertyDemo{
    public static void main(String args[]){

        try{
            // Creating the bean and allows to access getter and setter properties
            MyBean myBean = new MyBean();

            // Setting the properties on the myBean
            PropertyUtils.setSimpleProperty(myBean, "stringProp", "Hello!This is a string");
            PropertyUtils.setSimpleProperty(myBean, "floatProp", new Float(25.20));

            // Getting the simple properties
            System.out.println("String Property: " + PropertyUtils.getSimpleProperty(myBean, "stringProp"));

            System.out.println("Float Property: " + PropertyUtils.getSimpleProperty(myBean, "floatProp"));

            // Here we will create a list for the indexed property
            List list = new ArrayList();
            list.add("String value 0");
            list.add("String value 1");

            myBean.setListProp(list);

            // get and set this indexed property
            PropertyUtils.setIndexedProperty(myBean, "listProp[1]", "This is new string value 1");

            System.out.println("List Property[1]: " + PropertyUtils.getIndexedProperty(myBean, "listProp[1]"));

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
