package m;

/*
 * Represents the Dog object that is inherited from the Animal class
 * This class contains the level of the animal, name, If animal can swim, its token on the board, and boolean capture(Remove)
 */

public class Dog extends Animal{
	private static final int LEVEL = 2;

    /*Constructor of a Dog
     * @param animalName - Name of the animal on the board
     * @param can_swim  -  If the animal can swim or not
     * @param token     - Token of the animal on the board ex:('l' for Leopard)
     */
    public Dog(String animalName, String swimType, char token, boolean captured, int str) {
        super(animalName, swimType, token, captured, str);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    public Dog() {
        super("Dog", "none", 'd', false, 2);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
    
    public void resetStr() {
    	this.strLv = LEVEL;
    }
}