import com.javaflair.pokerprophesier.api.card.Card;


public class CardViewer {  //do wyswietlania obiektow klasy karta przy pomocy obiektow klasy string, 2 wersje: short AK, long Ace of Spades
	
	// Methods
	
	// suit to string short
	String suit2StringShort( int suit){
		String suitString = " ";
		switch(suit){
		case 1:
			suitString = "h";
			break;
		case 2:
			suitString = "d";
			break;
		case 3:
			suitString = "s";
			break;
		case 4:
			suitString = "c";
			break;
		}
		return suitString;
	}
	
	// TODO suit to string full 
	
	String suit2StringFull( int suit ){
		String suitString = " ";
		
		return suitString;
	}
	
	//rank to string short
	String rank2StringShort(int rank){
		
		String rankString = " ";
		switch(rank){
		
		case 1:
			rankString = "2";
			break;
		case 2:
			rankString = "3";
			break;
		case 3:
			rankString = "4";
			break;
		case 4:
			rankString = "5";
			break;
		case 5:
			rankString = "6";
			break;
		case 6:
			rankString = "7";
			break;
		case 7:
			rankString = "8";
			break;
		case 8:
			rankString = "9";
			break;
		case 9:
			rankString = "T";
			break;
		case 10:
			rankString = "J";
			break;
		case 11:
			rankString = "Q";
			break;
		case 12:
			rankString = "K";
			break;
		case 13:
			rankString = "A";
			break;
		}
		
		return rankString;
		
	}
	
	// TODO rank to string full
	
	String rank2StringFull( int rank ){
		
		String rankString = " ";
		
		return rankString;
		
	}
	
	
	// i finalny viewer krotki.
	
	String shortView( Card toBeViewed ){
		
		return rank2StringShort(toBeViewed.getRank()) + suit2StringShort(toBeViewed.getSuit());
		
	}
	
	// TODO oraz viewer dlugi

	String fullView( Card toBeViewed ){
		
		return rank2StringFull( toBeViewed.getRank() ) + suit2StringFull( toBeViewed.getSuit() );
		
	}
	
	
}
