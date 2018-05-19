package javaClassChina.eason.practice_3;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Random random = new Random();
        System.out.println("给你一个1到100之间的整数，猜猜这个数");
        int realNumber = random.nextInt(100)+1;
        System.out.println(realNumber);

        int yourGuess = 0;
        System.out.println("输入你的猜测");
        yourGuess=reader.nextInt();

        while(yourGuess != realNumber){
            if(yourGuess > realNumber){   //bigger
                System.out.println("Bigger than realNumber");
                yourGuess=reader.nextInt();
                continue;
            }else if(yourGuess < realNumber){  //smaller
                System.out.println("Smaller than realNumber");
                yourGuess=reader.nextInt();
                continue;
            }else{
                System.out.println("Congratulations!");
                break;
            }
        }
    }
}
