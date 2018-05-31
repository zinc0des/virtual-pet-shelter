package org.virtualpetshelter;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.eventFrom;
import static org.hamcrest.Matchers.stringContainsInOrder;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Collection;
import java.util.IllegalFormatFlagsException;
import java.util.Scanner;

import org.hamcrest.Description;
import org.junit.experimental.theories.Theories;
import org.mockito.internal.debugging.WarningsCollector;

public class VirtualPetShelterApp {
	
	/* This virtual pet shelter houses virtual pets. Initially, there are 4 pets in the shelter. 
	 * Their status is displayed along with the user menu for interacting with the pets.
	 * The player can feed and water all the pets, play with any pets, adopt a pet or admit a new 
	 * one into the shelter. The new status of the pets is updated after each selection is made 
	 * from the user menu. The tick method updates after each turn of the game loop. If any pet dies,
	 *  they are removed from the shelter. If all pets die, the game is over. If anytime, the player 
	 *  wants to quit the game, they can do so by typing "Quit".
	 */

	public static void main(String[] args) {
		VirtualPetShelter petShelter = new VirtualPetShelter();
		VirtualPet pet1 = new VirtualPet("Mark".toLowerCase());
		VirtualPet pet2 = new VirtualPet("Ron".toLowerCase());
		VirtualPet pet3 = new VirtualPet("Don".toLowerCase());
		VirtualPet pet4 = new VirtualPet("Lori".toLowerCase());
		
		//Add to the map
		petShelter.addVirtualPet(pet1);
		petShelter.addVirtualPet(pet2);
		petShelter.addVirtualPet(pet3);
		petShelter.addVirtualPet(pet4);
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		print("Thank you for volunteering at Marty's Al's Rescued Virtual Pet Shelter Sanctuary!\n");
		print("This is the status of your pets:");
		//Preliminary status of the pets in the shelter
		petShelter.listStatus();
		//Game Loop
		while (true) {
			System.out.println("\n");
			print("What would you like to do next?");
			int userInput = 0;
			String petName = null;
			while ((userInput < 1) && (userInput < 6)) {
				print("1: Feed the pets");
				print("2: Water the pets");
				print("3: Play with a pet");
				print("4: Adopt a pet");
				print("5: Admit a pet");
				print("6: Quit!");
				userInput = input.nextInt();
			}
			if (petShelter.pets.isEmpty()) {
				print("Pet Shelter is empty. Will you admit some Pets, Y/N?\n");
				String answer = input.next().toLowerCase();
				if (answer.equals("y")) {
					print("Enter the name of the pet to be Admitted?\n");
					petName = input.next().toLowerCase();
					petShelter.admit(petName);
				} else {
					System.out.println("GAME OVER!!!!");
					System.out.println("Quitting Now!!!");
					System.exit(0);
				}
			} else {
				print("\n");
				petShelter.listStatus();
				print("\n");
				switch (userInput) {
				case 1:
					print("Pets fed!");
					petShelter.feedAllPets();
					break;
				case 2:
					print("Pets watered!");
					petShelter.waterAllPets();
					break;
				//Playing with individual pets with their descriptions randomized. Game can be exited by typing "Quit"
				case 3:
					System.out.println("Ok, so you'd like to Play with the pet. Please choose one or type 'quit'");
					print("Which pet would you like to Play With?\n");
					petShelter.listDescriptions();
					petName = input.next().toLowerCase();
					if (petName.toLowerCase().equals("quit")) {
						System.out.println("GAME OVER!!!!\n" + 
								"Quitting Now!!!");
						System.exit(0);
					}
					petShelter.pets.get(petName).playWith();
					break;
				// Adopting a pet. Can be exited by typing "Quit"
				case 4:
					System.out.println("Ok, so you'd like to Adopt a pet. Please choose one or type 'quit':");
					print("Which pet would you like to Adopt?\n");
					petName = input.next().toLowerCase();
					if (petName.toLowerCase().equals("quit")) {
						System.out.println("GAME OVER!!!!\n" + 
								"Quitting Now!!!");
						System.exit(0);
					}
					petShelter.adopt(petName);
					break;
					//Admitting a pet in the shelter. Game can be exited by typing "Quit"
				case 5:
					System.out.println("Ok, so you'd like to Admit a pet.");
					print("Enter the name of the pet to be Admitted?\n");
					petName = input.next().toLowerCase();
					if (petName.toLowerCase().equals("quit")) {
						System.out.println("GAME OVER!!!!\n" + 
								"Quitting Now!!!");
						System.exit(0);
					}
					petShelter.admit(petName);
					break;
					//Game Quit Option from menu
				case 6:
					System.out.println("Ok, Quitting now.");
					System.exit(0);
					break;
				default:
					System.out.println("Please enter a valid option between 1 and 6");
					break;
				}
				petShelter.tickAll(); //Tick method called at end of loop
			}
		}
	}
	private static void print(String message) {
		System.out.println(message);
	}
}

