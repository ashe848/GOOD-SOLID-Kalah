package kalah.actions;

import kalah.board.CountAndCaptureBoard;
import kalah.board.House;

/**
 * Can only capture if opposite house is non empty
 * 
 * @author Abby S
 *
 */
public class NonEmptyCaptureAction extends CaptureAction {
	private int _endingHouseIndex;
	private House _endingHouse;
	private CountAndCaptureBoard _board;

	public void setEndingHouseIndex(int endingHouseIndex) {
		_endingHouseIndex = endingHouseIndex;	
	}

	public void act(CountAndCaptureBoard board) {
		_board = board;
		_endingHouse = (House) _board.getPit(_endingHouseIndex);
		
		//your ending house was not empty before
		if(_endingHouse.getNumberOfSeeds() != 1){
			return;
		}
		
		House oppositeHouse = (House) _board.getPit(oppositeHouseIndex());
		if(oppositeHouse.getNumberOfSeeds() > 0){
			int seedsToAdd = _endingHouse.takeSeeds() + oppositeHouse.takeSeeds();
			int storeIndex = _board.getBoardLayout().convertStoreToPitIndex(_endingHouse.getOwnerNum());
			_board.getPit(storeIndex).addSeeds(seedsToAdd);
		}
	}

	private int oppositeHouseIndex() {
		int oppositePlayerNum = _board.getBoardLayout().getOpposingPlayerNum(_endingHouse.getOwnerNum());
		int oppositeHouseNum = _board.getBoardLayout().getOpposingHouseNum(_endingHouse.getHouseNum());
		
		return _board.getBoardLayout().convertHouseToPitIndex(oppositePlayerNum, oppositeHouseNum);
	}	
}
