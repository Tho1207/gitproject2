package CS201_AS2_;
public class MyList<T> {
    Node<Product>head;
    Node<Product>tail;
    private int length = 0;
    public MyList() { head = tail = null;}
    public MyList(Node<Product> head, Node<Product> tail) {
        head = this.head;
        tail = this.tail;
    }
    public Node<Product> getHead(){return this.head;}
    public Node<Product> getTail() {return this.tail;} 
    public boolean isEmpty() { return(head==null);}
    public int length() {                           //return the length of this list
        return this.length;
    } 
    public void insertToHead(Product items) {  // Insert to Head
        Node<Product> q = new Node<>(items);
        
        if (isEmpty()) {head = tail = q;}
        else {
            Node<Product> p = head;
            head = q;
            head.next = p;
        }
        length++;
    }
    public void insertToTail(Product items) {       //Insert to Tail
        Node<Product> q = new Node<>(items);
        if (isEmpty()) {head = tail = q;}
        else {tail.next = q;
        tail = q;}
        length++;
    }       
    public int search(Product p) {              //Search product in the list
        if (isEmpty()) {return -1;}
        int index = 0;
        Node<Product> temp = head;
        while (temp != null) {
            if (String.valueOf(temp.info.getbCode()).equals(String.valueOf(p.getbCode()))) {
                System.out.println(temp.info.toString());
                return index;
            }
            index ++;
            temp = temp.next;
        }
        return -1;
    }
    public void deleteElement(Product item) {  //Delete product by Barcode
        Node<Product> prev = new Node<Product>(null);
        prev.next = head;
        Node<Product> next = head.next;
        Node<Product> p = head;
        boolean exists = false;
        if (head.info == item) {
            head = head.next;
            exists = true;
        }
        while (p.next != null) { //Searching and deleting an item from this list by comparing the ID of items
            if (p.info.getbCode().equals(item.getbCode())) {
                prev.next = next;
                exists = true;
                break;
            } 
            prev = p;
            p = p.next;
            next = p.next;
        }
        if (exists == false && p.info.getbCode().equals(item.getbCode())) {
            prev.next = null;
            exists = true;
        }
        if (exists) {
            length--;
            System.out.println("Sucessful");
        }
        else {
            System.out.println("List does not have the desired value");
        }
    }
    public void deleteTail() {    // Delete tail
        if (isEmpty() || head.next == null) {System.out.println("List is empty");}
        Node<Product> second_last = head;
        while (second_last.next.next != null) {
            second_last = second_last.next;
        }
        second_last.next = null;
       
    }

    Node<Product> paritionLast(Node<Product> start, Node<Product> end)
    {
    if(start == end || start == null || end == null)
        {return start;}
    Node<Product> pivot_prev = start;
    Node<Product> curr = start; 
    Product pivot = end.info; 
    while( start != end )
    {
        if(start.info.getbCode().compareToIgnoreCase(pivot.getbCode()) < 0 )
        { 
            pivot_prev = curr; 
            Product temp = curr.info; 
            curr.info = start.info; 
            start.info = temp; 
            curr = curr.next; 
        }
       start = start.next; 
    }
    Product temp = curr.info; 
    curr.info = pivot; 
    end.info = temp; 
    return pivot_prev;
    }
    void sort(Node<Product> start, Node<Product> end)  //Using Quick Sort
    {
        if(start == null || start == end|| start == end.next )
        return;
    Node<Product> pivot_prev = paritionLast(start, end);
    sort(start, pivot_prev);
    if( pivot_prev != null && 
        pivot_prev == start )
        sort(pivot_prev.next, end);
           
    else if(pivot_prev != null && 
            pivot_prev.next != null)
        sort(pivot_prev.next.next, end);
    }
   
    @Override
    public String toString() {
        String S = "";
        Node<Product> p = head;
        if (isEmpty()) {return S+ " ";}
        while (p.next != null) {
            S += String.valueOf(p.info) + "\n";
            p = p.next;
        }
        S += String.valueOf(p.info);
        return S + " ";
    }
}
