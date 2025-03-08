package javaprac;

public class Tile {
	int ypos; //row number
	int xpos; //col number
	char status;
	char tileType;
	
	Animal defender;
	Animal attacker;
	
	public Tile(int x, int y){
		this.ypos = x;
		this.xpos = y;
		System.out.println("New tile created at row " + xpos + " and col " + ypos);
	}
	
	public void getTileInfo() {
		System.out.println("I am located in row " + this.ypos + ", column " + xpos);
		System.out.println("My tile type is " + this.tileType);
		if(this.status != this.tileType) {
			System.out.println("I am currently occupied.");
		}else{
			System.out.println("I am not currently occupied.");
		}
	}
	
	public void setDefender(Animal scouter) {
		System.out.println("Player " + scouter.owner.playerID + "'s " + scouter.getAnimalName() + " is now defending this tile.");
	}
	
	
	//checks the type of tile
	public int checkTile(Animal scouter) {
		System.out.println("Currently checking tile at row " + this.ypos + ", col " + this.xpos);
		int validity = 1; //automatically assume that the movement is valid unless river tiles are involved
		switch (this.tileType) {
			case '_':
				System.out.println("It's a grass tile. Anyone can move here.");
				break;
			case 'R':
				System.out.println("This is a river tile. Can ya swim?");
				//SWIM LOGIC -- TBA
				if(scouter.isCanSwim() == true) {
					System.out.println("Looks like " + scouter.getAnimalName() + " can swim after all!");
				}else {
					System.out.println("Doesn't look like " + scouter.getAnimalName() + " knows how to swim!");
					validity = 0;
				}
				break;
			case 'T':
				System.out.println("Trapped! Your " + scouter.getAnimalName() + " has been weakened.");
				//TRAP LOGIC
				scouter.strLv = -1;
				System.out.println(scouter.getAnimalName() + " strLV: " + scouter.strLv);
				break;
			case 'H':
				//check the scouting animals pID
				if(scouter.owner.playerID == 1 && this.xpos > 0) {
					System.out.println("You made it to the enemy base!");
					baseCaptured(scouter);
				}else if(scouter.owner.playerID == 2 && this.xpos == 0) {
					System.out.println("You made it to the enemy base!");
					baseCaptured(scouter);
				}else {
					System.out.println("That's your own base, genius.");
				}
				break;
			default:
				System.out.println("TILE TYPE UNKNOWN");
		}
		//char courseOfAction = 'n';
		
		if(validity == 1) {
			System.out.println("Tile verified! Scouting for enemies...");
		}else {
			System.out.println("Sorry, you can't move here!");
		}
		
		return validity;
	}
	
	//checks to see if the tile is occupied by an enemy, obstructed by an ally, or is free
	public char scoutTile(Animal scouter) {
		char occupation = 'n';
		//occupation 'o' indicates open while 'b' indicates blocked
		
		if(defender == null) {
			occupation = 'o';
		}
		//defending animal is owned by the current player
		else if(defender != null && defender.owner.playerID == scouter.owner.playerID) {
			System.out.println("This space is obstructed by current player's " + defender.getAnimalName() + ", ownerID: " + defender.owner.playerID);
			System.out.println("Cannot resolve movement.");
			occupation = 'b';
		}else if(defender != null && defender.owner.playerID != scouter.owner.playerID) {
			System.out.println("This space is occupied by enemy player " + defender.owner.playerID + "'s " + defender.getAnimalName());
			System.out.println("Defender's strength level: " + defender.getLevel());
			System.out.println("Attacker's strength level: " + scouter.getLevel());
			if(defender.getLevel() > scouter.getLevel()) {
				System.out.println("The odds are not in your favor...");
			}else {
				System.out.println("Let's do this!");
			}
			this.attacker = scouter;
			battle();
		}
		return occupation;
	}
	
	public void battle() {
		System.out.println(this.attacker + " wants to fight " + this.defender);
	}
	
	public void baseCaptured(Animal myAnimal) {
		myAnimal.owner.setWinState(1);
		System.out.println("Player " + myAnimal.owner.playerID + " wins!");
	}
	
}
