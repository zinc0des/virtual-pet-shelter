package org.virtualpetshelter;

import java.util.concurrent.ThreadLocalRandom;

public class VirtualPet {
// instance variables
	private String virtualPetName;
	private int hunger;
	private int thirst;
	private int tiredness;
	private int boredom;
	private int age;

	// Constructor
	public VirtualPet(String virtualPetName) {
		this.setVirtualPetName(virtualPetName);
		this.hunger = ThreadLocalRandom.current().nextInt(1, 99);
		this.thirst = ThreadLocalRandom.current().nextInt(1, 99);
		this.tiredness = ThreadLocalRandom.current().nextInt(1, 99);
		this.boredom = ThreadLocalRandom.current().nextInt(1, 99);
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

	// Tick method increments the age of of the animal as well as general health
	// status such as hunger and thirst of the animal if the appropriate action does
	// not take place while an activity is completed. It will
	// eventually lead the animal to perish and the game will be over.

	public void tick() {
		this.hunger += 5;
		this.thirst += 10;
		this.tiredness += 20;
		this.boredom += 30;
		this.age += 1;
		System.out.println("Current Age of Marty: " + this.getAge());
		System.out.println("Current Hunger status of Marty: " + this.getHunger());
		System.out.println("Current Thirst level of Marty: " + this.getThirst());
		System.out.println("Current Boredom level of Marty: " + this.getPlay());
		System.out.println("Current Tiredness of Marty: " + this.getSleep());
		if (this.getAge() >= 50 || this.getHunger() >= 100 || this.getThirst() >= 100) {
			this.perish();
		}
		if (this.getHunger() > 90 && this.getHunger() < 100) {
			System.out.println("Feed me!");
		}
		if (this.getThirst() > 90 && this.getThirst() < 100) {
			System.out.println("Give me anything to drink!");
		}
		if (this.getSleep() > 95 && this.getSleep() < 100) {
			System.out.println("Please allow me to sleep!");
		}
		if (this.getPlay() > 95 && this.getPlay() < 100) {
			System.out.println("I'm bored. Please play with me!");
		}
	}

	private void perish() {
		System.out.println("Bless the soul of poor Marty the Sloth!");
		System.out.println("Thank you for playing!");
		System.exit(0);
	}

	public void feed() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, this.getHunger());
		System.out.println("Hunger before being Fed: " + this.getHunger());
		this.hunger -= randomNum;
	}

	public void water() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, this.getThirst());
		System.out.println("Thirst before drinking water: " + this.getThirst());
		this.thirst -= randomNum;
	}

	public void makeSleep() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, this.getSleep());
		System.out.println("Tiredness before a nap: " + this.getSleep());
		this.tiredness -= randomNum;
	}

	public void playWith() {
		int randomNum = ThreadLocalRandom.current().nextInt(1, this.getPlay());
		System.out.println("Boredom before playing: " + this.getPlay());
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