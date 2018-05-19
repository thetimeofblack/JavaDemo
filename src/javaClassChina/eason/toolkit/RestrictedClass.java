package javaClassChina.eason.toolkit;

import java.util.ArrayList;
import java.util.Random;

/**
 * for testing Singleton.
 * can only be initialized INITIAL_TIME*/
public final class RestrictedClass {

    private static final int MAX_INSTANCE = 2;
    private static ArrayList<RestrictedClass> restrictedClasses = null;

    static {
        restrictedClasses = new ArrayList<>(MAX_INSTANCE);
        for (int i = 0; i < RestrictedClass.MAX_INSTANCE; i++) {
            restrictedClasses.add(new RestrictedClass());
        }
    }

    private RestrictedClass(){
        /**void*/
    }

    public static RestrictedClass getInstance(){
        int index = new Random().nextInt(RestrictedClass.MAX_INSTANCE); //index equals 0 or 1
        return restrictedClasses.get(index);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            RestrictedClass myClass = RestrictedClass.getInstance();
            System.out.println(myClass);
        }
        System.out.println("finished");
    }
}