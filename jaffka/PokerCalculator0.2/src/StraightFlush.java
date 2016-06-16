import java.util.ArrayList;


public class StraightFlush {
	
	private ArrayList<Board> StraightFlushesList = new ArrayList<Board>();


	public StraightFlush(){
		for(int i = 0; i<4; i++){
			for( int j = 0; j<9; j++){
				Board Temp = new Board();
				Temp.add(new Card( i*13 + j ));
				Temp.add(new Card( i*13 + j + 1));
				Temp.add(new Card( i*13 + j + 2));
				Temp.add(new Card( i*13 + j + 3));
				Temp.add(new Card( i*13 + j + 4));
				StraightFlushesList.add(Temp);
			}
		}
	}
	
	public int isStraightFlush(Board testBoard){
		ArrayList<Card> community = testBoard.getArrayList();
		int res = -1;
		for( int i=0; i<3; i++){
			Board Temp = new Board();
			Temp.add(community.get(i));
			Temp.add(community.get(i+1));
			Temp.add(community.get(i+2));
			Temp.add(community.get(i+3));
			Temp.add(community.get(i+4));
			if( StraightFlushesList.contains(Temp)){
				res = community.get(i+4).getFigure();
			}
		}
		for(int i = 0; i<4 ; i++){
			if( 	community.contains(new Card(i*13 + 0)) &&
					community.contains(new Card(i*13 + 9)) &&
					community.contains(new Card(i*13 + 10)) &&
					community.contains(new Card(i*13 + 11)) &&
					community.contains(new Card(i*13 + 12)))
				res = 0;
		}
		return res;
	}
	
}
