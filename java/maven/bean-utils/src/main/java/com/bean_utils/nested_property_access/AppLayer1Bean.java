package com.bean_utils.nested_property_access;

public class AppLayer1Bean {
    private SubBean subBean;

    public void setSubBean(SubBean subBean) {
        this.subBean = subBean;
    }
    public SubBean getSubBean(){
        return this.subBean;
    }
}
