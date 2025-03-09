public class Tile {
    int ypos; // row number
    int xpos; // col number
    char status;
    char tileType;

    Animal defender;
    Animal attacker;

    public Tile(int x, int y) {
        this.ypos = x;
        this.xpos = y;
        System.out.println("New tile created at row " + xpos + " and col " + ypos);
    }

    public void getTileInfo() {
        System.out.println("I am located in row " + this.ypos + ", column " + xpos);
        System.out.println("My tile type is " + this.tileType);
        if (this.status != this.tileType) {
            System.out.println("I am currently occupied.");
        } else {
            System.out.println("I am not currently occupied.");
        }
    }

    public void clearDefender(Animal scouter) {
        this.defender = null;
        this.status = this.tileType; // Reset to original tile type
        System.out.println("Tile row " + this.ypos + " col" + this.xpos + " cleared of defender");
    }

    public void setDefender(Animal scouter) {
        this.defender = scouter;
        System.out.println("Player " + scouter.owner.playerID + "'s " + scouter.getAnimalName() + " is now defending this tile.");
    }

    public void setAttacker(Animal attacker) {
        this.attacker = attacker;
        System.out.println("Player " + attacker.owner.playerID + "'s " + attacker.getAnimalName() + " is now attacking this tile.");
    }

	public void clearAttacker(Animal Attacker) {
		if (this.attacker != null) {
			System.out.println("Tile cleared of attacker: " + this.attacker.getAnimalName());
			this.attacker = null;
		} else {
			System.out.println("No attacker to clear.");
		}
	}

    // Checks the type of tile
    public int checkTile(Animal scouter) {
        System.out.println("Currently checking tile at row " + this.ypos + ", col " + this.xpos);
        int validity = 1; // automatically assume that the movement is valid unless river tiles are involved
        switch (this.tileType) {
            case '_':
                System.out.println("It's a grass tile. Anyone can move here.");
                break;
            case 'R':
                System.out.println("This is a river tile. Can ya swim?");
                if (scouter.isCanSwim()) {
                    System.out.println("Looks like " + scouter.getAnimalName() + " can swim after all!");
                } else {
                    System.out.println("Doesn't look like " + scouter.getAnimalName() + " knows how to swim!");
                    validity = 0;
                }
                break;
            case 'T':
                System.out.println("Trapped! Your " + scouter.getAnimalName() + " has been weakened.");
                scouter.strLv = -1;
                System.out.println(scouter.getAnimalName() + " strLV: " + scouter.strLv);
                break;
            case 'H':
                if (scouter.owner.playerID == 1 && this.xpos > 0) {
                    System.out.println("You made it to the enemy base!");
                    baseCaptured(scouter);
                } else if (scouter.owner.playerID == 2 && this.xpos == 0) {
                    System.out.println("You made it to the enemy base!");
                    baseCaptured(scouter);
                } else {
                    System.out.println("That's your own base, genius.");
                }
                break;
            default:
                System.out.println("TILE TYPE UNKNOWN");
        }

        if (validity == 1) {
            System.out.println("Tile verified! Scouting for enemies...");
            char occupation = scoutTile(scouter);
            System.out.println("Tile occupation status: " + occupation);
            if (occupation == 'b') {
                validity = 1;
            }
        } else {
            System.out.println("Sorry, you can't move here!");
        }

        return validity;
    }

    // Checks to see if the tile is occupied by an enemy, obstructed by an ally, or is free
    public char scoutTile(Animal scouter) {
        char occupation = 'n';
        System.out.println("Debug: scoutTile called for scouter " + scouter.getAnimalName());
		//System.out.println("Debug: Defender Name is" + defender.getAnimalName()+"PlayerID"+ defender.owner.playerID);
        if (defender == null) {
            System.out.println("Debug: Defender is null. Tile is open.");
            occupation = 'o';
        } else if (defender != null && defender.owner.playerID == scouter.owner.playerID) {
            System.out.println("Debug: Tile is obstructed by ally.");
            occupation = 'b';	//edit this
        } else if (defender != null && scouter.owner.playerID != defender.owner.playerID) {
            System.out.println("Debug: Enemy defender detected. Setting attacker.");
            setAttacker(scouter); // Use setAttacker
            occupation = 'e';
            if (defender.getLevel() > scouter.getLevel()) {
                System.out.println("Debug: Defender is stronger.");
            } else {
                System.out.println("Debug: Attacker is stronger. Initiating battle.");
            }
            battle(occupation);
            //occupation = 'o';
        }
        return occupation;
    }

	public char battle(char OccupationStatus) {
		System.out.println("Debug: battle called between " + this.attacker.getAnimalName() + " and " + this.defender.getAnimalName());
	
		if (attacker.getLevel() >= defender.getLevel()) {
			// Attacker wins
			System.out.println("Debug: Attacker wins. Removing defender and placing attacker.");
			defender.owner.removeAnimal(defender); // Remove the defender from the game
            clearDefender(defender); // Clear the defender from the tile
            SetOriginalStatus();
			//defender = attacker; // Attacker becomes the new defender
			clearAttacker(attacker); // Clear the attacker field
			//this.status = defender.getAnimalToken(); // Update tile status to reflect the new defender
		} else {
			// Defender wins
			System.out.println("Debug: Defender wins. Removing attacker.");
			attacker.owner.removeAnimal(attacker); // Remove the attacker from the game
			clearAttacker(attacker); // Clear the attacker from the tile
            SetOriginalStatus();
			//this.status = defender.getAnimalToken(); // Tile status remains the same (defender stays)
		}

		return this.status;
	}

    public void baseCaptured(Animal myAnimal) {
        myAnimal.owner.setWinState(1);
        System.out.println("Player " + myAnimal.owner.playerID + " wins!");
    }

    // Resets the tile to its original status
    public void SetOriginalStatus() {
        this.status = '_';
    }
}