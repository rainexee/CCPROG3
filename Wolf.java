package javaprac;

public class Wolf extends Animal {
	private static final int LEVEL = 3;

    public Wolf(String animalName, boolean can_swim, char token) {
        super(animalName, can_swim, token);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    public Wolf() {
        super("Wolf", false, 'w');
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
}
