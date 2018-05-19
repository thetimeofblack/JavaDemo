package javaClassChina.eason.practice12.exp1;

public class GivenLetterThread extends Thread{

    public void setLetter(Letter letter) {
        this.letter = letter;
    }

    public void setSleepLength(int sleepLength) {
       this.sleepLength = sleepLength;
    }

    private Letter letter = null;
    private final char startChar = 'a',endChar = 'z';
    private int sleepLength = 5000;

    public GivenLetterThread(){ /**void*/}

    @Override
    public void run() {
        char start = this.startChar;
        while(true){
                this.letter.setChar(start);
                System.out.printf("显示的字符：%c\n",this.letter.getChar());
                try {
                    super.sleep(this.sleepLength);
                } catch (InterruptedException e) {
            }
            start = (char) ((int)start+1);
            if(start >= this.endChar){
                start = this.startChar;
            }
        }
    }
}
