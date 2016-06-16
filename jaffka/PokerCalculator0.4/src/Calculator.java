import com.javaflair.pokerprophesier.api.adapter.*;
import com.javaflair.pokerprophesier.api.exception.*;
import com.javaflair.pokerprophesier.api.helper.*;

public class Calculator {
	
	// Wiec tak: musimy odpalic countProb od Situacji, gdzie sa karty i community
	// potem trzeba sprawdzic czy wszystko sie udalo simulationCheck()
	// i na koniec otrzymac array ilosci zwyciezcow.
	
	// variables
	
	// the sim adapter from javaflair
	private PokerProphesierAdapter simulationAdapter = new PokerProphesierAdapter();
	
	// local num of plrs
	private int numberOfPlayers = 0;
	
	// helper
	private PlayerGameStatsHelper simulationResultTool;
	
	// crash getWinProbs() preventer
	private boolean inCaseOfError = true;
	
	// methods
	
	// the one that counts specific situation
	public void countProb( Situation one){
		inCaseOfError = false;
		int state = one.getSimulationState();
		simulationAdapter.setNumSimulations(2000000);
		try{
			simulationAdapter.runPlayerSimulations(one.getPlayersHoleCards(), one.getCommunityCards(), state);
		}catch(SimulatorException ex){
			System.out.println("dupsko");
			inCaseOfError = true;
		}
		simulationResultTool = simulationAdapter.getPlayerGameStatsHelper();
		numberOfPlayers = one.getNumberOfPlayers();
	}
	
	// the one that gets winning probabilities
	public float[] getWinProbs(){
		float[] resultFloatArray = new float[numberOfPlayers];
		for(int i=0;i< numberOfPlayers;i++){
			resultFloatArray[i] = simulationResultTool.getPlayerProb(i)*100 ;
		}
		return resultFloatArray;
	}
	
	// sim checker
	
	public boolean simulationCheck(){
		if(!inCaseOfError)
			return true;
		else
			return false;
	}
}
