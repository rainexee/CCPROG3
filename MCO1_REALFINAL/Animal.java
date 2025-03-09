//package m;


/*
 * Represents the Animal superclass. It passes the attributes to the animal classes
 * This class contains the animalName, token, can_Swim, Level initialization
 * X and Y position on the board and its dynamic level adjustment
 */
public class Animal {
    private String animalName;
    private char token; //char that represents the animal on the board
    
    private boolean canSwim;
    protected static final int LEVEL = 0;
    int xpos;
	int ypos;
	int strLv;
	boolean captured;
	
	Player owner;

    /*Animal constructor 
     * @param animalName    - Name of the animal
     * @param canSwim       - if animal can swim
     * @param token         - animal token represented on the board (ex: 'l' for leopard)
     * @param captured      -unused
     */
    public Animal(String animalName, boolean canSwim, char token, boolean captured) {
        this.animalName = animalName; //defines the name of the animal
        this.canSwim = canSwim; 		//determines animal's interaction with water tiles
        this.token = token;
        this.captured = false;
    }
    
    /*
     * sets the player number as the owner
     * @param this.owner
     */
    public void setPlayer(Player p1) {
    	this.owner = p1;
    }

    /*getter for animal name
     * @return animalName as string
     */
    public String getAnimalName() {
        return animalName;
    }
    /*getter for animal token
     * @return token as a char
     */
    public char getAnimalToken() {
    	return token;
    }
    /*getter for canswim
     *  @return canSwim as a boolean
     */
    public boolean isCanSwim() {
        return canSwim;
    }
    /*getter for level
     * @return LEVEL as an int
     */
    public int getLevel() {
        return LEVEL;
    }


}
