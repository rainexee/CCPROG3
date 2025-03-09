//package m;

/*represents the animal Rat that inherits values from the Animal class
 * This class contains the level of the animal, name, If animal can swim, its token on the board, and boolean capture
 */
 
public class Rat extends Animal {
    private static final int LEVEL = 1;
    /*Constructor of the rat class  
     * @param animalName - Name of the animal
     * @param can_swim - If animal can swim boolean
     * @param token - token of the animal (ex: 'r' for rat) on the board display
     * @param captured - boolean if animal has been captured or not
     */
    public Rat(String animalName, boolean can_swim, char token, boolean captured) {
        super(animalName, can_swim, token, captured);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }
    /*Constructor of a rat with no parameters passed
     * Initializes the rat with the predefenied attributes from the superclass
     * sets the strength level using the LEVEL final static int
     */
    public Rat() {
        super("Rat", true, 'r',false);
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