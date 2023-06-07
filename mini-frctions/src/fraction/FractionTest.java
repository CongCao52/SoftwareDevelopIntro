package fraction;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;



public class FractionTest {

	@Test
	/*
	 * test Fraction(int numerator, int denominator) with edge cases
	 */
	public void testFraction0() {
		assertEquals("0/20", new Fraction(0,20).toString());
		assertEquals("-1/13", new Fraction(1,-13).toString());
		assertEquals("3/6", new Fraction(-3,-6).toString());
		
		assertEquals("-3/9", new Fraction(-3,9).toString());
		
		// numerator is 0 and denominator is -30
		Fraction fraction = new Fraction(0, -30);
		assertEquals(0, fraction.numerator);
		assertEquals(30, fraction.denominator);
		// numerator and denominator both 0
		fraction = new Fraction(0, 0);
		assertEquals(0, fraction.numerator);
		assertEquals(0, fraction.denominator);

		
		
	}
@Test 
	/*
	 * test void reduceToLowestForm with edge cases
	 */
	public void testReduceToLowestForm() {
		// numerator is 20 and denominator is 40
		Fraction fraction = new Fraction(20, 40);
		fraction.reduceToLowestForm();
		assertEquals(1, fraction.numerator);
		assertEquals(2, fraction.denominator);
		
		// numerator is 0 and denominator is 4
		fraction = new Fraction(0, 4);
		fraction.reduceToLowestForm();
		assertEquals(0, fraction.numerator);
		assertEquals(1, fraction.denominator);
		
		
		// numerator is 4 and denominator is 2
		fraction = new Fraction(4, 2);
		fraction.reduceToLowestForm();
		assertEquals(2, fraction.numerator);
		assertEquals(1, fraction.denominator);
		
		// numerator is 0 and denominator is 4
		fraction = new Fraction(10, 8);
		fraction.reduceToLowestForm();
		assertEquals(5, fraction.numerator);
		assertEquals(4, fraction.denominator);
		
		
		
	}
	
	
@Test 
/*
 * test add function with edge cases
 */
	public void testAdd() {
		Fraction t1 = new Fraction(10,30);
		Fraction t2 = new Fraction(-10,25);
		// Fraction Calculation 5/10 + 10/30 = 5/6
		assertEquals("5/6", new Fraction(5,10).add(t1).toString());
		// Fraction Calculation 11/25 - 10/25 = 1/25
		assertEquals("1/25", new Fraction(11,25).add(t2).toString()); 
		
		
		Fraction t3 = new Fraction(2,4);
		Fraction t4 = new Fraction(-10,23);
		// Fraction Calculation 2/4 + 5/8 = 9/8
		assertEquals("9/8", new Fraction(5,8).add(t3).toString());
		// Fraction Calculation -10/23 + -5/23 = -15/23
		assertEquals("-15/23", new Fraction(5,-23).add(t4).toString());
		
		
		
		
		
	}
@Test 
/*
 * test subtract function with edge cases
 */
	public void testSubtract() {
		Fraction t1 = new Fraction(3,9);
		Fraction t2 = new Fraction(5,16);
		// Fraction Calculation 5/9 - 3/9 = 2/9
		assertEquals("2/9", new Fraction(5,9).subtract(t1).toString());
		// Fraction Calculation 4/16 - 5/16 = -1/16
		assertEquals("-1/16", new Fraction(4,16).subtract(t2).toString()); 
		
		
		Fraction t3 = new Fraction(10,100);
		Fraction t4 = new Fraction(16,16);
		// Fraction Calculation 10/100 - 10/100 = 0/1
		assertEquals("0/1", new Fraction(10,100).subtract(t3).toString());
		// Fraction Calculation 1/2 - 16/16 = -1/2
		assertEquals("-1/2", new Fraction(1,2).subtract(t4).toString()); 
		
		
		
	}	
@Test 
/*
 * test multiply function with edge cases
 */
	public void testMul() {
	
		Fraction t1 = new Fraction(1,5);
		// Fraction Calculation 5/2 * 1/5 = 1/2
		assertEquals("1/2", new Fraction(5,2).mul(t1).toString());
		
		Fraction t2 = new Fraction(1,10);
		// Fraction Calculation 1/10 * 0/3 = 0/1
		assertEquals("0/1", new Fraction(0,3).mul(t2).toString());
		// Fraction Calculation 0/2 * 0/50 = 0/1
		Fraction t3 = new Fraction(0,2);
		assertEquals("0/1", new Fraction(0,50).mul(t3).toString());
		// Fraction Calculation 100/50 * 50/100 = 1/1
		Fraction t4 = new Fraction(100,50);
		assertEquals("1/1", new Fraction(50,100).mul(t4).toString());
		
	}

@Test 
/*
 * test division function with edge cases
 */
	public void testDiv() {
		Fraction t1 = new Fraction(1,16);
		// Fraction Calculation 1/16 / 1/16 = 1/1
		assertEquals("1/1", new Fraction(1,16).div(t1).toString());
		
		Fraction t2 = new Fraction(2,16);
		// Fraction Calculation 1/16 / 2/16 = 1/2
		assertEquals("1/2", new Fraction(1,16).div(t2).toString());
		
		Fraction t3 = new Fraction(1,1);
		// Fraction Calculation 0/3 / 1/1 = 0/1
		assertEquals("0/1", new Fraction(0,3).div(t3).toString());
		
		Fraction t4 = new Fraction(100,33);
		// Fraction Calculation 33/33 / 100/33 = 33/100
		assertEquals("33/100", new Fraction(33,33).div(t4).toString());
		
	}
	@Test
	/*
	 * test change to decimal function with edge cases
	 */
	public void testDecimal() {
		
		assertTrue(new Fraction(1,4).decimal() == 0.25);
		
		assertEquals(0.3333333333, new Fraction(4,12).decimal(), 0.0001);
		
		assertEquals(0.1666666666, new Fraction(1,6).decimal(), 0.0001);
	
		assertTrue(new Fraction(100,5).decimal() == 20.0);
		
		assertTrue(new Fraction(0,90).decimal() == 0.0);
	}	
	
	@Test
	/*
	 * test square function with edge cases
	 */
	public void testSqr() {
		
		Fraction t1 = new Fraction(2,3);
		t1.sqr();
		assertEquals("4/9", t1.toString());
		
		
		Fraction t2 = new Fraction(4,16);
		t2.sqr();
		assertEquals("1/16", t2.toString());
		
		
		Fraction t3 = new Fraction(0,16);
		t3.sqr();
		assertEquals("0/1", t3.toString());
		
		
		Fraction t4 = new Fraction(5,-4);
		t4.sqr();
		assertEquals("25/16", t4.toString());
		
		
	}		
	
	
	@Test
	/*
	 * test AverageFunctionArray function with edge cases
	 */
	public void testAverageFractionArray() {
       //1 edge cases with same elements in array
		Fraction fraction1 = new Fraction(1, 2);
		Fraction fraction2 = new Fraction(1, 2);
		Fraction fraction3 = new Fraction(1, 2);
		
		Fraction[] fractions = new Fraction[] {fraction1, fraction2, fraction3};
		Fraction avgFraction = Fraction.average(fractions);

		assertEquals(1, avgFraction.numerator);
		assertEquals(2, avgFraction.denominator);
		
		//2
		// edge cases with multiple type of frac
		Fraction fraction4 = new Fraction(5, 10);
		Fraction fraction5 = new Fraction(-5, 10);
		Fraction fraction6 = new Fraction(6, -15);
		Fraction fraction7 = new Fraction(0, 18);
		
		Fraction[] fractions1 = new Fraction[] {fraction4, fraction5, fraction6,fraction7};
		Fraction avgFraction1 = Fraction.average(fractions1);
		assertEquals(-1, avgFraction1.numerator);
		assertEquals(10, avgFraction1.denominator);
		
		
		//3
		// edge cases,array elements add to zero. 
		Fraction fraction8 = new Fraction(-3, 5);
		Fraction fraction9 = new Fraction(3, 5);
		
		Fraction[] fractions2 = new Fraction[] {fraction8, fraction9};
		Fraction avgFraction2 = Fraction.average(fractions2);
		assertEquals(0, avgFraction2.numerator);
		assertEquals(1, avgFraction2.denominator);
		
		//4
		//edge class when the array is empty
		Fraction[] fractions3 = new Fraction[] {};
		Fraction avgFraction3 = Fraction.average(fractions3);
		assertEquals(0, avgFraction3.numerator);
		assertEquals(1, avgFraction3.denominator);
		
		
	}

	@Test
	/*
	 * test AverageIntArray function with edge cases
	 */
	public void testAverageIntArray() {
		//1
		//edge cases the elements sum to zero
		int[] ints = new int[] {1, -1, 3, -3};
		Fraction avgFraction = Fraction.average(ints);
		assertEquals(0, avgFraction.numerator);
		assertEquals(1, avgFraction.denominator);
		//2
		//edge cases the array is empty
		int[] ints1 = new int[] {};
		Fraction avgFraction1 = Fraction.average(ints1);
		assertEquals(0, avgFraction1.numerator);
		assertEquals(1, avgFraction1.denominator);
		
		//3
		// edge case all numbers in array are the same
		int[] ints2 = new int[] {-5, -5, -5, -5};
		Fraction avgFraction2 = Fraction.average(ints2);
		assertEquals(-5, avgFraction2.numerator);
		assertEquals(1, avgFraction2.denominator);
		
		
		//4
		// only one element in array
		int[] ints3 = new int[] {-14};
		Fraction avgFraction3 = Fraction.average(ints3);
		assertEquals(-14, avgFraction3.numerator);
		assertEquals(1, avgFraction3.denominator);
		
	}
	
	@Test
	/*
	 * test Equals function with edge cases
	 */
	public void testEquals() {
		Fraction t1 = new Fraction(50,100);
		Fraction t2 = new Fraction(6,12);
		
		Fraction t3 = new Fraction(3,16);
		Fraction t4 = new Fraction(4,16);
		
		Fraction t5 = new Fraction(-10,16);
		Fraction t6 = new Fraction(5,-8);
		
		Fraction t7 = new Fraction(0,16);
		Fraction t8 = new Fraction(0,100);
		
		assertTrue(t1.equals(t2));
		assertFalse(t3.equals(t4));
		assertTrue(t5.equals(t6));
		assertTrue(t7.equals(t8));
	}
	


}

	