package CoreJava.Generics.Basic;

public class WithoutGeneric {

    public static void main(String[] args) {

        sum(10, 20);
        sumDouble(10.20, 20.10);

    }

    static void sum(int a, int b) {
        System.out.println("The sum of two integers is: " + (a + b));

    }

    static void sumDouble(Double a, Double b) {
        System.out.println("The sum of two double is: " + (a + b));
    }
}
