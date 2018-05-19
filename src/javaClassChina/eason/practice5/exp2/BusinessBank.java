package javaClassChina.eason.practice5.exp2;

public final class BusinessBank extends Bank {

    private double year;

    public BusinessBank(int savedMoney, double year,double interestRate) {
        super(savedMoney, 0);
        this.year = year;
        super.setInterestRate(interestRate);
    }

    @Override
    protected double computerInterest() {
        super.year = (int)this.year;
        double r = this.year - (int)this.year;
        int day = (int)(r*1000);
        double yearInterest = super.computerInterest();
        double dayInterest = day * 0.0001 * super.savedMoney;
        super.interest = yearInterest + dayInterest;
        System.out.printf("%d元在商业银行%d年零%d天的利息：%.6f元\n",
                super.savedMoney,super.year,day,super.interest);
        return super.interest;
    }
}
