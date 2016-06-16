public class OnePair{
		
		public OnePair(){}
		
		public int[] isOnePair(Board testBoard){
			int res[] = {-1,-1,-1,-1};
			for(int i=0; i<13; i++){
				if( testBoard.containsHowManyOf(i) == 2 ){
					res[0] = i;
					if( i == 0){
						int Counter = 1;
						for( int j = 12; j>0;j--){
							if(testBoard.containsHowManyOf(j) == 1)
								res[Counter++] = j;
							if(Counter>3)
								break;
						}
					}
					break;
				}
			}
			if(res[0] > 0){
				if(testBoard.containsHowManyOf(0) ==1){
					int counter = 1;
					res[counter++] = 0;
					for(int i = 12; i>0;i--){
						if(testBoard.containsHowManyOf(i) == 1)
							res[counter++] = i;
						if(counter>3)
							break;
					}
				}else{
					int Counter = 1;
					for(int i = 12; i>0;i--){
						if(testBoard.containsHowManyOf(i) == 1)
							res[Counter++] = i;
						if(Counter>3)
							break;
					}
				}
			}
			return res;
		}
	}