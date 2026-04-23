package CoreJava.Generics.GenericClassMethod;

public class Main {
    public static void main(String[] args) {
        // calling Generic method defined in GenericMethod class
        GenericMethod gm = new GenericMethod();
        gm.display(123, "ABC");
        gm.display("Hello", 456);

    }
}
