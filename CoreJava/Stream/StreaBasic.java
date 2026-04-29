package CoreJava.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreaBasic {

    public static void main(String[] args) {

        // find the even numbers from a list os integers range 1,10
        List<Integer> numbers = List.of(10, 6, 8, 3, 9, 2, 7, 6, 5, 3);
        List<Integer> evenNumbers = new ArrayList<>();

        numbers.forEach(number -> {
            if (number % 2 == 0)
                evenNumbers.add(number);
        });


        //Implementation of streams
        //1. Create Stream from collections
        Stream<Integer> numberStream = numbers.stream();
        //Create Stream from array
        Integer[] numberArray = {10, 6, 8, 3, 9, 2, 7, 6, 5, 3};
        Stream<Integer> streamArray = Arrays.stream(numberArray);
        //Create Stream from values
        IntStream streamInteger = IntStream.rangeClosed(1, 10);

        //2. Intermediate operations  - Lazy operation - invoke bt terminal operation
        //filter(), map(), sorted(), distinct(), limit(), and skip().
        // numberStream.filter(number -> number%2==0).forEach(System.out::println);
        // numberStream.map(number -> number* number).forEach(System.out::println);
        // numberStream.sorted().forEach(System.out::println);
        // numberStream.distinct().forEach(System.out::println);
        //  numberStream.limit(5).forEach(System.out::println);
        //numberStream.skip(5).forEach(System.out::println);
        //3. Terminal operations
//        /
        // forEach(), count(), collect(), reduce(), min(), max(), anyMatch(), allMatch(), and noneMatch()umberStream.filter(number -> number%2==0).forEach(System.out::println);
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        System.out.println(stream.reduce(0, (number1, number2) -> number1 + number2));
//        int sum = stream.reduce(0, (number1, number2) -> number1 + number2);
//        System.out.println(sum);
        // System.out.println(stream.count());
    }
}
