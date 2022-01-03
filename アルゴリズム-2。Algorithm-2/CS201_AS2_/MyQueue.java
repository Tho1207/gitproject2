package CS201_AS2_;

public class MyQueue<T> {
    Node<T> head;
    Node<T> tail;
    public boolean isEmpty() {return(head==null);}
    public void enqueue(T item) {                            //Add new node to queue
        if (isEmpty()) {head = tail = new Node<T>(item);}
        else {
            tail.next = new Node<T>(item);
            tail = tail.next;
        }
    }
    public void display() {                                     //display queue
        if (isEmpty()) {System.out.println("Queue is empty");}
        else {
            Node<T> p = head;
            while (p != null) {
                System.out.println(p.info.toString());
                p = p.next;
            }

        }
    }
}
