
package coreJava.inheritance.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * This program uses reflection to print all features of a specific class.
 * @verision 2017-10-03
 * @author Eason.Hua
 * */
public final class ReflectionUtil {

    private final Class clazz;

    //do not use new to initialize the class
    private ReflectionUtil(Class clazz){
        this.clazz = clazz;
    }

    public static void main(String[] args) {
        //read class from command line or user input
        String className = "java.util.Date";
//        if(args.length > 0 ){ className = args[0];}else{
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Enter class name (e.g. java.util.Date)");
//            className = scanner.next();
//        }
        try {
            ReflectionUtil.printClass(Class.forName(className));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    /**print the whole information of the class*/
    public static void printClass(Class clazz){
        StringBuffer reader = new StringBuffer();
        reader.append(printClassTitle(clazz)).append(printFields(clazz))
                .append(printConstructors(clazz)).append(printMethods(clazz))
                .append("\n}");

        System.out.print(reader.toString());
    }

    /**show the title of the class*/
    public static String printClassTitle(Class clazz){
        StringBuffer reader = new StringBuffer();
        Class superClazz = clazz.getSuperclass();
        String modifiers = Modifier.toString(clazz.getModifiers());

        if(modifiers.length() > 0){
            reader.append(modifiers).append(" ");
        }

        reader.append("class ").append(clazz.getSimpleName());
        if(superClazz != null && superClazz != Object.class){   //superClazz.getName() != Object.class.getName()
            reader.append(" extends").append(superClazz.getName());
        }

        reader.append("{");

        return reader.toString();
    }

    /**show all the constructors of the class*/
    public static String printConstructors(Class clazz){
        //get all Constructors of the class
        StringBuilder builder = new StringBuilder().append("\n     //Constructors\n");
        Constructor[] constructors = clazz.getDeclaredConstructors();

        for (Constructor c :constructors) {
            String name = c.getName();
            String modifiers = Modifier.toString(c.getModifiers());
            //parameter list
            Class[] parameters = c.getParameterTypes();

            builder.append("     ").append(modifiers).append(" ")
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

    /**print all the Fields of the class*/
    public static String printFields(Class clazz){
        StringBuilder builder = new StringBuilder().append("\n     //fields\n");
        Field[] fields = clazz.getDeclaredFields();

        for(Field field:fields){
            String fieldName = field.getName();
            String modifier = Modifier.toString(field.getModifiers());

            builder.append("      ").append(modifier).append(" ").append(fieldName).append(";\n");
        }

        return builder.toString();
    }

    /**print all the methods*/
    public static String printMethods(Class clazz){
        StringBuilder builder = new StringBuilder().append("\n     //methods\n");
        Method[] methods = clazz.getDeclaredMethods();

        for(Method method : methods){
            String returnType = method.getReturnType().getName();
            String methodName = method.getName();
            String modifier = Modifier.toString(method.getModifiers());
            Class[] parameters = method.getParameterTypes();

            builder.append("      ").append(modifier).append(" ").append(returnType)
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
