package javaClassChina.eason.practice12.exp1;

import java.util.Scanner;

public class InputLetterThread extends Thread{

    private Scanner reader = null;
    private Letter letter = null;
    private int score = 0;


    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    public InputLetterThread(){
        this.reader = new Scanner(System.in);
    }

    @Override
    public void run() {
        while(true){
            String str = reader.nextLine();
            char c = str.charAt(0);
            if(c == '#'){
                System.exit(0);
            }else if(c == this.letter.getChar()){
                this.score += 1;
                System.out.printf("\t\t输入对了，目前得分%d\n",this.score);
            }else{
                System.out.printf("\t\t输入错了，目前得分%d\n",this.score);
            }

        }
    }
}
