package functionalInterfaces;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Main {

    static List<Integer> data = List.of(1, 2, 3, 4, 5);

    static void processData(List<Integer> i, Consumer<Integer> c) {
        i.stream().forEach(c);
    }

    static void processDataViaSupplier(Supplier<Integer> i, Consumer<Integer> c) {
        List.of(i.get()).forEach(c);
    }

    static Consumer<Integer> getConsumer() {
        return (v) -> {
            v++;
            System.out.println(v);
        };

    }

    static Supplier<Integer> getSupplier() {
//        Supplier is generator

        return () -> 100;

    }

    public static void main(String[] args) {
        System.out.println("Using built in Functional Interfaces");
        Main.processData(Main.data, Main.getConsumer());
        Main m = new Main();
        Main.processDataViaSupplier(Main.getSupplier(),Main.getConsumer());


    }


}
