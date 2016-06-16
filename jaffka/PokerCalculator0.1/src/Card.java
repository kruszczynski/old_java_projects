
public class Card {
	private byte value = -1;
	
	public Card(){
	}
	
	public Card( int single){
		value = (byte) single;
		if( !isProper() )
			value = -1;
	}
	
	public void set(int newValue){
		value = (byte) newValue;
		if(!isProper())
			value = -1;
	}
	
	public boolean equals( Card newCard){
		if( value == newCard.getValue() )
			return true;
		else
			return false;
	}
	
	public boolean isProper(){
		if( value < 0 || value > 51)
			return false;
		else
			return true;
	}
	
	public byte getFigure(){
		if( isProper() )
			return (byte) (value % 13);
		else
			return -1;
	}
	
	public byte getSuit(){
		if( isProper())
			return (byte) (( value - getFigure() ) / 13 );
		else
			return -1;	
	}
	
	public byte getValue(){
		if( isProper())
			return value;
		else
			return -1;
	}
	
	public boolean equals( Object o){
		Card temp = (Card) o;
		if( value == temp.getValue())
			return true;
		else
			return false;
	}
	
	public String view(){
		String res = null;
		switch(getFigure()){
		case 0: 
			res = "A";
			break;
		case 1: 
			res = "2";
			break;
		case 2: 
			res = "3";
			break;
		case 3: 
			res = "4";
			break;
		case 4: 
			res = "5";
			break;
		case 5: 
			res = "6";
			break;
		case 6: 
			res = "7";
			break;
		case 7: 
			res = "8";
			break;
		case 8: 
			res = "9";
			break;
		case 9: 
			res = "T";
			break;
		case 10: 
			res = "J";
			break;
		case 11: 
			res = "Q";
			break;
		case 12: 
			res = "K";
			break;
		}
		switch(getSuit()){
		case 0: 
			res = res+"h";
			break;
		case 1: 
			res = res+"d";
			break;
		case 2: 
			res = res+"c";
			break;
		case 3: 
			res = res+"s";
			break;
		}
		return res;
	}
}
