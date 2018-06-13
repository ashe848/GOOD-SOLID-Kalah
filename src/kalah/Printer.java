package kalah;

import com.qualitascorpus.testsupport.IO;

import kalah.board.BoardStateRetriever;
import kalah.board.CountAndCaptureBoard;

/**
 * Does the act of displaying
 * @author Abby S
 *
 */
public class Printer {
	private CountAndCaptureBoard _board;
	private BoardStateRetriever _stateRetriever;
	private IO _io;

	Printer(CountAndCaptureBoard board, BoardStateRetriever stateRetriever, IO io){
		_board = board;
		_stateRetriever = stateRetriever;
		_io = io;
	}
	
	public void printBoard() {		
		for(String line:_stateRetriever.retrieveState(_board)){
			_io.println(line);
		}
	}
	
	public void print(String message) {
		_io.println(message);
	}
}
