package javaprac;

public class Leopard extends Animal{
	private static final int LEVEL = 4;

    public Leopard(String animalName, boolean can_swim, char token) {
        super(animalName, can_swim, token);
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    public Leopard() {
        super("Leopard", false, 'l');
        this.strLv = LEVEL; // Initialize strLv with LEVEL
    }

    @Override
    public int getLevel() {
        return this.strLv; // Return the dynamic level
    }
}
