package battleship;
public abstract class Ship {

    // The row that contains the bow (front part of the ship)
	private int bowRow;

    // The column that contains the bow (front part of the ship)
	private int bowColumn;

    // private int length
	private int length;

    // A boolean that represents whether the ship is going to be placed horizontally or vertically
	private boolean horizontal;

    // An array of booleans that indicate whether that part of the ship has been hit or not
	public boolean[] hit = new boolean[4];
	
	
	public Ship() {
		this.bowRow = 0;
		this.bowColumn =0;
		this.horizontal = false;	
	}
	public abstract String getShipType();
	
	public Ship(int length) {
		this.length = 0;
		this.hit = new boolean[length];
	}

    // Returns the ship length
	public int getLength() {
		return this.length;
	}

    // Returns the row corresponding to the position of the bow
	public int getBowRow() {
		return this.bowRow;
	}

    // Returns the bow column location
	public int getBowColumn() {
		return this.bowColumn;
	}

    // Returns the hit array
	public boolean[] getHit() {
		
		return this.hit;
	}

    // Returns whether the ship is horizontal or not
	public boolean isHorizontal() {
		return this.horizontal;
	}

	
	public void setlength(int len) {
		this.length = len;
	}
	// setters
    // Sets the value of bow row
	public void setBowRow(int row) {
		this.bowRow = row;
	}

    // Sets the value of bow column
	public void setBowColumn(int column) {
		this.bowColumn = column; 
	}

    // Sets the value of the instance variable horizontal
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

    /**
     * Returns true if it is okay to put a ship of this length with its bow in this location, with the
     * given orientation, and returns false otherwise. The ship must not overlap another ship, or
     * touch another ship (vertically, horizontally, or diagonally), and it must not be touched or go
     * beyond the array. Do not actually change either the ship or the Ocean, just says whether it is
     * legal to do so.
     *
     * @param row
     *        the row line of the location of ship
     * @param column
     *        the column line of the location of ship
     * @param horizontal
     *        true if the given ship represents a horizontal direction
     *        false otherwise
     * @param ocean
     *        the new object Ocean we set up
     * @return  {@code true} if the given location meets the need to put the ships
     *          {@code false} otherwise
     */
    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        if (horizontal) {
          //check if the ship will go out of boundary
            if (column - length < 0) {
                return false;
            }
           // check if ship are closely next to each other or being occupied
            for (int r = row - 1; r < row + 2; r++) {
                for (int c = column - length - 1; c < column + 2; c++) {
                    try {
                        if (ocean.isOccupied(r, c)) {
                            return false;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                }
            }
        } else {
          //check if the ship will go out of boundary
            if (row - length < 0) {
                return false;
            }
          // check if ship are closely next to each other or being occupied
            for (int r = row -length - 1; r < row + 2; r++) {
                for (int c = column - 1; c < column + 2; c++) {
                    try {
                        if (ocean.isOccupied(r, c)) {
                            return false;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                }
            }
        }
        return true;
    }

    /**
     * place the ship in the ocean. This involves giving values to the bowRow,
     *  bowColumn, and horizontal instance variables in the ship, and it also involves
     *  putting a reference to the ship in each of 1 or more locations (up to 4) in the ships
     *  array in the Ocean object. (Note: This will be as many as four identical
     *  references)
     * @param row
     *        the row line of the location of ship
     * @param column
     *        the column line of the location of ship
     * @param horizontal
     *        true if the given ship represents a horizontal direction
     *        false otherwise
     * @param ocean
     *        the new object Ocean we set up
     */
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        this.setBowRow(row);
        this.setBowColumn(column);
        this.setHorizontal(horizontal);
        int i;

        if (horizontal) {
            for(i = column; i >= column - this.length + 1; --i) {
                ocean.getShipArray()[row][i] = this;
            }
        }

        if (!horizontal) {
            for(i = row; i >= row - this.length + 1; --i) {
                ocean.getShipArray()[i][column] = this;
            }
        }
    }

    /**
     * If a part of the ship occupies the given row and column, and the ship hasn't been sunk, mark
     * that part of the ship as 'x' (in the hit array, 0 indicates the bow) and return true,
     * otherwise return false.
     * @param row
     *        the row line of the location of ship
     * @param column
     *        the column line of the location of ship
     * @return  {@code true} if a part of the ship was hit
     *          {@code false} otherwise
     */
    public boolean shootAt(int row, int column){
        
    	if (this.isSunk()) {
            return false;
        } else if (this.horizontal) {
            if (row == this.bowRow && column >= this.bowColumn-this.length + 1 && column <= this.bowColumn) {
                this.hit[this.length-this.bowColumn+column-1] = true;
            	
                return true;
            } else {
                return false;
            }
        } else if (column == this.bowColumn && row >= this.bowRow-this.length+1 && row <= this.bowRow) {
            this.hit[this.length-this.bowRow+ row-1] = true;
          
            return true;
        } else {
            return false;
        }
    }

    /**
     * Return true if every part of the ship has been hit, false otherwise.
     * @return  {@code true} if every part of the ship was hit
     *          {@code false} otherwise
     */
    boolean isSunk(){
        for(int i = 0; i < this.length; i++){
        	
            if(hit[i] != true){
                return false;
            }
        }
        
        return true;
    }

    /**
     * Returns a single-character String to use in the Ocean's print method (see below).
     * <p>
     * This method should return 's' if the ship has been sunk and 'x' if it has not been sunk. This
     * method can be used to print out locations in the ocean that have been shot at; it should not be
     * used to print locations that have not been shot at.
     * <p>
     * Since toString behaves exactly the same for all ship types, it can be moved into the Ship
     * class.
     * @return  "x" if a part of the ship was hit but not sunk
     *          "S" if the ship has been sunk
     */
    @Override
    public String toString() {
      
          if (this.isSunk() == true) {
        	  
            return "s";
            
        } else {
        	
            return "x";
        }
    }   
}