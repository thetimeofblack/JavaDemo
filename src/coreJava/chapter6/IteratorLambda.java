package coreJava.chapter6;

import java.util.Arrays;
import java.util.List;

/**
 * 如果你使过几年Java，你就知道针对集合类，最常见的操作就是进行迭代，并将业务逻辑应用于各个元素，例如处理订单、交易和事件的列表。
 * 由于Java是命令式语言，Java 8之前的所有循环代码都是顺序的，即可以对其元素进行并行化处理。
 * 如果你想做并行过滤，就需要自己写代码，这并不是那么容易。
 * 通过引入lambda表达式和默认方法，将做什么和怎么做的问题分开了，这意味着Java集合现在知道怎样做迭代，并可以在API层面对集合元素进行并行处理。
 * 下面的例子里，我将介绍如何在使用lambda或不使用lambda表达式的情况下迭代列表。
 * 你可以看到列表现在有了一个 forEach()方法，它可以迭代所有对象，并将你的lambda代码应用在其中。
 * */
public final class IteratorLambda {

    public static void main(String[] args) {
        //before Java 8
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for(String feature:features){
            System.out.println(feature);
        }

    //Java 8
//        features.stream().forEach(System.out::println);
        features.stream().forEach((t) -> System.out.println(t));
    //or much simpler
        features.stream().forEach(System.out::println);

    }

}
