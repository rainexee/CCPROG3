package javaprac;

public class Room {
	
	int i, j;
	int rows = 7;
	int cols = 9;
	private Tile[][] tiles;
	Person myPerson;
	Person enemy;
	
	public Room() {
		tiles = new Tile[rows][cols];
		initializeTiles();
		initializePerson();
		initializeEnemy();
	}
	
	private void initializeTiles() {
		for(i = 0; i < rows; i++) {
			for(j = 0; j < cols; j++) {
				tiles[i][j] = new Tile(i, j);
				tiles[i][j].status = '_';
				tiles[i][j].tileType = tiles[i][j].status;
			}
			System.out.println("Row complete, next row");
		}
		
		//RIVER TILE INITIALIZATION
		for(i = 1; i < 3; i++) {
			for(j = 3; j < 6; j++) {tiles[i][j].status = 'R'; tiles[i][j].tileType = tiles[i][j].status;}}
		for(i = 4; i < 6; i++) {
			for(j = 3; j < 6; j++) {tiles[i][j].status = 'R'; tiles[i][j].tileType = tiles[i][j].status;}}
		
		//TRAP TILE INITIALIZATION
		tiles[2][0].status = 'T'; tiles[2][0].tileType = tiles[2][0].status;
		tiles[2][cols - 1].status = 'T'; tiles[2][cols - 1].tileType = tiles[2][cols - 1].status;
		
		tiles[3][1].status = 'T'; tiles[3][1].tileType = tiles[3][1].status;
		tiles[3][cols - 2].status = 'T'; tiles[3][cols - 2].tileType = tiles[3][cols - 2].status;
		tiles[4][0].status = 'T'; tiles[4][0].tileType = tiles[4][0].status;
		tiles[4][cols - 1].status = 'T'; tiles[4][cols - 1].tileType = tiles[4][cols - 1].status;
		
		//HOME TILE INITIALIZATION
		tiles[3][0].status = 'H'; tiles[3][0].tileType = tiles[3][0].status;
		tiles[3][cols - 1].status = 'H'; tiles[3][cols - 1].tileType = tiles[3][cols - 1].status;
		
		
	}
	
	private void initializePerson() {
		myPerson = new Person("John", 21);
		myPerson.xpos = 0;
		myPerson.ypos = 0;
		myPerson.strLv = 3;
		tiles[myPerson.ypos][myPerson.xpos].status = 'X';
	}
	
	private void initializeEnemy() {
		enemy = new Person("Cotton Eye Joe", 32);
		enemy.xpos = 2;
		enemy.ypos = 1;
		enemy.strLv = 1;
		tiles[enemy.ypos][myPerson.xpos].status = 'E';
	}
	
	private void checkTile(int y, int x) {
		if(tiles[y][x].status == 'E') {
			System.out.println("Holy fuck, it's " + enemy.name + "!");
			System.out.println("Prepare for battle...");
			if(myPerson.strLv >= enemy.strLv) {
				System.out.println("You won!");
			}else{
				System.out.println("You died...");
			}
		}
	}
	
	/*public void getTiles() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(j < 2) {
					System.out.print(tiles[i][j].status + " | ");
				}else{
					System.out.print(tiles[i][j].status);
					System.out.println();
				}
			}
		}
	}*/
	public void getTiles() {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(j < cols - 1) {
					System.out.print(tiles[i][j].status + " | ");
				}else{
					System.out.print(tiles[i][j].status);
					System.out.println();
				}
			}
		}
	}
	
	/*public void getPerson() {
		
	}*/
	
	public void movePersonRight() {
		if(myPerson.ypos <= rows - 1 && myPerson.ypos >= 0) {
			if(myPerson.xpos != cols - 1) {
				tiles[myPerson.ypos][myPerson.xpos].status = tiles[myPerson.ypos][myPerson.xpos].tileType;
				myPerson.xpos++;
				tiles[myPerson.ypos][myPerson.xpos].status = 'X'; 
				System.out.println();
				getTiles();
			}else{
				System.out.println("Destination out of bounds");
				myPerson.ypos = myPerson.ypos;
			}
		}
	}
	
	public void movePersonLeft() {
		if(myPerson.ypos <= cols && myPerson.ypos >= 0) {
			if(myPerson.xpos != 0) {
				tiles[myPerson.ypos][myPerson.xpos].status = tiles[myPerson.ypos][myPerson.xpos].tileType;
				myPerson.xpos--;
				tiles[myPerson.ypos][myPerson.xpos].status = 'X'; 
				System.out.println();
				getTiles();
			}else{
				System.out.println("Destination out of bounds");
				myPerson.ypos = myPerson.ypos;
			}
		}
	}
	
	public void movePersonUp() {
		if(myPerson.ypos <= rows && myPerson.ypos >= 0) {
			if(myPerson.ypos != 0) {
				tiles[myPerson.ypos][myPerson.xpos].status = tiles[myPerson.ypos][myPerson.xpos].tileType;
				myPerson.ypos--;
				tiles[myPerson.ypos][myPerson.xpos].status = 'X'; 
				System.out.println();
				getTiles();
			}else{
				System.out.println("Destination out of bounds");
				myPerson.ypos = myPerson.ypos;
			}
		}
	}
	
	public void movePersonDown() {
		if(myPerson.ypos <= rows && myPerson.ypos >= 0) {
			if(myPerson.ypos != rows - 1) {
				tiles[myPerson.ypos][myPerson.xpos].status = tiles[myPerson.ypos][myPerson.xpos].tileType;
				myPerson.ypos++;
				tiles[myPerson.ypos][myPerson.xpos].status = 'X'; 
				System.out.println();
				getTiles();
			}else{
				System.out.println("Destination out of bounds");
				myPerson.ypos = myPerson.ypos;
			}
		}
	}
}
