package javaClassChina.eason.practice6.exp1;

import java.util.Arrays;

public class Gymnastics implements ComputerAverage {

    @Override
    public double average(double[] x) {
        double average = 0, total = 0;
        int count = x.length;
        Arrays.sort(x);
        if(count >= 3){
            for (int i = 1; i < count -1 ; i++) {
                total += x[i];
            }
        }else{
            total = 0;
        }
        average = (count != 2 ? total/(count-2):0);
        return average;
    }
}
