package CoreJava.Generics.GenericClassMethod;

public class GenericMethod {

    public <K, V, T> T display(K key, V value) {
        System.out.println("Key: " + key + ", Value: " + value);
        return null; // Just for demonstration, you can return any type as needed
    }
}
