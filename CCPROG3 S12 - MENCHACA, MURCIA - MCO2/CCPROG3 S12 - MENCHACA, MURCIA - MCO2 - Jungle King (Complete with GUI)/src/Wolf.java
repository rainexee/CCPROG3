//package m;

/*
 * Represents the Wolf object that is inherited from the Animal class
 * This class contains the level of the animal, name, If animal can swim, its token on the board, and boolean capture(Remove)
 */

public class Wolf extends Animal{
	private static final int LEVEL = 3;

    /*Constructor of a Wolf
     * @param animalName - Name of the animal on the board
     * @param can_swim  -  If the animal can swim or not
     * @param token     - Token of the animal on the board ex:('l' for Leopard)
     * @param captured - Boolean to determine if animal has been captured or not
     * @param str - Strenght of the animal
     */
    public Wolf(String animalName, String swimType, char token, boolean captured, int str) {
        super(animalName, swimType, token, captured, str);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }
    /*
     * Constructor of a wolf with no parameters that uses super to put data into it.
     */
    public Wolf() {
        super("Wolf", "none", 'w', false, 3);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }
    /*
     * This is a getter method that gets the dynamic level of the Wolf
     * @return strLv
     */
    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
    /*
     * this method is to reset the dynamic level back to its original status
     */
    public void resetStr() {
    	this.strLv = LEVEL;
    }
}