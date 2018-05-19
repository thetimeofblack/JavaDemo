package coreJava.chapter6;

import java.util.Arrays;
import java.util.List;

/**
 * 本例介绍最广为人知的函数式编程概念map。它允许你将对象进行转换。
 * 例如在本例中，我们将 costBeforeTax 列表的每个元素转换成为税后的值。
 * 我们将 x -> x*x lambda表达式传到 map() 方法，后者将其应用到流中的每一个元素。
 * 然后用 forEach() 将列表元素打印出来。使用流API的收集器类，可以得到所有含税的开销。
 * 有 toList() 这样的方法将 map 或任何其他操作的结果合并起来。由于收集器在流上做终端操作，因此之后便不能重用流了。
 * */
public final class MapLambda {

    public static void main(String[] args) {
        List<Double> costBeforeTax = Arrays.asList(100d,200d,300d,400d,500d);
        double total = 0;

        //do the same in Java 8 using Lambda
        costBeforeTax.stream().map((t) -> (t + t * 0.12)).forEach(System.out::println);
        double bill = costBeforeTax.stream().map((t) -> (t + t * 0.12)).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total cost:" + bill);

        //add 12% Tax and calculate total, before Java 8
        for (Double cost:costBeforeTax){
            double price = cost + 0.12 * cost;
            total += price;
            System.out.println(price);
        }
        System.out.println("Total cost:" + total);
    }

}
