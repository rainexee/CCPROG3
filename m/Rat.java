
public class Rat extends Animal {
    private static final int LEVEL = 1;

    public Rat(String animalName, String swimType, char token, boolean captured) {
        super(animalName, swimType, token, captured);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    public Rat() {
        super("Rat", "swim", 'r',false);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
    
}