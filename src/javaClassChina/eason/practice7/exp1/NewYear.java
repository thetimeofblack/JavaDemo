package javaClassChina.eason.practice7.exp1;

public class NewYear {

    public static void main(String[] args) {
        MobileShop mobileShop = new MobileShop();
        mobileShop.setMobileAccount(30);
        System.out.println(mobileShop);
        mobileShop.getPurchaseMoney1().buyMobile();
        mobileShop.getPurchaseMoney2().buyMobile();
        System.out.println(mobileShop);
    }

}
