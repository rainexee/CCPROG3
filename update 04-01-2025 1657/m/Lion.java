package m;
public class Lion extends Animal {
    private static final int LEVEL = 6;

    public Lion(String animalName, String swimType, char token, boolean captured, int str) {
        super(animalName, swimType, token, captured, str);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    public Lion() {
        super("Lion", "cross", 'k',false, 6);
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