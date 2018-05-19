package coreJava.inheritance;

import java.util.ArrayList;
import java.util.Objects;

/**remember Integer.intValue() and Integer.ValueOf()*/
public class AutoBoxing {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.ensureCapacity(10);
        list.add(10);
        Integer a = 1000;
        Integer b = Integer.valueOf(1000);
        System.out.println("a == b? "+ (a == b));
        System.out.println("a equals b? "+Objects.equals(a,b));
        System.out.printf("%d %s %.1f",new Object[]{new Integer(1),"widgets",new Double(2.0d)});
    }

    public static double getMax(double[] values){
        double largest = Double.NEGATIVE_INFINITY;
        for(double v : values){
            if(v > largest){
                largest = v;
            }
        }
        return largest;
    }
}