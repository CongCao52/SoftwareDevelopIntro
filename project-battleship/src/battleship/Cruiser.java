package battleship;


public class Cruiser extends Ship{
	public Cruiser() {
		int len =3;
		this.setlength(len);
	}
      
    
       public int getLength() {
   		return 3;
   	}

	@Override
	public String getShipType() {
		return "cruiser";
	}
	

	

}