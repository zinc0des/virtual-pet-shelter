package org.virtualpetshelter;

import java.util.List;
import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class VirtualPetShelter {
	
	Map<String, VirtualPet> pets = new HashMap<>();

	public VirtualPetShelter() {
		
	}
	public void addVirtualPet(VirtualPet myPet) {
		pets.put(myPet.getVirtualPetName(), myPet);
		
	}

	public VirtualPet getVirtualPet(String virtualPetName) {
		return pets.get(virtualPetName);
	}

	public Collection<VirtualPet> getAllVirtualPets() {
		return pets.values();
	}
	
	

	public void feedAllPets() {
		for (VirtualPet thisPet : pets.values()) {
			thisPet.feed();		
		}
	}
	
	public void waterAllPets() {
		for (VirtualPet thisPet : pets.values()) {
			thisPet.water();
		}
	}
	
	public void makeSleepAllPets() {
		for (VirtualPet thisPet : pets.values()) {
			thisPet.makeSleep();
		}
	}
	
	public void playWithAllPets() {
		for (VirtualPet thisPet : pets.values()) {
			thisPet.playWith();
		}
	}
	
	public void tickAll() {
		List<String> deadList = new ArrayList<>();
		for (VirtualPet thisPet : pets.values()) {
			thisPet.tick();
			if (thisPet.getAge() >= 50 || thisPet.getHunger() >= 100 || thisPet.getThirst() >= 100 || thisPet.getPlay() >= 100 || thisPet.getSleep() >= 100 )  {
				deadList.add(thisPet.getVirtualPetName());
			}
		}
		for (String petName : deadList) {
			System.out.println(petName + " is dead!");
			pets.remove(petName);
		}	
	}
	
	public void sleep(String petName) {
		this.pets.get(petName).makeSleep();
		System.out.println(petName + " Slept!");
	}
	
	public void play(String petName) {
		this.pets.get(petName).playWith();
		System.out.println(petName + " Played!");
	}
	
	public void adopt(String petName) {
		if (pets.containsKey(petName)) {
			pets.remove(petName);
			System.out.println(petName + " Adopted!");
		} else {
			System.out.println("Unable to Adopt " + petName + ". The requested Pet does not exist !");
		}
	}
	
	public void admit(String petName) {
		if (this.pets.containsKey(petName)) {
			System.out.println("Cannot Admit this Pet. " + petName + " already is in the Pet Shelter!!!");
		} else {
			this.pets.put(petName, new VirtualPet(petName));
		}
	}
	
	public void listPets() {
		System.out.println("List of Current Pets in the Shelter");
		for (String petName: this.pets.keySet()) {
		System.out.println(petName);
		}
	}
	
	public void listDescriptions() {
		for (VirtualPet vPet : this.pets.values() ) {
			System.out.println("[ " + vPet.getVirtualPetName() + " ] " + vPet.getDescription());
		}
	}
	
	public void listStatus() {
//		System.out.println("Thank you for volunteering at Big Al's Virtual Pet Shelter and Delicatessen!\n");
//		System.out.println("This is the status of your pets:");
//		System.out.println("\n");
		System.out.println("Name\t|Hunger\t|Thirst\t|Boredom\t");
		System.out.println("--------|-------|-------|-------");
		for (String petName: this.pets.keySet()) {
			System.out.println(petName + "\t" + "| "+ this.pets.get(petName).getHunger() + "\t" + "|" + this.pets.get(petName).getThirst() + "\t" + "|" + this.pets.get(petName).getSleep());
		}
	}

	
}
