package CoreJava.Collections.Iterator;

public class LinkedList<E> {
    private LinkedListNode<E> head;

    LinkedList(LinkedListNode<E> head) {
        this.head = head;
    }

    public void printAll() {
        LinkedListNode<E> temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
