package kalah.datastructures;

public interface BoardLayout {

	int convertHouseToPitIndex(int playerNum, int houseNum);

	int convertStoreToPitIndex(int playerNum);

	int convertPlayerToIndex(int playerNum);

	int convertIndexToPlayer(int playerIndex);

	int getOpposingHouseNum(int houseNum);

	int getOpposingPlayerNum(int currentPlayerNum);

}