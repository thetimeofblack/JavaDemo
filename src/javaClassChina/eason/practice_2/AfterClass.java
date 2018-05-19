package javaClassChina.eason.practice_2;

import java.util.Arrays;

public class AfterClass {
    public static void main(String[] args) {
        //用两种方法声明一个3X3的数组,并将所有值赋为1
        int[][] twoDimentionalArray = new int[3][3];
        for (int i = 0; i < twoDimentionalArray.length; i++) {
            for (int j = 0; j < twoDimentionalArray[i].length; j++) {
                twoDimentionalArray[i][j] = 1;
            }
        }
        int[][] twoDimentionalArray_1 = {{1,1,1},{1,1,1},{1,1,1}};
        //声明一个10个char型的数组，并输出所有值
        char[] myChar =  {'I',' ','a','m',' ','h','a','p','p','y'};
        for (char c: myChar) {
            System.out.print(c);
        }
        //输出数组元素5
        System.out.print("\nfifth in myChar="+myChar[5]+"\n");
        //给数组元素9赋值
        myChar[8] = '!';
        //给数组排序
        Arrays.sort(myChar);
        for (char c: myChar) {
            System.out.print(c);
        }
    }
}
