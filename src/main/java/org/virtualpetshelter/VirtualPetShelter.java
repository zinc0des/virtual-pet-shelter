package org.virtualpetshelter;

import java.awt.print.Printable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
		for (VirtualPet thisPet : pets.values()) {
			thisPet.tick();
		}
	}
	
	public void feed(String petName) {
		this.pets.get(petName).feed();
		System.out.println(petName + " Fed!");
	}
	
	public void water(String petName) {
		this.pets.get(petName).water();
		System.out.println(petName + " Watered!");
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
		this.pets.remove(petName);
		System.out.println(petName + " Adopted!");
	}
	
	public void admit(String petName) {
		if (this.pets.keySet().contains(petName)) {
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
	
	public void listStatus() {
		System.out.println("Thank you for volunteering at Big Al's Virtual Pet Shelter and Delicatessen!\n");
		System.out.println("This is the status of your pets:");
		System.out.println("\n");
		System.out.println("Name\t|Hunger\t|Thirst\t|Boredom");
		System.out.println("--------|-------|-------|-------");
		for (String petName: this.pets.keySet()) {
			System.out.println(petName + "\t" + this.pets.get(petName).getHunger() + "\t" + this.pets.get(petName).getThirst() + "\t" + this.pets.get(petName).getSleep());
		}
	}

	
}
