package kalah.board;

import kalah.Kalah;

public class House extends Pit{
	private int _houseNum;
	private int _ownerPlayerNum;
	private int _numberOfSeeds=0;
	
	protected House(int houseNum, int playerNum){
		_houseNum = houseNum;
		_ownerPlayerNum = playerNum;
		_numberOfSeeds = Kalah.INITIAL_SEEDS_PER_HOUSE;
	}
	
	public int getHouseNum() {
		return _houseNum;
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
	
	public int takeSeeds(){
		int seeds = _numberOfSeeds;
		_numberOfSeeds = 0;
		return seeds;
	}
	
	public boolean isEmpty(){
		return _numberOfSeeds==0;
	}
	
	public String toString(){
		return " " + _houseNum + "[" + super.toString() + "] ";
	}
}
