package battleship;

public class Destroyer extends Ship{
	public Destroyer() {
		int len = 2;
	  this.setlength(len);
	}
		
   
    @Override
	public int getLength() {
		return 2;
	}

	@Override
	public String getShipType() {
		return "destroyer";
	}
	

	}