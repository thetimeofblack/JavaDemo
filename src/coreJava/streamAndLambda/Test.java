package coreJava.streamAndLambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class Test {

    public static void main(String[] args) {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2,3),
                Arrays.asList(4,5,6)
        );
        Stream<Integer> outputStream = inputStream.flatMap((childList)->childList.stream());
        outputStream.forEach(System.out::println);

    }
}
