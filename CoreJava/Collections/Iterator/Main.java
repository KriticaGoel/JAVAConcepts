package CoreJava.Collections.Iterator;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        LinkedListNode n3 = new LinkedListNode(3, null);
        LinkedListNode n2 = new LinkedListNode(2, n3);
        LinkedListNode n1 = new LinkedListNode(1, n2);

        LinkedList linkedList = new LinkedList(n1);

        linkedList.printAll();

        Collectors.toList();
    }
}
