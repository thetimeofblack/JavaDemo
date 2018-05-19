package javaClassChina.eason.practice5.exp2;

/**Description for General Banks*/
public class Bank {

    /**getters and setters*/
    public void setSavedMoney(int savedMoney) {
        this.savedMoney = savedMoney;
    }
    public void setInterestRate(double rate){
        this.interestRate = rate;
    }


    public int getSavedMoney() {
        return savedMoney;
    }

    protected int savedMoney = 0;
    protected int year = 0;         //存储时长的整年,仅可整年存储
    protected double interest = 0;
    protected double interestRate = 0.29;  //普通银行存款利息

    public Bank(int savedMoney,int year){
        this.savedMoney = savedMoney;
        this.year = year;
    }

    protected double computerInterest(){
        this.interest = this.interestRate * year * savedMoney;
        return interest;
    }
}