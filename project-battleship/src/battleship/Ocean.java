package battleship;
import java.util.Random;
public class Ocean {

	// Used to quickly determine which ship is in any given location
	private Ship[][] ships = new Ship[10][10];

	// The total number of shots fired by the user
	private int shotsFired;

	/*
	 * The number of times a shot hit a ship. If the user shoots the same
	 * part of a ship more than once, every hit is counted, even though
	 * additional “hits” don’t do the user any good.
	 */
	private int hitCount;

	// The number of ships sunk (10 ships in all)
	private int shipsSunk;

	// Creates an ”empty” ocean filled the ships array with EmptySea objects.
	private String[][] display; 
	
	/*
	 * default constructor
	 */
	public Ocean() {
		// initializes any game variables, such as how many shots have been fired
		this.shotsFired =0;
		this.hitCount = 0;
		this.shipsSunk = 0;

		// filled the ”empty” ocean with a bunch of EmptySea instances.
		for(int i=0; i<=9; i++) {
			for(int j = 0; j<=9; j++) {
				this.ships[i][j] = new EmptySea();
				this.ships[i][j].setBowColumn(j);
				this.ships[i][j].setBowRow(i);
				
			}	
		}
		this.displayArray();
	}

	/**
	 *  Place all ten ships randomly on the (initially empty) ocean
	 */
    void placeAllShipsRandomly() {
        Random random = new Random();
        Ship[] ships = new Ship[10];
        /* Large ships are placed before the small ones to avoid running out of
         * legal spaces to place them.
         */
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                ships[i] = new Battleship(); // put one battleship first
            } else if (i < 3) {
                ships[i] = new Cruiser();    // put two cruisers secondly
            } else if (i < 6) {
                ships[i] = new Destroyer();  // put three destroyers thirdly
            } else if (i < 10) {
                ships[i] = new Submarine();  // put four submarines lastly
            }
        }

        for (Ship ship : ships) {
            while (true) {
                int row = random.nextInt(10);       // return integer between 0 and 9 as row number
                int column = random.nextInt(10);    // return integer between 0 and 9 as column number
                boolean horizontal = random.nextBoolean();// return true or false to determine the direction of ship
                // if the location meets the need to put a ship, then put it.
                boolean check = ship.okToPlaceShipAt(row, column, horizontal, this);
                if (check ==true) {
                    ship.placeShipAt(row, column, horizontal, this);
                    break;}
            }
        }
    }

	/** Returns true if the given location contains a ship, false if it does not
	 *
	 * @param row
	 * @param column
	 * @return true if the given location contains a ship
	 *         false otherwise
	 */
	boolean isOccupied(int row, int column) {
		if(row<0 || column<0) {
			return false;
		}
		else if(this.ships[row][column].getShipType() !="empty") {return true;}
		else {return false;}
		
	}

	/**
	 * Returns true if the given location contains a ”real” ship, still afloat, (not an EmptySea),
	 * false if it does not. In addition, this method updates the number of shots that have been
	 * fired, the number of hits and shipsSunk. Note: If a location contains a ”real” ship, shootAt
	 * should return true every time the user shoots at that same location. Once a ship has been
	 * ”sunk”, additional shots at its location should return false.
	 * @param row
	 * @param column
	 * @return true if the given location contains a ”real” ship
	 *         false when shot at an empty sea
	 */
	boolean shootAt(int row, int column) {
		
		this.shotsFired = this.shotsFired +1 ;
		if(ships[row][column].shootAt(row,column)==true) {
			this.hitCount = this.hitCount+1;

			if (ships[row][column].isSunk()==true) {
				System.out.println("You just sank a ship - " + this.ships[row][column].getShipType());
				this.shipsSunk++;}


			return true;
		}
		
		else {return false;
		}
	}

	/**
	 * @return Returns the number of shots fired (in the game)
	 */
	int getShotsFired() {
	return this.shotsFired;	
	}

	/**
	 * @return Returns the number of hits recorded (in the game).
	 * All hits are counted, not just the first time a given square is hit
	 */
	int getHitCount() {
		return this.hitCount;
	}

	/**
	 * @return Returns the number of sunk ships recorded (in the game).
	 */
	int getShipsSunk() {
		return this.shipsSunk; 
	}

	/**
	 * @return Returns true if all ships have been sunk, otherwise false
	 */
	boolean isGameOver() {
		if(this.shipsSunk<10) {return false;}
		else {return true;}
	}

	/**
	 * @return Returns the 10x10 array of Ships.
	 */
	Ship[][] getShipArray(){
	return this.ships; 
	
	}

	/**
	 * USED FOR DEBUGGING PURPOSES ONLY.
	 * Prints the location of different kinds of ships. To aid the user, row numbers
	 * should be displayed along the left edge of the array, and column numbers should
	 * be displayed along the top. Numbers should be 0 to 9, not 1 to 10.
	 * <p>
	 * The top left corner square should be 0, 0.
	 * <p>
	 * Use Use ‘b’ to indicate a Battleship,  ‘c’ to indicate a Cruiser, ‘d’: Use ‘d’
	 * to indicate a Destroyer. Use ‘s’ to indicate a Submarine, Use ‘ ’ (single space)
	 * to indicate an EmptySea
	 * <p>
	 * and ’ ’ (a period) to indicate a location that there is "emptysea".
	 */
    public void printWithShips() {
        String[][] shipsDisplay = new String[11][11];
        for(int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++) {
                if (i == 0) {           // column numbers should be displayed along the top
                    shipsDisplay[i][j] = Integer.toString(j - 1);
                  
                } else if (j == 0) {    // row numbers should be displayed along the left edge of the array
                    shipsDisplay[i][j] = Integer.toString(i - 1);
                } 
                else if (this.getShipArray()[i - 1][j - 1].getShipType() == "battleship"){
                	
                    shipsDisplay[i][j] = "b";
                } else if (this.getShipArray()[i - 1][j - 1].getShipType() == "cruiser"){
                    shipsDisplay[i][j] = "c";
                } else if (this.getShipArray()[i - 1][j - 1].getShipType() == "destroyer"){
                    shipsDisplay[i][j] = "d";
                } else if (this.getShipArray()[i - 1][j - 1].getShipType() == "submarine") {
                    shipsDisplay[i][j] = "s";
                } else {
                    shipsDisplay[i][j] = " ";
                    
                }
            }
        }
	        // The top left corner square should be 0, 0
	        shipsDisplay[0][0] = " ";
	        for(int i = 0; i < shipsDisplay.length; i++) {
	            for(int j = 0; j < shipsDisplay.length; j++) {
	                System.out.print(shipsDisplay[i][j] + " ");
	            }

	            System.out.println();
	        }
	    }
	    
	  
	public void displayArray() {
        this.display = new String[11][11];
        for(int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++) {
                if (i == 0) {           // column numbers should be displayed along the top
                    this.display[i][j] = Integer.toString(j - 1);
                } else if (j == 0) {    // row numbers should be displayed along the left edge of the array
                    this.display[i][j] = Integer.toString(i - 1);
                } else {
                    this.display[i][j] = ".";
                }
            }
        }
        // The top left corner square should be 0, 0
        this.display[0][0] = " ";
    }

		/**
		 * Prints the ocean. To aid the user, row numbers should be displayed along the left edge of the
		 * array, and column numbers should be displayed along the top. Numbers should be 0 to 9, not 1
		 * to 10.
		 * <p>
		 * The top left corner square should be 0, 0.
		 * <p>
		 * Use ’S’ to indicate a location that you have fired upon and hit a (real) ship, ’-’ to indicate
		 * a location that you have fired upon and found nothing there, ’x’ to indicate a location
		 * containing a sunken ship,
		 * <p>
		 * and ’.’ (a period) to indicate a location that you have never fired upon.
		 */
	    public void changeDisplay(int row, int column) {
	        Ship x = this.getShipArray()[row][column];
	            if (x.isSunk()) {
	            	
	                int i;
	                if (x.isHorizontal()) {
	                    for(i = -x.getLength()+2; i <= 1; i++) {
	                        this.display[x.getBowRow() + 1][x.getBowColumn() + i] = this.getShipArray()[x.getBowRow()][x.getBowColumn()].toString();
	                    }
	                } else {
	                    for(i = -x.getLength()+2; i <= 1; i++) {
	                        this.display[x.getBowRow() + i][x.getBowColumn() + 1] = this.getShipArray()[x.getBowRow()][x.getBowColumn()].toString();
	                    }
	                }
	            }  else {
	            this.display[row + 1][column + 1] = this.getShipArray()[row][column].toString();
	                
	            } 
	    }


		  public void print() {
		        for(int i = 0; i < this.display.length; i++) {
		            for(int j = 0; j < this.display[i].length; j++) {
		                System.out.print(this.display[i][j] + " ");
		            }

		            System.out.println();
		        }
		    }
	}
