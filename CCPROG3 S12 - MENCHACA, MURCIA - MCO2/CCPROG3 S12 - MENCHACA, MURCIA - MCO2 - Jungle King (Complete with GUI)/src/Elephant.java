//package m;

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
     * @param captured  - If the animal got captured or not
     * @param str      - Strenght of the animal
     */
    public Elephant(String animalName, String swimType, char token, boolean captured, int str) {
        super(animalName, swimType, token, captured, str);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }
/*
 * Constructor of the elephant with no parameters so uses super to input data for the variables
 * 
 */
    public Elephant() {
        super("Elephant", "none", 'e', false, 7);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }
/*
 * getter for the animals dynamic strength level
 * @return strLv - dynamic level
 */
    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
    /*
     * This method resets the strength level of the animal to its default strength
     * 
     */
    public void resetStr() {
    	this.strLv = LEVEL;
    }
}