package kalah.board;

public class Store extends Pit{
	private int _ownerPlayerNum;
	private int _numberOfSeeds=0;
	
	protected Store(int playerNum) {
		_ownerPlayerNum = playerNum;
	}
	
	public int getOwnerNum() {
		return _ownerPlayerNum;
	}
	
	public int getNumberOfSeeds(){
		return _numberOfSeeds;
	}
	
	public void addSeeds(int numberToAdd){
		_numberOfSeeds += numberToAdd;
	}
	
	public String toString(){
		return " " + super.toString() + " ";
	}
}
