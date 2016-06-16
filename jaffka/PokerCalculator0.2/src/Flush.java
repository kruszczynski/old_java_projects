import java.util.ArrayList;

public class Flush{
		
		public Flush(){}
		
		public int isFlush(Board testBoard){
			ArrayList<Card> community = testBoard.getArrayList();
			int res = -1;
			int Counter;
			for( int i =0; i<4; i++){
				Counter = 0;
				for( Card Temp : community){
					if( Temp.getSuit() == i){
						Counter ++;
						if(Temp.getFigure() == 0 || res == 0)
							res = 0;
						else if(res<Temp.getFigure())
							res=Temp.getFigure();
						
					}
				}
				if(Counter < 5)
					res = -1;
				else
					break;
			}
			return res;
		}
	}