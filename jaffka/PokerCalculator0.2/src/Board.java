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
	
	public ArrayList<Card> getArrayList(){
		return community;
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
	
}
