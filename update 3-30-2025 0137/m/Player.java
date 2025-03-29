package m;
import java.util.Scanner;

public class Player {
	Room room;
	int playerID;
	private int winState = 0;
	
	 Animal[] myAnimals;
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
	
	public Animal getSelectedAnimal() {
		return this.selectedAnimal;
	}
	
	public void initializeAnimals(int pID) {
		int totalAnimals = 8; //total number of animals for the myAnimals array
		this.myAnimals = new Animal[] {
				
				/*new Elephant("Elephant", "none", 'e', false),
	            new Wolf("Wolf", "none", 'w', false),
	            new Leopard("Leopard", "none", 'l', false),
	            new Rat("Rat", "swim", 'r', false),
	            new Cat("Cat", "none", 'c', false),
	            new Dog("Dog", "none", 'd', false),
	            new Tiger("Tiger", "cross", 't', false),
	            new Lion("Lion", "cross", 'k', false)*/
				
				//TEST BUILD
				new Elephant("Elephant", "none", 'e', false),
	            new Wolf("Wolf", "none", 'w', false),
	            new Lion("Lion", "cross", 'k', false),
	            new Rat("Rat", "swim", 'r', false),
	            new Cat("Cat", "none", 'c', false),
	            new Dog("Dog", "none", 'd', false),
	            new Tiger("Tiger", "cross", 't', false),
	            new Leopard("Leopard", "none", 'l', false)
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
			//System.out.println("Initiating vanguard placement...");
			for(int i = 0; i < 8; i++) {
				if(i < 4) {
					myAnimals[animalIndex].xpos = colNum;
					myAnimals[animalIndex].ypos = rowNum;
					room.tiles[rowNum][colNum].status = myAnimals[animalIndex].getAnimalToken();
					room.tiles[rowNum][colNum].setDefender(myAnimals[animalIndex]);
					System.out.println(myAnimals[animalIndex].getAnimalName() + " positioned at column " + myAnimals[animalIndex].xpos + ", row " + myAnimals[animalIndex].ypos);
					rowNum+=2; //moves down 2 positions for the next animal
					animalIndex++; //next animal placement
					if(i == 3) {rowNum = 1;} //reset rowNum to 0 when the 4th animal is placed
				}
				
				if(i >= 4 && i < 6) {
					System.out.println("Initiating middle guard placement...");
					colNum = 1;
					myAnimals[animalIndex].xpos = colNum;
					myAnimals[animalIndex].ypos = rowNum;
					room.tiles[rowNum][colNum].status = myAnimals[animalIndex].getAnimalToken();
					room.tiles[rowNum][colNum].setDefender(myAnimals[animalIndex]);
					System.out.println(myAnimals[animalIndex].getAnimalName() + " positioned at column " + myAnimals[animalIndex].xpos + ", row " + myAnimals[animalIndex].ypos);
					rowNum+=4;
					animalIndex++;
					if(i==5) {rowNum=0;}
				}
				
				if(i >= 6) {
					System.out.println("Initiating rear guard placement...");
					colNum = 0;
					myAnimals[animalIndex].xpos = colNum;
					myAnimals[animalIndex].ypos = rowNum;
					room.tiles[rowNum][colNum].status = myAnimals[animalIndex].getAnimalToken();
					room.tiles[rowNum][colNum].setDefender(myAnimals[animalIndex]);
					System.out.println(myAnimals[animalIndex].getAnimalName() + " positioned at column " + myAnimals[animalIndex].xpos + ", row " + myAnimals[animalIndex].ypos);
					rowNum+=6;
					animalIndex++;
				}
			}
			
		}
		else if(pID == 2) {
            int animalIndex = 0; //indices of the animals in the myAnimal array

            int rowNum = 6; //starts at row 0
            int colNum = 6; //starts at column 3
            //position the first 4 animals
            //System.out.println("Initiating vanguard placement...");
            for(int i = 0; i < 8; i++) {
                //System.out.println("Current animal index: " + animalIndex);
            	if(i < 4) {
	                myAnimals[animalIndex].xpos = colNum;
	                myAnimals[animalIndex].ypos = rowNum;
	                room.tiles[rowNum][colNum].status = myAnimals[animalIndex].getAnimalToken();
					room.tiles[rowNum][colNum].setDefender(myAnimals[animalIndex]);
	                //System.out.println(myAnimals[animalIndex].getAnimalName() + " positioned at column " + myAnimals[animalIndex].xpos + ", row " + myAnimals[animalIndex].ypos);
	                rowNum-=2; //moves left 2 positions for the next animal
	                animalIndex++; //next animal placement
	                if(i == 3) {rowNum = 5;} //reset rowNum to 0 when the 4th animal is placed
            	}
                if(i >= 4 && i < 6) {
					System.out.println("Initiating middle guard placement...");
					colNum = 7;
					myAnimals[animalIndex].xpos = colNum;
					myAnimals[animalIndex].ypos = rowNum;
					room.tiles[rowNum][colNum].status = myAnimals[animalIndex].getAnimalToken();
					room.tiles[rowNum][colNum].setDefender(myAnimals[animalIndex]);
					System.out.println(myAnimals[animalIndex].getAnimalName() + " positioned at column " + myAnimals[animalIndex].xpos + ", row " + myAnimals[animalIndex].ypos);
					rowNum-=4;
					animalIndex++;
					if(i==5) {rowNum=6;}
				}
				
				if(i >= 6) {
					System.out.println("Initiating rear guard placement...");
					colNum = 8;
					myAnimals[animalIndex].xpos = colNum;
					myAnimals[animalIndex].ypos = rowNum;
					room.tiles[rowNum][colNum].status = myAnimals[animalIndex].getAnimalToken();
					room.tiles[rowNum][colNum].setDefender(myAnimals[animalIndex]);
					System.out.println(myAnimals[animalIndex].getAnimalName() + " positioned at column " + myAnimals[animalIndex].xpos + ", row " + myAnimals[animalIndex].ypos);
					rowNum-=6;
					animalIndex++;
				}
			}
        }
	}
	
	public void setRoom(Room r) {
		this.room = r;
	}
	
	/*public void selectAnimal() {
		System.out.println("Select an animal to move: ");
		System.out.println(" 1 - Elephant \t 2 - Wolf \t 3 - Lion");
		System.out.println(" 4 - Rat \t 5 - Cat \t 6 - Dog");
		System.out.println(" 7 - Tiger \t 8 - Leopard");
		System.out.println("Press 9 to Return.");
		
		Scanner myObj = new Scanner(System.in);
		//int index = myObj.nextInt();
		int index = -1;
		boolean confirmed = false;
		while(!confirmed) {
			 index = myObj.nextInt();
			switch(index) {
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
					if(index - 1 >= 0 && index - 1 < myAnimals.length && myAnimals[index - 1] != null) {	//infinite loop
						index = index - 1;
						confirmed = true;
					}else{
						System.out.println("That Animal is Dead");
					}
					break;
				case 9:
					confirmed = true;
					break;
				default:
					System.out.println("Invalid input. Try Again.");
					confirmed = false;
			}
		} //while(confirmed == false);
		//TO DO implement for when selected animal is still null
		
		selectedAnimal = myAnimals[index];
		System.out.println("You have selected " + selectedAnimal.getAnimalName());
		moveAnimal();
		
	}*/
	
	
	
	public boolean controllerSelect(int input) {
		
		boolean confirmed = false;
		System.out.println("Animal index selected: " + input);
		switch(input) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				if(input  >= 0 && input  < myAnimals.length && myAnimals[input] != null) {	//infinite loop
					confirmed = true;
				}else{
					System.out.println("That Animal is Dead");
					confirmed = false;
				}
				break;
			default:
				System.out.println("Invalid input. Try Again.");
				confirmed = false;
			}
		selectedAnimal = myAnimals[input];
		return confirmed;
	}
	public boolean controllerMove(char input) {
		int currentX = selectedAnimal.xpos;
		int currentY = selectedAnimal.ypos;
		int previousX = selectedAnimal.xpos;
		int previousY = selectedAnimal.ypos;
		boolean verified = false;
		
		switch(input) {
			case 'w':
				verified = verifyUp(verified, currentY, currentX, previousY, previousX);
				break;
			case 'a':
				verified = verifyLeft(verified, currentY, currentX, previousY, previousX);
				break;
			case 's':
				verified = verifyDown(verified, currentY, currentX, previousY, previousX);
				break;
			case 'd':
				verified = verifyRight(verified, currentY, currentX, previousY, previousX);
				break;
			case 'x':
				verified = false;
				break;
			default:
				System.out.println("Try again!");
				verified = false;
		}
		
		if(verified == true) {
			System.out.println("Movement successful");
			return true;
		}else {
			System.out.println("Let's try that one again!.");
			return false;
		}
	}
	
	public void reset() {
		selectedAnimal = null;
	}
	
	/*public void moveAnimal() {
		System.out.println("w - move up \t s - move down");
		System.out.println("a - move left \t d - move right");
		System.out.println("x - return to animal select");
		System.out.println("Currently selected animal: " + this.selectedAnimal.getAnimalName());
		Scanner myStr = new Scanner(System.in);
		String input = myStr.nextLine();
		//System.out.println("LIVE VERSION");
		int currentX = selectedAnimal.xpos;
		int currentY = selectedAnimal.ypos;
		int previousX = selectedAnimal.xpos;
		int previousY = selectedAnimal.ypos;
		boolean verified = false;
		
		switch(input) {
			case "w":
				verified = verifyUp(verified, currentY, currentX, previousY, previousX);
				break;
			case "a":
				verified = verifyLeft(verified, currentY, currentX, previousY, previousX);
				break;
			case "s":
				verified = verifyDown(verified, currentY, currentX, previousY, previousX);
				break;
			case "d":
				verified = verifyRight(verified, currentY, currentX, previousY, previousX);
				break;
			case "x":
				verified = false;
				break;
			default:
				System.out.println("Try again!");
				verified = false;
		}
		
		if(verified == true) {
			endTurn();
		}else {
			System.out.println("Let's try that one again!.");
			returnToSelect(selectedAnimal);
		}
		
	}*/
	
	private boolean verifyRight(boolean verified, int currentY, int currentX, int previousY, int previousX) {
		char result;
    	int canMove = 0;
    	int openSpaces = 0;
		currentX++;
		if(previousX < room.cols - 1)
		{
		canMove = room.tiles[currentY][currentX].checkTile(selectedAnimal);
		}
		if(canMove == 1) {
			result = room.tiles[currentY][currentX].scoutTile(selectedAnimal);
			//System.out.println("OUTPUT HERE!"+result);
			if(result == 'o')
			{
				room.tiles[previousY][previousX].clearDefender(selectedAnimal);
				moveRight(); //STEP 4 - MOVE FROM CURRENT SPACE TO NEW SPACE
				room.tiles[currentY][currentX].setDefender(selectedAnimal);
				verified = true;
			}
			else if(result == 'e') {
				room.tiles[previousY][previousX].clearDefender(selectedAnimal);
				System.out.println(room.tiles[currentY][currentX].attacker.getAnimalName() + room.tiles[currentY][currentX].attacker.owner.playerID + " is attacking");
				int battleResult = room.tiles[currentY][currentX].battle();
				if(battleResult == this.playerID) {
					System.out.println("You won!");
					moveRight();
				}else {
					System.out.println("Your animal has died.");
				}
				verified = true;
			}else if(result == 'b') {
				verified = false;
			}
		}else if(canMove == 2) { //crossing a river with lion or tiger
			//check 4 spaces left to see if they are all open
			for(int i = 0; i < 4; i++) { //must successfully
				result = room.tiles[currentY][currentX].scoutTile(selectedAnimal);
				if(result == 'o') {
					System.out.println("Row " + currentY + ", column " + currentX + "open");
					openSpaces++;}
				if(i < 3) {currentX++;}
			}
			if(openSpaces == 4) {
				System.out.println("Current Y " + currentY);
				room.tiles[previousY][previousX].clearDefender(selectedAnimal);
				moveRight(); //STEP 4 - MOVE FROM CURRENT SPACE TO NEW SPACE
				moveRight();
				moveRight();
				moveRight();
				room.tiles[currentY][currentX].setDefender(selectedAnimal);
				System.out.println("Complete");
				verified = true;
			}else {
				System.out.println("Can't cross!");
				verified = false;
			}
		}else{
			verified = false;
		}
		return verified;
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
    private boolean verifyLeft(boolean verified, int currentY, int currentX, int previousY, int previousX) {
    	char result;
    	int canMove = 0;
    	int openSpaces = 0;
    	currentX--;
		if(previousX > 0)
		{
		canMove = room.tiles[currentY][currentX].checkTile(selectedAnimal);
		}
		//room.tiles[currentY][currentX].checkTile(selectedAnimal);
		if(canMove == 1) {
			result = room.tiles[currentY][currentX].scoutTile(selectedAnimal);
			//System.out.println("OUTPUT HERE!"+result);
			if(result == 'o')
			{
				room.tiles[previousY][previousX].clearDefender(selectedAnimal);
				moveLeft(); //STEP 4 - MOVE FROM CURRENT SPACE TO NEW SPACE
				room.tiles[currentY][currentX].setDefender(selectedAnimal);
				verified = true;
			}
			else if(result == 'e') {
				room.tiles[previousY][previousX].clearDefender(selectedAnimal);
				System.out.println(room.tiles[currentY][currentX].attacker.getAnimalName() + room.tiles[currentY][currentX].attacker.owner.playerID + " is attacking");
				int battleResult = room.tiles[currentY][currentX].battle();
				if(battleResult == this.playerID) {
					System.out.println("You won!");
					moveLeft();
				}else {
					System.out.println("Your animal has died.");
				}
				verified = true;
			}else if(result == 'b') {
				verified = false;
			}
		}else if(canMove == 2) { //crossing a river with lion or tiger
			//check 4 spaces left to see if they are all open
			for(int i = 0; i < 4; i++) { //must successfully
				result = room.tiles[currentY][currentX].scoutTile(selectedAnimal);
				if(result == 'o') {
					System.out.println("Row " + currentY + ", column " + currentX + "open");
					openSpaces++;}
				if(i < 3) {currentX--;}
			}
			if(openSpaces == 4) {
				System.out.println("Current Y " + currentY);
				room.tiles[previousY][previousX].clearDefender(selectedAnimal);
				moveLeft(); //STEP 4 - MOVE FROM CURRENT SPACE TO NEW SPACE
				moveLeft();
				moveLeft();
				moveLeft();
				room.tiles[currentY][currentX].setDefender(selectedAnimal);
				System.out.println("Complete");
				verified = true;
			}else {
				System.out.println("Can't cross!");
				verified = false;
			}
		}else{
			verified = false;
		}
    	return verified;
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
    
    private boolean verifyUp(boolean verified, int currentY, int currentX, int previousY, int previousX) {
    	char result;
    	int canMove = 0;
    	int openSpaces = 0;
    	
    	currentY--; //STEP 1 SCOUT ONE TILE ABOVE
    	if(previousY > 0)
		{ 
			canMove = room.tiles[currentY][currentX].checkTile(selectedAnimal); //STEP 2 CHECK THE TILE ABOVE SELECTED ANIMAL
		}
		//STEP 3 BATTLE IF NECESSARY - TO DO
		if(canMove == 1) {
			result = room.tiles[currentY][currentX].scoutTile(selectedAnimal);
			//System.out.println("OUTPUT HERE!"+result);
			if(result == 'o')
			{
				room.tiles[previousY][previousX].clearDefender(selectedAnimal);
				moveUp(); //STEP 4 - MOVE FROM CURRENT SPACE TO NEW SPACE
				room.tiles[currentY][currentX].setDefender(selectedAnimal);
				verified = true;
			}
			else if(result == 'e') {
				room.tiles[previousY][previousX].clearDefender(selectedAnimal);
				System.out.println(room.tiles[currentY][currentX].attacker.getAnimalName() + room.tiles[currentY][currentX].attacker.owner.playerID + " is attacking");
				int battleResult = room.tiles[currentY][currentX].battle();
				if(battleResult == this.playerID) {
					System.out.println("You won!");
					moveUp();
				}else {
					System.out.println("Your animal has died.");
				}
				verified = true;
			}else if(result == 'b') {
				verified = false;
			}
		}else if(canMove == 2) { //crossing a river with lion or tiger
			//check 3 spaces above to see if they are all open
			for(int i = 0; i < 3; i++) { //must successfully
				result = room.tiles[currentY][currentX].scoutTile(selectedAnimal);
				if(result == 'o') {
					System.out.println("Row " + currentY + ", column " + currentX + "open");
					openSpaces++;}
				if(i < 2) {currentY--;}
			}
			if(openSpaces == 3) {
				System.out.println("Current Y " + currentY);
				room.tiles[previousY][previousX].clearDefender(selectedAnimal);
				moveUp(); //STEP 4 - MOVE FROM CURRENT SPACE TO NEW SPACE
				moveUp();
				moveUp();
				room.tiles[currentY][currentX].setDefender(selectedAnimal);
				System.out.println("Complete");
				verified = true;
			}else {
				System.out.println("Can't cross!");
				verified = false;
			}
		}else{
			verified = false;
		}
    	return verified;
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
    
    private boolean verifyDown(boolean verified, int currentY, int currentX, int previousY, int previousX) {
    	char result;
    	int canMove = 0;
    	int openSpaces = 0;
    	
    	currentY++;
		if(previousY < room.rows - 1)
		{
		canMove = room.tiles[currentY][currentX].checkTile(selectedAnimal);
		}
		//room.tiles[currentY][currentX].checkTile(selectedAnimal);
		if(canMove == 1) {
			result = room.tiles[currentY][currentX].scoutTile(selectedAnimal);
			//System.out.println("OUTPUT HERE!"+result);
			if(result == 'o')
			{
				room.tiles[previousY][previousX].clearDefender(selectedAnimal);
				moveDown(); //STEP 4 - MOVE FROM CURRENT SPACE TO NEW SPACE
				room.tiles[currentY][currentX].setDefender(selectedAnimal);
				verified = true;
			}
			else if(result == 'e') {
				room.tiles[previousY][previousX].clearDefender(selectedAnimal);
				System.out.println(room.tiles[currentY][currentX].attacker.getAnimalName() + room.tiles[currentY][currentX].attacker.owner.playerID + " is attacking");
				int battleResult = room.tiles[currentY][currentX].battle();
				if(battleResult == this.playerID) {
					System.out.println("You won!");
					moveDown();
				}else {
					System.out.println("Your animal has died.");
				}
				verified = true;
			}else if(result == 'b') {
				verified = false;
			}
		}else if(canMove == 2) { //crossing a river with lion or tiger
			//check 3 spaces below to see if they are all open
			for(int i = 0; i < 3; i++) { //must successfully
				result = room.tiles[currentY][currentX].scoutTile(selectedAnimal);
				if(result == 'o') {
					System.out.println("Row " + currentY + ", column " + currentX + "open");
					openSpaces++;}
				if(i < 2) {currentY++;}
			}
			if(openSpaces == 3) {
				System.out.println("Current Y " + currentY);
				room.tiles[previousY][previousX].clearDefender(selectedAnimal);
				moveDown(); //STEP 4 - MOVE FROM CURRENT SPACE TO NEW SPACE
				moveDown();
				moveDown();
				room.tiles[currentY][currentX].setDefender(selectedAnimal);
				System.out.println("Complete");
				verified = true;
			}else {
				System.out.println("Can't cross!");
				verified = false;
			}
		}else{
			verified = false;
		}
    	return verified;
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
	
	public void returnToSelect(Animal selectedAnimal) {
		System.out.println("Returning to animal select...");
		selectedAnimal = null;
	//	selectAnimal();
	}

	// FINAL DONT
	public void removeAnimal(Animal deadAnimal) {
		for (int i = 0; i < this.myAnimals.length; i++) {
			if (this.myAnimals[i] == deadAnimal) {
				System.out.println("Player " + this.playerID + "'s " + deadAnimal.getAnimalName() + " has been defeated!");
				this.myAnimals[i] = null; // remove animal from list
				deadAnimal = null;		  // completely remove animal
				break;
			}
		}
	}
	
}