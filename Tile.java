package javaprac;

public class Tile {
	int ypos; //row number
	int xpos; //col number
	char status;
	char tileType;
	
	public Tile(int x, int y){
		this.xpos = x;
		this.ypos = y;
		System.out.println("New tile created at row " + xpos + " and col " + ypos);
	}
}
