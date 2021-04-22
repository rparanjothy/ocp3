package parallelStreams;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Parallel Streams");
        IntConsumer x = (s) -> System.out.println(s);

        List.of(1, 2, 3, 4, 3).stream().forEach(System.out::println);
        IntStream.range(0, 10).forEach(x);
        IntStream.rangeClosed(0, 10).forEach(x);

        IntStream.range(0, 10).parallel().forEach(x);
        List.of(1, 2, 3, 4, 3).parallelStream().forEach(System.out::println);
        System.out.println(List.of(1, 2, 3, 4, 3).parallelStream().collect(Collectors.groupingBy((e)->e+10)));
//        without Initial value reduce gives an optional.
        System.out.println(List.of(1, 2, 3, 4, 3).parallelStream().reduce(0,(ax,ay)->ax+ay));
//        CAn also use method references
        System.out.println(List.of(1, 2, 3, 4, 3).parallelStream().mapToDouble((ef)->ef).reduce(0,Double::max));
    }
}
