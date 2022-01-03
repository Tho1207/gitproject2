import java.util.Scanner;
import java.util.ArrayList;
public class LuckyNumber {
    static Scanner scanner = new Scanner(System.in);
    static int num;         
    static int myNum;     
    static float totalGames = 0;    
    static float totalGuess = 0;
    static int minGuess=0 ;
    static int count;       
    static ArrayList<Integer> bestGame = new ArrayList<Integer>();  
    static ArrayList<Integer> gameNo = new ArrayList<Integer>();    
    static void randomNum(int max){
        myNum = (int)(Math.random()*(max+1));   
    }
    static void guessNum(){
        String answer ="";
        count = 0;
        randomNum(100);       
        System.out.println("I'm thinking of a number between 0 and 100..."); 
        System.out.print("Your guess? ");
         num = scanner.nextInt();
        while (num!=myNum){                             
            if (num < myNum ) {
                count += 1;
                System.out.println("Its higher than your guess.");
            } else if (num > myNum) {
                count += 1;
                System.out.println("Its lower than your guess.");
            } 
            System.out.print("Your guess? ");
            num = scanner.nextInt();
        }
        if (num == myNum) {
            count += 1;         
            totalGuess += count;    
            totalGames += 1;    
            bestGame.add(count);
            System.out.println("Congrats on guessing right after "+count+ " times.");
            System.out.println("Do you want to play again?");
            answer = scanner.next().toLowerCase();
            playAgain(answer);  
        }
    }
    static void playAgain(String ans){
        if (ans.equals("y") || ans.equals("yes")){      
            guessNum();
        } else {                                        
            System.out.println("Thank you");
            guessAvg();
        }
    }
    static void guessAvg(){
        float Avg = totalGuess / totalGames ;
        int totalGamesInt = (int) totalGames;
        int totalGuessInt = (int) totalGuess;
        System.out.println("Total guesses in " + totalGamesInt + " games are " + totalGuessInt);
        System.out.println("Guess avarage = " + Avg);
        for (int i : bestGame){                                                
            if (minGuess ==0 || minGuess > i){
                minGuess = i;
            }
        }
        for (int i=0; i< bestGame.size(); i++){                                     
            int val = bestGame.get(i);
            if (val==minGuess){
                gameNo.add(i+1);
            }
        }
        System.out.println("The best game(s) with only " + minGuess + " guess(es) is/are game number: ");
        for (int i : gameNo){                                                         
            System.out.println(i);
        }
    }
    public static void main(String[] args){
        guessNum();
    }
}
