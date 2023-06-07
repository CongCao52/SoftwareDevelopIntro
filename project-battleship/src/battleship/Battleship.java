package battleship;
public class Battleship extends Ship{

	public Battleship() {
		int len = 4;
		this.setlength(len);
	}
        
  @Override
	public int getLength() {
		return 4;
	}
 @Override
public String getShipType() {
		return "battleship";
	}

}