//package m;
/*
 * Represents the Rat object that is inherited from the Animal class
 * This class contains the level of the animal, name, If animal can swim, its token on the board, capture status, strenght
 */
public class Rat extends Animal {
    private static final int LEVEL = 0;


    /*
    * This is the constructor of the Rat with its parameters added
     * @param animalName - Name of the animal on the board
     * @param can_swim  -  If the animal can swim or not
     * @param token     - Token of the animal on the board ex:('l' for Leopard)
     * @param captured - Boolean of the captured status
     * @param str      - Strength of the animal
      */
    public Rat(String animalName, String swimType, char token, boolean captured, int str) {
        super(animalName, swimType, token, captured, str);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }
/*
 * Constructor of the Rat with no variables but uses super to pass inputs into the parameter
 */
    public Rat() {
        super("Rat", "swim", 'r',false, 1);
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