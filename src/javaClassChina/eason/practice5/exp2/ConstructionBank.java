package javaClassChina.eason.practice5.exp2;

/**Description for Construction banks*/
public class ConstructionBank extends Bank {
    public void setYear(double year) {
        this.year = year;
    }

    private double year;        //e.g.  8.236

        //constructor
    public ConstructionBank(double year,double interestRate,int savedMoney){
            super(savedMoney,0);
            this.year = year;
            super.setInterestRate(interestRate);
        }

        @Override
        public double computerInterest(){
        super.year = (int)this.year;
        double r = this.year - (int)this.year;
        int day = (int)(r*1000);
        double yearInterest = super.computerInterest();
        double dayInterest = day * 0.0001 * super.savedMoney;
        super.interest = yearInterest + dayInterest;
        System.out.printf("%d元在建设银行%d年零%d天的利息：%.6f元\n",
                super.savedMoney,super.year,day,super.interest);
        return super.interest;
    }

    @Override
    public String toString(){
       return "this is Construction Bank of China";
    }


}
