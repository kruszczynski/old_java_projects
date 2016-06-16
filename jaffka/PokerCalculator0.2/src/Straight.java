import java.util.ArrayList;

public class Straight{
		private ArrayList<Board> StraightsList = new ArrayList<Board>();
		
		public Straight(){
			for(int i=0;i<9;i++){
				Board Temp = new Board();
				Card c1 = new Card( i);
				Card c2 = new Card( i + 1);
				Card c3 = new Card( i + 2);
				Card c4 = new Card( i + 3);
				Card c5 = new Card( i + 4);
				Temp.add(c1);
				Temp.add(c2);
				Temp.add(c3);
				Temp.add(c4);
				Temp.add(c5);
				StraightsList.add(Temp);
			}
		}
		
		public int isStraight(Board testBoard){
			ArrayList<Card> community = testBoard.getArrayList();
			int res = -1;
			Board StraightenedBoard = new Board();
			for( Card Temp : community){
				Card TempCard = new Card(Temp.getFigure());
				if(!StraightenedBoard.contains(TempCard))
					StraightenedBoard.add(TempCard);
			}
			StraightenedBoard.sort();
			for( int i = 0; i<StraightenedBoard.getArrayList().size()-4; i++){
				Board TempBoard = new Board();
				TempBoard.add(StraightenedBoard.getArrayList().get(i));
				TempBoard.add(StraightenedBoard.getArrayList().get(i+1));
				TempBoard.add(StraightenedBoard.getArrayList().get(i+2));
				TempBoard.add(StraightenedBoard.getArrayList().get(i+3));
				TempBoard.add(StraightenedBoard.getArrayList().get(i+4));
				if(StraightsList.contains(TempBoard))
					res = StraightenedBoard.getArrayList().get(i+4).getFigure();
			}
			if( StraightenedBoard.contains( new Card(0))){
				if(	StraightenedBoard.contains( new Card(9)) &&
					StraightenedBoard.contains( new Card(10)) &&
					StraightenedBoard.contains( new Card(11)) &&
					StraightenedBoard.contains( new Card(12)) )
						res = 0;
			}
			return res;
		}
		
	}