////package m;

/*
 * Represents the Tiger object that is inherited from the Animal class
 * This class contains the level of the animal, name, If animal can swim, its token on the board, capture status, strenght
 */
public class Tiger extends Animal {
    private static final int LEVEL = 5;

        /*
    * This is the constructor of the Tiger with its parameters added
     * @param animalName - Name of the animal on the board
     * @param can_swim  -  If the animal can swim or not
     * @param token     - Token of the animal on the board ex:('l' for Leopard)
     * @param captured - Boolean of the captured status
     * @param str      - Strength of the animal
      */
    public Tiger(String animalName, String swimType, char token, boolean captured, int str) {
        super(animalName, swimType, token, captured, str);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }
    /*
 * Constructor of the Tiger with no variables but uses super to pass inputs into the parameter
 */
    public Tiger() {
        super("Tiger", "cross", 't',false, 5);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }
    /*
     * this method returns the dynamic level of the animals strenght 
     * @return strLv
     */
    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
     /*
     * resets the strenghtlevel back to default
     */
    public void resetStr() {
    	this.strLv = LEVEL;
    }
}