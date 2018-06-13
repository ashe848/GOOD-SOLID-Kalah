package kalah.actions;

import kalah.board.CountAndCaptureBoard;
import kalah.board.House;
import kalah.board.Pit;
import kalah.board.Store;

public class SowAction extends BoardAction {
	private int _pitIndex;
	private boolean _hasAnotherMove=false;
	private CaptureAction _captureAction;
	
	public SowAction(int startingHouseIndex, CaptureAction captureAction) {
		_pitIndex = startingHouseIndex;
		_captureAction = captureAction;
	}

	public void act(CountAndCaptureBoard board) {
		House startHouse = (House) board.getPit(_pitIndex);
		if(startHouse.isEmpty()){
			throw new EmptyStartHouseException();
		}
		
		int seedsToSow = startHouse.takeSeeds();
		while(seedsToSow > 0){
			Pit pit = board.getNextPit(_pitIndex++);
			if(pit instanceof Store && pit.getOwnerNum() != startHouse.getOwnerNum()) {
				continue; //don't sow in opponents store
			}
			pit.addSeed();
			seedsToSow--;
		}
		Pit endingPit = board.getPit(_pitIndex);
		
		boolean sameOwner = endingPit.getOwnerNum()==startHouse.getOwnerNum();
		if(endingPit instanceof Store && sameOwner){ //landed on own store
			_hasAnotherMove = true;
		} else if(endingPit instanceof House && sameOwner){ //attempt to capture
			_captureAction.setEndingHouseIndex(_pitIndex);
			board.apply(_captureAction);
		}
	}

	public boolean hasAnotherMove(){
		return _hasAnotherMove;
	}
}
