public class Animal {
    private String animalName;
    private boolean canSwim;
    protected static final int LEVEL = 0;

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

    // existing code
}
