import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Coinflip {
    public static boolean determineFirstPlayer(Scanner myObj) {
        // Create a list of numbers from 1 to 8
        List<Integer> animalNumbers = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            animalNumbers.add(i);
        }

        // Create a list of animal strength levels
        List<Integer> animalStrengths = new ArrayList<>();
        animalStrengths.add(5); // Strength of Elephant
        animalStrengths.add(3); // Strength of Wolf
        animalStrengths.add(4); // Strength of Leopard
        animalStrengths.add(1); // Strength of Rat
        animalStrengths.add(3); // Strength of Cat
        animalStrengths.add(4); // Strength of Dog
        animalStrengths.add(6); // Strength of Tiger
        animalStrengths.add(7); // Strength of Lion

        // literally random seed from ccprog1-2
        long seed = System.nanoTime();
        Collections.shuffle(animalNumbers, new Random(seed));
        Collections.shuffle(animalStrengths, new Random(seed));

        // Player 1 picks a number, while loop checks if number out of range via negation
        System.out.println("Player 1, pick a number from 1 to 8:");
        int playerOneNumber = myObj.nextInt();
        while (!animalNumbers.contains(playerOneNumber)) {
            System.out.println("Invalid number. Please pick a number from 1 to 8:");
            playerOneNumber = myObj.nextInt();
        }
        animalNumbers.remove(Integer.valueOf(playerOneNumber));

        // Player 2 picks a number, while loop checks if number out of range via negation
        System.out.println("Player 2, pick a number from the remaining numbers:");
        int playerTwoNumber = myObj.nextInt();
        while (!animalNumbers.contains(playerTwoNumber)) {
            System.out.println("Invalid number. Please pick a number from the remaining numbers:");
            playerTwoNumber = myObj.nextInt();
        }
        
        // -1 because index notation
        int playerOneStrength = animalStrengths.get(playerOneNumber - 1);
        int playerTwoStrength = animalStrengths.get(playerTwoNumber - 1);

        //change later to animal name once we pick the final animals
        System.out.println("Player 1 picked number: " + playerOneNumber + " with strength level: " + playerOneStrength);
        System.out.println("Player 2 picked number: " + playerTwoNumber + " with strength level: " + playerTwoStrength);

        // Determine which player goes first based on the strength level
        return playerOneStrength > playerTwoStrength;
    }
}
