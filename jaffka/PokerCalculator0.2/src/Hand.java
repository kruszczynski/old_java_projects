public class Hand {
	private Card card1 = new Card();
	private Card card2 = new Card();
	
	public Hand(){
	}
	
	public Hand( Card c1, Card c2){
		if( c1.isProper() && c2.isProper() && !c1.equals(c2) ){
			card1 = c1;
			card2 = c2;
		}
	}
	
	public void setCards( Card c1, Card c2){
		if( c1.isProper() && c2.isProper() && !c1.equals(c2) ){
			card1 = c1;
			card2 = c2;
		}
	}
	
	public Card getCard( int i ){
		if( i == 1)
			return card1;
		else if( i == 2)
			return card2;
		else
			return new Card();
	}
	
	public boolean isProper(){
		if( card1.isProper() && card2.isProper() && !card1.equals(card2) )
			return true;
		else
			return false;
	}
	
	public boolean equals( Object o){
		Hand temp = (Hand) o;
		if( card1.equals(temp.getCard(1)) ||
			card1.equals(temp.getCard(2)) ||
			card2.equals(temp.getCard(1)) ||
			card2.equals(temp.getCard(2)) )
			return true;
		else
			return false;
	}
	
	public String view(){
		return card1.view() + card2.view();
	}
	
}
