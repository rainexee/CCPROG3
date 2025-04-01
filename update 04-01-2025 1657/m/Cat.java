//package m;

/*
 * Represents the Cat object that is inherited from the Animal class
 * This class contains the level of the animal, name, If animal can swim, its token on the board, and boolean capture(Remove)
 */

public class Cat extends Animal{
	private static final int LEVEL = 1;

    /*Constructor of a Cat
     * @param animalName - Name of the animal on the board
     * @param can_swim  -  If the animal can swim or not
     * @param token     - Token of the animal on the board ex:('l' for Leopard)
     */
    public Cat(String animalName, String swimType, char token, boolean captured, int str) {
        super(animalName, swimType, token, captured, str);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }
    /*
     * Cat constructor with no parameters and uses super to give deets.
     * 
     */
    public Cat() {
        super("Cat", "none", 'c', false, 1);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }
    /*
     * getLevel returns the dynamic level of the cat.
     * @return strLv as int.
     */
    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
   /*
    * resets strenght level as original level.
    */
    public void resetStr() {
    	this.strLv = LEVEL;
    }
}