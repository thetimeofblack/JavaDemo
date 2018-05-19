package javaClassChina.eason.practice_3;
//import java.util.Scanner;
public class Number {
    public static void main(String[] args) {
//        int number = 0;
//        Scanner reader=new Scanner(System.in);
//        System.out.println("请输入一个1至99999之间的数");
//        number = reader.nextInt();
        int a[]={5,34,55,121,214,1234,1221,12345,12321};
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]+"="+Number.isPali(a[i]));
        }
    }

    /**
     * 判断输入数字是否为回文数
     * */
    private static boolean isPali(int number){
        //numebr转成Array,取反，组合成新String->Integer,判断是否相等
        char[] char_init=String.valueOf(number).toCharArray();
        char [] char_last=new char[char_init.length];
        for(int i=0;i<char_init.length;i++){
            int index=char_init.length-1-i;
            char_last[index]=char_init[i];
        }
        int last=Integer.parseInt(new String(char_last));
        return (last == number);
    }

    private static void test_Number(int number) {
        int d5,d4,d3,d2,d1;
        if(number >= 1 && number <= 99999){
            d5 = number/10000;
            d4 = number%10000/1000;
            d3 = number%1000/100;
            d2 = number%100/10;
            d1 = number%10;
            if(d5 != 0){
                //number是5位数
                System.out.println(number+"是5位数");
                if(d1==d5 && d2==d4){
                    System.out.println(number+"是回文数");
                }else{
                    System.out.println(number+"不是回文数");
                }
            }else if(d4 != 0){
                //number是4位数
                System.out.println(number+"是4位数");
                if(d1 == d4 && d2 == d3){
                    System.out.println(number+"是回文数");
                }else{
                    System.out.println(number+"不是回文数");
                }
            }else if(d3 != 0){
                //number是3位数
                System.out.println(number+"是3位数");
                if(d1 == d3){
                    System.out.println(number+"是回文数");
                }else{
                    System.out.println(number+"不是回文数");
                }
            }else if(d2 != 0){
                //number是2位数
                System.out.println(number+"是2位数");
                if(d1 == d2){
                    System.out.println(number+"是回文数");
                }else{
                    System.out.println(number+"不是回文数");
                }
            }else{
                //number是1位
                System.out.println(number+"是个位数");
                System.out.println(number+"是回文数");
            }
        }else{
            System.out.printf("%d不在1至99999之间",number);
        }
    }
}
