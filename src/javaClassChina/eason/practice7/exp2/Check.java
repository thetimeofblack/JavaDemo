package javaClassChina.eason.practice7.exp2;

public class Check {
    public static void main(String[] args) {
        String[] name = {"Apple","Bomb","Suit","H2SO4","Watch","S"};
        Goods[] goods = new Goods[name.length];
        for (int i = 0; i < goods.length; i++) {
            goods[i] = new Goods();
            goods[i].setName(name[i]);
            if(i%2 == 0){
                goods[i].setDanger(Boolean.TRUE);
            }else{
                goods[i].setDanger(Boolean.FALSE);
            }
        }
        Check.checkGoods(goods);
    }

    public static void checkGoods(Goods[] goods){
        ExamineMachine machine = new ExamineMachine();
        for (int i = 0; i < goods.length; i++) {
            try {
                machine.checkBag(goods[i]);
                System.out.print(goods[i].getName()+" successfully passed");
            } catch (DangerException e) {
                e.toShow();
                System.out.print(goods[i].getName()+" be banned!");
            }
        }

    }
}