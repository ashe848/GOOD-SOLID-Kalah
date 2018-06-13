package kalah.actions;

import kalah.Kalah;
import kalah.board.CountAndCaptureBoard;

public class ScoreAction extends BoardAction {
	private int _playerNum;
	private int _playerScore;
	
	public ScoreAction(int playerNum) {
		_playerNum = playerNum;
	}
	
	public void act(CountAndCaptureBoard board) {
		_playerScore = 0;
		
		for(int houseNum=Kalah.FIRST_HOUSE_NUM; houseNum<=Kalah.LAST_HOUSE_NUM; houseNum++){
			int houseIndex = board.getBoardLayout().convertHouseToPitIndex(_playerNum, houseNum);
			_playerScore += board.getPit(houseIndex).getNumberOfSeeds();
		}
		
		int storeIndex = board.getBoardLayout().convertStoreToPitIndex(_playerNum);
		_playerScore += board.getPit(storeIndex).getNumberOfSeeds();
	}
	
	public int getPlayerScore(){
		return _playerScore;
	}
}
