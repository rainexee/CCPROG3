package javaprac;

import java.util.Random;

public class Room {
    int i, j;
    int rows = 7;
    int cols = 9;
    int roomID;
    
    private Player[] players = new Player[2];
    Tile[][] tiles;
    /*private Animal[] animals;
    private Animal selectedAnimal;
    private Animal[] enemies;
    private Animal selectedEnemy;*/

    public Room(int rID) {
        tiles = new Tile[rows][cols];
        this.roomID = 1;
        initializeTiles();
        /*
        initializePerson();
        initializeEnemy();
        */
        initializePlayers();
    }
    
    
    private void initializeTiles() {
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                tiles[i][j] = new Tile(i, j);
                tiles[i][j].status = '_';
                tiles[i][j].tileType = tiles[i][j].status;
            }
            System.out.println("Row complete, next row");
        }

        // RIVER TILE INITIALIZATION
        for (i = 1; i < 3; i++) {
            for (j = 3; j < 6; j++) {
                tiles[i][j].status = 'R';
                tiles[i][j].tileType = tiles[i][j].status;
            }
        }
        for (i = 4; i < 6; i++) {
            for (j = 3; j < 6; j++) {
                tiles[i][j].status = 'R';
                tiles[i][j].tileType = tiles[i][j].status;
            }
        }

        // TRAP TILE INITIALIZATION
        tiles[2][0].status = 'T';
        tiles[2][0].tileType = tiles[2][0].status;
        tiles[2][cols - 1].status = 'T';
        tiles[2][cols - 1].tileType = tiles[2][cols - 1].status;

        tiles[3][1].status = 'T';
        tiles[3][1].tileType = tiles[3][1].status;
        tiles[3][cols - 2].status = 'T';
        tiles[3][cols - 2].tileType = tiles[3][cols - 2].status;
        tiles[4][0].status = 'T';
        tiles[4][0].tileType = tiles[4][0].status;
        tiles[4][cols - 1].status = 'T';
        tiles[4][cols - 1].tileType = tiles[4][cols - 1].status;

        // HOME TILE INITIALIZATION
        tiles[3][0].status = 'H';
        tiles[3][0].tileType = tiles[3][0].status;
        tiles[3][cols - 1].status = 'H';
        tiles[3][cols - 1].tileType = tiles[3][cols - 1].status;
    }
    
    private void initializePlayers() {
    	/*for(int i = 0; i < 2; i++) {
    		players[i].playerID = i+1;
    		players[i].setRoom(this);
    		System.out.println("Player " + players[i].playerID + " successfully initialized");
    		System.out.println("Player" + players[i].playerID + " set to Room " + players[i].room.roomID + ".");
    	}*/
    	Player p1 = new Player(1, this);
    	//Player p2 = new Player(2);
    	players[0] = p1;
    	//players[0] = p2;
    }
    
    /*private void initializePerson() {
        animals = new Animal[] {
            new Rat("Rat", true),
            new Tiger("Tiger", true)
            // Add more animals here
        };

        Random random = new Random();
        selectedAnimal = animals[random.nextInt(animals.length)];

        System.out.println("Selected Animal: " + selectedAnimal.getAnimalName());

        selectedAnimal.xpos = 0;
        selectedAnimal.ypos = 0;
        selectedAnimal.strLv = 3;
        tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = 'X';
    }

    private void initializeEnemy() {
        enemies = new Animal[] {
            new Rat("Enemy Rat", true),
            new Tiger("Enemy Tiger", true)
            // Add more enemy animals here
        };

        Random random = new Random();
        selectedEnemy = enemies[random.nextInt(enemies.length)];

        System.out.println("Selected Enemy: " + selectedEnemy.getAnimalName());

        selectedEnemy.xpos = 2;
        selectedEnemy.ypos = 1;
        selectedEnemy.strLv = 1;
        tiles[selectedEnemy.ypos][selectedEnemy.xpos].status = 'E';
    }*/

    /*private void checkTile(int y, int x) {
        if (tiles[y][x].status == 'E') {
            System.out.println("Holy cow, it's " + selectedEnemy.getAnimalName() + "!");
            System.out.println("Prepare for battle...");
            if (selectedAnimal.getLevel() >= selectedEnemy.getLevel()) {
                System.out.println("You won!");
            } else {
                System.out.println("You died...");
            }
        }
    
        if (tiles[y][x].status == 'T') {
            System.out.println("You ran into a trap! " + selectedAnimal.getAnimalName() + " is weakened!");
            selectedAnimal.strLv -= 2; // Adjust the level
            System.out.println(selectedAnimal.getAnimalName() + "'s level is now " + selectedAnimal.getLevel());
        }
    }*/

    public void getTiles() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j < cols - 1) {
                    System.out.print(tiles[i][j].status + " | ");
                } else {
                    System.out.print(tiles[i][j].status);
                    System.out.println();
                }
            }
        }
    }
    
    public Player getPlayer(int pID) {
    	return players[pID-1];
    }
    /*
    public void movePersonRight() {
        if (selectedAnimal.ypos <= rows - 1 && selectedAnimal.ypos >= 0) {
            if (selectedAnimal.xpos != cols - 1) {
                tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = tiles[selectedAnimal.ypos][selectedAnimal.xpos].tileType;
                selectedAnimal.xpos++;
                checkTile(selectedAnimal.ypos, selectedAnimal.xpos);
                tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = 'X';
                System.out.println();
                getTiles();
            } else {
                System.out.println("Destination out of bounds");
                selectedAnimal.ypos = selectedAnimal.ypos;
            }
        }
    }

    public void movePersonLeft() {
        if (selectedAnimal.ypos <= cols && selectedAnimal.ypos >= 0) {
            if (selectedAnimal.xpos != 0) {
                tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = tiles[selectedAnimal.ypos][selectedAnimal.xpos].tileType;
                selectedAnimal.xpos--;
                checkTile(selectedAnimal.ypos, selectedAnimal.xpos);
                tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = 'X';
                System.out.println();
                getTiles();
            } else {
                System.out.println("Destination out of bounds");
                selectedAnimal.ypos = selectedAnimal.ypos;
            }
        }
    }

    public void movePersonUp() {
        if (selectedAnimal.ypos <= rows && selectedAnimal.ypos >= 0) {
            if (selectedAnimal.ypos != 0) {
                tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = tiles[selectedAnimal.ypos][selectedAnimal.xpos].tileType;
                selectedAnimal.ypos--;
                checkTile(selectedAnimal.ypos, selectedAnimal.xpos);
                tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = 'X';
                System.out.println();
                getTiles();
            } else {
                System.out.println("Destination out of bounds");
                selectedAnimal.ypos = selectedAnimal.ypos;
            }
        }
    }

    public void movePersonDown() {
        if (selectedAnimal.ypos <= rows && selectedAnimal.ypos >= 0) {
            if (selectedAnimal.ypos != rows - 1) {
                tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = tiles[selectedAnimal.ypos][selectedAnimal.xpos].tileType;
                selectedAnimal.ypos++;
                checkTile(selectedAnimal.ypos, selectedAnimal.xpos);
                tiles[selectedAnimal.ypos][selectedAnimal.xpos].status = 'X';
                System.out.println();
                getTiles();
            } else {
                System.out.println("Destination out of bounds");
                selectedAnimal.ypos = selectedAnimal.ypos;
            }
        }
    }*/
}
