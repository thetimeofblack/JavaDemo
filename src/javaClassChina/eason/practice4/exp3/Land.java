package javaClassChina.eason.practice4.exp3;

public class Land {
    public static void main(String[] args) {
        Village.setWaterAmount(200);
        int leftWater = Village.getWaterAmount();
        System.out.println("水井里有" + leftWater + "升水");
        Village zhaoZhuang = new Village("赵庄");
        Village maJiaHeZi = new Village("马家河子");
        zhaoZhuang.setPeopleNumber(80);
        maJiaHeZi.setPeopleNumber(120);
        zhaoZhuang.drinkWater(50);
        leftWater = maJiaHeZi.lookWaterAmount();
        System.out.println(maJiaHeZi.getName() + "发现水井中有" + leftWater + "升水");
        System.out.println("赵庄的人口" + zhaoZhuang.getPeopleNumber());
        System.out.println("马家河子的人口" + maJiaHeZi.getPeopleNumber());
    }
}
