package CoreJava.Generics.Basic;

public class SumGeneric<F, S> {
    F firstObject;
    S secondObject;

    public SumGeneric(F firstObject, S secondObject) {
        this.firstObject = firstObject;
        this.secondObject = secondObject;
    }

    public F getFirstObject() {
        return firstObject;
    }

    public S getSecondObject() {
        return secondObject;
    }

    public void sum() {
        if (firstObject instanceof Integer && secondObject instanceof Integer) {
            System.out.println("The sum of two integers is: " + ((Integer) firstObject + (Integer) secondObject));
        } else if (firstObject instanceof Double && secondObject instanceof Double) {
            System.out.println("The sum of two double is: " + ((Double) firstObject + (Double) secondObject));
        } else {
            System.out.println("Unsupported types for summation.");
        }
    }
}