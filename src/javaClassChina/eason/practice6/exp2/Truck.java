package javaClassChina.eason.practice6.exp2;

public class Truck {
    public void setGoods(ComputerWeight[] goods) {
        this.goods = goods;
    }

    private ComputerWeight[] goods;
    private double totalWeight = 0;

    public Truck(ComputerWeight[] goods){
        this.goods = goods;
    }

    public double getTotalWeights(){
        this.totalWeight = 0;
        for (int i = 0; i < this.goods.length; i++) {
            this.totalWeight += this.goods[i].computerWeight();
        }
        return this.totalWeight;
    }
}
