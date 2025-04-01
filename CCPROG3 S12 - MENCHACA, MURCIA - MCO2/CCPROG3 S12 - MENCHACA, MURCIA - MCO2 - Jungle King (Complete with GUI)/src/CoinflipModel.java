//package m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * Class for the coinflip model for MVC integration. It contains the following variables
 * animalNumbers list that contains the numbers tied to the animals when game is played
 * animalStrengths - list that contains the strenght for each animal
 * 
 * 
 */
public class CoinflipModel {
    private List<Integer> animalNumbers;
    private List<Integer> animalStrengths;

    /*
     * Constructor for the coinflipModel for MVC integration. It also contains a randomizer to make sure the animal strenghts and numbers are different
     * to avoid fixed placements when it comes to the coinflip for the random element to be available.
     */
    public CoinflipModel() {
        // Initialize animal numbers and strengths
        animalNumbers = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            animalNumbers.add(i);
        }

        animalStrengths = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            animalStrengths.add(i);
        }

        // Literally the srandtime thing in ccprog2
        long seed = System.nanoTime();
        Collections.shuffle(animalNumbers, new Random(seed));
        Collections.shuffle(animalStrengths, new Random(seed));
    }
    /*
     * getter for the AnimalNumbers
     * @return list animalNumbers
     */
    public List<Integer> getAnimalNumbers() {
        return animalNumbers;
    }
    /*
     * getter for the animalStrengths
     * @return animalStrenght - 1
     */
    public int getStrength(int number) {
        return animalStrengths.get(number - 1);
    }
    /*
     * Method that removes the number of the animal when it comes to the coinflip to prevent duplication
     */
    public void removeNumber(int number) {
        animalNumbers.remove(Integer.valueOf(number));
    }
}