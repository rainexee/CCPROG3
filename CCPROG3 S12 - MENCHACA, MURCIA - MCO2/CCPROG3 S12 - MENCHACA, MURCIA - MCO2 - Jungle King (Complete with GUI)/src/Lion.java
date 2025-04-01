//package m;

/*
 * Represents the Lion object that is inherited from the Animal class
 * This class contains the level of the animal, name, If animal can swim, its token on the board
 */
public class Lion extends Animal {
    private static final int LEVEL = 6;
/*
 * This is the constructor of the Lion with its parameters added
     * @param animalName - Name of the animal on the board
     * @param can_swim  -  If the animal can swim or not
     * @param token     - Token of the animal on the board ex:('l' for Leopard)
     * @param captured - Boolean of the captured status
     * @param str      - Strength of the animal
      */
    public Lion(String animalName, String swimType, char token, boolean captured, int str) {
        super(animalName, swimType, token, captured, str);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }
/*
 * Constructor of the Lion with no variables but uses super to pass inputs into the parameter
 */
    public Lion() {
        super("Lion", "cross", 'k',false, 6);
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