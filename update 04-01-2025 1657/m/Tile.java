//package m;

import java.lang.Math;
import java.lang.ModuleLayer.Controller;
/*
 * this class represents the tiles of the board. It has the row and column number, tiletype and status
 */
public class Tile {
    int ypos; // row number
    int xpos; // col number
    char status;
    char tileType;

    Animal defender;
    Animal attacker;
/*
 * Constructor for The tile. it gets the row and column number from the two parameters
 * @param x - col number
 * @Param y - row number
 */
    public Tile(int x, int y) {
        this.ypos = x;
        this.xpos = y;
        //System.out.println("New tile created at row " + xpos + " and col " + ypos);
    }
/*
 * This method displayed the tile info, tiletype and status if occupied or not
 */
    public void getTileInfo() {
        System.out.println("I am located in row " + this.ypos + ", column " + xpos);
        System.out.println("My tile type is " + this.tileType);
        if (this.status != this.tileType) {
            System.out.println("I am currently occupied.");
        } else {
            System.out.println("I am not currently occupied.");
        }
    }
/*
 * this method clears the defenders and clears the tiletype
 * @param scouter - scouts the next tile 
 */
    public void clearDefender(Animal scouter) {
        this.defender = null;
        this.status = this.tileType; // Reset to original tile type
        //System.out.println("Tile row " + this.ypos + " col" + this.xpos + " cleared of defender");
    }
/*
 * setDefender method sets the defending animal
 * @param scouter - Animal that is being challenged to battle
 */
    public void setDefender(Animal scouter) {
        this.defender = scouter;
        System.out.println("Player " + scouter.owner.playerID + "'s " + scouter.getAnimalName() + " is now defending this tile.");
    }
/*
 * This method sets the attacking animal
 * @param attacker - Attacking animal that initiated battle
 */
    public void setAttacker(Animal attacker) {
        this.attacker = attacker;
        //System.out.println("Player " + attacker.owner.playerID + "'s " + attacker.getAnimalName() + " is now attacking this tile.");
    }
/*
 * This method clears the attacker if the attacker loses the battle
 * @param Attacker - Attacking animal
 */
	public void clearAttacker(Animal Attacker) {
		if (this.attacker != null) {
			//System.out.println("Tile cleared of attacker: " + this.attacker.getAnimalName());
			this.attacker = null;
		} else {
			System.out.println("No attacker to clear.");
		}
	}

    /*
     * This method checks the tile type if they can move there or not
     * @param scouter - Animal that will move to a new tile
     */
    public int checkTile(Animal scouter) {
        //System.out.println("Currently checking tile at row " + this.ypos + ", col " + this.xpos);
        int validity = 1; // automatically assume that the movement is valid unless river tiles are involved
        switch (this.tileType) {
            case '_':
                System.out.println("It's a grass tile. Anyone can move here.");
                if(scouter.strLv == -1) {
                	scouter.resetStr();
                	System.out.println(scouter.getAnimalName() + "'s Strength restored to " + scouter.getLevel());
                }
                break;
            case 'R':
                System.out.println("This is a river tile. Can ya swim?");
                if (scouter.getSwimType() != "none") {
                    System.out.println("Looks like " + scouter.getAnimalName() + " can swim after all!");
                    //IMPLEMENT A METHOD THAT TELEPORTS IF TIGER OR LION
                    if(scouter.getSwimType() == "cross") {
                    	System.out.println("Attempting to cross...");
                    	validity = 2;
                    }
                } else {
                    System.out.println("Doesn't look like " + scouter.getAnimalName() + " knows how to swim!");
                    validity = -1;
                }
                break;
            case 'T':
                //trap tiles in the player 1 side
            	if(this.xpos <= 1) {
                	if(scouter.owner.playerID == 2) {
                		weakenAnimal(scouter);
                	}
                }else if(this.xpos >= 7) {
                	if(scouter.owner.playerID == 1) {
                		weakenAnimal(scouter);
                	}
                }
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
        } else if (validity == 2){
        	System.out.println("Let's see if your " + scouter.getAnimalName() + " can cross the river");
        }
        else {
            System.out.println("Sorry, you can't move here!");
        }

        return validity;
    }

    /*
     * This method checks if the aenimal can move to the tile, if its free, obstructed or battle
     * @return occupation
     */
    public char scoutTile(Animal scouter) {
        char occupation = 'n';
        //System.out.println("Debug: scoutTile called for scouter " + scouter.getAnimalName());
		//System.out.println("Debug: Defender Name is" + defender.getAnimalName()+"PlayerID"+ defender.owner.playerID);
        if (defender == null) {
            //System.out.println("Debug: Defender is null. Tile is open.");
            occupation = 'o';
        } else if (defender != null && defender.owner.playerID == scouter.owner.playerID) {
            //System.out.println("Debug: Tile is obstructed by ally.");
            occupation = 'b';	//edit this
        } else if (defender != null && scouter.owner.playerID != defender.owner.playerID && this.tileType != 'R') {
            //System.out.println("Debug: Enemy defender detected. Setting attacker.");
            setAttacker(scouter); // Use setAttacker
            occupation = 'e';
            if (defender.getLevel() > scouter.getLevel()) {
                //System.out.println("Debug: Defender is stronger.");
            } else {
                //System.out.println("Debug: Attacker is stronger. Initiating battle.");
            }
            //battle(occupation);
        } else if(defender != null && this.tileType == 'R') {
        	System.out.println("No fighting in the river!");
        	occupation = 'b';
        }
        return occupation;
    }
/*
 * This method is for the animals battling and compares their strenght level to see who is victorious
 * @return battleWinner
 */
	public int battle() {
		//System.out.println("Debug: battle called between " + this.attacker.getAnimalName() + " and " + this.defender.getAnimalName());
		int battleWinner = 0;
		//get the strength difference between the two animals
		
		int strengthDiff = Math.abs(attacker.getLevel() - defender.getLevel());
		System.out.println("Attacker str: " + attacker.getLevel());
		System.out.println("Defender str: " + defender.getLevel());
		System.out.println("Strength difference: " + strengthDiff);
		
		//the only strength difference of exactly 7 is between rat and elephant
		//additional condition: must not be on a Trap tile
		if(strengthDiff == 7 && this.tileType != 'T') {
			if(attacker.getAnimalName() == "Rat") { //rat attacking elephant
				battleWinner = attacker.owner.playerID;
				defender.owner.removeAnimal(defender); // Remove the defender from the game
	            clearDefender(defender); // Clear the defender from the tile
				defender = attacker; // Attacker becomes the new defender
				clearAttacker(attacker); // Clear the attacker field
			}else if(defender.getAnimalName() == "Rat") { //rat defending against elephant
				battleWinner = defender.owner.playerID;
				battleWinner = defender.owner.playerID;
				attacker.owner.removeAnimal(attacker);
			}
		}else{//all other battles between animals NOT involving rats and elephants
			if (attacker.getLevel() >= defender.getLevel()) {
				// Attacker wins
				battleWinner = attacker.owner.playerID;
				defender.owner.removeAnimal(defender); // Remove the defender from the game
	            clearDefender(defender); // Clear the defender from the tile
				defender = attacker; // Attacker becomes the new defender
				clearAttacker(attacker); // Clear the attacker field
			} else {
				// Defender wins
				battleWinner = defender.owner.playerID;
				attacker.owner.removeAnimal(attacker);
			}
		}
		return battleWinner;
	}
/*
 * This method sets the winstate to the player that captures the base
 * @param myAnimal - Animal that captured the homebase
 */
    public void baseCaptured(Animal myAnimal) {
        myAnimal.owner.setWinState(1);
        System.out.println("Player " + myAnimal.owner.playerID + " wins!");
    }

    
    /*
     * This method sets the tile to its original status
     */
    public void SetOriginalStatus() {
        this.status = this.tileType;
    }
    /*
     * This method weakens the animal if it has been trapped
     * @param scouter - Animal that got trapped
     */
    public void weakenAnimal(Animal scouter) {
    	System.out.println("Trapped! Your " + scouter.getAnimalName() + " has been weakened.");
        scouter.strLv = -1;
        System.out.println(scouter.getAnimalName() + " strLV: " + scouter.strLv);
    }
}