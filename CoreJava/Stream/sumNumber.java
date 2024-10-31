package CoreJava.Stream;

import java.util.stream.Stream;

public class sumNumber {
    public static void main(String[] args) {
        Stream<Integer> intList = Stream.of(1, 2, 3, 4, 5);
        int sum = intList.reduce(0, (number1, number2) -> number1 + number2 / 2);
        System.out.println(sum);
    }


}
