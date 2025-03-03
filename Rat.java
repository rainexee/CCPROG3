public class Rat extends Animal {
    private static final int LEVEL = 1;

    public Rat(String animalName, boolean can_swim) {
        super(animalName, can_swim);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    public Rat() {
        super("Rat", true);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
}
