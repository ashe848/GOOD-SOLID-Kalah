package kalah;

public class Player {
	private int _playerNumber;
	
	public Player(int playerNumber){
		_playerNumber = playerNumber;
	}
	
	public int getPlayerNumber() {
		return _playerNumber;
	}
	
	public String toString() {
		return String.valueOf(_playerNumber);
	}
}
