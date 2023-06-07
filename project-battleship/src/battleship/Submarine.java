package battleship;

public class Submarine extends Ship{
	
		
	public Submarine() {
		int len = 1;
		this.setlength(len);
	}
    
	@Override
	public int getLength() {
		return 1;
	}

	@Override
	public String getShipType() {
		return "submarine";
	}
	

	}
	
	