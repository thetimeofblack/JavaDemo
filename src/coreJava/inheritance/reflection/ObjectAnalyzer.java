package coreJava.inheritance.reflection;

import coreJava.inheritance.Employee;

import java.lang.StringBuffer;
import java.lang.reflect.*;
import java.time.LocalDate;
import java.util.ArrayList;

public final class ObjectAnalyzer {

    private ArrayList<Object> visited = new ArrayList<>();

    /**
     * Unit test
     * */
    public static void main(String[] args) {

        Employee emp1 = new Employee(null,1000, LocalDate.now());
        int[] str = {1,2,3,4};
//        Manager emp1 = new Manager("eason",2000,LocalDate.now());

        ObjectAnalyzer analyzer = new ObjectAnalyzer();

        //int[ 4 ] {1, 2, 3, 4}
        System.out.println(analyzer.listFields(str));

        //public class Employee implements java.lang.Comparable, java.lang.Cloneable,
        // [ String name = null, double salary = 1000.0, LocalDate hireDate = 2017-11-25 ]
        System.out.println(analyzer.listFields(emp1));

//      Constructors
//      public java.coreJava.inheritance.Employee(String,double,int,int,int);
        System.out.println(ObjectAnalyzer.printConstructors(emp1));

//        //methods
//        public boolean equals(java.lang.Object);
//        public java.lang.String toString();
        System.out.println(ObjectAnalyzer.printMethods(emp1));
    }

    /**
     * Convert an object to a String representation that lists all fields;
     * @param object an object
     * @return a string with the object's class name and all fields names and values.
     * */
    public String listFields(Object object) {
        StringBuffer reader = new StringBuffer();
        //if object is null
        if (object == null) {
            return "null";
        }
        //if visited contains object, return ...   OR add to visited
        if (this.visited.contains(object)) {
            return "...";
        } else {
            this.visited.add(object);
        }
        //if object is instance of String ,returns that
        if (object instanceof java.lang.String) { //or object.getClass() == String.class;
            return (String) object;
        }

        //start analysing the object
        Class clazz = object.getClass();
        //if is Array: print like "Integer[] ArrayName {1,2,3,4}".
        if (clazz.isArray()) {
            int lengthOfObject = Array.getLength(object);
            reader.append(clazz.getComponentType().getSimpleName()).append("[ ").append(lengthOfObject)
                    .append(" ]").append(" {");
            //print members of the Array, using Reflection.Array static methods.
            for (int i = 0; i < lengthOfObject; i++) {
                if (i > 0) {
                    reader.append(", ");
                }
                Object val = Array.get(object, i);
                //check if it's primitive type.
                if (clazz.getComponentType().isPrimitive()) {
                    reader.append(val);
                } else {    //not primitive type -> analyze every object
                    reader.append(listFields(val));   //为防止无限递归，类中添加visited记录访问过的对象
                }
            }
            reader.append("}");
        } else {
            //not an Array: print like "public (final) className (extends ...) (implements ...)
            // [ String field1 = "value", field2 = "value2"]".

            //get all fields of object and open accessibility
            Field[] fields = clazz.getDeclaredFields();
            Class superClass = clazz.getSuperclass();
            Class[] interfaces = clazz.getInterfaces();
            AccessibleObject.setAccessible(fields, true);

            //test if the class is pubic
            if(clazz.getModifiers() == 1){
                reader.append("public ");
            }

            reader.append("class ").append(clazz.getSimpleName());
            //get its super class if exists
            if(superClass != null && superClass != Object.class){
                reader.append(" extends " + superClass.getName());
            }
            //get implemented interfaces if exists
            if(interfaces.length > 0){
                reader.append(" implements ");
                for (Class per_interface : interfaces){
                    reader.append(per_interface.getName()).append(", ");
                }
            }

            reader.append(" [ ");
            for (Field field : fields) {
                if(!(reader.charAt(reader.length() - 2) == '[')){        //if the last char is '[', do not add ",".
                    reader.append(", ");
                }
                Class typeOfField = field.getType();    //type of the field
                String fieldType = typeOfField.getSimpleName();
                reader.append(fieldType).append(" ").append(field.getName()).append(" = ");

                try {
                    Object val = field.get(object);
                    if (field.getType().isPrimitive()) {
                        reader.append(val);
                    } else {
                        reader.append(val==null?"null":val.toString());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            reader.append(" ]");
        }
        return reader.toString();
    }

    /**show all the constructors of the class*/
    public static String printConstructors(Object object){
        //get all Constructors of the class
        Class clazz = object.getClass();
        if(clazz.isArray()){
            return "object is an Array";
        }
        StringBuilder builder = new StringBuilder().append("\n      //Constructors\n");
        Constructor[] constructors = clazz.getDeclaredConstructors();

        for (Constructor c :constructors) {
            String name = c.getName();
            String modifiers = Modifier.toString(c.getModifiers());
            //parameter list
            Class[] parameters = c.getParameterTypes();

            builder.append("      ").append(modifiers).append(" ")
                    .append(name+"(");
            for (int i = 0; i < parameters.length; i++) {
                if(i > 0){builder.append(",");}
                builder.append(parameters[i].getSimpleName());
            }
            builder.append(");");
            builder.append("\n");
        }
        return builder.toString();
    }

    /**print all the methods*/
    public static String printMethods(Object object){
        Class clazz = object.getClass();
        if(clazz.isArray()){
            return "object is an Array";
        }
        //get all Constructors of the class
        StringBuilder builder = new StringBuilder().append("\n      //methods\n");
        Method[] methods = clazz.getDeclaredMethods();

        for(Method method : methods){
            String returnType = method.getReturnType().getName();
            String methodName = method.getName();
            //is public, private or protected?
            String modifier = Modifier.toString(method.getModifiers());
            Class[] parameters = method.getParameterTypes();

            builder.append("       ").append(modifier).append(" ").append(returnType)
                    .append(" ").append(methodName).append("(");
            for (int i = 0; i < parameters.length; i++) {
                if(i > 0){builder.append(",");}
                builder.append(parameters[i].getName());
            }
            builder.append(");\n");
        }
        return builder.toString();
    }
}