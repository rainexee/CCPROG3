package javaprac;

import java.util.Date;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		
		
		Room room1 = new Room();
		room1.getTiles();
		
		room1.movePersonRight();
		Scanner myObj = new Scanner(System.in);
		String input;
		
		do{
			input = myObj.nextLine();
			switch(input) {
				case "w":
					room1.movePersonUp();
					input = "y";
					break;
				case "a":
					room1.movePersonLeft();
					input = "y";
					break;
				case "s":
					room1.movePersonDown();
					input = "y";
					break;
				case "d":
					System.out.println("Moving right");
					room1.movePersonRight();
					input = "y";
					break;
				default:
					input = "X";
			}
		}while(input == "y");
		System.out.println("Program terminated");
	}
}

/*public class Person{
	int age;
	String name;
	String occupation;
	int id;
}*/
