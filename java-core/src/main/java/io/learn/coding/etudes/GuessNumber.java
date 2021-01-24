package io.learn.coding.etudes;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(9000) + 1000;
        int guessCount = 1;
        boolean play =  true;
        while (play) {
            Scanner keyboardInput = new Scanner(System.in);
            System.out.printf("This is your %s guess.%n", guessCount);
            System.out.println("To stop game type 'stop' for guess");
            System.out.print("Enter number your guess (number from 1000 to 9999): ");
            try {
                String guessString = keyboardInput.nextLine();
                if ("stop".equals(guessString)) {
                    System.out.println("Thank you for your time.");
                    play = false;
                    break;
                }
                int guess = Integer.parseInt(guessString);
                if (guess < 1000 || guess > 9999) {
                    guessCount++;
                    System.out.println("Please enter number from 1000 to 9999");
                    continue;
                }
                if (guess < number) {
                    System.out.println("Your guess is too small");
                    guessCount++;
                } else if (guess > number) {
                    System.out.println("Your guess is too big");
                    guessCount++;
                } else {
                    System.out.printf("You win, number was %s.%n", number);
                    guessCount++;
                    System.out.printf("It took %s steps to guess%n", guessCount);
                    play = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid number from 1000 to 9999");
                guessCount++;
            }
        }
    }
}
