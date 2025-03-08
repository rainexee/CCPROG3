package javaprac;

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

    public Animal(String animalName, boolean canSwim, char token) {
        this.animalName = animalName; //defines the name of the animal
        this.canSwim = canSwim; 		//determines animal's interaction with water tiles
        this.token = token;
        this.captured = false;
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

    public boolean isCanSwim() {
        return canSwim;
    }

    public int getLevel() {
        return LEVEL;
    }

}
