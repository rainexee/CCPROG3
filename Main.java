import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int winState = 0;
		//int currentPlayer = 1;				
		
		//Player player1 = new Player(1);

		Room room1 = new Room(1);
		System.out.println("Begin Game");
		Scanner myObj = new Scanner(System.in);
		room1.getPlayer(1).turnActive = Coinflip.determineFirstPlayer(myObj);
		room1.getTiles();
		while(winState == 0) {
			if(room1.getPlayer(1).turnActive  == true) {
				room1.getPlayer(1).selectAnimal();
			}else{
				room1.getPlayer(2).selectAnimal();
			}
		}
		
	}
}

