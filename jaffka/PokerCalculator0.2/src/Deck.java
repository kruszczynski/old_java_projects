import java.util.ArrayList;
public class Deck {
	private ArrayList<Card> Cards = new ArrayList<Card>();
	
	public void add(Card New){
		if(!Cards.contains(New))
		Cards.add(New);
	}
	
	public void add(ArrayList<Card> New){
		for(Card Temp : New){
			if(!Cards.contains(Temp)){
				Cards.add(Temp);
			}
		}
	}
	
	public void addHands(ArrayList<Hand> New){
		for(Hand Temp : New){
			if(!Cards.contains(Temp.getCard(1)))
				Cards.add(Temp.getCard(1));
			if(!Cards.contains(Temp.getCard(2)))
				Cards.add(Temp.getCard(2));
			
		}
	}
	
	public Card get(int number){
		return Cards.get(number);
	}
	
	public void remove(Card Unneeded){
		Cards.remove(Unneeded);
	}
	
	public boolean contains(Card Check){
		return Cards.contains(Check);
	}
	
	public int size(){
		return Cards.size();
	}
	
	public String view(){
		String res = "";
		for(Card temp : Cards){
			res = res + temp.view() + " ";
		}
		return res;
	}
}
