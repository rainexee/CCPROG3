package javaprac;

import java.util.Scanner;

public class Player {
	Room room;
	int playerID;
	private int winState = 0;
	
	private Animal[] myAnimals;
	private Animal selectedAnimal;
	
	boolean turnActive;
	
	
	public Player(int pID, Room room) {
		this.playerID = pID;
		this.room = room;
		System.out.println("Room id: " + room.roomID);
		//initialize the player's pieces to their respective roster
		initializeAnimals(this.playerID);
		System.out.println("Welcome, Player" + this.playerID);
	}
	
	public int getWinState() {
		return this.winState;
	}
	
	public int setWinState(int winner) {
		return this.winState = winner;
	}
	
	public void initializeAnimals(int pID) {
		int totalAnimals = 2; //total number of animals for the myAnimals array
		this.myAnimals = new Animal[] {	
	            new Leopard("Leopard", false, 'l'),
	            new Rat("Rat", true, 'r')
				
				/*new Elephant("Elephant", false, 'e'),
	            new Wolf("Wolf", false, 'w'),
	            new Leopard("Leopard", false, 'l'),
	            new Rat("Rat", true, 'r')*/
	            //new Cat
	            //new Dog
	            //new Tiger
	            //new Lion
	        };
		//assigns all newly created animals to the player
		for(int i = 0; i < totalAnimals; i++) {
			myAnimals[i].setPlayer(this);//assigns current animal to player
			System.out.println(myAnimals[i].getAnimalName() + " assigned to Player " + this.playerID); //confirms animal assignment
		}
		
		//assign each animal's initial position on the board
			
		if(pID == 1) {
			//start at the vanguard
			int animalIndex = 0; //indices of the animals in the myAnimal array
			
			int rowNum = 0; //starts at row 0
			int colNum = 2; //starts at column 3
			//position the first 4 animals
			System.out.println("Initiating vanguard placement...");
			for(int i = 0; i < 2; i++) {
				System.out.println("Current animal index: " + animalIndex);
				myAnimals[animalIndex].xpos = colNum;
				myAnimals[animalIndex].ypos = rowNum;
				room.tiles[rowNum][colNum].status = myAnimals[animalIndex].getAnimalToken();
				System.out.println(myAnimals[animalIndex].getAnimalName() + " positioned at column " + myAnimals[animalIndex].xpos + ", row " + myAnimals[animalIndex].ypos);
				rowNum+=2; //moves down 2 positions for the next animal
				animalIndex++; //next animal placement
			}
			
			
			
			///TO DO!!
			System.out.println("Initiating middle guard placement...");
			
			System.out.println("Current animal index: " + animalIndex);
			
		}
		else if(pID == 2) {
            int animalIndex = 0; //indices of the animals in the myAnimal array

            int rowNum = 6; //starts at row 0
            int colNum = 6; //starts at column 3
            //position the first 4 animals
            System.out.println("Initiating vanguard placement...");
            for(int i = 0; i < 2; i++) {
                System.out.println("Current animal index: " + animalIndex);
                myAnimals[animalIndex].xpos = colNum;
                myAnimals[animalIndex].ypos = rowNum;
                room.tiles[rowNum][colNum].status = myAnimals[animalIndex].getAnimalToken();
                System.out.println(myAnimals[animalIndex].getAnimalName() + " positioned at column " + myAnimals[animalIndex].xpos + ", row " + myAnimals[animalIndex].ypos);
                rowNum-=2; //moves left 2 positions for the next animal
                animalIndex++; //next animal placement
            }
                //System.out.println("CURRENT OWNER: "+ myAnimals[animalIndex].owner);
        }
	}
	
	public void setRoom(Room r) {
		this.room = r;
	}
	
	public void selectAnimal() {
		/*System.out.println("Select an animal to move: ");
		System.out.println(" 1 - Elephant \t 2 - Wolf \t 3 - Leopard");
		System.out.println(" 4 - Rat \t 5 - Cat \t 6 - Dog");
		System.out.println(" 7 - Tiger \t 8 - Lion");
		System.out.println("Press 9 to Return.");*/
		
		System.out.println("Select an animal to move: ");
		System.out.println(" 1 - Leopard \t 2 - Rat");
		System.out.println("Press 9 to Return.");
		
		Scanner myObj = new Scanner(System.in);
		int index = myObj.nextInt();
		boolean confirmed = false;
		do {
			switch(index) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
					if(myAnimals[index-1].captured == false && myAnimals[index-1] != null) {
						index = index - 1;
						confirmed = true;
					}else{
						System.out.println(myAnimals[index - 1].getAnimalName() + " is not available");
					}
					break;
				case 9:
					confirmed = true;
					break;
				default:
					System.out.println("Invalid input. Try Again.");
					confirmed = false;
			}
		} while(confirmed == false);
		//TO DO implement for when selected animal is still null
		
		selectedAnimal = myAnimals[index];
		System.out.println("You have selected " + selectedAnimal.getAnimalName());
		moveAnimal();
		
	}
	
	public void moveAnimal() {
		System.out.println("w - move up \t s - move down");
		System.out.println("a - move left \t d - move right");
		System.out.println("x - return to animal select");
		System.out.println("Currently selected animal: " + this.selectedAnimal.getAnimalName());
		Scanner myStr = new Scanner(System.in);
		String input = myStr.nextLine();
		
		int currentX = selectedAnimal.xpos;
		int currentY = selectedAnimal.ypos;
		int canMove = 0;
		
		do{
			switch(input) {
				case "w":
					currentY--; //STEP 1 SCOUT ONE TILE ABOVE
					canMove = room.tiles[currentY][currentX].checkTile(selectedAnimal); //STEP 2 CHECK THE TILE ABOVE SELECTED ANIMAL
					//STEP 3 BATTLE IF NECESSARY - TO DO
					if(canMove == 1) {
						moveUp(); //STEP 4 - MOVE FROM CURRENT SPACE TO NEW SPACE
						input = "y";
					}else {
						input = "x";
					}
					break;
				case "a":
					currentX--;
					canMove = room.tiles[currentY][currentX].checkTile(selectedAnimal);
					//room.tiles[currentY][currentX].checkTile(selectedAnimal);
					if(canMove == 1) {
						moveLeft(); //STEP 4 - MOVE FROM CURRENT SPACE TO NEW SPACE
						input = "y";
					}else {
						input = "x";
					}
					break;
				case "s":
					currentY++;
					canMove = room.tiles[currentY][currentX].checkTile(selectedAnimal);
					//room.tiles[currentY][currentX].checkTile(selectedAnimal);
					if(canMove == 1) {
						moveDown(); //STEP 4 - MOVE FROM CURRENT SPACE TO NEW SPACE
						input = "y";
					}else {
						input = "x";
					}
					break;
				case "d":
					currentX++;
					canMove = room.tiles[currentY][currentX].checkTile(selectedAnimal);
					//room.tiles[currentY][currentX].checkTile(selectedAnimal);
					if(canMove == 1) {
						moveRight(); //STEP 4 - MOVE FROM CURRENT SPACE TO NEW SPACE
						input = "y";
					}else {
						input = "x";
					}
					break;
				case "x":
					returnToSelect(input, selectedAnimal);
					input = "y";
					break;
				default:
					input = "X";
			}
		}while(input != "y");
		endTurn();
		//this.room.getTiles();
		
	}

    public void moveRight() {
    	//STEP 1 - animal position should not be at LEFT or RIGHT borders
    	if (selectedAnimal.xpos <= room.cols - 1 && selectedAnimal.xpos >= 0) {
            //STEP 2 - animal position should not be at right border
    		if (selectedAnimal.xpos != room.cols - 1) {
            	//STEP 3 - selected animal's current tile returns to original status
    			room.tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = room.tiles[selectedAnimal.ypos][selectedAnimal.xpos].tileType;
                selectedAnimal.xpos++;
                //checkTile(selectedAnimal.ypos, selectedAnimal.xpos);
                room.tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = selectedAnimal.getAnimalToken();
                System.out.println();
                room.getTiles();
            } else {
                System.out.println("Destination out of bounds");
                selectedAnimal.ypos = selectedAnimal.ypos;
            }
        }
    }

    public void moveLeft() {
        if (selectedAnimal.xpos <= room.cols && selectedAnimal.xpos >= 0) {
            if (selectedAnimal.xpos != 0) {
            	room.tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = room.tiles[selectedAnimal.ypos][selectedAnimal.xpos].tileType;
                selectedAnimal.xpos--;
                //checkTile(selectedAnimal.ypos, selectedAnimal.xpos);
                room.tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = selectedAnimal.getAnimalToken();
                System.out.println();
                room.getTiles();
            } else {
                System.out.println("Destination out of bounds");
                selectedAnimal.ypos = selectedAnimal.ypos;
            }
        }
    }

    public void moveUp() {
        if (selectedAnimal.ypos <= room.rows && selectedAnimal.ypos >= 0) {
            if (selectedAnimal.ypos != 0) {
            	room.tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = room.tiles[selectedAnimal.ypos][selectedAnimal.xpos].tileType;
                selectedAnimal.ypos--;
                //checkTile(selectedAnimal.ypos, selectedAnimal.xpos);
                room.tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = selectedAnimal.getAnimalToken();
                System.out.println();
                room.getTiles();
            } else {
                System.out.println("Destination out of bounds");
                selectedAnimal.ypos = selectedAnimal.ypos;
            }
        }
    }

    public void moveDown() {
        if (selectedAnimal.ypos <= room.rows && selectedAnimal.ypos >= 0) {
            if (selectedAnimal.ypos != room.rows - 1) {
            	room.tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = room.tiles[selectedAnimal.ypos][selectedAnimal.xpos].tileType;
                selectedAnimal.ypos++;
                //checkTile(selectedAnimal.ypos, selectedAnimal.xpos);
                room.tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = selectedAnimal.getAnimalToken();
                System.out.println();
                room.getTiles();
            } else {
                System.out.println("Destination out of bounds");
                selectedAnimal.ypos = selectedAnimal.ypos;
            }
        }
    }
	
	public void endTurn() {
		System.out.println("Player " + this.playerID + "'s turn is over.");
		this.selectedAnimal = null;
		this.turnActive = false;
		this.room.getTiles();
		
		if(this.playerID == 1) {
			room.getPlayer(2).turnActive = true;
		}else{
			room.getPlayer(1).turnActive = true;
		}
	}
	
	public void returnToSelect(String input, Animal selectedAnimal) {
		System.out.println("Returning to animal select...");
		selectedAnimal = null;
		selectAnimal();
		input = "y";
	}
	
}
