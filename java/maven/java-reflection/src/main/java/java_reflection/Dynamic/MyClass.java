package java_reflection.Dynamic;

import java.util.HashMap;

public class MyClass {
    private HashMap<String, Class> fields;

    public MyClass(){
        this.fields = new HashMap<String, Class>();
    }

    public void addValue(String name, Class c){
        fields.put(name, c);
    }

    public Class getValue(String name){
        return fields.get(name);
    }
}
