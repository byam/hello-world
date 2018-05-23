package com.bean_utils.nested_property_access;

import org.apache.commons.beanutils.PropertyUtils;

public class BeanUtilsDemo {
    public static void main(String args[]){
        try{
            // create the bean
            AppLayer1Bean nested = new AppLayer1Bean();
            // set a SubBean which is part of another bean
            SubBean sb = new SubBean();
            sb.setStringProperty("Hello World from SubBean");
            nested.setSubBean(sb);

            // accessing and setting nested properties
            PropertyUtils.setNestedProperty(
                    nested, "subBean.stringProperty",
                    "Hello World from SubBean, set via Nested Property Access");

            System.out.println(
                    PropertyUtils.getNestedProperty(nested, "subBean.stringProperty"));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
