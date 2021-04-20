package collections;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class User {
    String name;
    String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public User(String name, String city) {
        this.name = name;
        this.city = city;
    }
}

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>(List.of(new User("ram", "NY"), new User("bujji", "NY"), new User("mar", "TX"), new User("rish", "Chennai"), new User("ra2m", null), new User("ram", null)));
//        Map<String, List<User>> collect = userList.stream().collect(Collectors.groupingBy(User::getCity));
        Map<Optional<String>, List<User>> collect = userList.stream().collect(Collectors.groupingBy(e -> Optional.ofNullable(e.getCity())));
//        HashMap<String, List<User>> collect2 = userList.stream().collect(Collectors.groupingBy(User::getCity,HashMap::new,Collectors.toList()));
//        Map<String, List<User>> collect3 = userList.stream().collect(Collectors.groupingBy(User::getCity,Collectors.toList()));
        collect.forEach((s, users) -> System.out.println(s + ":" + users));
//        collect2.forEach((s, users) -> System.out.println(s+":"+users));
//        collect3.forEach((s, users) -> System.out.println(s+":"+users));

//        These return the element in the list that matches the condition.. NOT a boolean
        Optional<User> ff = userList.stream().findFirst();
        Optional<User> fa = userList.stream().filter(e -> e.getName().equals("da")).findAny();


//        anyMatch and allMatch returns boolean - Predicate goes in the method.. not in the filter.
        Boolean anyMatched = userList.stream().anyMatch(e -> e.getName().equals("da"));
        Boolean anyMatched1 = userList.stream().anyMatch(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return true;
            }
        });

        Boolean allMatched = userList.stream().allMatch(e->e.getName().length()>1);

        Boolean anyMatched2 = userList.stream().anyMatch(e -> true);

        //    Opposite of anyMatch, allMatch is noneMatch
        Boolean noneMatched = userList.stream().noneMatch(e->e.getName().length()>100);

        System.out.println(ff.orElse(new User("empty", "empty")));
        System.out.println(fa.orElse(new User("empty", "empty")));
        System.out.println("anyMatched : "+anyMatched);
        System.out.println("anyMatched1 : "+anyMatched1);
        System.out.println("allMatched: "+allMatched);
        System.out.println("noneMatched: "+noneMatched);
    }
}
