
public class Elephant extends Animal {
	
	private static final int LEVEL = 7;

    public Elephant(String animalName, boolean can_swim, char token, boolean captured) {
        super(animalName, can_swim, token, captured);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    public Elephant() {
        super("Elephant", false, 'e', false);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
}
