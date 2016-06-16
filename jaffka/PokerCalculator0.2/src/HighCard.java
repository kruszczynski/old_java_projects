import java.util.ArrayList;

public class HighCard{
		
		public HighCard(){}
		
		public int isHighCard(Board testBoard){
			ArrayList<Card> community = testBoard.getArrayList();
			int res = -1;
			for(Card Temp : community){
				if(Temp.getFigure() > res)
					res = Temp.getFigure();
			}
			if(testBoard.containsHowManyOf(0) == 1)
				res = 0;
			return res;
		}
	}