package coreJava.practice1;

public class string_test {

    public static void main(String[] args) {
        String tom = new String("How are you");
        String me = "How are you";
        String jerry = new String("How are you");
        System.out.println("tom == me?" + tom == me);       //false
        System.out.println("jerry == me?" + jerry == me);       //false
        System.out.println("tom == jerry?" + tom == jerry);     //false

//        {
//            String s="abcd";
//            System.out.println(s+s.hashCode());
//            s=s+1;
//            System.out.println(s+s.hashCode());
//
//            String greeting="Hello World";
//            /**计算String码点*/
//            int cpCount=greeting.codePointCount(0,greeting.length());
//            System.out.println("cpCount= "+cpCount);
//            /**获取指定位置的char值*/
//            char first=greeting.charAt(0);
//            char last=greeting.charAt(greeting.length()-1);
//            System.out.println(first+" "+last);
//            /**ASCII码*/
//            int[] codePoints=greeting.codePoints().toArray();
//            for(int i:codePoints){
//                System.out.println(i+" ");
//            }
//            /**当我们要通过拼接String时效率很低，此时可以用StringBuilder构建*/
//            StringBuilder builder=new StringBuilder();
//            String first_part="Hello";
//            String second_part="world";
//            char middle='M';
//            builder.append(first_part);
//            builder.append(second_part);
//            builder.insert(5,middle);
//            String completedString=builder.toString();
//            System.out.println(completedString);
//        }

    }

    ///**测试String类拼接与是否相等
    // *difference between ==  and  equals*/
    //private static void test_equality() {
    //    String str1="Hello";
    //    String str2="He";
    //    String str3=str2+"llo";
    //    System.out.println("str1= "+str1.hashCode()+" str2="+str2.hashCode()+" str3= "+str3.hashCode());
    //    if(str1=="Hello"){
    //        System.out.println("str1==Hello");
    //    }
    //    if(str1==str3){
    //        System.out.println("same memory location");
    //    }
    //    if(str1.equals(str3)){
    //        System.out.println("same value");
    //    }
    //}
}
