public class TwoPair{
		
		public TwoPair(){}
		
		public int[] isTwoPair(Board testBoard){
			int res[] = {-1,-1,-1};
			for(int i=1; i<13;i++){
				if(testBoard.containsHowManyOf(i) == 2){
					res[1] = res[0];
					res[0] = i;
				}
			}
			if(testBoard.containsHowManyOf(0) == 2){
				res[1] = res[0];
				res[0] = 0;
				for(int i = 12; i>0;i--){
					if(testBoard.containsHowManyOf(i) == 1){
						res[2] = i;
						break;
					}
				}
			}else if(testBoard.containsHowManyOf(0)==1){
				res[2] = 0;
			}else{
				for(int i = 12; i>0;i--){
					if(testBoard.containsHowManyOf(i) ==1){
						res[2] = i;
						break;
					}
				}
			}
			return res;
		}
	}