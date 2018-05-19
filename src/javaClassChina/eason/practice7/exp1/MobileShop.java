package javaClassChina.eason.practice7.exp1;

public final class MobileShop {

    public InnerPurchaseMoney getPurchaseMoney1() {
        return purchaseMoney1;
    }

    public InnerPurchaseMoney getPurchaseMoney2() {
        return purchaseMoney2;
    }

    private InnerPurchaseMoney purchaseMoney1;
    private InnerPurchaseMoney purchaseMoney2;
    private int mobileAccount;

    public MobileShop(){
        this.purchaseMoney1 = new InnerPurchaseMoney(20000);
        this.purchaseMoney2 = new InnerPurchaseMoney(10000);
    }

    public void setMobileAccount(int mobileAccount){
        this.mobileAccount = mobileAccount;
    }

    /**使用商店的固定额度的内部购物券买手机, cannot be used in other shops*/
    class InnerPurchaseMoney{
        private int moneyValue;
        public InnerPurchaseMoney(int moneyValue){
            this.moneyValue = moneyValue;
        }
        public void buyMobile(){
            if(this.moneyValue >= 20000){
                mobileAccount = mobileAccount - 6;
                System.out.println("用价值"+this.moneyValue+"的内部购物券买了6部手机");
            }else if(this.moneyValue < 20000 && this.moneyValue >= 10000){
                mobileAccount = mobileAccount - 3;
                System.out.println("用价值"+this.moneyValue+"的内部购物券买了3部手机");
            }
        }
    }

    @Override
    public String toString() {
        return new StringBuilder().append("现在商店有").append(this.mobileAccount)
                                  .append("部手机").toString();
    }
}