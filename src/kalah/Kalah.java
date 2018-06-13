package kalah;

import com.qualitascorpus.testsupport.IO;
import com.qualitascorpus.testsupport.MockIO;

import kalah.actions.NonEmptyCaptureAction;
import kalah.actions.ScoreAction;
import kalah.actions.SowAction;
import kalah.board.CountAndCaptureBoard;
import kalah.board.KalahBoard;
import kalah.board.ASCIIBoardRepresentation;
import kalah.datastructures.CircularList;
import kalah.datastructures.EachPlayerHouseStoreLayout;
import kalah.datastructures.GameObjectContainer;

/**
 * This class is the starting point for a Kalah implementation using
 * the test infrastructure.
 */
public class Kalah implements CountAndCaptureGame {
	public static final int NUMBER_OF_PLAYERS = 2;
	public static final int FIRST_PLAYER_NUM = 1;
	public static final int STORES_PER_PLAYER = 1;
	public static final int HOUSES_PER_PLAYER = 6;
	public static final int INITIAL_SEEDS_PER_HOUSE = 4;
	public static final int FIRST_HOUSE_NUM = 1;
	public static final int LAST_HOUSE_NUM = FIRST_HOUSE_NUM + HOUSES_PER_PLAYER -1;
	private static final int STARTING_PLAYER_NUM = FIRST_PLAYER_NUM;

	private CountAndCaptureBoard _board = new KalahBoard(new EachPlayerHouseStoreLayout(), false);
	private GameObjectContainer<Player> _players = new CircularList<Player>();
	private int _currentPlayerNum;
	private Printer _printer;

	public static void main(String[] args) {
		new Kalah().play(new MockIO());
	}

	public void play(IO io) {
		registerPlayers();
		_printer = new Printer(_board, new ASCIIBoardRepresentation(), io);

		_printer.printBoard();
		while(!isGameOver(_currentPlayerNum)){
			String prompt = Messages.buildInputPrompt(_currentPlayerNum);
			int cancelResult = -1;
			int startingHouseNum = io.readInteger(prompt, FIRST_HOUSE_NUM, LAST_HOUSE_NUM, cancelResult, Messages.QUIT_INPUT);

			if(startingHouseNum == cancelResult){
				quit();
				return;
			}

			try {
				SowAction sower = new SowAction(_board.getBoardLayout().convertHouseToPitIndex(_currentPlayerNum, startingHouseNum),
						new NonEmptyCaptureAction());
				_board.apply(sower);

				if(!sower.hasAnotherMove()){
					switchTurn();
				}
			} catch (CountAndCaptureException e) { //something happened while trying to sow, try again
				_printer.print(e.getMessage());
			}
			_printer.printBoard();
		}
		finish();
	}

	private void registerPlayers(){
		int playerNum = STARTING_PLAYER_NUM;
		for(int i=0; i<NUMBER_OF_PLAYERS; i++){
			_players.add(new Player(playerNum++));
		}

		_currentPlayerNum = _players.get(0).getPlayerNumber();
	}

	private void switchTurn(){
		int currentPlayerIndex = _board.getBoardLayout().convertPlayerToIndex(_currentPlayerNum);
		_currentPlayerNum = _players.get(++currentPlayerIndex).getPlayerNumber();
	}

	private boolean isGameOver(int playerNum){
		int playerFirstHouseIndex = _board.getBoardLayout().convertHouseToPitIndex(playerNum, FIRST_HOUSE_NUM);
		int playerLastHouseIndex = _board.getBoardLayout().convertHouseToPitIndex(playerNum, LAST_HOUSE_NUM);
		return _board.areEmptyPits(playerFirstHouseIndex, playerLastHouseIndex);
	}

	private void quit() {
		_printer.print(Messages.GAME_OVER_MESSAGE);
		_printer.printBoard();
	}

	private void finish() {
		_printer.print(Messages.GAME_OVER_MESSAGE);
		_printer.printBoard();

		int winner = FIRST_PLAYER_NUM;
		int maxScore = 0;
		for(int p=FIRST_PLAYER_NUM; p<FIRST_HOUSE_NUM+NUMBER_OF_PLAYERS; p++){
			//use score action visitor on board to get score
			ScoreAction scoreAction = new ScoreAction(p);
			_board.apply(scoreAction);
			int score = scoreAction.getPlayerScore();

			_printer.print(Messages.buildPlayerScoreDisplay(p, score));
			if (score == maxScore){
				_printer.print(Messages.TIE_MESSAGE);
				return;
			} else if(score > maxScore){
				maxScore = score;
				winner = p;
			}
		}
		_printer.print(Messages.buildWinnerDisplay(winner));
	}
}
