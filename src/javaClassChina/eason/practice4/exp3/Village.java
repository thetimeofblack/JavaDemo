package javaClassChina.eason.practice4.exp3;

public class Village {
    private static int waterAmount;
    private int peopleNumber;
    private String name;

    public Village(String name){
        this.name = name;
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getWaterAmount() {
        return waterAmount;
    }

    public static void setWaterAmount(int waterAmount) {
        if (waterAmount > 0) {
            Village.waterAmount = waterAmount;
        }
    }

    public void drinkWater(int drinkAmount){
        if ((Village.waterAmount - drinkAmount) > 0) {
            Village.waterAmount -= drinkAmount;
            System.out.println(name + "喝了" + drinkAmount + "升水");
        } else {
            Village.waterAmount = 0;
        }
    }

    public static int lookWaterAmount(){
        return Village.waterAmount;
    }

}
