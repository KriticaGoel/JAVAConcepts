package CoreJava.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsPractice {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.forEach(System.out::println);
        numbers.stream().findFirst().ifPresent(System.out::println);
        List<String> stringList = Arrays.asList("Apple", "Mango");
        System.out.println(stringList.stream().collect(Collectors.joining()));
        System.out.println(stringList.stream().count());

        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");

        // What does the following code snippet do?
        Map<Integer, List<String>> groupedByLength = fruits.stream().collect(Collectors.groupingBy(String::length));

        System.out.println("Result: " + groupedByLength);

        //calculate the average of a list of integers
        List<Integer> avg = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(avg.stream().mapToInt(Integer::intValue).sum());
        System.out.println(avg.stream().mapToInt(Integer::intValue).average());
        // convert a list of strings to uppercase or lowercase
        List<String> listString = List.of("Apllel", "mAngo");
        System.out.println(listString.stream().map(String::toUpperCase).collect(Collectors.toList()));
        System.out.println(listString.stream().map(String::toLowerCase).collect(Collectors.toList()));
        //calculate the sum of all even numbers
        List<Integer> listeven = List.of(1, 2, 3, 5, 4, 6, 7, 8, 9);
        System.out.println(listeven.stream().filter(x -> x % 2 == 0).mapToInt(Integer::intValue).sum());
        //calculate the sum of all odd numbers
        System.out.println(listeven.stream().filter(x -> x % 2 != 0).mapToInt(Integer::intValue).sum());
        listeven.stream().sorted().forEach(System.out::println);
        //Remove all duplicate elements from a list
        List<Integer> listduplicate = List.of(1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 2, 3, 4, 5, 6);
        listduplicate.stream().collect(Collectors.toSet()).forEach(System.out::println);
        //count the number of strings in a list that start with a specific letter
        List<String> abc = Arrays.asList("Kritica", "Kavita", "Sachin");
        System.out.println(abc.stream().filter(x -> x.startsWith("K")).count());
        //Fileter with character and find length
        abc.stream().filter(x -> x.startsWith("K")).map(String::length).collect(Collectors.toList()).forEach(System.out::println);
        //sort a list of strings in alphabetical order, ascending
        //sort a list of strings in alphabetical order, Descending Order
        ////sort a list of strings in alphabetical order, ascending
        //find the maximum and minimum values in a list of integers

        //find the second smallest and largest elements in a list of integers


        //https://www.w3resource.com/java-exercises/stream/java-stream-exercise-8.php
    }

}
