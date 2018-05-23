package com.bean_utils.dynabeans;

import org.apache.commons.beanutils.LazyDynaClass;
import org.apache.commons.beanutils.LazyDynaBean;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.MutableDynaClass;

public class LazyDynaBeanExample {

    public static void main(String[] args) {

        // create LazyDynaClass
        MutableDynaClass dynaClass = new LazyDynaClass();
        dynaClass.add("name", java.lang.String.class);
        dynaClass.add("age", java.lang.Integer.class);

        // create LazyDynaBean
        DynaBean dynaBean = new LazyDynaBean(dynaClass);

        dynaBean.set("name", "byam");
        dynaBean.set("age", 28);

        System.out.println("name: " + dynaBean.get("name"));
        System.out.println("age: " + dynaBean.get("age"));
    }
}
