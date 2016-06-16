import java.util.ArrayList;

public class Quads {
	
	public Quads(){}
	
	public int[] isQuads(Board testBoard){
		ArrayList<Card> community = testBoard.getArrayList();
		int res[] = {-1,-1};
		for( int i = 0; i<13; i++){
			if( testBoard.containsHowManyOf(i) == 4 ){
					res[0] = i;
					break;
			}
		}
		if( res[0] > -1){
			if(res[0] == 0){
				int kicker = -1;
				for( Card Temp : community){
					if( kicker < Temp.getFigure()){
						kicker = Temp.getFigure();
					}
					res[1] = kicker;
				}
			}else if( 	testBoard.containsHowManyOf(0) > 0){
				res[1] = 0;
			}else{
				for( int i = 12; i>0; i--){
					if(		testBoard.containsHowManyOf(i) > 0){
						res[1] = i;
						break;
					}
				}
			}
		}
		return res;
	}

}
