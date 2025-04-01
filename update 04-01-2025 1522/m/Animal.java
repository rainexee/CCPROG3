package m;



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

    public Animal(String animalName, String swimType, char token, boolean captured, int str) {
        this.animalName = animalName; //defines the name of the animal
        this.swimType = swimType; 		//determines animal's interaction with water tiles
        this.token = token;
        this.captured = false;
        this.LEVEL = str;
    }
    
    public void setPlayer(Player p1) {
    	this.owner = p1;
    }

    public String getAnimalName() {
        return animalName;
    }
    
    public char getAnimalToken() {
    	return token;
    }

    public String getSwimType() {
    	return swimType;
    }

    public int getLevel() {
        return LEVEL;
    }
    
    public void resetStr() {
    	this.strLv = LEVEL;
    }

}
