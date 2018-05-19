package javaClassChina.eason.practice12.exp2;

public final class Number implements Runnable {

    public static void main(String[] args) {
        Number number = new Number();
        number.startGivenNumberThread();
        number.startGuessNumberThread();
    }

    private static final int SMALLER = -1,LARGER = 1,SUCCESS = 8;
    private int realNumber,guessNumber,message = SMALLER,min = 0,max = 100;
    //isGivenNumber意味着是否已经设置guess number,pleaseGuess意味着是否能开始猜
    private boolean pleaseGuess = false, isGivenNumber = false;
    private Thread givenNumberThread = null, guessNumberThread = null;

    public void startGivenNumberThread(){
        this.givenNumberThread.start();
    }

    public void startGuessNumberThread(){
        this.guessNumberThread.start();
    }

    public Number(){
        this.givenNumberThread = new Thread(this);
        this.guessNumberThread = new Thread(this);
    }

    /**
     * method for guessing numbers and set message(SMALLER, LARGER, SUCCESS)
     * based on the results
     * @param count the total times you have guessed the number
     * */
    public synchronized void setMessage(int count){
        //若当前线程是givenNumberThread并且还未设置数字,设置数字并且置位
        if(Thread.currentThread() == this.givenNumberThread && this.isGivenNumber == false){
            System.out.println("please guess a number between closed 1 and 100");
            this.realNumber = (int)(Math.random() * 100 + 1);
            this.isGivenNumber = true;
            this.pleaseGuess = true;
        }
        //若当前线程是givenNumberThread并且已经设置数字,判断guessNumber与realNumber大小(pleaseGuess == true则等待)
        if(Thread.currentThread() == this.givenNumberThread){
            while(this.pleaseGuess == true) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted wait");
                }
            }
            if(this.realNumber > this.guessNumber){     //smaller than
                System.out.println("your number is smaller!");
                this.message = Number.SMALLER;
            }else if(this.realNumber < this.guessNumber) {
                System.out.println("your number is larger!");
                this.message = Number.LARGER;
            }else{
                System.out.println("Congratulations!");
                this.message = Number.SUCCESS;
            }
                this.pleaseGuess = true;
        }
        //若当前是guessNumberThread且数字已设置，则开始猜数字(pleaseGuess == false则等待)
        if(Thread.currentThread() == this.guessNumberThread && this.isGivenNumber == true){
            while(this.pleaseGuess == false){
                try {
                    wait();
                } catch (InterruptedException e) { }
            }
            if(this.message == SUCCESS){
                return;
            }
            if(this.message == Number.SMALLER){
                this.min = this.guessNumber;
                this.guessNumber = (this.min + this.max)/2;
            }else if(this.message == Number.LARGER){
                this.max = this.guessNumber;
                this.guessNumber = (this.min + this.max)/2;
            }
            System.out.println("I am the "+ count + " times to guess: "+this.guessNumber);
            this.pleaseGuess = false;
        }
        notifyAll();
    }

    @Override
    public void run() {
        for(int count = 1; true; count += 1){
            this.setMessage(count);
            if(this.message == Number.SUCCESS){
                return;
            }
        }
    }
}
