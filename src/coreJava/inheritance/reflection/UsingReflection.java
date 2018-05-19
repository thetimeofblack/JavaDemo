package coreJava.inheritance.reflection;

import coreJava.inheritance.Employee;

import java.lang.reflect.Field;

public final class UsingReflection {

    public static void main(String[] args) {
        //initialize an object
        Employee harry = new Employee("harry",1000,null);
        try {
            //get the Field -> private String name;
            Field f = Employee.class.getDeclaredField("name");
            f.setAccessible(Boolean.TRUE);
            f.set(harry,"Eason");
            System.out.println(harry);  //name of harry has been modified
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}