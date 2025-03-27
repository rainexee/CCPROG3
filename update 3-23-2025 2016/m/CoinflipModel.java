import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CoinflipModel {
    private List<Integer> animalNumbers;
    private List<Integer> animalStrengths;

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

        // Shuffle the lists
        long seed = System.nanoTime();
        Collections.shuffle(animalNumbers, new Random(seed));
        Collections.shuffle(animalStrengths, new Random(seed));
    }

    public List<Integer> getAnimalNumbers() {
        return animalNumbers;
    }

    public int getStrength(int number) {
        return animalStrengths.get(number - 1);
    }

    public void removeNumber(int number) {
        animalNumbers.remove(Integer.valueOf(number));
    }
}