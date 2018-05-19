package coreJava.practice1;

public class Test {
    public static void main(String[] args) {
        String str1 = new String("Hello");
        String str3 = new String("Hello");
        String str2 = "He"+"llo";
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
    }
}
