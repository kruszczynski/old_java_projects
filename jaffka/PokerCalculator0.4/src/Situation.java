import com.javaflair.pokerprophesier.api.card.*;

public class Situation {
	
	// variables
	
	// Array with players hole cards
	private HoleCards[] playersHoleCardsArray = new HoleCards[10];
	
	// Community Cards Object
	private CommunityCards situationCommunityCards = new CommunityCards();
	
	//num of plrs int
	private int numberOfPlayers = 0;
	
	// player adding method
	public void addPlayer( Card one, Card two){
		playersHoleCardsArray[numberOfPlayers] = new HoleCards(one,two);
		numberOfPlayers++;
	}
	
	//methods
	
	// commmunity cards adding methods
	
	//Flop
	public void addFlop( Card flopOne, Card flopTwo, Card flopThree){
		if(situationCommunityCards.size() == 0){
			situationCommunityCards.add(flopOne);
			situationCommunityCards.add(flopTwo);
			situationCommunityCards.add(flopThree);
		}
	}
	
	//Turn
	public void addTurn( Card turn){
		if(situationCommunityCards.size() == 3)
			situationCommunityCards.add(turn);
	}
	
	//River
	public void addRiver( Card river ){
		if( situationCommunityCards.size() == 4)
			situationCommunityCards.add(river);
	}
	
	//getter of Hole Cards
	public HoleCards[] getPlayersHoleCards(){
		return playersHoleCardsArray;
	}
	
	//getter od community cards
	public CommunityCards getCommunityCards(){
		return situationCommunityCards;
	}
	
	// sim state getter
	public int getSimulationState(){
		if( situationCommunityCards.size() == 0)
			return 1;
		if( situationCommunityCards.size() == 3)
			return 2;
		if( situationCommunityCards.size() == 4)
			return 3;
		if( situationCommunityCards.size() == 5)
			return 4;
		else
			return 0;
	}
	
	// no of players getter
	public int getNumberOfPlayers(){
		return numberOfPlayers;
	}
}
