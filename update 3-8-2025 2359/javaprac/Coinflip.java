package javaprac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Coinflip {
    public static boolean determineFirstPlayer(Scanner myObj) {
        // Create a list of numbers from 1 to 8
        List<Integer> animalNumbers = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            animalNumbers.add(i);
        }

        // Create a list of animal strength levels
        List<Integer> animalStrengths = new ArrayList<>();
        animalStrengths.add(5); // Strength of Elephant
        animalStrengths.add(3); // Strength of Wolf

        // literally random seed from ccprog1-2
        long seed = System.nanoTime();
        Collections.shuffle(animalNumbers, new Random(seed));
        Collections.shuffle(animalStrengths, new Random(seed));

        // Player 1 picks a number, while loop checks if number out of range via negation
        System.out.println("Player 1, pick a number from 1/2:");
        int playerOneNumber = myObj.nextInt();
        while (!animalNumbers.contains(playerOneNumber)) {         
            System.out.println("Invalid number. Please pick a number from 1 to 2:");
            playerOneNumber = myObj.nextInt();
        }
        animalNumbers.remove(Integer.valueOf(playerOneNumber));
        int playerTwoNumber = animalNumbers.get(0);

        /* 
        // Player 2 picks a number, while loop checks if number out of range via negation
        System.out.println("Player 2, pick a number from the remaining numbers:");
        int playerTwoNumber = myObj.nextInt();
        while (!animalNumbers.contains(playerTwoNumber)) {
            System.out.println("Invalid number. Please pick a number from the remaining numbers:");
            playerTwoNumber = myObj.nextInt();
        }
        */
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
