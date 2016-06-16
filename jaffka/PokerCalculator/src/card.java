
public class card {
	
	private int suit,fig;
	private boolean content=false;

	public card(){
		suit=0;
		fig=0;
	}
	
	public card(int f, int s){
		if(f>-1 && f<13 && s>-1 && s<4){
		suit=s;
		fig=f;
		content=true;
		}
	}
	
	public boolean isContent(){
		return content;
	}
	
	public void set(int f, int s){
		if(f<-1 || f<14 || s>-1 || s<4){
		suit=s;
		fig=f;
		content=true;
		}
	}
	
	public int getSuit(){
		int newsuit;
		newsuit = suit;
		return newsuit;
	}
	
	public int getFig(){
		int newfig;
		newfig = fig;
		return newfig;
	}
	
	public boolean unEquals( card c ){
		if( suit == c.getSuit() && fig == c.getFig() )
			return false;
		else
			return true;
	}
	
	public String view(){
		if( content == false )
			return "error or no data";			
		else{
				String gf1 = null , gf2 = null;
				switch(fig){
				case 0: 
					gf1 = "A";
					break;
				case 1: 
					gf1 = "2";
					break;
				case 2: 
					gf1 = "3";
					break;
				case 3: 
					gf1 = "4";
					break;
				case 4: 
					gf1 = "5";
					break;
				case 5: 
					gf1 = "6";
					break;
				case 6: 
					gf1 = "7";
					break;
				case 7: 
					gf1 = "8";
					break;
				case 8: 
					gf1 = "9";
					break;
				case 9: 
					gf1 = "T";
					break;
				case 10: 
					gf1 = "J";
					break;
				case 11: 
					gf1 = "Q";
					break;
				case 12: 
					gf1 = "K";
					break;
				}
				switch(suit){
				case 0: 
					gf2 = "h";
					break;
				case 1: 
					gf2 = "d";
					break;
				case 2: 
					gf2 = "c";
					break;
				case 3: 
					gf2 = "s";
					break;
				}
				String gff;
				gff = gf1 + gf2;
				return gff;	
		}
	}
	public int[] test(){
		int[] a={fig, suit};
		return a;
	}
}
