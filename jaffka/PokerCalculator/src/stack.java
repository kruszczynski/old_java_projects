
public class stack {
	
	card[] stack= new card[52];				// nasz stos kart
	int number = 0;							//ile kart mamy w stosie
	
	// Kreator pustego stosu
	
	public stack(){
		for(int i = 0; i<52; i++){
			stack[i] = new card();
		}
	}
	
	public void push( card c ){
		boolean sameCards = false;
		if(number != 0){
			for( int i=0; i<number; i++){
				if( !stack[i].unEquals(c) )
					sameCards = true;
			}
		}
		if( sameCards == false ){
			stack[ number ] = c;
			number++;
		}
	}
	
	public int getNumber(){
		return number;
	}
	
	public boolean isInStack( card c ){
		boolean temp = true;
		for(int i = 0; i<number; i++){
			if(!stack[i].unEquals(c))
				temp = false;
		}
		if(temp == true)
			return false;
		else
			return true;
	}
}
