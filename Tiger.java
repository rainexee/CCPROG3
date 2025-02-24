class Tiger extends Animal{
private static final int LEVEL = 5; // if level higher it can take the animal out of play
private static final int WEAKER = 2;
    public Tiger() {
        this.animalName = "Tiger";
        this.can_swim = true;
    }
    public static void main(String[] args) //tester
    {
        Tiger tiger = new Tiger();
        System.out.println("Animal Name: " + tiger.animalName);
        System.out.println("Can Swim: "+ tiger.can_swim);
        if(tiger.LEVEL > tiger.WEAKER)
        {
            System.out.println("Tiger BEATS WEAK");
        }
    }


}