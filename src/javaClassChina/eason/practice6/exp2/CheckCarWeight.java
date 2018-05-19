package javaClassChina.eason.practice6.exp2;

public class CheckCarWeight {
    public static void main(String[] args) {
        ComputerWeight[] goods = new ComputerWeight[650];
        for (int i = 0; i < goods.length; i++) {
            if(i%3 == 0){
                goods[i] = new Television();
            }else if(i%3 == 1){
                goods[i] = new Computer();
            }else{
                goods[i] = new WashMachine();
            }
        }
        Truck truck = new Truck(goods);
        System.out.printf("\n货车装载的货物重量:%-8.5f kg\n",truck.getTotalWeights());
        goods = new ComputerWeight[68];
        for (int i = 0; i < goods.length; i++) {
            if(i%2 == 0){
                goods[i] = new Television();
            }else{
                goods[i] = new WashMachine();
            }
        }
        truck.setGoods(goods);
        System.out.printf("货车装载的货物重量:%-8.5f kg\n",truck.getTotalWeights());
    }
}