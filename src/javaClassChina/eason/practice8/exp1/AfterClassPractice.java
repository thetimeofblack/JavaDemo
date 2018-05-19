package javaClassChina.eason.practice8.exp1;

public class AfterClassPractice {

    public static void main(String[] args) {
        String str1 = "ABCABC",str2 = null,str3 = null,str4 = null;
        str2 = str1.replaceAll("A","First");
        str3 = str2.replaceAll("B","Second");
        str4 = str3.replaceAll("C","Third");
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);

        long i = 45123;
        System.out.println(Long.toBinaryString(i));
        System.out.println(Long.toOctalString(i));
        System.out.println(Long.toHexString(i));
        System.out.println(Long.toString(i));
    }
}
