import java.util.Arrays;
import java.util.Scanner;

/**
 * Character Sheet
 * This programme creates a character not unlike how a character might be in a
 * game like Dungeons and Dragons
 * (Note: this programme is exclusively for coding practice and should
 * not be used in lieu of software that is used for D&D)
 */
public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        printMenu();
        while(!quit){
            System.out.println("Please Enter an option:");
            while(!sc.hasNextInt()){
                System.out.println("Input Invalid - Not An Interger.");
                System.out.println("Please enter your choice");
                sc.next();
            }
            int action = sc.nextInt();
            switch(action){
                case 0:
                    System.out.println("Programme Done, Goodbye");
                    quit = true;
                    break;
                case 1:
                    System.out.println("# Let's Make a Character!");
                    makeCharacter();
                    quit = true;
                    break;
                default:
                    System.out.println("That is not a valid option");
                    break;
            }
        }
    }

    public static void printMenu(){
        System.out.println("Available Options:");
        System.out.println("0 - Quit");
        System.out.println("1 - Make A Character");
        System.out.println("X - Anything Else");
    }

    public static void makeCharacter(){
        System.out.println("For the sake of speed, we're gonna make a human fighter today");
        System.out.println("Let's Roll for your scores!");
        // scores is where the six overall scores will be kept
        // tempScores is used for keeping the dice rolls as they're made 
        // tempScoreSum finds the sum of the three highest rolls (Done by sorting the array and then adding index's 1 2 and 3)
        int[]scores = new int[6];
        int[]tempScores = new int[4];
        int tempScoresSum;

        // For this we are using the "4 Drop lowest" rule
        // As the title suggests, 4d6 are rolled and the lowest dice is dropped, giving your score out of 18
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 4; j++){
                tempScores[j] = (int)(6.0 * Math.random()) + 1;
            }
            Arrays.sort(tempScores);
            System.out.println("Your rolls are:");
            for(int k = 0; k < tempScores.length; k++){
                System.out.print(tempScores[k]+" ");
            }
            System.out.println();
            System.out.println("We drop the lowest score, that's "+tempScores[0]);
            tempScoresSum = tempScores[1]+tempScores[2]+tempScores[3];
            System.out.println("Score #"+(i + 1)+" is..."+tempScoresSum);
            scores[i] = tempScoresSum;
            System.out.println();
        }

        Arrays.sort(scores);
        System.out.println("Your Scores are:");
        for(int i = 0; i < scores.length; i++){
            System.out.print(scores[i]+" ");
        }
        System.out.println();
    }

}