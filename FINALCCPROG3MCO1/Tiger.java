

public class Tiger extends Animal {
    private static final int LEVEL = 5;

    public Tiger(String animalName, boolean can_swim, char token) {
        super(animalName, can_swim, token);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    public Tiger() {
        super("Tiger", true, 't');
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
}
