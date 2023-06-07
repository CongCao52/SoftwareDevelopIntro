package battleship;

public class EmptySea extends Ship {

	/*
	 * Default constructor,set the zero length variable to be 1 and call the constructor in the super class
	 */
	
	public EmptySea() {
		super();
		this.setlength(1);
	}

	/**
	 * This method overrides shootAt(int row, int column) that is inherited from Ship, and always
	 * returns false to indicate that nothing was hit.
	 */
	@Override
    public boolean shootAt(int row, int column){
       /*
    	if(this.bowRow == row && this.bowColumn == column){
            this.hit[0] = true;
        }
        */
        return false;
    }

	/**
	 * This method overrides isSunk() that is inherited from Ship, and always returns false to
	 * indicate that you didn't sink anything.
	 */
	@Override
	public boolean isSunk(){
		return false;
	}

	/**
	 * Returns a single-character String to use in the Ocean鈥檚 print method.
	 */
	@Override
	public String toString() {
        return "-";
    }

	/**
	 * This method just returns the string "empty"
	 */
	@Override
    public String getShipType() {
        return "empty";
    }
	

}
