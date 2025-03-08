public class Tile {
	int ypos; //row number
	int xpos; //col number
	private int laststepx;
	private int laststepy;
	char status;
	char tileType;
	
	Animal defender;
	Animal attacker;
	
	public Tile(int x, int y){
		this.ypos = y;
		this.xpos = x;
		this.laststepx = x;
        this.laststepy = y;
		System.out.println("New tile created at row " + ypos + " and col " + xpos);
	}
	
	public void setLastPosition(int x, int y) {
		System.out.println("Storing last position: row=" + y + ", col=" + x);
        this.laststepx = x;
        this.laststepy = y;
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
	public void checkTile(Animal scouter, Room room) {
		System.out.println("Currently checking tile at row " + this.ypos + ", col " + this.xpos);
    
		switch (this.tileType) {
			case '_':
				System.out.println("It's a grass tile.");
				break;
				case 'R':	//IMPLEMENTATION IS HERE
				System.out.println("This is a river tile. Can ya swim?");
				if (!scouter.isCanSwim()) {
					System.out.println("=== Debug Info ===");
					System.out.println("Current position: " + scouter.xpos + "," + scouter.ypos);
					System.out.println("Last stored position: " + this.laststepx + "," + this.laststepy);
					System.out.println("Attempting to restore position...");


    System.out.println(scouter.getAnimalName() + " cannot swim! Movement cancelled.");
    // Debug print to check stored positions
    System.out.println("Last stored position: " + this.laststepx + "," + this.laststepy);
    // Clear current position
    room.tiles[scouter.ypos][scouter.xpos].status = '_';
    // Reset river tile
    room.tiles[this.ypos][this.xpos].status = 'R';
    // Return animal to its last position
    room.tiles[this.laststepy][this.laststepx].status = scouter.getAnimalName().charAt(0);
    // Update animal's coordinates PLS FIX
	if (scouter.xpos != this.laststepx) {
		scouter.xpos = this.laststepx;
	}
	if (scouter.ypos != this.laststepy) {
		scouter.ypos = this.laststepy;
	}
	return;
				}
				System.out.println(scouter.getAnimalName() + " can swim through the river!");
				break;
			case 'T':
				System.out.println("Trapped! Your " + scouter.getAnimalName() + " has been weakened.");
				// TRAP LOGIC
				scouter.strLv = -1;
				System.out.println(scouter.getAnimalName() + " strLV: " + scouter.strLv);
				break;
			case 'H':
				// Check the scouting animal's player ID
				if (scouter.owner.playerID == 1 && this.xpos > 0) {
					System.out.println("You made it to the enemy base!");
				} else if (scouter.owner.playerID == 2 && this.xpos == 0) {
					System.out.println("You made it to the enemy base!");
				}
				baseCaptured(scouter);
				break;
			default:
				System.out.println("TILE TYPE UNKNOWN");
		}
		char courseOfAction = 'n';
		System.out.println("Scouting for enemies...");
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
		System.out.println("Player " + myAnimal.owner.playerID + " wins!");
	}
	
}