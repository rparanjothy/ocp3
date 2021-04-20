package optional;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalExamples {

    public static void main(String[] args) {
        Optional e = Optional.empty();

        Optional strOptional = Optional.of("ABC");
//        This throws NPE
//        Optional snOptional = Optional.of(null);

        var onull = Optional.ofNullable(null); //this gives Optional.empty

        System.out.println(strOptional.get());
        System.out.println(e.orElse("Ram"));
        System.out.println(e);
        System.out.println(onull);
        System.out.println(onull.orElse("nullHere"));
        System.out.println(onull.orElse(null));
//        Use this only when the initial Else is time consuming
        System.out.println(onull.orElseGet(new Supplier<String>() {

            @Override
            public String get() {
                return "hi";
            }
        }));


        System.out.println(onull.isEmpty());
        System.out.println(onull.isPresent());
//        System.out.println(onull.orElseThrow());

        Optional<String> strOptional1 = Optional.of("ABC");
        Optional dd = strOptional1.flatMap(v -> Optional.of(v.toLowerCase()));
        System.out.println(dd);

//      Min max from streams
        //        Streams return Optional
        List<String> cities = new ArrayList<>(List.of("chennai", "chenn", "pflugerville", "austin"));
        cities.forEach(System.out::println);
//        Stream of lists
        Stream<List<String>> ss = Stream.of(cities, cities);
        cities.stream().forEach(System.out::println);
        cities.stream().forEach(System.out::println);
        var mxCity = cities.stream().max(Comparator.comparing(city -> city.length()));
        var mnCity = cities.stream().min(Comparator.comparing(city -> city.length()));
        System.out.println(mxCity + "," + mnCity);

        //count returns long
        System.out.println(cities.stream().count());

        cities.stream().mapToDouble(String::length).forEach(System.out::println);
        var dd1 = cities.stream().mapToInt(String::length);
        System.out.println(dd1.summaryStatistics());

        Comparator<String> lenCompare = (a, b) -> a.compareTo(b);
        Comparator<String> valueCompare = Comparator.comparing(p -> p.length());

        cities.stream().sorted(lenCompare.thenComparing(valueCompare)).forEach(System.out::println);
        var rr = cities.stream().sorted(lenCompare.thenComparing(valueCompare)).collect(Collectors.joining("!"));
        System.out.println(rr);
//        Collect is to pesist/Materialize the stream.
        var rr1 = cities.stream().sorted(lenCompare.thenComparing(valueCompare)).collect(Collectors.toList());

        System.out.println(rr1);

//        immutable list from the List.of fac methd

        List<String> iml = List.of("a", "b", "c");
        System.out.println(iml);

//        This gives RTE bc of immutablility
//        Collections.sort(iml);

//        if the object you are using does not implement the comparable intf, then you have to supply a comparator.
//        below we are using String and it impl. comparable.
        var sss = cities.stream().sorted(Comparator.comparing(String::length));
        sss.forEach(System.out::println);

         class UX {
            int id;
            String n;

            public UX() {
                this.id = 0;
                this.n = "0";
            }

            public UX(int id, String n) {
                this.id = id;
                this.n = n;
            }

            public String getN() {
                return n;
            }


        }

        var eee = List.of(new UX(1, "111"), new UX(2, "rere"), new UX(3, "qeqweqw"));
//        below RTE
//        eee.stream().sorted().forEach(System.out::println);
//        below will Compile and Run bc it has a comparator as the Class of ours does not implement it
        eee.stream().sorted(Comparator.comparing(e3 -> e3.getN().length())).map(UX::getN).forEach(System.out::println);

        class UX1 extends UX implements Comparable{
            @Override
            public int compareTo(Object o) {
                return -11;
            }
            //No default constructor bc you didnt have one with no args in the UX, also you added one with signature
            public UX1(int i,String j){
                this.id=i;
                this.n=j;
            }
        }

        var eee2 = List.of(new UX1(1, "111"), new UX1(2, "rere"), new UX1(3, "qeqweqw"));
        eee2.stream().sorted().forEach(e2-> System.out.println(e2.getN()));
    }


}



