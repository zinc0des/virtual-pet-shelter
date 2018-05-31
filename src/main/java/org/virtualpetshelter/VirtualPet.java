package org.virtualpetshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.omg.CosNaming._BindingIteratorImplBase;


public class VirtualPet {
// instance variables
	private String virtualPetName;
	private ArrayList<String> descriptionList;
	private int hunger;
	private int thirst;
	private int tiredness;
	private int boredom;
	private int age;

	// Constructor
	public VirtualPet(String virtualPetName) {
		this.setVirtualPetName(virtualPetName);
		this.descriptionList = new ArrayList<String>();
		this.descriptionList.add(" loves to roll on soft grass!");
		this.descriptionList.add(" is rather fidgety today.");
		this.descriptionList.add(" love to lick your face!");
		this.descriptionList.add(" is rather feisty today.");
		this.descriptionList.add(" has mesmerizingly innocent eyes.");
		this.hunger = ThreadLocalRandom.current().nextInt(1, 20);
		this.thirst = ThreadLocalRandom.current().nextInt(1, 20);
		this.tiredness = ThreadLocalRandom.current().nextInt(1, 20);
		this.boredom = ThreadLocalRandom.current().nextInt(1, 20);
		this.age = 0;
	}

	// Getter and setter variables
	public int getHunger() {
		return this.hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getThirst() {
		return this.thirst;
	}

	public void setThirst(int thirst) {
		this.thirst = thirst;
	}

	public int getSleep() {
		return this.tiredness;
	}

	public void setSleep(int tiredness) {
		this.tiredness = tiredness;
	}

	public int getPlay() {
		return this.boredom;
	}

	public void setPlay(int boredom) {
		this.boredom = boredom;
	}
	
	public String getDescription() {
		return this.descriptionList.get(ThreadLocalRandom.current().nextInt(0, this.descriptionList.size()));
	}

	

	// Tick method increments the age of of the animal as well as general health
	// status such as hunger and thirst of the animal if the appropriate action does
	// not take place while an activity is completed. It will
	// eventually lead the animal to perish and the game will be over.

	public void tick() {
		this.hunger += 1;
		this.thirst += 1;
		this.tiredness += 1;
		this.boredom += 1;
		this.age += 1;
		if (this.getHunger() > 90 && this.getHunger() < 100) {
			System.out.println(this.getVirtualPetName() + "  may need to be fed!");
		}
		if (this.getThirst() > 90 && this.getThirst() < 100) {
			System.out.println(this.getVirtualPetName() + " seems to be thirsty!");
		}
		if (this.getSleep() > 95 && this.getSleep() < 100) {
			System.out.println(this.getVirtualPetName() + " may be tired!");
		}
		if (this.getPlay() > 95 && this.getPlay() < 100) {
			System.out.println(this.getVirtualPetName() + " seems to be bored. Please play with it!");
		}
	}


	public void feed() {
		int randomNum;
		if (this.getHunger() <= 1) {
			randomNum = 0;
		} else {
			randomNum = ThreadLocalRandom.current().nextInt(1, this.getHunger());
		}
		this.hunger -= randomNum;
	}

	public void water() {
		int randomNum;
		if (this.getThirst() <= 1) {
			randomNum = 0;
		} else {
			randomNum = ThreadLocalRandom.current().nextInt(1, this.getThirst());
		}
		this.thirst -= randomNum;
	}

	public void makeSleep() {
		int randomNum;
		if (this.getSleep() <= 1) {
			randomNum = 0;
		} else {
		 randomNum = ThreadLocalRandom.current().nextInt(1, this.getSleep());
		}
		this.tiredness -= randomNum;
	}

	public void playWith() {
		System.out.println("OK, you play with " + this.getVirtualPetName());
		int randomNum;
		if (this.getPlay() <= 1) {
			randomNum = 0;
		} else {
		randomNum = ThreadLocalRandom.current().nextInt(1, this.getPlay());
		}
		this.boredom -= randomNum;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public String getVirtualPetName() {
		return virtualPetName;
	}

	public void setVirtualPetName(String virtualPetName) {
		this.virtualPetName = virtualPetName;
	}

	public boolean isAlive() {
		if ((this.hunger >= 100) || (this.thirst >= 100) || (this.age >= 50)) {
			return false;
		} else {
			return true;
	}

	}

	
}