package com.bean_utils;


import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;

public class DynaBeanExample {
    private final String NR_OF_WHEELS = "numberOfWheels";

    private void runExample() throws InstantiationException, IllegalAccessException {

        DynaClass dynaClass = new BasicDynaClass("Car", null,
                new DynaProperty[] {
                        new DynaProperty(NR_OF_WHEELS, Integer.TYPE)
                });

        DynaBean car = dynaClass.newInstance();
        car.set(NR_OF_WHEELS, 4);
        System.out.println("Number of wheels: " + car.get(NR_OF_WHEELS));
        System.out.println("DynaBean is instance of DynaClass: " + car.getDynaClass().getName());


    }
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        DynaBeanExample ac = new DynaBeanExample();
        ac.runExample();
    }
}
