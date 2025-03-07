package javaprac;

public class Elephant extends Animal {
	
	private static final int LEVEL = 7;

    public Elephant(String animalName, boolean can_swim, char token) {
        super(animalName, can_swim, token);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    public Elephant() {
        super("Elephant", false, 'e');
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
}
