package kalah.board;

import kalah.Kalah;

/**
 * Represents the state of the board using ASCII characters
 * 
 * @author Abby S
 *
 */
public class ASCIIBoardRepresentation implements BoardStateRetriever {
	private CountAndCaptureBoard _board;
	private String[] _boardState;
	
	public String[] retrieveState(CountAndCaptureBoard board) {
		_board = board;
		_boardState = new String[]{outerBorder(), topLine(), innerBorder(), bottomLine(), outerBorder()};
		return _boardState;
	}	

	private String topLine() {
		String topLine = "";
		topLine+="| P2 |";
		for(int houseNum=Kalah.LAST_HOUSE_NUM; houseNum>=Kalah.FIRST_HOUSE_NUM; houseNum--){
			topLine+=_board.getPit(_board.getBoardLayout().convertHouseToPitIndex(2, houseNum)); //gets the house and toStrings it
			topLine+="|";
		}
		topLine+=_board.getPit(_board.getBoardLayout().convertStoreToPitIndex(1));		
		topLine+="|";

		return topLine;
	}

	private String innerBorder() {
		String innerBorder = "";
		innerBorder+="|    |";
		for(int i=0; i<Kalah.HOUSES_PER_PLAYER; i++){
			innerBorder+="-------";
			if(i!=Kalah.HOUSES_PER_PLAYER-1){
				innerBorder+="+";//print + in between houses
			}
		}
		innerBorder+="|    |";
		
		return innerBorder;
	}

	private String bottomLine() {
		String bottomLine = "";
		bottomLine+="|";
		bottomLine+=_board.getPit(_board.getBoardLayout().convertStoreToPitIndex(2));		

		for(int houseNum=Kalah.FIRST_HOUSE_NUM; houseNum<=Kalah.LAST_HOUSE_NUM; houseNum++){
			bottomLine+="|";
			bottomLine+=_board.getPit(_board.getBoardLayout().convertHouseToPitIndex(1, houseNum)); //gets the house and toStrings it
		}
		bottomLine+="| P1 |";
		
		return bottomLine;	
	}

	private String outerBorder() {
		String outerBorder = "";
		outerBorder+="+----+";
		for(int i=0; i<Kalah.HOUSES_PER_PLAYER; i++){
			outerBorder+="-------+";
		}
		outerBorder+="----+";
		
		return outerBorder;
	}	
}
