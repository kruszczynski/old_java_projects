

public class HandTester {
	private StraightFlush testSF = new StraightFlush();
	private Quads testQ = new Quads();
	private FullHouse testFH = new FullHouse();
	private Flush testF = new Flush();
	private Straight testS = new Straight();
	private Trips testT = new Trips();
	private TwoPair testTP = new TwoPair();
	private OnePair testOP = new OnePair();
	private HighCard testHC = new HighCard();
	
	public HandTester(){}
	
	public int[] testIt(Board toBeTested){
		int i = 8;
		int res[] = {1,1,-1,-1,-1};
		int temp[] = {-1};
			switch(i){
			case 8:
				temp[0] = testSF.isStraightFlush(toBeTested);
				if( temp[0] != -1){
					res[0] = 8;
					res[1] = temp[0];
					break;
				}
			case 7:
				temp = testQ.isQuads(toBeTested);
				if( temp[0] != -1 && temp[1] != -1){
					res[0] = 7;
					res[1] = temp[0];
					res[2] = temp[1];
					break;
				}
			case 6:
				temp = testFH.isFullHouse(toBeTested);
				if( temp[0] != -1 && temp[1] != -1){
					res[0] = 6;
					res[1] = temp[0];
					res[2] = temp[1];
						break;
				}
			case 5:
				temp[0] = testF.isFlush(toBeTested);
				if( temp[0] != -1){
					res[0] = 5;
					res[1] = temp[0];
					break;
				}
			case 4:
				temp[0] = testS.isStraight(toBeTested);
				if( temp[0] != -1){
					res[0] = 4;
					res[1] = temp[0];
					break;
				}
			case 3:
				temp = testT.isTrips(toBeTested);
				if( 	temp[0] != -1 && temp[1] != -1 && temp[2] != -1){
					res[0] = 3;
					res[1] = temp[0];
					res[2] = temp[1];
					res[3] = temp[2];
					break;
				}
			case 2:
				temp = testTP.isTwoPair(toBeTested);
				if( temp[0] != -1 && temp[1] != -1 && temp[2] != -1){
					res[0] = 2;
					res[1] = temp[0];
					res[2] = temp[1];
					res[3] = temp[2];
					break;
				}
			case 1:
				temp = testOP.isOnePair(toBeTested);
				if(	temp[0] != -1 && temp[1] != -1 && temp[2] != -1 && temp[3] != -1){
					res[0] = 1;
					res[1] = temp[0];
					res[2] = temp[1];
					res[3] = temp[2];
					res[4] = temp[3];
					break;
				}
			case 0:
				res[0] = 0;
				res[1] = testHC.isHighCard(toBeTested);
				break;
			}
			return res;
	}
}
