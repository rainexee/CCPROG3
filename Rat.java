class Rat extends Animal {
    private static final int LEVEL = 1;


    public Rat(String animalName, boolean can_swim) {
        super(animalName,can_swim); 
    }

    public Rat()
    {
        super("Rat", true);
        if(Rat.LEVEL > super.getLevel())
        {
            System.out.println("Rat BEATS " + this.getAnimalName());
        }
    }

    // existing code
}