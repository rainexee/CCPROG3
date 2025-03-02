public class Tiger extends Animal {
    private static final int LEVEL = 5; // if level higher it can take the animal out of play
        public Tiger(String animalName, boolean can_swim) {
            super(animalName, can_swim);
        }
        public Tiger() {
            super("Tiger", true);
            if(Tiger.LEVEL > super.getLevel())
            {
                System.out.println("Tiger BEATS " + this.getAnimalName());
            }
        }
    
    }
