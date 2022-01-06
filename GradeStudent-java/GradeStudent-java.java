import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;
public class GradeStudent{
    static Scanner scanner = new Scanner(System.in);
    static float weighted = 0;
    static ArrayList<Integer> assignScore = new ArrayList<Integer>();  
    static ArrayList<Integer> totalWeight = new ArrayList<Integer>();   
    static float performance = 0;      
    static DecimalFormat df = new DecimalFormat("0.0");
    static void process() {
        assignScore.clear();
        totalWeight.clear();
        performance = 0;
        System.out.println("");
        begin();
        midTerm();
        finalTerm();
        homework();
        report();
        weightStandard();
    }
    static void begin(){
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
    }

    static void midTerm() {
        System.out.println("");
        System.out.println("Midterm: ");
        System.out.print("Weight (0-100)? ");
        int middleWeight = scanner.nextInt();
        totalWeight.add(middleWeight);
        System.out.print("Score earned? ");
        int middleScore = scanner.nextInt();
        System.out.print("Were scores shifted (1=yes, 2=no) ? ");
        int scoreShift = scanner.nextInt();
        totalPoint(scoreShift,middleScore, middleWeight);
    }
    
    static void finalTerm() {
        System.out.println("");
        System.out.println("Final: ");
        System.out.print("Weight (0-100)? ");
        int finalWeight = scanner.nextInt();
        totalWeight.add(finalWeight);
        System.out.print("Score earned? ");
        int finalScore = scanner.nextInt();
        System.out.print("Were scores shifted (1=yes, 2=no) ? ");
        int finalShift = scanner.nextInt();
        totalPoint(finalShift,finalScore, finalWeight);
    }
    
    static void totalPoint(int shift, int score, int weight) {
        if (shift == 1) {
            System.out.print("Shift amount? ");
            int amount = scanner.nextInt();
            float total = amount + score;
            if (total > 100) {
                total = 100;
            }
            System.out.println("Total points = " + (int)total + "/ 100" );
            weighted = total/100 * weight;
            performance += weighted;
            System.out.println("Weighted score = " + df.format(weighted) + " / "+ weight);
        } else {
            if (score > 100) {
                score = 100;
            }
            System.out.println("Total points = " + score + "/ 100");
            float newScore = score; 
            weighted = newScore/100 * weight;
            performance += weighted;
            System.out.println("Weighted score = " + df.format(weighted) + " / "+ weight);
        }
    }
    static void homework() {
        System.out.println("");
        System.out.println("Homework: ");
        System.out.print("Weight (0-100)? ");
        int hwWeight = scanner.nextInt();
        totalWeight.add(hwWeight);
        System.out.print("Number of assignments? ");
        int hwNum = scanner.nextInt();
        assignments(hwNum);
        System.out.print("How many sections did you attend? ");
        int sectionNum = scanner.nextInt();                                         
        int point = sectionPoint(sectionNum);
        if (point > 30) {                                                           
            point = 30;
        }
        System.out.println("Section Points = " + point + "/30");
        totalPointHW(hwWeight);
    }

    static void assignments(int num) {
        for (int i=1; i< num+1; i++ ){                                              
            System.out.println("Assignment " + i + " score and max ? ");
            int score = scanner.nextInt();
            assignScore.add(score);                                                  
            int max = scanner.nextInt();
            assignScore.add(max);                                                    
        }
    }

    static int sectionPoint(int num){
        return num*5;
    }

    static void totalPointHW(int num){
        int assignTotal = 0;
        int assignMax = 0;
        for (int i=0; i<assignScore.size(); i++) {
            if (i % 2 ==0) {                                                            
                assignTotal += assignScore.get(i);
            } else {
                assignMax += assignScore.get(i);                                         
            }
        }
        if (assignTotal > 150) {                                                         
            assignTotal = 150;
            assignMax = 150;
        }
        System.out.println("Total points = " + assignTotal + " / " + assignMax);
        float total = assignTotal;
        float max = assignMax;
        weighted = total/max * num;
        System.out.println("Weighted Score = " + df.format(weighted));
        performance += weighted;                                                          
    }

    static void report(){
        System.out.println("");
        float GPA;
        System.out.println("Overall percentage = " + performance);
        if (performance < 60){
            GPA = 0;
        } else if (performance < 75) {
            GPA = 1;
        } else if (performance < 85) {
            GPA = 2;
        } else {
            GPA = 3;
        }
        System.out.println("Your grade will be at least : " + GPA);
        review((int)GPA);
    }
    static void review(int num){
        switch(num){
            case 0:
                System.out.println("Failed. Try harder next time");
                break;
            case 1:
                System.out.println("Passed but the results are not satisfactory");
                break;
            case 2:
                System.out.println("Passed and the results are satisfactory");
                break;
            case 3:
                System.out.println("Excellent job !!!");
        }
    }
    static void weightStandard(){
        int total = 0;
        for (int i : totalWeight){
            if ( i < 0 || i > 100) {
                System.out.println("Weight must be from 0 to 100");
                System.out.println("Please start from the beginning");
                process();
            } else {
                total += i;
            }
        }
        if (total > 100 || total < 100) {
            System.out.println("Total weighted score must be exactly 100");
            System.out.println("Please start from the beginning");
            process();
        }
    }
    
    
    public static void main(String[] args) {
        begin();
        midTerm();
        finalTerm();
        homework();
        report();
        weightStandard();
    }
}