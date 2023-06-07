package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {

	Ocean ocean;
	Ship ship;

	@BeforeEach
	void setUp() throws Exception {
		ocean = new Ocean();
	}

	@Test
	void testGetLength() {
		ship = new Battleship();
		assertEquals(4, ship.getLength());

		//TODO
		//test 2
		ship = new Cruiser();
		assertEquals(3, ship.getLength());

		//test 3
		ship = new Destroyer();
		assertEquals(2, ship.getLength());

		//test 4
		ship = new Submarine();
		assertEquals(1, ship.getLength());

	}

	@Test
	void testGetBowRow() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, battleship.getBowRow());

		//TODO
		//test 2
		Ship cruiser = new Cruiser();
		int row1 = 5;
		int column1 = 5;
		boolean horizontal1 = false;
		cruiser.placeShipAt(row1, column1, horizontal1, ocean);
		assertEquals(row1, cruiser.getBowRow());

		//test 3
		Ship destroyer = new Destroyer();
		int row2 = 8;
		int column2 = 8;
		boolean horizontal2 = false;
		destroyer.placeShipAt(row2, column2, horizontal2, ocean);
		assertEquals(row2, destroyer.getBowRow());

		//test 4
		Ship submarine = new Submarine();
		int row3 = 9;
		int column3 = 0;
		boolean horizontal3 = true;
		submarine.placeShipAt(row3, column3, horizontal3, ocean);
		assertEquals(row3, submarine.getBowRow());
	}

	@Test
	void testGetBowColumn() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		battleship.setBowColumn(column);
		assertEquals(column, battleship.getBowColumn());

		//TODO
		//test 2
		Ship cruiser = new Cruiser();
		int row1 = 2;
		int column1 = 5;
		boolean horizontal1 = true;
		cruiser.placeShipAt(row1, column1, horizontal1, ocean);
		cruiser.setBowColumn(column1);
		assertEquals(column1, cruiser.getBowColumn());

		//test 3
		Ship destroyer = new Destroyer();
		int row2 = 7;
		int column2 = 2;
		boolean horizontal2 = false;
		destroyer.placeShipAt(row2, column2, horizontal2, ocean);
		destroyer.setBowColumn(column2);
		assertEquals(column2, destroyer.getBowColumn());

		//test 4
		Ship submarine = new Submarine();
		int row3 = 7;
		int column3 = 2;
		boolean horizontal3 = false;
		submarine.placeShipAt(row3, column3, horizontal3, ocean);
		submarine.setBowColumn(column3);
		assertEquals(column3, submarine.getBowColumn());
	}

	@Test
	void testGetHit() {
		ship = new Battleship();
		boolean[] hits = new boolean[4];
		assertArrayEquals(hits, ship.getHit());
		assertFalse(ship.getHit()[0]);
		assertFalse(ship.getHit()[1]);
		assertFalse(ship.getHit()[2]);
		assertFalse(ship.getHit()[3]);

		//TODO
		//test 2
		Ship cruiser = new Cruiser();
		assertArrayEquals(hits, cruiser.getHit());
		assertFalse(cruiser.getHit()[0]);
		assertFalse(cruiser.getHit()[1]);
		assertFalse(cruiser.getHit()[2]);

		//test 3
		Ship destroyer = new Destroyer();
		assertArrayEquals(hits, destroyer.getHit());
		assertFalse(destroyer.getHit()[0]);
		assertFalse(destroyer.getHit()[1]);

		//test 4
		Ship submarine = new Submarine();
		assertArrayEquals(hits, submarine.getHit());
		assertFalse(submarine.getHit()[0]);
	}

	@Test
	void testGetShipType() {
		ship = new Battleship();
		assertEquals("battleship", ship.getShipType());

		//TODO
		//test 2
		ship = new Cruiser();
		assertEquals("cruiser", ship.getShipType());

		//test 3
		ship = new Destroyer();
		assertEquals("destroyer", ship.getShipType());

		//test 4
		ship = new Submarine();
		assertEquals("submarine", ship.getShipType());
	}

	@Test
	void testIsHorizontal() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertTrue(battleship.isHorizontal());

		//TODO
		//test 2
		Ship cruiser = new Cruiser();
		int row1 = 6;
		int column1 = 7;
		boolean horizontal1 = false;
		cruiser.placeShipAt(row1, column1, horizontal1, ocean);
		assertFalse(cruiser.isHorizontal());

		//test 3
		Ship destroyer = new Destroyer();
		int row2 = 3;
		int column2 = 5;
		boolean horizontal2 = false;
		destroyer.placeShipAt(row2, column2, horizontal2, ocean);
		assertFalse(destroyer.isHorizontal());

		//test 4
		Ship submarine = new Submarine();
		int row3 = 8;
		int column3 = 6;
		boolean horizontal3 = true;
		submarine.placeShipAt(row3, column3, horizontal3, ocean);
		assertTrue(submarine.isHorizontal());
	}

	@Test
	void testSetBowRow() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.setBowRow(row);
		assertEquals(row, battleship.getBowRow());

		//TODO
		//test 2
		Ship cruiser = new Cruiser();
		int row1 = 5;
		int column1 = 3;
		boolean horizontal1 = true;
		cruiser.setBowRow(row1);
		assertEquals(row1, cruiser.getBowRow());

		//test 3
		Ship destroyer = new Destroyer();
		int row2 = 8;
		int column2 = 8;
		boolean horizontal2 = false;
		destroyer.setBowRow(row2);
		assertEquals(row2, destroyer.getBowRow());

		//test 4
		Ship submarine = new Submarine();
		int row3 = 7;
		int column3 = 3;
		boolean horizontal3 = false;
		submarine.setBowRow(row3);
		assertEquals(row3, submarine.getBowRow());
	}

	@Test
	void testSetBowColumn() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.setBowColumn(column);
		assertEquals(column, battleship.getBowColumn());

		//TODO
		//test 2
		Ship cruiser = new Cruiser();
		int row1 = 7;
		int column1 = 7;
		boolean horizontal1 = true;
		cruiser.setBowColumn(column1);
		assertEquals(column1, cruiser.getBowColumn());

		//test 3
		Ship destroyer = new Destroyer();
		int row2 = 6;
		int column2 = 5;
		boolean horizontal2 = true;
		destroyer.setBowColumn(column2);
		assertEquals(column2, destroyer.getBowColumn());

		//test 4
		Ship submarine = new Submarine();
		int row3 = 4;
		int column3 = 7;
		boolean horizontal3 = true;
		submarine.setBowColumn(column3);
		assertEquals(column3, submarine.getBowColumn());
	}

	@Test
	void testSetHorizontal() {
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.setHorizontal(horizontal);
		assertTrue(battleship.isHorizontal());

		//TODO
		//test 2
		Ship cruiser = new Cruiser();
		int row1 = 7;
		int column1 = 4;
		boolean horizontal1 = true;
		cruiser.setHorizontal(horizontal1);
		assertTrue(cruiser.isHorizontal());

		//test 3
		Ship destroyer = new Destroyer();
		int row2 = 5;
		int column2 = 6;
		boolean horizontal2 = false;
		destroyer.setHorizontal(horizontal2);
		assertFalse(destroyer.isHorizontal());

		//test 4
		Ship submarine = new Submarine();
		int row3 = 8;
		int column3 = 4;
		boolean horizontal3 = false;
		submarine.setHorizontal(horizontal3);
		assertFalse(submarine.isHorizontal());
	}

	@Test
	void testOkToPlaceShipAt() {

		//test when other ships are not in the ocean
		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		boolean ok = battleship.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok, "OK to place ship here.");

		//TODO
		//test 2
		Ship cruiser = new Cruiser();
		int row1 = 3;
		int column1 = 6;
		boolean horizontal1 = false;
		boolean ok1 = cruiser.okToPlaceShipAt(row1, column1, horizontal1, ocean);
		assertTrue(ok1, "OK to place ship here.");

		//test 3
		Ship destroyer = new Destroyer();
		int row2 = 9;
		int column2 = 4;
		boolean horizontal2 = false;
		boolean ok2 = destroyer.okToPlaceShipAt(row2, column2, horizontal2, ocean);
		assertTrue(ok2, "OK to place ship here.");

		//test 4
		Ship submarine = new Submarine();
		int row3 = 9;
		int column3 = 9;
		boolean horizontal3 = true;
		boolean ok3 = submarine.okToPlaceShipAt(row3, column3, horizontal3, ocean);
		assertTrue(ok3, "OK to place ship here.");
	}

	@Test
	void testOkToPlaceShipAtAgainstOtherShipsOneBattleship() {

		//test when other ships are in the ocean

		//place first ship
		Battleship battleship1 = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		boolean ok1 = battleship1.okToPlaceShipAt(row, column, horizontal, ocean);
		assertTrue(ok1, "OK to place ship here.");
		battleship1.placeShipAt(row, column, horizontal, ocean);

		//test second ship
		Battleship battleship2 = new Battleship();
		row = 1;
		column = 4;
		horizontal = true;
		boolean ok2 = battleship2.okToPlaceShipAt(row, column, horizontal, ocean);
		assertFalse(ok2, "Not OK to place ship vertically adjacent below.");

		//TODO
		//test 2
		//place first ship
		Cruiser cruiser1 = new Cruiser();
		int row1 = 3;
		int column1 = 5;
		boolean horizontal1 = true;
		boolean ok3 = cruiser1.okToPlaceShipAt(row1, column1, horizontal1, ocean);
		assertTrue(ok3, "OK to place ship here.");
		cruiser1.placeShipAt(row1, column1, horizontal1, ocean);

		//test second ship
		Cruiser cruiser2 = new Cruiser();
		int row2 = 3;
		int column2 = 6;
		boolean horizontal2 = false;
		boolean ok4 = cruiser2.okToPlaceShipAt(row2, column2, horizontal2, ocean);
		assertFalse(ok4, "Not OK to place ship vertically adjacent below.");

		//test 3
		//place first ship
		Destroyer destroyer1 = new Destroyer();
		int row3 = 5;
		int column3 = 7;
		boolean horizontal3 = true;
		boolean ok5 = destroyer1.okToPlaceShipAt(row3, column3, horizontal3, ocean);
		assertTrue(ok5, "OK to place ship here.");
		destroyer1.placeShipAt(row3, column3, horizontal3, ocean);

		//test second ship
		Destroyer destroyer2 = new Destroyer();
		int row4 = 4;
		int column4 = 7;
		boolean horizontal4 = false;
		boolean ok6 = destroyer2.okToPlaceShipAt(row4, column4, horizontal4, ocean);
		assertFalse(ok6, "Not OK to place ship vertically adjacent below.");

		//test 4
		//place first ship
		Submarine submarine1 = new Submarine();
		int row5 = 8;
		int column5 = 5;
		boolean horizontal5 = true;
		boolean ok7 = submarine1.okToPlaceShipAt(row5, column5, horizontal5, ocean);
		assertTrue(ok7, "OK to place ship here.");
		submarine1.placeShipAt(row5, column5, horizontal5, ocean);

		//test second ship
		Submarine submarine2 = new Submarine();
		int row6 = 9;
		int column6 = 5;
		boolean horizontal6 = true;
		boolean ok8 = submarine2.okToPlaceShipAt(row6, column6, horizontal6, ocean);
		assertFalse(ok8, "Not OK to place ship vertically adjacent below.");
	}

	@Test
	void testPlaceShipAt() {

		Ship battleship = new Battleship();
		int row = 0;
		int column = 4;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);
		assertEquals(row, battleship.getBowRow());
		assertEquals(column, battleship.getBowColumn());
		assertTrue(battleship.isHorizontal());

		assertEquals("empty", ocean.getShipArray()[0][0].getShipType());
		assertEquals(battleship, ocean.getShipArray()[0][1]);
		assertEquals(battleship, ocean.getShipArray()[0][2]);
		assertEquals(battleship, ocean.getShipArray()[0][3]);
		assertEquals(battleship, ocean.getShipArray()[0][4]);


		//TODO
		//test 2
		Ship battleship1 = new Battleship();
		int row1 = 5;
		int column1 = 7;
		boolean horizontal1 = false;
		battleship1.placeShipAt(row1, column1, horizontal1, ocean);
		assertEquals(row1, battleship1.getBowRow());
		assertEquals(column1, battleship1.getBowColumn());
		assertFalse(battleship1.isHorizontal());

		assertEquals("empty", ocean.getShipArray()[1][7].getShipType());
		assertEquals(battleship1, ocean.getShipArray()[2][7]);
		assertEquals(battleship1, ocean.getShipArray()[3][7]);
		assertEquals(battleship1, ocean.getShipArray()[4][7]);
		assertEquals(battleship1, ocean.getShipArray()[5][7]);

		//test 3
		Ship cruiser = new Cruiser();
		int row2 = 5;
		int column2 = 4;
		boolean horizontal2 = true;
		cruiser.placeShipAt(row2, column2, horizontal2, ocean);
		assertEquals(row2, cruiser.getBowRow());
		assertEquals(column2, cruiser.getBowColumn());
		assertTrue(cruiser.isHorizontal());

		assertEquals("empty", ocean.getShipArray()[5][5].getShipType());
		assertEquals(cruiser, ocean.getShipArray()[5][2]);
		assertEquals(cruiser, ocean.getShipArray()[5][3]);
		assertEquals(cruiser, ocean.getShipArray()[5][4]);

		//test 4
		Ship cruiser1 = new Cruiser();
		int row3 = 4;
		int column3 = 9;
		boolean horizontal3 = false;
		cruiser1.placeShipAt(row3, column3, horizontal3, ocean);
		assertEquals(row3, cruiser1.getBowRow());
		assertEquals(column3, cruiser1.getBowColumn());
		assertFalse(cruiser1.isHorizontal());

		assertEquals("empty", ocean.getShipArray()[5][9].getShipType());
		assertEquals(cruiser1, ocean.getShipArray()[4][9]);
		assertEquals(cruiser1, ocean.getShipArray()[3][9]);
		assertEquals(cruiser1, ocean.getShipArray()[2][9]);
	}

	@Test
	void testShootAt() {

		Ship battleship = new Battleship();
		int row = 0;
		int column = 9;
		boolean horizontal = true;
		battleship.placeShipAt(row, column, horizontal, ocean);

		assertFalse(battleship.shootAt(1, 9));
		boolean[] hitArray0 = {false, false, false, false};
		assertArrayEquals(hitArray0, battleship.getHit());

		//TODO
		//test 2
		Ship battleship1 = new Battleship();
		int row1 = 0;
		int column1 = 4;
		boolean horizontal1 = true;
		battleship1.placeShipAt(row1, column1, horizontal1, ocean);

		assertTrue(battleship1.shootAt(0, 4));
		boolean[] hitArray1 = {false, false, false, true};
		assertArrayEquals(hitArray1, battleship1.getHit());

		//test 3
		Ship submarine = new Submarine();
		int row2 = 8;
		int column2 = 9;
		boolean horizontal2 = true;
		submarine.placeShipAt(row2, column2, horizontal2, ocean);

		assertTrue(submarine.shootAt(8, 9));
		boolean[] hitArray2 = {true, false, false, false};
		assertArrayEquals(hitArray2, submarine.getHit());

		//test 4
		Ship destoyer = new Destroyer();
		int row3 = 9;
		int column3 = 5;
		boolean horizontal3 = false;
		destoyer.placeShipAt(row3, column3, horizontal3, ocean);

		assertTrue(destoyer.shootAt(9, 5));
		assertTrue(destoyer.shootAt(8, 5));
		boolean[] hitArray3 = {true, true, false, false};
		assertArrayEquals(hitArray3, destoyer.getHit());
	}

	@Test
	void testIsSunk() {

		Ship submarine = new Submarine();
		int row = 3;
		int column = 3;
		boolean horizontal = true;
		submarine.placeShipAt(row, column, horizontal, ocean);

		assertFalse(submarine.isSunk());
		assertFalse(submarine.shootAt(5, 2));
		assertFalse(submarine.isSunk());

		//TODO
		//test 2
		Ship submarine1 = new Submarine();
		int row1 = 3;
		int column1 = 3;
		boolean horizontal1 = true;
		submarine1.placeShipAt(row1, column1, horizontal1, ocean);

		assertFalse(submarine1.isSunk());
		assertTrue(submarine1.shootAt(3, 3));
		assertTrue(submarine1.isSunk());

		//test 3
		Ship destroyer = new Destroyer();
		int row2 = 3;
		int column2 = 9;
		boolean horizontal2 = true;
		destroyer.placeShipAt(row2, column2, horizontal2, ocean);

		assertFalse(destroyer.isSunk());
		assertTrue(destroyer.shootAt(3, 9));
		assertFalse(destroyer.isSunk());

		//test 4
		Ship destroyer1 = new Destroyer();
		int row3 = 3;
		int column3 = 9;
		boolean horizontal3 = true;
		destroyer1.placeShipAt(row3, column3, horizontal3, ocean);

		assertFalse(destroyer1.isSunk());
		assertTrue(destroyer1.shootAt(3, 9));
		assertFalse(destroyer1.isSunk());
		assertTrue(destroyer1.shootAt(3, 8));
		assertTrue(destroyer1.isSunk());
	}

	@Test
	void testToString() {

		Ship battleship = new Battleship();
		assertEquals("x", battleship.toString());

		int row = 9;
		int column = 1;
		boolean horizontal = false;
		battleship.placeShipAt(row, column, horizontal, ocean);
		battleship.shootAt(9, 1);
		assertEquals("x", battleship.toString());

		//TODO
		//test 2
		Ship battleship1 = new Battleship();
		assertEquals("x", battleship1.toString());

		int row1 = 9;
		int column1 = 1;
		boolean horizontal1 = false;
		battleship1.placeShipAt(row1, column1, horizontal1, ocean);
		battleship1.shootAt(9, 1);
		battleship1.shootAt(8, 1);
		battleship1.shootAt(7, 1);
		battleship1.shootAt(6, 1);
		assertEquals("s", battleship1.toString());

		//test 3
		Ship submarine = new Submarine();
		assertEquals("x", submarine.toString());

		int row2 = 2;
		int column2 = 1;
		boolean horizontal2 = false;
		submarine.placeShipAt(row2, column2, horizontal2, ocean);
		submarine.shootAt(2, 1);
		assertEquals("s", submarine.toString());

		//test 4
		Ship submarine1 = new Submarine();
		assertEquals("x", submarine1.toString());

		int row3 = 2;
		int column3 = 1;
		boolean horizontal3 = false;
		submarine1.placeShipAt(row3, column3, horizontal3, ocean);
		submarine1.shootAt(3, 4);
		assertEquals("x", submarine1.toString());
	}

}