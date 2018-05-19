package javaClassChina.eason.practice5.exp2;

public class SaveMoney {
    public static void main(String[] args) {
        int amount = 8000;
        Bank bank1 = new ConstructionBank(8.236,0.035d,amount);
        bank1.computerInterest();
        Bank bank2 = new BusinessBank(amount,8.236,0.045d);
        bank2.computerInterest();

    }
}
