package coreJava.practice1;

import java.util.Scanner;

public class Enum_test1 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("MEDIUM="+Size.MEDIUM.toString());
        System.out.println("please enter the abbreviation of MEDIUM");

        String input=scanner.next().toUpperCase();
        /**Enum.valueOf Returns the enum constant of the specified enum type with the
         * specified name.  The name must match exactly an identifier used
         * to declare an enum constant in this type.  (Extraneous whitespace
         * characters are not permitted.)
         * if not matched, an Exception will be thrown.
         * */
        Size size=Enum.valueOf(Size.class,input);
        System.out.println(size.getAbbreviation()+" "+size.toString()+" "+size.ordinal());


        //print hashCode
        System.out.println(Size.MEDIUM.hashCode());
        System.out.println(size.hashCode());
    }

    /**Size是一个枚举类,SMALL,LARGE,MEDIUM分别为Size的实例*/
    enum Size { //class
        SMALL("S"),MEDIUM("M"),LARGE("L");
        private String abbreviation;

        /**self-designed methods*/
        private Size(String abbreviation){
            this.abbreviation=abbreviation;
        }
        public String getAbbreviation(){
            return this.abbreviation;
        }
    }
}




