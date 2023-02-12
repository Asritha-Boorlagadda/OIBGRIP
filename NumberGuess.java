import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String play = "yes";
        int round = 0;
        int FinalScore = 0;
        int TotalAttempts = 0;
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Choose a number in the range of 1 to 100. Guess the number within 4 attempts.");
        System.out.println("------------------------------------------------------------------------------------");
        while (play.equals("yes")) {
            ++round;
            int guess, i, a = 4, attempts = 0, score = 4;
            int randnum = ThreadLocalRandom.current().nextInt(1, 101);
            for (i = 0; i < a; i++) {
                System.out.print("\nGuess the number : ");
                guess = sc.nextInt();
                if (randnum == guess) {
                    attempts++;
                    System.out.println("------------------------");
                    System.out.println("Hurray!! You won!");
                    System.out.println("------------------------");
                    System.out.println("\nAttempts : " + attempts);
                    System.out.println("Your Score : " + score);
                    TotalAttempts += attempts;
                    FinalScore += score;
                    System.out.println("\nWould you wish to play the game again? (yes/no) : ");
                    play = sc.next().toLowerCase();
                    break;
                } else if (randnum > guess && guess >= 1) {
                    System.out.println("Generated number is greater than " + guess);
                    attempts++;
                    score--;
                } else if (randnum < guess && guess <= 100) {
                    System.out.println("Generated number is less than " + guess);
                    attempts++;
                    score--;
                } else if (guess <= 0 || guess > 100) {
                    System.out.println("You wasted an attempt. Enter a valid number(1-100)");
                    attempts++;
                    score--;
                }

            }
            if (i == a) {
                System.out.println("--------------------------");
                System.out.println("You lost!");
                System.out.println("--------------------------");
                System.out.println("Generated number is " + randnum);
                TotalAttempts += attempts;
                FinalScore += score;
                System.out.println("\nAttempts : " + attempts);
                System.out.println("Your Score : " + score);
                System.out.print("\nWould you wish to play the game again? (yes/no) : ");
                play = sc.next().toLowerCase();
            }
        }
        System.out.println("\nRounds : " + round);
        System.out.println("Total Attempts : " + TotalAttempts);
        System.out.println("Final Score : " + FinalScore);
        System.out.println("\nThanks for playing!!\n");
    }
}
