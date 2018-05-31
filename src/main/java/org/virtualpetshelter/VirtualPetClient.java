package org.virtualpetshelter;

import java.util.Scanner;

public class VirtualPetClient {
	/*
	 * This virtual pet game allows the player to interact with Marty the Sloth in
	 * various ways. A menu first pops us notifying the options on activities
	 * available. Marty's hunger and/or thirst levels should not exceed 100. If it
	 * does, Marty dies. The player can feed, make him drink water,play with him, as
	 * well as put him to sleep. Marty's age will increment by 1 every time the
	 * player chooses a new activity from the menu. If age exceeds 50, Marty will
	 * die!
	 * 
	 */
	public static void main(String[] args) {
		VirtualPet myPet = new VirtualPet("Marty the Sloth");
		Scanner input = new Scanner(System.in);
		print("Welcome to the pet shelter of Marty the Sloth.");
		System.out.println(" ________________________________");
		System.out.println("(_______^^^____________^^^_______)");
		System.out.println("      /  (((         / (((       ");
		System.out.println("     / /  \\         / /  \\"  );
		System.out.println("       \\   \\         \\   \\");
		System.out.println("        \\   \\         \\   \\");
		System.out.println("         \\   \\");
		System.out.println("  ________\\   \\         \\   \\");
		System.out.println(" /        \\\\   \\        \\   \\");
		System.out.println("/((@))((@))\\\\   \\        \\   \\");
		System.out.println("\\   (-)    / \\   \\ _____  \\   \\");
		System.out.println(" \\__\\-/___/ /    /         /   \\");
		System.out.println(" /           \\__/          \\  |");
		System.out.println("/                              /");
		System.out.println("|                             /");
		System.out.println(" \\                           /");
		System.out.println("  \\                         /");
		System.out.println("   \\                       /");
		System.out.println("    \\_____________________/");
		while (myPet.isAlive()) {
			
			print("What do you want to do?");
			int userInput = 0;
			while ((userInput < 1) && (userInput < 5)) {
				print("1: Feed a pet");
				print("2: Water Marty");
				print("3: Put Marty to sleep");
				print("4: Play with Marty");
				print("5: Quit the game!");
				userInput = input.nextInt();
			}
			switch (userInput) {
			case 1:
				System.out.println("Feeding Marty!");
				myPet.feed();
				System.out.println("Marty Fed!");
				break;
			case 2:
				myPet.water();
				System.out.println("Gave Marty fresh water to drink!");
				break;
			case 3:
				myPet.makeSleep();
				System.out.println("Put Marty to sleep!");
				break;
			case 4:
				myPet.playWith();
				System.out.println("Played with Marty! Oh what fun it was to see him hanging on a tree!");
				break;
			case 5:
				System.out.println("Exiting Game!!!!");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a valid option between 1 and 5");
				break;
			}
			myPet.tick();
		}
		System.out.println("Bless the soul of poor Marty the Sloth!");
		System.out.println("Thank you for playing!");
		input.close();

	}

	private static void print(String message) {
		System.out.println(message);
	}
}
