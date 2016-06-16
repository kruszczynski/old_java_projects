import java.util.ArrayList;
import java.util.Arrays;

public class Board {
	private ArrayList<Card> community = new ArrayList<Card>();
	
	public Board(){
	}
	
	public void add( Card newCard ){
		if( community.size() < 8 && !community.contains(newCard))
			community.add( newCard );
	}
	
	public void add( ArrayList<Card> List){
		if((community.size() + List.size() )< 8){
			for( Card Temp : List){
				if(!community.contains(Temp))
					community.add(Temp);
			}
		}
	}
	
	public void remove( Card Unnecessary){
		community.remove(Unnecessary);
	}
	
	public void add(Hand Hand){
		if( Hand.isProper()){
			community.add(Hand.getCard(1));
			community.add(Hand.getCard(2));
		}
	}
	
	public void clear(){
		community.clear();
	}
	
	public void sort(){
		int counter = 0;
		int matrix[]=new int[community.size()];
		for(Card temp : community)
			matrix[counter++]=temp.getValue();
		community.clear();
		Arrays.sort(matrix);
		for(int temp:matrix)
			community.add(new Card(temp));
	}
	
	public int size(){
		return community.size();
	}
	
	public String view(){
		String res = "";
		for(Card Temp : community){
			res = res + Temp.view() + " " ;
		}
		return res;
	}
	
	public boolean equals(Object o){
		Board Temp = (Board) o;
		boolean test = false;
		for( int i = 0; i<size(); i++){
			if( community.get(i).equals(Temp.community.get(i)) )
				test = true;
			else{
				test = false;
				break;
			}
		}
		return test;
	}
	
	public int containsHowManyOf( int Figure){
		int Counter = 0;
		for( Card Temp : community){
			if( Figure == Temp.getFigure())
				Counter++;
		}
		return Counter;
	}
	
	public boolean contains(Card Candidate){
		boolean test = false;
		for( Card Temp : community){
			if( Temp.equals(Candidate)){
				test = true;
				break;
			}
		}
		return test;
	}
	
	public boolean isProper(){
		boolean trial = false;
		for( Card temp : community){
			if(temp.isProper())
				trial = true;
			else{
				trial = false;
				break;
			}
		}
		return trial;
	}
	
	public int testStraightFlush(){
			StraightFlush SF = new StraightFlush();
			return SF.isStraightFlush();
	}
	
	public int[] testQuads(){
			Quads Q = new Quads();
			return Q.isQuads();
	}
	
	public int[] testFullHouse(){
			FullHouse FH = new FullHouse();
			return FH.isFullHouse();
	}
	
	public int testFlush(){
			Flush F = new Flush();
			return F.isFlush();
	}
	
	public int testStraight(){
			Straight S = new Straight();
			return S.isStraight();
	}
	
	public int[] testTrips(){
			Trips T = new Trips();
			return T.isTrips();
	}
	
	public int[] testTwoPair(){
			TwoPair TP = new TwoPair();
			return TP.isTwoPair();
	}
	
	public int[] testOnePair(){
			OnePair OP = new OnePair();
			return OP.isOnePair();
	}
	
	public int testHighCard(){
			HighCard HC = new HighCard();
			return HC.isHighCard();
	}

	
	public class StraightFlush{
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
		
		public int isStraightFlush(){
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
	
	public class Quads{
		
		public Quads(){}
		
		public int[] isQuads(){
			int res[] = {-1,-1};
			for( int i = 0; i<13; i++){
				if( containsHowManyOf(i) == 4 ){
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
				}else if( 	containsHowManyOf(0) > 0){
					res[1] = 0;
				}else{
					for( int i = 12; i>0; i--){
						if(		containsHowManyOf(i) > 0){
							res[1] = i;
							break;
						}
					}
				}
			}
			return res;
		}
	}
	
	public class FullHouse{
		
		public FullHouse(){}
		
		public int[] isFullHouse(){
			int res[] = {-1,-1};
			if(containsHowManyOf(0) == 3){
				res[0] = 0;
				for(int i = 12;i>0;i--){
					if(containsHowManyOf(i) >1){
						res[1] = i;
						break;
					}
				}
			}else{
				for( int i = 12;i>0; i--){
					if(containsHowManyOf(i) == 3){
						res[0] = i;
						break;
					}
				}
				if(containsHowManyOf(0) == 2)
					res[1] = 0;
				else{
					for(int i =12; i> 0; i--){
						if(containsHowManyOf(i) >1){
							if(i!=res[0]){
								res[1] = i;
								break;
							}
						}
					}
				}
			}
			return res;
		}
		
	}
	
	public class Flush{
		
		public Flush(){}
		
		public int isFlush(){
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
		
		public int isStraight(){
			int res = -1;
			Board StraightenedBoard = new Board();
			for( Card Temp : community){
				Card TempCard = new Card(Temp.getFigure());
				if(!StraightenedBoard.contains(TempCard))
					StraightenedBoard.add(TempCard);
			}
			StraightenedBoard.sort();
			for( int i = 0; i<StraightenedBoard.community.size()-4; i++){
				Board TempBoard = new Board();
				TempBoard.add(StraightenedBoard.community.get(i));
				TempBoard.add(StraightenedBoard.community.get(i+1));
				TempBoard.add(StraightenedBoard.community.get(i+2));
				TempBoard.add(StraightenedBoard.community.get(i+3));
				TempBoard.add(StraightenedBoard.community.get(i+4));
				if(StraightsList.contains(TempBoard))
					res = StraightenedBoard.community.get(i+4).getFigure();
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
	
	public class Trips{
		
		public Trips(){}
		
		public int[] isTrips(){
			int res[] = {-1,-1,-1};
			for(int i = 0; i< 13; i++){
				if( containsHowManyOf(i) == 3){
						res[0] = i;
						if( res[0] == 0)
							break;
				}
			}
			if(res[0] >-1){
				if(res[0] == 0){
					int Counter = 1;
					for(int i = 12; i>0; i--){
						if(containsHowManyOf(i)>0)
							res[Counter++] = i;
						if(Counter >2)
							break;
					}
				}else{
					int Counter = 1;
					boolean Ace = false;
					if( containsHowManyOf(0)>0){
						res[1] = 0;
						Ace = true;
					}
					if(Ace){
						for(int i = 12; i>0; i--){
							if(containsHowManyOf(i)>0){
								res[2] = i;
								break;
							}
						}
					}else{
						for(int i = 12; i>0;i--){
							if(containsHowManyOf(i)>0)
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
	
	public class TwoPair{
		
		public TwoPair(){}
		
		public int[] isTwoPair(){
			int res[] = {-1,-1,-1};
			for(int i=1; i<13;i++){
				if(containsHowManyOf(i) == 2){
					res[1] = res[0];
					res[0] = i;
				}
			}
			if(containsHowManyOf(0) == 2){
				res[1] = res[0];
				res[0] = 0;
				for(int i = 12; i>0;i--){
					if(containsHowManyOf(i) == 1){
						res[2] = i;
						break;
					}
				}
			}else if(containsHowManyOf(0)==1){
				res[2] = 0;
			}else{
				for(int i = 12; i>0;i--){
					if(containsHowManyOf(i) ==1){
						res[2] = i;
						break;
					}
				}
			}
			return res;
		}
	}
	
	public class OnePair{
		
		public OnePair(){}
		
		public int[] isOnePair(){
			int res[] = {-1,-1,-1,-1};
			for(int i=0; i<13; i++){
				if( containsHowManyOf(i) == 2 ){
					res[0] = i;
					if( i == 0){
						int Counter = 1;
						for( int j = 12; j>0;j--){
							if(containsHowManyOf(j) == 1)
								res[Counter++] = j;
							if(Counter>3)
								break;
						}
					}
					break;
				}
			}
			if(res[0] > 0){
				if(containsHowManyOf(0) ==1){
					int counter = 1;
					res[counter++] = 0;
					for(int i = 12; i>0;i--){
						if(containsHowManyOf(i) == 1)
							res[counter++] = i;
						if(counter>3)
							break;
					}
				}else{
					int Counter = 1;
					for(int i = 12; i>0;i--){
						if(containsHowManyOf(i) == 1)
							res[Counter++] = i;
						if(Counter>3)
							break;
					}
				}
			}
			return res;
		}
	}
	
	public class HighCard{
		
		public HighCard(){}
		
		public int isHighCard(){
			int res = -1;
			for(Card Temp : community){
				if(Temp.getFigure() > res)
					res = Temp.getFigure();
			}
			if(containsHowManyOf(0) == 1)
				res = 0;
			return res;
		}
	}
	
}
