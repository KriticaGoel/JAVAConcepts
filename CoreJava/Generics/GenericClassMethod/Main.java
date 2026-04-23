package CoreJava.Generics.GenericClassMethod;

public class Main {
    public static void main(String[] args) {
        // calling Generic method defined in GenericMethod class
        GenericMethod gm = new GenericMethod();
        gm.display(123, "ABC");
        gm.display("Hello", 456);

        dosomething("Kritica");
        dosomething(100);



    }

    //Static method in generics
    public static <T> T dosomething(T input) {
        System.out.printf("The value of input is: %s %n", input);
        return input;
    }
}
