import java.util.Scanner;

/**Guess a number
 * @version 1.1
 * @author Robert Nilsson
*/

public class HiLo {
    public static void main(String[] args){

        System.out.println("Welcome to HiLo!");
        System.out.println("Try to guess my number");
        System.out.println("Choose difficulty:");
        System.out.println("1. Easy (1-10)");
        System.out.println("2. Medium (1-100)");
        System.out.println("3. Hard (1-1000)");

        // Get user input
        Scanner sc = new Scanner(System.in);
        int maxNumber, tries;
        int level;
        try {
            String testlevel = sc.nextLine();
            level = Integer.parseInt(testlevel);
        } catch(NumberFormatException e) {
            throw new NumberFormatException(("Only numbers 1, 2 or 3 allowed!"));
        }




        switch (level) {
            case 1:
                maxNumber = 10;
                tries = playGame(maxNumber);
                System.out.println("You guessed my number in " +tries + " tries.");
                break;
            case 2:
                maxNumber = 100;
                tries = playGame(maxNumber);
                System.out.println("You guessed my number in " +tries + " tries.");
                break;
            case 3:
                maxNumber = 1000;
                tries = playGame(maxNumber);
                System.out.println("You guessed my number in " +tries + " tries.");
                break;
            default:
                System.out.println("You must choose 1, 2 or 3!");
                break;
        }

    }

    public static int playGame(int maxNumber){


        int answer = (int)(Math.random() * maxNumber) +1;
        int guess;
        int tries = 0;

        do {
            System.out.println("Guess a number between 1 and " +maxNumber);
            Scanner s = new Scanner(System.in);
            try {
                String testGuess = s.nextLine();
                guess = Integer.parseInt(testGuess);
            } catch(NumberFormatException e) {
                throw new NumberFormatException(("Only numbers allowed!"));
            }
            giveResponse(answer, guess);

            //Count number of tries for end result
            tries = tries + 1;

        } while (guess != answer);

        return tries;

    }

    public static void giveResponse(int answer, int guess) {
        if(answer == guess) {
            System.out.println("The number " + guess +" is correct!");
        }
        else if(answer < guess) {
            System.out.println("Your guess was to high!");
        }
        else if(answer > guess) {
            System.out.println("Your guess was to low!");
        }
    }
}