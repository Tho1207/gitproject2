package CS201_AS2_;
import java.util.*;
public class AS2_Main {
    static void menu() {
        System.out.println("Choose one of this options:");
        System.out.println("Product list:");
        System.out.println("1.Load data from file and display");
        System.out.println("2.Input & add to the end.");
        System.out.println("3.Display data");
        System.out.println("4.Save product list to file.");
        System.out.println("5.Search by ID");
        System.out.println("6.Delete by ID");
        System.out.println("7.Sort by ID.");
        System.out.println("8.Convert to Binary");
        System.out.println("9.Load to stack and display");
        System.out.println("10.Load to queue and display");
    }
    public static void main(String[] args) {
        MyList<Product> myList = new MyList<>();
        MyStack<Product> myStack = new MyStack<>();
        MyQueue<Product> myQueue = new MyQueue<>();
        Scanner scanner = new Scanner(System.in);
        OperationToProduct q = new OperationToProduct();
        String ans = "yes";
        int choice;
        while (ans.equals("yes") || ans.equals("y")) {    //lopp for menu
            menu();
            System.out.println("Your choice: ");
            choice = scanner.nextInt();
            switch(choice) {
                case 1:                                                      //Load data from file and display
                    q.getAllItemsFromFile("Data.txt", myList);
                    System.out.println("ID | Title | Quantity | Price ");
                    System.out.println(myList);
                    break;
                case 2:                         //Input & add to the end.
                    q.addLast(myList);
                    break;
                case 3:                     //Display data
                    q.displayAll(myList);       
                    break;
                case 4:             //Save product list to file.
                    q.writeAllItemsToFile("console_output.txt", myList);
                    break;
                case 5:                 //Search by ID
                    q.searchByCode(myList);
                    break;
                case 6:                    //Delete by ID
                    q.deleteByCode(myList);
                    break;
                case 7:                     //Sort by ID.
                    q.quickSortByCode(myList);
                    break;
                case 8:                     //Convert to Binary
                    int quan = myList.getHead().info.getQuantity();
                    q.convertToBinary(quan);
                    System.out.println();
                    break;
                case 9:                 //Load to stack and display
                    q.getAllItemsFromFile("Data.txt", myStack);
                    break;
                case 10:                   //Load to queue and display.
                    q.getAllItemsFromFile("Data.txt", myQueue);
                    break;
            }   
            System.out.println("Do you want to continue? (Yes/no) ");
            ans = scanner.next().toLowerCase();
        }
        System.out.println("Thank you for using. Em có làm tiêu chí nâng cao ạ");

    }
}
