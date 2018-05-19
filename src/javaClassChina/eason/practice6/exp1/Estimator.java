package javaClassChina.eason.practice6.exp1;

public class Estimator {
    public static void main(String[] args) {
        double a[] = {9.89,9.88,9.99,9.12,9.69,9.76,8.97};
        double b[] = {89,56,78,90,100,77,56,45,36,79,98};
        ComputerAverage computer = new Gymnastics();;
        double result = computer.average(a);
        System.out.printf("体操选手最后得分:%5.3f\n",result);
        computer = new School();
        System.out.printf("班级考试平均分:%-5.2f",computer.average(b));
    }
}