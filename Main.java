import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room();
        room1.getTiles();

        Scanner myObj = new Scanner(System.in);
        String input;
        boolean playerOneTurn = true;

        do {
            System.out.println("Player " + (playerOneTurn ? "1" : "2") + "'s turn. Enter a command (w/a/s/d):");
            if (playerOneTurn) {
                room1.getPlayer(1).selectAnimal();
            } else {
                room1.getPlayer(2).selectAnimal();
            }
            input = myObj.nextLine();
            switch (input) {
                case "w":
                    if (playerOneTurn) {
                        room1.movePersonUp(room1.getPlayer(1).getSelectedAnimal());
                    } else {
                        room1.movePersonUp(room1.getPlayer(2).getSelectedAnimal());
                    }
                    break;
                case "a":
                    if (playerOneTurn) {
                        room1.movePersonLeft(room1.getPlayer(1).getSelectedAnimal());
                    } else {
                        room1.movePersonLeft(room1.getPlayer(2).getSelectedAnimal());
                    }
                    break;
                case "s":
                    if (playerOneTurn) {
                        room1.movePersonDown(room1.getPlayer(1).getSelectedAnimal());
                    } else {
                        room1.movePersonDown(room1.getPlayer(2).getSelectedAnimal());
                    }
                    break;
                case "d":
                    if (playerOneTurn) {
                        room1.movePersonRight(room1.getPlayer(1).getSelectedAnimal());
                    } else {
                        room1.movePersonRight(room1.getPlayer(2).getSelectedAnimal());
                    }
                    break;
                default:
                    input = "X";
            }
            playerOneTurn = !playerOneTurn; // Switch turns
        } while (!input.equals("X"));

        System.out.println("Program terminated");
        myObj.close();
    }
}
