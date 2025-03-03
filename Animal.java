public class Animal {
    private String animalName;
    private boolean canSwim;
    protected static final int LEVEL = 0;
    int xpos;
	int ypos;
	int strLv;
	boolean captured;

    public Animal(String animalName, boolean canSwim) {
        this.animalName = animalName;
        this.canSwim = canSwim;
    }

    public String getAnimalName() {
        return animalName;
    }

    public boolean isCanSwim() {
        return canSwim;
    }

    public int getLevel() {
        return LEVEL;
    }

}
