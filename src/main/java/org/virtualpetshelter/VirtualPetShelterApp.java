package org.virtualpetshelter;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.eventFrom;
import static org.hamcrest.Matchers.stringContainsInOrder;

import java.util.Scanner;

import org.mockito.internal.debugging.WarningsCollector;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		
		VirtualPetShelter petShelter = new VirtualPetShelter();
				Scanner input = new Scanner(System.in);
	 
				while (true) {
					print("What do you want to do?");
					int userInput = 0;
					String petName = null;
					while ((userInput < 1) && (userInput < 6)) {
						print("1: Feed the pets");
						print("2: Water the pets");
						print("3: Play with a pet");
						print("4: Adopt a pet");
						print("5: Admit a pet");
						print("6: Quit the game!");
						userInput = input.nextInt();
					}
					if (petShelter.pets.isEmpty()) {
						print("Pet Shelter is empty. Will you admit some Pets y/N?\n");
						String answer = input.next().toLowerCase();
						if (answer.equals("y")) {
							print("Enter the name of the pet to be Admitted?\n");
							petName = input.next().toLowerCase();
							petShelter.admit(petName);
						} else  {
							System.out.println("Nothing to do, Quitting!!!");
							System.exit(0);
						}
					} else {
						petShelter.listStatus();
						switch (userInput) {
						case 1:
							System.out.println("Ok, so you'd like to feed the pet. Please choose one:");
							print("Which pet would you like to Feed?\n");
							petName = input.next().toLowerCase();
							petShelter.pets.get(petName).feed();
							petShelter.pets.get(petName).tick();
							petShelter.listStatus();
							break;
						case 2:
							System.out.println("Ok, so you'd like to water the pet. Please choose one:");
							print("Which pet would you like to Water?\n");
							petName = input.next().toLowerCase();
							petShelter.pets.get(petName).water();
							petShelter.pets.get(petName).tick();
							petShelter.listStatus();
							break;
						case 3:
							System.out.println("Ok, so you'd like to Play with the pet. Please choose one:");
							print("Which pet would you like to Play With?\n");
							petName = input.next().toLowerCase();
							petShelter.pets.get(petName).playWith();
							petShelter.pets.get(petName).tick();
							petShelter.listStatus();
							break;
						case 4:
							System.out.println("Ok, so you'd like to Adopt a pet. Please choose one:");
							print("Which pet would you like to Adopt?\n");
							petName = input.next().toLowerCase();
							petShelter.pets.remove(petName);
							petShelter.listStatus();
							break;
						case 5:
						System.out.println("Ok, so you'd like to Admit a pet.");
						print("Enter the name of the pet to be Admitted?\n");
						petName = input.next().toLowerCase();
						petShelter.admit(petName);
						petShelter.pets.get(petName).tick();
						petShelter.listStatus();
						break;
					case 6:
						System.out.println("Ok, Quitting now.");
						System.exit(0);
						break;
					default:
						System.out.println("Please enter a valid option between 1 and 6");
						break;
					}
				}
			
				}

			}

			private static void print(String message) {
				System.out.println(message);
			}
		}




