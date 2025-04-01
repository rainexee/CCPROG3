//package m;

/*
 * Represents the Leopard object that is inherited from the Animal class
 * This class contains the level of the animal, name, If animal can swim, its token on the board, capture status, and strenght
 */

public class Leopard extends Animal{
	private static final int LEVEL = 4;

    /*Constructor of a leopard
     * @param animalName - Name of the animal on the board
     * @param can_swim  -  If the animal can swim or not
     * @param token     - Token of the animal on the board ex:('l' for Leopard)
     * @param captured - Boolean of the captured status
     * @param str      - Strength of the animal
     */
    public Leopard(String animalName, String swimType, char token, boolean captured, int str) {
        super(animalName, swimType, token, captured, str);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }
/*
 * Constructor of the leopard with no variables but uses super to pass inputs into the parameter
 */
    public Leopard() {
        super("Leopard", "none", 'l', false, 4);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }
/*
 * Getter for the dynamic level of the strength of the animal. 
 */
    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
    /*
     * This method resets the dynamic strength back to default
     */
    public void resetStr() {
    	this.strLv = LEVEL;
    }
}