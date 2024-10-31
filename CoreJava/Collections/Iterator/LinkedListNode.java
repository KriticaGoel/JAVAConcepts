package CoreJava.Collections.Iterator;

public class LinkedListNode<E> {

    int data;
    LinkedListNode<E> next;

    LinkedListNode(int data, LinkedListNode<E> next) {
        this.data = data;
        this.next = next;
    }

}
