package javaprac;

public class Tile {
	int xpos;
	int ypos;
	char status;
	char tileType;
	
	public Tile(int x, int y){
		this.xpos = x;
		this.ypos = y;
		System.out.println("New tile created at " + xpos + " and " + ypos);
	}
}
