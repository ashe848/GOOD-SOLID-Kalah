package kalah.board;

public abstract class Pit {

	public abstract int getOwnerNum();
	
	public abstract int getNumberOfSeeds();
	
	public void addSeed(){
		addSeeds(1); //so if do something else when add seed only change 1 place
	}
	
	public abstract void addSeeds(int numberToAdd);
	
	public String toString(){
		return String.format("%2d", getNumberOfSeeds());
	}
}
