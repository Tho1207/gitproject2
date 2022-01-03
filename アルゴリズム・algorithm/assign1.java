// このプロジェクトの目的はアルゴリズムの練習です。バブルソートと選択ソートと挿入ソートと線形探索と二分探索-基本的なアルゴリズムです。
//最初は1を入力してください。INPUT.TXTを作って、それから、Ｎ（アレイのサイズ）どんな数でも入力して、後はＮ回でランダムの数を入力してください。
//終わったら、続くか続かないかって質問が出ます。続きたい場合は"Ｙ"って入力してください。
//2-INPUT.TXTのアレイが出ます
//3-バブルソート
//4-選択ソート
//5-挿入ソート
//6-線形探索
//7-二分探索
//どんなメソッドを選んでも、新しいOUTPUT.TXTを作って、メソッドの結果がそのファイルに書いてありますので、是非ご覧ください。
import java.util.*;
import java.io.*;
class sortArray {                             
    int [] a; int n;
    sortArray() {}
    sortArray(int[]b){
        int i;
        n = b.length;
        a = new int[n];
        for(i=0;i<n;i++) 
        {a[i] = b[i];
        }
    } 
    void swap(int i, int k)                     
    {
        int x; 
        x=a[i];
        a[i]=a[k];
        a[k]=x;
    }
    void bubbleSort(){                            
        try {
            File myFile = new File("OUTPUT1.TXT");      
            if (myFile.createNewFile()) {               
                System.out.println("File created: " + myFile.getName());  
            } else {
                System.out.println("File already exists.");
            }
            FileWriter writer = new FileWriter("OUTPUT1.TXT");  
            int i, j;  
            for (i = 0; i < n-1; i++)                       
            {  
                for (j = 0; j < n-1-i; j++)  
                {  
                    if (a[j] > a[j+1])  
                        {  
                            swap(j, j+1);                   
                        } 
                } 
                for(int e=0;e<n;e++)                        
                {
                    System.out.print("  " + a[e]);
                    writer.write(a[e] + " ");
                }
                System.out.println();
                writer.write("\n"); 
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    } 
    void selectSort() {                     
        try {
            File myFile = new File("OUTPUT2.TXT");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter writer = new FileWriter("OUTPUT2.TXT"); 
            for (int i=0; i<n-1;i++) {
                int mindex = i;
                for (int j = i+1; j<n; j++) {
                    if (a[j] < a[mindex]) {
                        mindex = j;
                    }
                }
                swap(mindex, i);
                for(int e=0;e<n;e++)
                {
                    System.out.print("  " + a[e]);
                    writer.write(a[e] + " ");
                }
                System.out.println();
                writer.write("\n"); 
            }
            writer.close();   
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }
    void insertSort() {                    
        try {
            File myFile = new File("OUTPUT3.TXT");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter writer = new FileWriter("OUTPUT3.TXT"); 
            for (int i=1; i<n; ++i) {
                int key = a[i];
                int j = i-1;
                while (j>=0 && a[j]>key) {
                    a[j+1] = a[j];
                    j = j-1;
                }
                a[j+1] = key;
                for(int e=0;e<n;e++)
                {
                    System.out.print("  " + a[e]);
                    writer.write(a[e] + " ");
                }
                System.out.println();
                writer.write("\n"); 
            }   
                
            writer.close();   
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }  
}   
class searchArray {                                    
    int [] b; int n; int val;
    ArrayList<Integer> vals = new ArrayList<Integer>();
    searchArray() {}
    searchArray(int[]a, int value){
        int i;
        val = value;
        n = a.length;
        b = new int[n];
        for(i=0;i<n;i++) 
        {b[i] = a[i];
        }
    }   
    void linearSearch() {               
        try {
            File myFile = new File("OUTPUT4.TXT");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter writer = new FileWriter("OUTPUT4.TXT"); 
            for (int i=0; i<n; i++) {
                if (b[i]>val) {
                    vals.add(i);
                }
            }
            for (int num : vals) {
                System.out.println(num);
                writer.write(num + " ");
            }   
            writer.close();   
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    void sort() {                     
        for (int i=1; i<n; ++i) {
            int key = b[i];
            int j = i-1;
            while (j>=0 && b[j]>key) {
                b[j+1] = b[j];
                j = j-1;
            }
            b[j+1] = key;
        }
        binarySearch(b, 0, n-1, val);
    }
    void binarySearch(int[] b, int low, int high, int val) {        
        try {
            File myFile = new File("OUTPUT5.TXT");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter writer = new FileWriter("OUTPUT5.TXT"); 
            if (high>=low) {
                int mid = low + (high-low)/2;
                if (b[mid] == val) {
                    System.out.println(mid);
                    writer.write(mid + " ");
                }
                if (b[mid] < val) {
                    binarySearch(b, mid+1, high, val);
                }
                if (b[mid] > val ) {
                    binarySearch(b, low, mid-1, val);
                }
            } else {
                System.out.println("No search value in array");
                writer.write("No search value in array");
            }
            writer.close(); 
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
public class assign1 {
    static Scanner scanner = new Scanner(System.in);
    static int choice, n;
    static int[] a;
    static ArrayList<Integer> list = new ArrayList<Integer>();
    static void menu () {           //menu 
        System.out.println("Please enter from 1 to 7");
        System.out.println("1-Enter a number(range from 1 to 20)");
        System.out.println("2-Read data from INPUT.TXT");
        System.out.println("3-Bubble Sort");
        System.out.println("4-Selection Sort");
        System.out.println("5-Insertion Sort");
        System.out.println("6-Linear Search");
        System.out.println("7-Binary Search");
    }
    static void createFiles() {                     
        try {
        File myFile = new File("INPUT.TXT");
        if (myFile.createNewFile()) {
            System.out.println("File created: " + myFile.getName());
        } else {
            System.out.println("File already exists.");
        }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {       
            System.out.println("Your input(n<20)");
            n = scanner.nextInt();
            FileWriter writer = new FileWriter("INPUT.TXT");            
            for (int i = 0; i < n; i++) {
                 writer.write(scanner.nextInt() + " ");         
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static void readFiles() {                       
        try {
            list.clear();
            File file = new File("INPUT.TXT");
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    list.add(scan.nextInt());       
                } else {
                    scan.next();
                }
            }
        a = new int[list.size()];
        for (int i=0; i<list.size(); i++) {         
            a[i] = list.get(i);
        }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws Exception {
            String ans = "yes";
            while (ans.equals("yes") || ans.equals("y")){
                menu();
            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    createFiles();
                    break;
                case 2:
                    readFiles();
                    for (int num:a) {
                        System.out.print(num + " ");
                    }
                    System.out.println("");
                    break;
                case 3:
                    readFiles();
                    sortArray b = new sortArray(a);
                    b.bubbleSort(); 
                    break;
                case 4:
                    readFiles();
                    sortArray s = new sortArray(a);
                    s.selectSort();
                    break;
                case 5:
                    readFiles(); 
                    sortArray i = new sortArray(a);
                    i.insertSort();
                    break;
                case 6:
                    readFiles(); 
                    System.out.println("Input value: ");
                    int val = scanner.nextInt(); 
                    searchArray l = new searchArray(a, val);
                    l.linearSearch();
                    break;
                case 7:
                    readFiles();
                    System.out.println("Input value: ");
                    val = scanner.nextInt(); 
                    searchArray bi = new searchArray(a, val);
                    bi.sort();
                    break; 
                }
                System.out.println("Continue? (Yes - No)");
                ans = scanner.next();
            }

            }
            
}
