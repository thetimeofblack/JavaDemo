package javaClassChina.eason.practice12.exp1;

public class TypeKey {

    public static void main(String[] args) {
        System.out.println("键盘练习(输入#结束程序)");
        System.out.printf("输入显示字符(回车)\n");
        Letter letter = new Letter();
        GivenLetterThread giveChar = new GivenLetterThread();
        InputLetterThread typeChar = new InputLetterThread();
        giveChar.setLetter(letter);
        giveChar.setSleepLength(3000);
        typeChar.setLetter(letter);
        giveChar.start();
        typeChar.start();
    }

}
