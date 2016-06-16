public class FullHouse{
		
		public FullHouse(){}
		
		public int[] isFullHouse(Board testBoard){
			int res[] = {-1,-1};
			if(testBoard.containsHowManyOf(0) == 3){
				res[0] = 0;
				for(int i = 12;i>0;i--){
					if(testBoard.containsHowManyOf(i) >1){
						res[1] = i;
						break;
					}
				}
			}else{
				for( int i = 12;i>0; i--){
					if(testBoard.containsHowManyOf(i) == 3){
						res[0] = i;
						break;
					}
				}
				if(testBoard.containsHowManyOf(0) == 2)
					res[1] = 0;
				else{
					for(int i =12; i> 0; i--){
						if(testBoard.containsHowManyOf(i) >1 && i!=res[0]){
								res[1] = i;
								break;
							}
						}
					}
				}
		
			return res;
		}
		
	}