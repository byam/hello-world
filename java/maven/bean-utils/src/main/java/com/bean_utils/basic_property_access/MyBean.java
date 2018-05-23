package com.bean_utils.basic_property_access;

import java.util.ArrayList;
import java.util.List;

public class MyBean {
    private String stringProp;
    private float floatProp;

    //indexed property
    @SuppressWarnings("rawtypes")
    private List listProp = new ArrayList();

    public void setStringProp(String stringProp) { this.stringProp = stringProp; }
    public String getStringProp() { return this.stringProp; }

    public void setFloatProp(float floatProp) { this.floatProp = floatProp; }
    public float getFloatProp() { return this.floatProp; }

    public void setListProp(List<?> listProp) { this.listProp = listProp; }
    public List<?> getListProp() { return this.listProp; }
}
