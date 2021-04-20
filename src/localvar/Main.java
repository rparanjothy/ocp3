package localvar;

import java.util.List;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class Main {
    //    Cant use var as a class prop/Class field
//    var j=10;
//    Can use in static initializer
    static {
        var k = 1;
    }

    //    can use in instance initializer
    {
        var m = "Hello";
    }

    static String getF() {
        return "sds";
    }

    public static void main(String[] args) {
        var i = 10;
        var jj = Main.getF();
        UnaryOperator f = (var x) -> "Hi";
        IntFunction f3 = String::valueOf;
        UnaryOperator f1 = x -> {
            return 1;
        };
        List.of("ad", "ad").stream().map(f).forEach(System.out::println);
        List.of("ad", "ad").stream().map(f1).forEach(System.out::println);
        List.of(1,2,3,3).stream().map((x)->x+"!!!").forEach(System.out::println);

        IntStream.range(0,4).forEach(System.out::println);
        IntStream.rangeClosed(0,4).forEach(System.out::println);

    }
}
