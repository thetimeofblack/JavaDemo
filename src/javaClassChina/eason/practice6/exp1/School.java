package javaClassChina.eason.practice6.exp1;

public class School implements ComputerAverage {

    @Override
    public double average(double[] x) {
        double total = 0;
        for (int i = 0; i < x.length; i++) {
            total += x[i];
        }
        return (total/x.length);
    }
}
