import java.util.Random;

public class Room {
    int i, j;
    int rows = 7;
    int cols = 9;
    private Tile[][] tiles;
    private Animal[] animals;
    private Animal selectedAnimal;
    private Animal[] enemies;
    private Animal selectedEnemy;
    private Player[] players;
    public int roomID;

    public Room() {
        tiles = new Tile[rows][cols];
        players = new Player[2];
        initializeTiles();
        initializePlayers();
        initializePerson();
        initializeEnemy();
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
        players[0] = new Player(1, this);
        players[1] = new Player(2, this);
    }

    private void initializePerson() {
        animals = new Animal[] {
        new Rat("Rat", true, 'R'),
        new Tiger("Tiger", true, 'T')
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
            new Rat("Enemy Rat", true, 'R'),
            new Tiger("Enemy Tiger", true, 'T')
            // Add more enemy animals here
        };
    
        // Assign initial positions for enemies
        int enemyIndex = 0;
        int rowNum = 0;
        int colNum = cols - 3; // Start at the opposite side of the map
    
        // Position the enemies
        System.out.println("Initiating enemy placement...");
        for (int i = 0; i < enemies.length; i++) {
            System.out.println("Current enemy index: " + enemyIndex);
            enemies[enemyIndex].xpos = colNum;
            enemies[enemyIndex].ypos = rowNum;
            tiles[rowNum][colNum].status = enemies[enemyIndex].getAnimalToken();
            System.out.println(enemies[enemyIndex].getAnimalName() + " positioned at column " + enemies[enemyIndex].xpos + ", row " + enemies[enemyIndex].ypos);
            rowNum += 2; // Move down 2 positions for the next enemy
            enemyIndex++; // Next enemy placement
        }
    
        // Additional enemy placement logic if needed
        System.out.println("Enemy placement complete.");
    }

    private void checkTile(int y, int x) {
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
    }

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

    public void movePersonRight(Animal animal) {
        if (animal.ypos <= rows - 1 && animal.ypos >= 0) {
            if (animal.xpos != cols - 1) {
                tiles[animal.ypos][animal.xpos].status = tiles[animal.ypos][animal.xpos].tileType;
                animal.xpos++;
                checkTile(animal.ypos, animal.xpos);
                tiles[animal.ypos][animal.xpos].status = 'X';
                System.out.println();
                getTiles();
            } else {
                System.out.println("Destination out of bounds");
                animal.ypos = animal.ypos;
            }
        }
    }

    public void movePersonLeft(Animal animal) {
        if (animal.ypos <= cols && animal.ypos >= 0) {
            if (animal.xpos != 0) {
                tiles[animal.ypos][animal.xpos].status = tiles[animal.ypos][animal.xpos].tileType;
                animal.xpos--;
                checkTile(animal.ypos, animal.xpos);
                tiles[animal.ypos][animal.xpos].status = 'X';
                System.out.println();
                getTiles();
            } else {
                System.out.println("Destination out of bounds");
                animal.ypos = animal.ypos;
            }
        }
    }

    public void movePersonUp(Animal animal) {
        if (animal.ypos <= rows && animal.ypos >= 0) {
            if (animal.ypos != 0) {
                tiles[animal.ypos][animal.xpos].status = tiles[animal.ypos][animal.xpos].tileType;
                animal.ypos--;
                checkTile(animal.ypos, animal.xpos);
                tiles[animal.ypos][animal.xpos].status = 'X';
                System.out.println();
                getTiles();
            } else {
                System.out.println("Destination out of bounds");
                animal.ypos = animal.ypos;
            }
        }
    }

    public void movePersonDown(Animal animal) {
        if (animal.ypos <= rows && animal.ypos >= 0) {
            if (animal.ypos != rows - 1) {
                tiles[animal.ypos][animal.xpos].status = tiles[animal.ypos][animal.xpos].tileType;
                animal.ypos++;
                checkTile(animal.ypos, animal.xpos);
                tiles[animal.ypos][animal.xpos].status = 'X';
                System.out.println();
                getTiles();
            } else {
                System.out.println("Destination out of bounds");
                animal.ypos = animal.ypos;
            }
        }
    }

    public Player getPlayer(int pID) {
        return players[pID - 1];
    }

    public Tile[][] getTilesArray() {
        return tiles;
    }
}
