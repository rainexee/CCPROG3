//package m;

/*
 * Represents the Leopard object that is inherited from the Animal class
 * This class contains the level of the animal, name, If animal can swim, its token on the board
 */

public class Leopard extends Animal{
	private static final int LEVEL = 4;

    /*Constructor of a leopard
     * @param animalName - Name of the animal on the board
     * @param can_swim  -  If the animal can swim or not
     * @param token     - Token of the animal on the board ex:('l' for Leopard)
     * @param captured - boolean if animal has been captured or not
     */
    public Leopard(String animalName, boolean can_swim, char token, boolean captured) {
        super(animalName, can_swim, token, captured);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }
    /*Constructor of a leopard with no parameters passed
     * Initializes the leopard with the predefenied attributes from the superclass
     * sets the strength level using the LEVEL final static int
     */
    public Leopard() {
        super("Leopard", false, 'l', false);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    /*
     * retrieves the current dynamic level of the Leopard
     * @return the dynamic level as an integer
     */
    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
}