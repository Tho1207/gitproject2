package CS201_AS2_;

public class Node<T> {
    T info;
    Node<T> next;
    public Node(){}
    public Node(T x, Node<T> p) {
        info = x;
        next = p;
    }
    public Node(T x) {
        info = x;
        next = null;
    }
    @Override 
    public String toString() {
        return String.valueOf(info);
    }
}

