package CS201_AS2_;

public class MyStack<T> {
    Node<T> head;
    public MyStack() {head = null;}
    public boolean isEmpty() {return(head==null);}
    public void push(T item) {
        head = new Node<T>(item,head);
    }
    public void show() {
        if (isEmpty()) {System.out.println("Stack is empty");}
        else {
            Node<T> p = head;
            while(p != null) {
                System.out.println(p.info.toString());
                p = p.next;
            }
        }
    }
}
