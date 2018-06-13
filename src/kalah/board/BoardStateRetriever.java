package kalah.board;

/**
 * Retrieves a string representation of board state in order to display it
 * 
 * @author Abby S
 *
 */
public interface BoardStateRetriever {
	public String[] retrieveState(CountAndCaptureBoard board);
}
