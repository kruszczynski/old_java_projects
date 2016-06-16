import com.javaflair.pokerprophesier.api.card.*;
import com.javaflair.pokerprophesier.api.exception.*;



public class Program {
	
	public static void main(String[] args){
		
		Situation test = new Situation();
		CardViewer cardViewer = new CardViewer();
		
		Card A1 = new Card(13,1);
		Card A2 = new Card(13,2);
		Card B1 = new Card(12,4);
		Card B2 = new Card(13,1);
		System.out.println( cardViewer.shortView(A1) + cardViewer.shortView(A2) + " oraz " + cardViewer.shortView(B1) + cardViewer.shortView(B2) );
		test.addPlayer(A1,A2);
		test.addPlayer(B1,B2);
		Calculator c = new Calculator();
		c.countProb(test);
		if(c.simulationCheck()){
			float a[] = c.getWinProbs();
			System.out.println( cardViewer.shortView(A1) + cardViewer.shortView(A2) + ": " + String.format( "%.1f" , a[0] ) + " " +
					cardViewer.shortView(B1) + cardViewer.shortView(B2)+ ": " + String.format( "%.1f", a[1] ));
		}
		
		TestInterface TI = new TestInterface();
		TI.test();
		
		SimpleAnimation kolko = new SimpleAnimation();
		kolko.go();
		
		
	}
}
