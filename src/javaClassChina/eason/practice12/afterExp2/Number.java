package javaClassChina.eason.practice12.afterExp2;

public final class Number implements Runnable{

    public static void main(String[] args) {
        Number number = new Number();
        number.startGivenNumberThread();
        number.startGuessNumberThread();
        number.startCopiedGuessNumberThread();
    }

    private static final int SMALLER = -1,LARGER = 1,SUCCESS = 8;
    private int realNumber,guessNumber,message = SMALLER,min = 0,max = 100, count = 0;
    //isGivenNumber意味着是否已经设置guess number,pleaseGuess意味着是否能开始猜
    private boolean pleaseGuess = false, isGivenNumber = false, firstGuess = true;
    private Thread givenNumberThread = null;
    private Thread guessNumberThread = null;
    private Thread copiedGuessNumberThread = null;

    public void startCopiedGuessNumberThread() {
        this.copiedGuessNumberThread.start();
    }

    public void startGivenNumberThread(){
        this.givenNumberThread.start();
    }

    public void startGuessNumberThread(){
        this.guessNumberThread.start();
    }

    public Number(){
        this.givenNumberThread = new Thread(this);
        this.guessNumberThread = new Thread(this);
        this.copiedGuessNumberThread = new Thread(this);
    }

    private void blockCurrentThread(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void guessNumber(){
        while(this.pleaseGuess == false || this.isGivenNumber == false){
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        if(this.message == SUCCESS){    //若已经猜中，则退出无需再猜
            return;
        }
        if(this.message == Number.SMALLER){
            this.min = this.guessNumber;
            this.guessNumber = (this.min + this.max)/2;
        }else if(this.message == Number.LARGER){
            this.max = this.guessNumber;
            this.guessNumber = (this.min + this.max)/2;
        }
        this.count ++;
        System.out.println("I am " + Thread.currentThread().getName());
        System.out.println(count + " times to guess: " + this.guessNumber);
        this.pleaseGuess = false;
    }

    /**
     * Method for guessing numbers and set message(SMALLER, LARGER, SUCCESS)
     * based on the results.
     * */
    public synchronized void setMessage(){
        //若当前线程是givenNumberThread并且还未设置数字,设置数字并且置位。
        if(Thread.currentThread() == this.givenNumberThread && this.isGivenNumber == false){
            System.out.println("please guess number between closed 1 and 100");
            this.realNumber = (int)(Math.random() * 100 + 1);
            this.isGivenNumber = true;
            this.pleaseGuess = true;
        }

        //若当前线程是givenNumberThread并且已经设置数字,判断guessNumber与realNumber大小(pleaseGuess == true则等待)
        if(Thread.currentThread() == this.givenNumberThread && this.isGivenNumber == true){
            while(this.pleaseGuess == true) {
                try {
                    wait();
                } catch (InterruptedException e) { }
            }
            if(this.realNumber > this.guessNumber){     //smaller than
                System.out.println("your number is smaller!");
                this.message = Number.SMALLER;
            }else if(this.realNumber < this.guessNumber) {
                System.out.println("your number is larger!");
                this.message = Number.LARGER;
            }else{
                System.out.println("Congratulations");
                this.message = Number.SUCCESS;
            }
                this.pleaseGuess = true;
        }

        //若当前是guessNumberThread且数字已设置，则开始猜数字(pleaseGuess == false则等待)
        if(Thread.currentThread() == this.guessNumberThread){
            if(this.firstGuess == false){
                this.blockCurrentThread();
            }
           this.guessNumber();
           this.firstGuess = false;
        }else if(Thread.currentThread() == this.copiedGuessNumberThread){
            if(this.firstGuess == true){
                this.blockCurrentThread();
            }
            this.guessNumber();
            this.firstGuess = true;
        }
        notifyAll();
    }

    @Override
    public void run() {
        while(true){
            this.setMessage();
            if(this.message == SUCCESS){
                return;
            }
        }
    }

}
