package coreJava.chapter6;

import java.util.Arrays;
import java.util.Comparator;

public class LengthComparator implements Comparator<String>{

    public static void main(String[] args) {
        Comparator<String> comparator = new LengthComparator();

        //(x,y)-> Math.max(x,y); == Math::max;方法引用
        Comparator<Integer> comparatorInt = Math::max;

        System.out.println("LengthComparator implements Comparable? "+(comparator instanceof Comparator));
        //can be used directly
        System.out.println(comparator.compare("Mary","EasonHua"));
        String[] friends = {"Jacob","Hanesova","Peter"};
        //option 1
//        Arrays.sort(friends,comparator);
        //option 2 using lambda expression
        Arrays.sort(friends,(str1,str2) -> {return str1.length()-str2.length();});
        for(String name : friends){
        System.out.print(name + " ");

    }
}

    @Override
    public int compare(String o1, String o2) {
        return o1.length()-o2.length();
    }

//    /**compare two strings based on length*/
//    @Override
//    public int compare(String str1, String str2) {
//        return (str1.length() - str2.length());
//    }
}
