package CoreJava.Generics.GenericClassMethod;

public class GenericMethod {

    public <K, V> void display(K key, V value) {
        System.out.println("Key: " + key + ", Value: " + value);
    }
}
