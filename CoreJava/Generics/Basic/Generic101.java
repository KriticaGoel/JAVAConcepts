package CoreJava.Generics.Basic;

public class Generic101 {

    public static void main(String[] args) {
        SumGeneric<Integer, Integer> sumInteger = new SumGeneric<>(10, 20);
        sumInteger.sum();
        // System.out.printf("The sum of integer %s,%s is %s ",sumInteger.getFirstObject(),sumInteger.getSecondObject(),sumInteger.getSecondObject()+sumInteger.getFirstObject());
        SumGeneric<Double, Double> sumDouble = new SumGeneric<>(10.20, 20.10);
        sumDouble.sum();
    }
}
