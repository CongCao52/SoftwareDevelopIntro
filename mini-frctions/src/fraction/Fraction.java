package fraction;
/*
 * Represents the calculation of fraction number. 
 */
public class Fraction{
       //initialize the variables
		public int numerator; 
		public int denominator; 
		public int common_factor; 
		
		
		/*
		 * Get the greatest common divisor with numerator a and denominator b
		 * return a integer
		 */
		public static int gcd (int a,int b) {
			a = Math.abs(a);
			b = Math.abs(b);
			
	        if(b==0)
	            return a;
	        else
	            return gcd(b,a%b);
		}
		
		/*
		 * default constructor
		 */
		public Fraction() {
			this.numerator = 0;
			this.denominator = 1;
			this.common_factor = 1;
		}
		/*
		 * constructor get the input and change the signs respect to numerator and denominator
		 */
		public Fraction(int numerator, int denominator) {
			
			if (denominator<0) {  
				this.numerator = -1*numerator; 
				this.denominator = -1*denominator;
			}
			else {
			
			this.numerator = numerator; 
			this.denominator = denominator; 
			}
			
			//reduceToLowestForm();
					
		}
		/*
		 * void function reduce current fraction by eliminating common factors
		 * return nothing
		 */
		public void reduceToLowestForm() {
			if (this.numerator==0 && this.denominator!=0){
				this.denominator = 1;
				
			}
			else if(this.denominator ==0) {
				 throw new ArithmeticException("Denominator is zero!");
				
			}
			else {  //get common divisor and put into the fraction
			this.common_factor = gcd(this.numerator, this.denominator);
				this.numerator =  this.numerator / this.common_factor;
				this.denominator = this.denominator / this.common_factor;	
		}}
		/*
		 * add the current fraction to the given otherFraction
		 */

		public Fraction add(Fraction otherFraction) {
			int x = this.numerator * otherFraction.denominator + this.denominator * otherFraction.numerator;
			int y = this.denominator * otherFraction.denominator;
			Fraction newf = new Fraction(x,y);
			newf.reduceToLowestForm();
			return newf; 
			
		}
		/*
		 * subtract the given otherFraction from the current fraction
		 */
		public Fraction subtract(Fraction otherFraction) {
			int x = this.numerator * otherFraction.denominator - this.denominator * otherFraction.numerator;
			int y = this.denominator * otherFraction.denominator;
			Fraction newf = new Fraction(x,y);
			newf.reduceToLowestForm();        //reduce the form
			return newf; 
		}
		/*
		 * multiply the current fraction by the given otherFraction
		 */
		public Fraction mul(Fraction otherFraction) {
			int x = this.numerator * otherFraction.numerator;
			int y = this.denominator * otherFraction.denominator;
			Fraction newf = new Fraction(x,y);
			newf.reduceToLowestForm();         //reduce the form
			return newf; 
		}
		
		/*
		 * divide the current fraction by the given otherFraction
		 */
		public Fraction div(Fraction otherFraction) {
			int x = this.numerator * otherFraction.denominator;
			int y = this.denominator * otherFraction.numerator;
			Fraction newf = new Fraction(x,y);
			newf.reduceToLowestForm();
			return newf; 
		}
		
		/*
		 * return this fraction in decimal form
		 */
		public double decimal() {
			double x = this.numerator;
			double y = this.denominator;
			double z = x / y;
			return z; 
			
		}	
		/*
		 * square the current fraction and reduces it to lowest form
		 */
		
		public void sqr() {
			int x = this.numerator * this.numerator; 
			int y = this.denominator * this.denominator;
			Fraction newf = new Fraction(x,y);
			newf.reduceToLowestForm();            //reduce it to lowest form
			this.numerator = newf.numerator;
			this.denominator = newf.denominator; 
		}		
		
		/*
		 * Average the current fraction with the given otherFraction
		 * return a new fraction that is the average of this fraction and the otherFraction
		 */

		public Fraction average(Fraction otherFraction) {
			int x = this.numerator * otherFraction.denominator + this.denominator * otherFraction.numerator;
			int y = this.denominator * otherFraction.denominator;
			x = x * 1;
			y = y * 2;
			
			Fraction newf = new Fraction(x,y);
			newf.reduceToLowestForm();   //reduce to the lowest form
			return newf; 
		}		
		
		/*
		 * static method to average all of the fraction in the given array
		 */
		public static Fraction average(Fraction[] fractions) {
			if(fractions.length ==0) { 
			return new Fraction(0,1);
			}else {          //initial the first fraction in the array. 
			int x = fractions[0].numerator;
			int y = fractions[0].denominator;
			
			//add each denominator and numerators with calculation. 
			for(int i = 0; i<fractions.length-1;i++) {
			x =	x * fractions[i+1].denominator + y * fractions[i+1].numerator;
			y = y * fractions[i+1].denominator;	
			}
			y = y * fractions.length;      //take the average
			
			Fraction newf = new Fraction(x,y);  //reduce to the lowest form
			newf.reduceToLowestForm();
			return newf; 	
			
			}
			
		}
		/*
		 * static method to average all of the integers in the given array
		 */
		public static Fraction average(int[] ints) {
		if(ints.length ==0) { 
				return new Fraction(0,1);
				} else {
			
		int x = 0;	                                     
		for(int i = 0; i< ints.length;i++) {
			x = x + ints[i];                         //add the integers
			}		
			int y = ints.length;             //put the last integers as denominator    
			Fraction newf = new Fraction(x,y);         
			newf.reduceToLowestForm();
			return newf; 
			
				}
		
		}
		
		
		
		//@override
		/*
		 * overriden method to compare the given object to the current fraction for equality
		 * two fractions are considered equal if they have the same numerator and same denominator, after eliminating common factors.
		 */
		public boolean equals(Object object) {
			Fraction newFrac = (Fraction) object;
			Fraction oldFrac = new Fraction(this.numerator, this.denominator);
			newFrac.reduceToLowestForm();
			oldFrac.reduceToLowestForm();
			
			if(newFrac.numerator == oldFrac.numerator && newFrac.denominator == oldFrac.denominator) {
				return true; 
			}
			else {return false;} 
		}
        /*
         * overriden method to return a string representation of the current fraction		
         */
		public String toString() {

			return (this.numerator + "/" + this.denominator);
			
		}
		
		
}
