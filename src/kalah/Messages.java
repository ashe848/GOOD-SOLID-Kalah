package kalah;

/**
 * Utility class representing messages that can be displayed during the game
 * 
 * @author Abby S
 *
 */
public class Messages {
	public static final String GAME_OVER_MESSAGE = "Game over";
	public static final String TIE_MESSAGE = "A tie!";
	public static final String QUIT_INPUT = "q";
	public static final String EMPTY_HOUSE_MESSAGE = "House is empty. Move again.";
	
	private Messages(){
		//private constructor to prevent instantiation
	}
	
	public static final String buildInputPrompt(int playerNum){
		return "Player P" + playerNum + "'s turn - Specify house number or '" + QUIT_INPUT + "' to quit: ";
	}
	
	public static final String buildPlayerScoreDisplay(int playerNum, int score){
		return "\tplayer " + playerNum + ":" + score;
	}
	
	public static final String buildWinnerDisplay(int winningPlayerNum) {
		return "Player " + winningPlayerNum + " wins!";
	}
}
