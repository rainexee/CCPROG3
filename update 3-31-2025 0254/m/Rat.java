package m;
public class Rat extends Animal {
    private static final int LEVEL = 0;

    public Rat(String animalName, String swimType, char token, boolean captured, int str) {
        super(animalName, swimType, token, captured, str);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    public Rat() {
        super("Rat", "swim", 'r',false, 1);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
    
    public void resetStr() {
    	this.strLv = LEVEL;
    }
    
}