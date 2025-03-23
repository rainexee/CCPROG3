// package m;
import java.util.Scanner;

/*Represents the Driver/Main file that contains the room, players, win conditions, animal etc
 * 
 */
public class Main {
	public static void main(String[] args) {
		
		//Player player1 = new Player(1);
		Room room1 = new Room(1);
		Scanner myObj = new Scanner(System.in);
		
		room1.getPlayer(1).turnActive = Coinflip.determineFirstPlayer(myObj);
		room1.getTiles();
		while(room1.getPlayer(1).getWinState() == 0 && room1.getPlayer(2).getWinState() == 0) {
			if(room1.getPlayer(1).turnActive == true) {
				room1.getPlayer(1).selectAnimal();
			}else{
				room1.getPlayer(2).selectAnimal();
			}
		}

		if(room1.getPlayer(1).getWinState() == 1) {
			System.out.println("Great job, Player 1!");
		}else if(room1.getPlayer(2).getWinState() == 1) {
			System.out.println("Great job, Player 2!");
		}
		
	}
}

/*public class Person{
	int age;
	String name;
	String occupation;
	int id;
}*/
