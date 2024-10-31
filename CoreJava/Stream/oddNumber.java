package CoreJava.Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class oddNumber {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        List<Integer> intList = stream.filter(n -> n % 2 != 0).collect(Collectors.toList());
        intList.forEach(System.out::println);

    }
}
