//package m;

/*
 * Class that represents the Animal superclass. it contains the following variables
 * @var animalName - String that names the Animal
 * @var token - Icon of the Animal 
 * @var swimType - determines animal's interaction with water tiles
 * @var LEVEL - Strenght level of the animal
 * @var xpos - X Position on the board
 * @var ypos - Y axis on the board
 * @var strLv - Dynamic strenght level of the animal assuming they hit trap
 * @var captured - If the animal gets captured
 */

public class Animal {
    private String animalName;
    private char token; //char that represents the animal on the board
    
    private String swimType;
    protected final int LEVEL;
    int xpos;
	int ypos;
	int strLv;
	boolean captured;
	
	Player owner;
    /*
     * Constructor for the animal with params included
     * @param animalName - Name of the animal
     * @param swimType - Type of interaction with water tiles
     * @param token - Token representation of the animal
     * @param captured - Boolean that determines if animal is captured or not.
     * @param str - Strenght level of the animal
     */
    public Animal(String animalName, String swimType, char token, boolean captured, int str) {
        this.animalName = animalName; //defines the name of the animal
        this.swimType = swimType; 		//determines animal's interaction with water tiles
        this.token = token;
        this.captured = false;
        this.LEVEL = str;
    }
    /*setPlayer
     * Sets the owner to P1
     */
    public void setPlayer(Player p1) {
    	this.owner = p1;
    }
    /*
     * getter for the animalName
     * return String
     */
    public String getAnimalName() {
        return animalName;
    }
    /*getter for the AnimalToken
     * return token as char
     */
    public char getAnimalToken() {
    	return token;
    }
    /*
     * getter for the swim type
     * return swimType as string
     */
    public String getSwimType() {
    	return swimType;
    }
    /*
     * getter for the level
     * @return LEVEL as int
     */
    public int getLevel() {
        return LEVEL;
    }
    /*
     * resets dynamic strenght to original state.
     * 
     */
    public void resetStr() {
    	this.strLv = LEVEL;
    }

}
