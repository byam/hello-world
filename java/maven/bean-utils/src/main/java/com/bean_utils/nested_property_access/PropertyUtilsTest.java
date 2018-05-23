package com.bean_utils.nested_property_access;

import org.apache.commons.beanutils.PropertyUtils;

public class PropertyUtilsTest {
    public static void main(String args[]){
        try{
            Tv Color = new Tv();
            PropertyUtils.setProperty(Color, "color", "Black");
            String value = (String) PropertyUtils.getProperty(Color, "color");
            System.out.println("The color value of Tv is: " + value);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static class Tv{
        private String color;

        public String getColor(){
            return color;
        }
        public void setColor(String color){
            this.color = color;
        }
    }
}
