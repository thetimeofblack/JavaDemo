package javaClassChina.eason.practice4.exp1;

public class Vehicle {
    private double speed;
    private int    power;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void speedUp(int s) {
        this.speed += s;
        if (this.speed >= 200) {
            System.out.println("提速失败，速度不可超过200");
            speed -= s;
        }
    }

    public void speedDown(int s) {
        this.speed -= s;
        if (this.speed <= 0) {
            System.out.println("减速失败，速度不可低于0");
            speed += s;
        }
    }

    public void brake() {
        this.speed = 0;
    }

}
