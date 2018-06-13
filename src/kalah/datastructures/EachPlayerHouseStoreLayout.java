package kalah.datastructures;

import kalah.Kalah;

public class EachPlayerHouseStoreLayout implements BoardLayout{

	public int convertHouseToPitIndex(int playerNum, int houseNum){
		int earlierPlayers = convertPlayerToIndex(playerNum);
		int earlierPits = earlierPlayers *(Kalah.HOUSES_PER_PLAYER+Kalah.STORES_PER_PLAYER);
		return earlierPits + (houseNum-Kalah.FIRST_HOUSE_NUM);
	}

	public int convertStoreToPitIndex(int playerNum){
		int effectiveHouseNumber = Kalah.FIRST_HOUSE_NUM + Kalah.HOUSES_PER_PLAYER;
		return convertHouseToPitIndex(playerNum, effectiveHouseNumber);
	}

	public int convertPlayerToIndex(int playerNum){
		return playerNum - Kalah.FIRST_PLAYER_NUM;
	}
	
	public int convertIndexToPlayer(int playerIndex) {
		return playerIndex + Kalah.FIRST_PLAYER_NUM;
	}

	public int getOpposingHouseNum(int houseNum) {
		int sumOfOpposingHouseNums = Kalah.FIRST_HOUSE_NUM + Kalah.HOUSES_PER_PLAYER;
		return sumOfOpposingHouseNums - houseNum;		
	}
	
	//let opp player be next player in player list
	public int getOpposingPlayerNum(int currentPlayerNum){
		int currentPlayerIndex = convertPlayerToIndex(currentPlayerNum);
		return convertIndexToPlayer(currentPlayerIndex + 1); 
	}
}
