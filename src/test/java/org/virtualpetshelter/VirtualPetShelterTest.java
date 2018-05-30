package org.virtualpetshelter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {
	VirtualPetShelter petShelter;
	private VirtualPet myPet2;
	private VirtualPet myPet1;

	@Before
	public void setUp() {
		petShelter = new VirtualPetShelter();
		myPet1 = new VirtualPet("Pam");
		myPet2 = new VirtualPet("Ron");
	}

	@Test
	public void addAndGetVirtualPetTest() {
		petShelter.addVirtualPet(myPet1);
		VirtualPet retrievedVirtualPet = petShelter.getVirtualPet(myPet1.getVirtualPetName());
		assertThat(retrievedVirtualPet, is(myPet1));
	}
	
	@Test
	public void addAndGetAllVirtualPetsTest() {
		petShelter.addVirtualPet(myPet1);
		petShelter.addVirtualPet(myPet2);
		Collection<VirtualPet> allPets = petShelter.getAllVirtualPets();
		assertThat(allPets, containsInAnyOrder(myPet1, myPet2));
		//assertEquals(2,  allPets.size());
	}
	
	@Test
	public void shouldBeAbletoInteractWithVirtualPets() {
		petShelter.addVirtualPet(myPet1);
		petShelter.addVirtualPet(myPet2);
		petShelter.feedAllPets();
		assertTrue(myPet1.getHunger() >= 1 &&  myPet1.getHunger() <= 99);
		petShelter.waterAllPets();
		assertTrue(myPet2.getThirst() >= 1 && myPet2.getThirst() <= 99);
		petShelter.makeSleepAllPets();
		assertTrue(myPet1.getSleep() >= 1 && myPet1.getSleep() <= 99);
		petShelter.playWithAllPets();
		assertTrue(myPet2.getPlay() >= 1 && myPet2.getPlay() <= 99);
		int currentThirst = myPet1.getThirst();
		int currentSleep = myPet1.getSleep();
		int currentHunger = myPet2.getHunger();
		int currentBoredom = myPet2.getPlay();
		petShelter.tickAll();
		assertTrue(currentThirst < myPet1.getThirst() && currentSleep < myPet1.getSleep() && currentHunger < myPet2.getHunger() && currentBoredom < myPet2.getPlay());
	}

	
	
}
