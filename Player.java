package javaprac;

import java.util.Scanner;

public class Player {
	Room room;
	int playerID;
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
	
	public void initializeAnimals(int pID) {
		int totalAnimals = 4; //total number of animals for the myAnimals array
		this.myAnimals = new Animal[] {	
	            new Elephant("Elephant", false, 'e'),
	            new Wolf("Wolf", false, 'w'),
	            new Leopard("Leopard", false, 'l'),
	            new Rat("Rat", true, 'r')
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
			for(int i = 0; i < 4; i++) {
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
	}
	
	public void setRoom(Room r) {
		this.room = r;
	}
	
	public void selectAnimal() {
		System.out.println("Select an animal to move: ");
		System.out.println(" 1 - Elephant \t 2 - Wolf \t 3 - Leopard");
		System.out.println(" 4 - Rat \t 5 - Cat \t 6 - Dog");
		System.out.println(" 7 - Tiger \t 8 - Lion");
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
					if(myAnimals[index-1].captured == false || myAnimals[index-1] != null) {
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
		System.out.println("Currently selected animal: " + this.selectedAnimal.getAnimalName());
		Scanner myStr = new Scanner(System.in);
		String input = myStr.nextLine();
		do{
			switch(input) {
				case "w":
					moveUp();
					input = "y";
					break;
				case "a":
					moveLeft();
					input = "y";
					break;
				case "s":
					moveDown();
					input = "y";
					break;
				case "d":
					moveRight();
					input = "y";
					break;
				default:
					input = "X";
			}
		}while(input == "y");
		myStr.close(); 
		//this.room.getTiles();
		
	}

    public void moveRight() {
        if (selectedAnimal.ypos <= room.rows - 1 && selectedAnimal.ypos >= 0) {
            if (selectedAnimal.xpos != room.cols - 1) {
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
        if (selectedAnimal.ypos <= room.cols && selectedAnimal.ypos >= 0) {
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
		this.turnActive = false;
	}
	
}
