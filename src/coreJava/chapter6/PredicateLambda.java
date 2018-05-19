package coreJava.chapter6;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**除了在语言层面支持函数式编程风格，Java 8也添加了一个包，叫做 java.util.function。
 * 它包含了很多类，用来支持Java的函数式编程。
 * 其中一个便是Predicate，使用 java.util.function.Predicate 函数式接口以及lambda表达式，
 * 可以向API方法添加逻辑，用更少的代码支持更多的动态行为。
 * 下面是Java 8 Predicate 的例子，展示了过滤集合数据的多种常用方法。Predicate接口非常适用于做过滤。*/
public final class PredicateLambda{

    public static void main(String[] args) {
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell","C", "Lisp");
        List<String> strList = Arrays.asList("Eason"," ","sa","Michael","Germany");
        List<Integer> intList = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

        {
            System.out.println("Languages which starts with J :");
            PredicateLambda.stringFilter(languages, (str)->str.startsWith("J"));
            System.out.println("Languages which ends with a ");
            PredicateLambda.stringFilter(languages, (str)->str.endsWith("a"));
            System.out.println("Print all languages :");
            PredicateLambda.stringFilter(languages, (str)->true);
            System.out.println("Print no language : ");
            PredicateLambda.stringFilter(languages, (str)->false);
            System.out.println("Print language whose length greater than 4:");
            PredicateLambda.stringFilter(languages, (str)->str.length() > 4);
            System.out.println("Languages which starts with J and four length long:");
            PredicateLambda.stringFilterEnhanced(languages,(str)->str.startsWith("J"),(str)->str.length()==4);
        }

        {
            List<String> filtered = strList.stream().filter((x)->x.length() > 2).collect(Collectors.toList());
            System.out.printf("Original List: %s, filtered List: %s",strList,filtered);
            List<String> G7 = strList.stream().map((x) -> x.toUpperCase()).collect(Collectors.toList());
            G7.stream().forEach(System.out::println);
        }

        {
            List<Integer> distinct = intList.stream().map(i -> i*i).distinct().collect(Collectors.toList());
            distinct.stream().forEach(i-> System.out.print(i+" "));
        }

        //获取数字的个数、最小值、最大值、总和以及平均值
        {
            IntSummaryStatistics stats = intList.stream().mapToInt(x->x).summaryStatistics();
            System.out.println("Highest prime number in List : " + stats.getMax());
            System.out.println("Lowest prime number in List : " + stats.getMin());
            System.out.println("Sum of all prime numbers : " + stats.getSum());
            System.out.println("Average of all prime numbers : " + stats.getAverage());
        }

}

    public static void stringFilter(List<String> list, Predicate<String> condition){
//        list.forEach((name)->{if(condition.test(name)){System.out.println(name+" ");}});
        list.stream().filter(condition).forEach(System.out::println);
    }

    // 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，->通过Lambda表达式new and return一个Predicate
    // 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
    public static void stringFilterEnhanced(List<String> list, Predicate<String> firstCondition,Predicate<String> secondCondition){
        list.stream().filter(firstCondition.and(secondCondition)).forEach(System.out::println);
    }

}
