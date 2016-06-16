public class Trips{
		
		public Trips(){}
		
		public int[] isTrips(Board testBoard){
			int res[] = {-1,-1,-1};
			for(int i = 0; i< 13; i++){
				if( testBoard.containsHowManyOf(i) == 3){
						res[0] = i;
						if( res[0] == 0)
							break;
				}
			}
			if(res[0] >-1){
				if(res[0] == 0){
					int Counter = 1;
					for(int i = 12; i>0; i--){
						if(testBoard.containsHowManyOf(i)>0)
							res[Counter++] = i;
						if(Counter >2)
							break;
					}
				}else{
					int Counter = 1;
					boolean Ace = false;
					if( testBoard.containsHowManyOf(0)>0){
						res[1] = 0;
						Ace = true;
					}
					if(Ace){
						for(int i = 12; i>0; i--){
							if(testBoard.containsHowManyOf(i)>0){
								res[2] = i;
								break;
							}
						}
					}else{
						for(int i = 12; i>0;i--){
							if(testBoard.containsHowManyOf(i)>0)
								res[Counter++] = i;
							if(Counter>2)
								break;
						}
					}
				}
			}
			return res;
		}
	}