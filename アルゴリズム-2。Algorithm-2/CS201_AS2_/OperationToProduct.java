package CS201_AS2_;

import java.io.*;
import java.util.*;

public class OperationToProduct {
    static Scanner scanner = new Scanner(System.in);
    public int index(Product p, MyList<Product> list) {  //Searching and returning the index of product p in the list. If not found return -1.
        return list.search(p);
    }
    public Product createProduct() { //Creating and returning a product with info input from keyboard.
        System.out.println("Input new ID: ");
        String  a= scanner.next();
        System.out.println("Input Product's Name: ");
        String b = scanner.next();
        System.out.println("Input Product's quantity: ");
        int c = scanner.nextInt();
        System.out.println("Input Product's price: ");
        double d = scanner.nextDouble();
        return new Product(a,b,c,d);
     }

    public void getAllItemsFromFile(String fileName, MyList<Product> list) {  // Reading all products from the file and insert them to the list at tail.
        BufferedReader br = null;
        try {
            File file = new File(fileName); 
            FileReader fr = new FileReader(file); 
            br = new BufferedReader(fr); 
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replace("|", "");               //Remove "|" 
                String [] arrOFfStr = line.split("  ");         //split string by space
                String a = arrOFfStr[0];
                String b = arrOFfStr[1];
                int c = Integer.valueOf(arrOFfStr[2]);
                double d = Double.valueOf(arrOFfStr[3]);
                Product p = new Product(a,b,c,d);               //add each string to new Product
                list.insertToTail(p);
            }
        }catch(IOException e) { e.printStackTrace();}
        finally{
              try { if (br != null) br.close(); }
              catch(IOException e) { e.printStackTrace(); }
        }
    }
    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) { //Reading all products from the file and insert them to the stack.
        BufferedReader br = null;
        try {
            File file = new File(fileName); 
            FileReader fr = new FileReader(file); 
            br = new BufferedReader(fr); 
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replace("|", "");
                String [] arrOFfStr = line.split("  ");
                String a = arrOFfStr[0];
                String b = arrOFfStr[1];
                int c = Integer.valueOf(arrOFfStr[2]);
                double d = Double.valueOf(arrOFfStr[3]);
                Product p = new Product(a,b,c,d);
                stack.push(p);
            }
            System.out.println("ID | Title | Quantity | Price ");
            stack.show();
          }
           catch(IOException e) { e.printStackTrace();}
           finally
           {
              try { if (br != null) br.close(); }
              catch(IOException e) { e.printStackTrace(); }
           }
    }
    public void getAllItemsFromFile(String fileName, MyQueue<Product>queue) {
        BufferedReader br = null;
        try {
            File file = new File(fileName); 
            FileReader fr = new FileReader(file); 
            br = new BufferedReader(fr); 
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replace("|", "");
                String [] arrOFfStr = line.split("  ");
                String a = arrOFfStr[0];
                String b = arrOFfStr[1];
                int c = Integer.valueOf(arrOFfStr[2]);
                double d = Double.valueOf(arrOFfStr[3]);
                Product p = new Product(a,b,c,d);
                queue.enqueue(p);
            }
            System.out.println("ID | Title | Quantity | Price ");
            queue.display();
           }
           catch(IOException e) { e.printStackTrace();}
           finally
           {
              try { if (br != null) br.close(); }
              catch(IOException e) { e.printStackTrace(); }
           }
    }
    public void addLast(MyList<Product> list) {//Adding a product to the list, info of the product input from keyboard.
        System.out.println("How many products do u want to add?");
        int choice = scanner.nextInt();
        for (int i=1; i<=choice; i++) {
            System.out.println("New product No" + i + ": ");
            Product a = createProduct();
            list.insertToTail(a);
        }
    }
    public void displayAll(MyList<Product> list) {
        System.out.println("ID | Title | Quantity | Price ");
        System.out.println(list);
    }
    public void writeAllItemsToFile(String fileName, MyList<Product> list) {//Writing all products from the list to the file
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(list.toString());
            myWriter.close();

          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    public void searchByCode(MyList<Product> list) {
        System.out.println("Please input the ID that u need to search: ");
        String ID = scanner.next();
        int index = index(new Product(ID),list);
        if (index == -1) {System.out.println("-1 -> No value in list");} 
    }
    public void deleteByCode(MyList<Product> list) {  //Deleting first product that has the ID input from keyboard from the list.
        System.out.println("Please input the ID that u need to delete: ");
        String ID = scanner.next();
        list.deleteElement(new Product(ID));
    }
    public void quickSortByCode(MyList<Product> list) { //Using Quick Sort
        Node<Product> n = list.getHead();
        while(n.next != null) {
            n = n.next;
        }
        list.sort(list.getHead(), n);
        System.out.println("Sorted list by Quick Sort: ");
        System.out.println(list);

    }
    public void addFirst(MyList<Product> list) {//Adding new product to head of Linked List. The info input from keyboard.
        System.out.println("How many products do u want to add?");
        int choice = scanner.nextInt();
        for (int i=1; i<=choice; i++) {
            System.out.println("New product No" + i + ": ");
            Product a = createProduct();
            list.insertToHead(a);
        }
    }
    public void convertToBinary(int x) {  //Convert to Binary
        int binary[] = new int[40];
        int index = 0;
        while(x>0) {
            binary[index++] = x % 2;
            x = x/2;
        }
        System.out.print("Binary value: ");
        for (int i=index-1; i>=0; i--) {
            System.out.print(binary[i]);
        }
    }
    
}
