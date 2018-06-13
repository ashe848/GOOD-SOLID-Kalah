package kalah.board;

import kalah.actions.BoardAction;
import kalah.datastructures.BoardLayout;

/**
 * The collective representing some layout of Pits
 * 
 * @author Abby S
 *
 */
public abstract class CountAndCaptureBoard {
	
	public void apply(BoardAction boardAction){
		boardAction.act(this);
	}
	
	public abstract Pit getPit(int index);
	
	public abstract Pit getNextPit(int currentIndex);
	
	public abstract boolean areEmptyPits(int startIndex, int endIndex);
	
	public abstract BoardLayout getBoardLayout();
}
