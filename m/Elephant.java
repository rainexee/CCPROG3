
/*
 * Represents the Elephant object that is inherited from the Animal class
 * This class contains the level of the animal, name, If animal can swim, its token on the board, and boolean capture(Remove)
 */

public class Elephant extends Animal{
	private static final int LEVEL = 7;

    /*Constructor of an Elephant
     * @param animalName - Name of the animal on the board
     * @param can_swim  -  If the animal can swim or not
     * @param token     - Token of the animal on the board ex:('l' for Leopard)
     */
    public Elephant(String animalName, String swimType, char token, boolean captured) {
        super(animalName, swimType, token, captured);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    public Elephant() {
        super("Elephant", "none", 'e', false);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
}