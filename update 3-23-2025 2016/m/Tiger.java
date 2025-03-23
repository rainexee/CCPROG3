package m;
public class Tiger extends Animal {
    private static final int LEVEL = 5;

    public Tiger(String animalName, String swimType, char token, boolean captured) {
        super(animalName, swimType, token, captured);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    public Tiger() {
        super("Tiger", "cross", 't',false);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
    
}