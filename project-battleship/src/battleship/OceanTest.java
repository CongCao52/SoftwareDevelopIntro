package battleship;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OceanTest {

	Ocean ocean;
	
	static int NUM_BATTLESHIPS = 1;
	static int NUM_CRUISERS = 2;
	static int NUM_DESTROYERS = 3;
	static int NUM_SUBMARINES = 4;
	static int OCEAN_SIZE = 10;
	
	@BeforeEach
	void setUp() throws Exception {
		ocean = new Ocean();
	}

	@Test
	void testEmptyOcean() {
		
		//tests that all locations in the ocean are "empty"
		
		Ship[][] ships = ocean.getShipArray();
		
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[i].length; j++) {
				Ship ship = ships[i][j];
				
				assertEquals("empty", ship.getShipType());
			}
		}
		
		assertEquals(0, ships[0][0].getBowRow());
		assertEquals(0, ships[0][0].getBowColumn());
		
		assertEquals(5, ships[5][5].getBowRow());
		assertEquals(5, ships[5][5].getBowColumn());
		
		assertEquals(9, ships[9][0].getBowRow());
		assertEquals(0, ships[9][0].getBowColumn());
	}
	
	@Test
	void testPlaceAllShipsRandomly() {
		
		//tests that the correct number of each ship type is placed in the ocean
		
		ocean.placeAllShipsRandomly();

		Ship[][] ships = ocean.getShipArray();
		ArrayList<Ship> shipsFound = new ArrayList<Ship>();
		
		int numBattlehips = 0;
		int numCruisers = 0;
		int numDestroyers = 0;
		int numSubmarines = 0;
		int numEmptySeas = 0;
		
		for (int i = 0; i < ships.length; i++) {
			for (int j = 0; j < ships[i].length; j++) {
				Ship ship = ships[i][j];
				if (!shipsFound.contains(ship)) {
					shipsFound.add(ship);
				}
			}
		}
		
		for (Ship ship : shipsFound) {
			if ("battleship".equals(ship.getShipType())) {		
				numBattlehips++;
			} else if ("cruiser".equals(ship.getShipType())) {
				numCruisers++;
			} else if ("destroyer".equals(ship.getShipType())) {
				numDestroyers++;
			} else if ("submarine".equals(ship.getShipType())) {
				numSubmarines++;
			} else if ("empty".equals(ship.getShipType())) {
				numEmptySeas++;
			}
		}
		
		assertEquals(NUM_BATTLESHIPS, numBattlehips);
		assertEquals(NUM_CRUISERS, numCruisers);
		assertEquals(NUM_DESTROYERS, numDestroyers);
		assertEquals(NUM_SUBMARINES, numSubmarines);
		
		//calculate total number of available spaces and occupied spaces
		int totalSpaces = OCEAN_SIZE * OCEAN_SIZE; 
		int occupiedSpaces = (NUM_BATTLESHIPS * 4)
				+ (NUM_CRUISERS * 3)
				+ (NUM_DESTROYERS * 2)
				+ (NUM_SUBMARINES * 1);
		
		//test number of empty seas, each with length of 1
		assertEquals(totalSpaces - occupiedSpaces, numEmptySeas);
	}

	@Test
	void testIsOccupied() {

		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		Ship submarine = new Submarine();
		row = 0;
		column = 0;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.isOccupied(1, 5));
		
		//TODO
		//test 2
		Destroyer destroyer1 = new Destroyer();
		int row1 = 1;
		int column1 = 5;
		boolean horizontal1 = false;
		destroyer1.placeShipAt(row1, column1, horizontal1, ocean);

		Ship submarine1 = new Submarine();
		row1 = 0;
		column1 = 0;
		horizontal1 = false;
		submarine1.placeShipAt(row1, column1, horizontal1, ocean);

		assertFalse(ocean.isOccupied(1, 4));

		//test 3
		Battleship battleship = new Battleship();
		int row2 = 7;
		int column2 = 3;
		boolean horizontal2 = false;
		battleship.placeShipAt(row2, column2, horizontal2, ocean);
		assertTrue(ocean.isOccupied(5, 3));

		//test 4
		Cruiser cruiser = new Cruiser();
		int row3 = 0;
		int column3 = 3;
		boolean horizontal3 = true;
		cruiser.placeShipAt(row3, column3, horizontal3, ocean);
		assertFalse(ocean.isOccupied(0, 4));
	}

	@Test
	void testShootAt() {
	
		assertFalse(ocean.shootAt(0, 1));
		
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		assertTrue(ocean.shootAt(1, 5));
		
		assertFalse(destroyer.isSunk());
		assertTrue(ocean.shootAt(0, 5));
		assertTrue(destroyer.isSunk());
		
		//TODO
		//test 2, the orientation is horizontal
		Destroyer destroyer1 = new Destroyer();
		int row1 = 0;
		int column1 = 2;
		boolean horizontal1 = true;
		destroyer1.placeShipAt(row1, column1, horizontal1, ocean);
		assertTrue(ocean.shootAt(0, 2));

		assertFalse(destroyer1.isSunk());
		assertFalse(ocean.shootAt(0, 5));
		assertFalse(destroyer1.isSunk());
		assertTrue(ocean.shootAt(0, 1));
		assertTrue(destroyer1.isSunk());

		//test 3
		Submarine submarine = new Submarine();
		int row2 = 3;
		int column2 = 2;
		boolean horizontal2 = true;
		submarine.placeShipAt(row2, column2, horizontal2, ocean);
		assertFalse(ocean.shootAt(3, 3));
		assertFalse(submarine.isSunk());

		//test 4
		Submarine submarine1 = new Submarine();
		int row3 = 0;
		int column3 = 8;
		boolean horizontal3 = true;
		submarine1.placeShipAt(row3, column3, horizontal3, ocean);
		assertTrue(ocean.shootAt(0, 8));
		assertTrue(submarine1.isSunk());
	}

	@Test
	void testGetShotsFired() {
		
		//should be all false - no ships added yet
		assertFalse(ocean.shootAt(0, 1));
		assertFalse(ocean.shootAt(1, 0));
		assertFalse(ocean.shootAt(3, 3));
		assertFalse(ocean.shootAt(9, 9));
		assertEquals(4, ocean.getShotsFired());
		
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		Ship submarine = new Submarine();
		row = 0;
		column = 0;
		horizontal = false;
		submarine.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertTrue(ocean.shootAt(0, 5));
	    assertTrue(destroyer.isSunk());
		assertEquals(6, ocean.getShotsFired());
		
		//TODO
		//test 2 SHOOT SUBMARINE
		assertTrue(ocean.shootAt(0, 0));
		assertTrue(submarine.isSunk());
		assertEquals(7, ocean.getShotsFired());

		//test 3 shoot the sunk ship
		assertTrue(destroyer.isSunk());
		assertFalse(ocean.shootAt(0, 5));
		assertFalse(ocean.shootAt(0, 0));
		assertFalse(ocean.shootAt(1, 5));
		assertEquals(10, ocean.getShotsFired());

		//test 4 make a horizontal destroyer
		Destroyer destroyer1 = new Destroyer();
		int row1 = 4;
		int column1 = 1;
		boolean horizontal1 = true;
		destroyer1.placeShipAt(row1, column1, horizontal1, ocean);
		assertTrue(ocean.shootAt(4, 0));
		assertFalse(destroyer1.isSunk());
		assertTrue(ocean.shootAt(4, 1));
		assertTrue(destroyer1.isSunk());
		assertEquals(12, ocean.getShotsFired());
	}

	@Test
	void testGetHitCount() {
		
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertEquals(1, ocean.getHitCount());
		
		//TODO
		//TEST 2 shoot same location
		assertTrue(ocean.shootAt(1, 5));
		assertEquals(2, ocean.getHitCount());

		//test 3 shoot the empty sea
		assertFalse(ocean.shootAt(0, 9));
		assertEquals(2, ocean.getHitCount());
		assertFalse(ocean.shootAt(1, 8));
		assertEquals(2, ocean.getHitCount());
		assertFalse(ocean.shootAt(7, 5));
		assertEquals(2, ocean.getHitCount());


		//test 4 shoot the sunk ship
		assertTrue(ocean.shootAt(0, 5));
		assertEquals(3, ocean.getHitCount());
		assertTrue(destroyer.isSunk());
		assertFalse(ocean.shootAt(0, 5));
		assertFalse(ocean.shootAt(1, 5));
		assertEquals(3, ocean.getHitCount());
	}
	
	@Test
	void testGetShipsSunk() {
		
		Destroyer destroyer = new Destroyer();
		int row = 1;
		int column = 5;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		
		assertTrue(ocean.shootAt(1, 5));
		assertFalse(destroyer.isSunk());
		assertEquals(1, ocean.getHitCount());
		assertEquals(0, ocean.getShipsSunk());
		
		//TODO
		//test 2 test sunk
		assertTrue(ocean.shootAt(0, 5));
		assertTrue(destroyer.isSunk());
		assertEquals(2, ocean.getHitCount());
		assertEquals(1, ocean.getShipsSunk());

		//test 3 test horizontal destroyer
		Destroyer destroyer1 = new Destroyer();
		int row1 = 2;
		int column1 = 3;
		boolean horizontal1 = true;
		destroyer1.placeShipAt(row1, column1, horizontal1, ocean);

		assertTrue(ocean.shootAt(2, 3));
		assertFalse(destroyer1.isSunk());
		assertEquals(3, ocean.getHitCount());
		assertEquals(1, ocean.getShipsSunk());

		//TODO
		//test 4 test sunk
		assertTrue(ocean.shootAt(2, 2));
		assertTrue(destroyer1.isSunk());
		assertEquals(4, ocean.getHitCount());
		assertEquals(2, ocean.getShipsSunk());

	}

	@Test
	void testGetShipArray() {
		
		Ship[][] shipArray = ocean.getShipArray();
		assertEquals(OCEAN_SIZE, shipArray.length);
		assertEquals(OCEAN_SIZE, shipArray[0].length);
		
		assertEquals("empty", shipArray[0][0].getShipType());
		
		//TODO
		//test 2
		Destroyer destroyer = new Destroyer();
		int row = 3;
		int column = 8;
		boolean horizontal = false;
		destroyer.placeShipAt(row, column, horizontal, ocean);
		assertEquals("empty", shipArray[2][3].getShipType());
		assertEquals("destroyer", shipArray[3][8].getShipType());
		assertEquals("destroyer", shipArray[2][8].getShipType());

		//test 3
		Submarine submarine = new Submarine();
		int row1 = 0;
		int column1 = 9;
		boolean horizontal1 = false;
		submarine.placeShipAt(row1, column1, horizontal1, ocean);
		assertEquals("empty", shipArray[0][8].getShipType());
		assertEquals("submarine", shipArray[0][9].getShipType());

		//test 4
		Destroyer destroyer1 = new Destroyer();
		int row2 = 2;
		int column2 = 3;
		boolean horizontal2 = true;
		destroyer1.placeShipAt(row2, column2, horizontal2, ocean);
		assertEquals("destroyer", shipArray[2][3].getShipType());

	}

}