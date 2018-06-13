package kalah.board;

import kalah.Kalah;
import kalah.datastructures.BoardLayout;
import kalah.datastructures.CircularList;
import kalah.datastructures.GameObjectContainer;

/**
 * Interface for manipulating the contents of the board
 * Manages Pits
 * 
 * @author Abby S
 *
 */
public class KalahBoard extends CountAndCaptureBoard {
	private GameObjectContainer<Pit> _pits;
	private BoardLayout _layout;
	private boolean _reverseIteratingDirection;

	public KalahBoard(BoardLayout layout, boolean reverseIteratingDirection) {
		_pits = new CircularList<>();
		_layout = layout;
		_reverseIteratingDirection = reverseIteratingDirection;
		
		for(int p=Kalah.FIRST_PLAYER_NUM; p<Kalah.FIRST_PLAYER_NUM+Kalah.NUMBER_OF_PLAYERS; p++){
			addHouses(p);
			addStores(p);
		}
	}

	private void addHouses(int p) {
		int houseNum = Kalah.FIRST_HOUSE_NUM;
		for(int i=0; i<Kalah.HOUSES_PER_PLAYER; i++){
			_pits.add(new House(houseNum++, p));
		}
	}

	private void addStores(int p) {
		_pits.add(new Store(p)); //as STORES_PER_PLAYER == 1, only adds 1 store, only contains owner num
	}

	public Pit getPit(int index) {
		return _pits.get(index);
	}

	public Pit getNextPit(int currentIndex) {
		return _pits.get(currentIndex + (_reverseIteratingDirection?-1:1));
	}
	
	public boolean areEmptyPits(int startIndex, int endIndex) {
		for(int i=startIndex; i<=endIndex; i++){
			if(_pits.get(i).getNumberOfSeeds()>0){
				return false;
			}
		}
		return true;
	}

	public BoardLayout getBoardLayout() {
		return _layout;
	}
}
