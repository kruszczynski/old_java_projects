public class hand {
	
	private card one = new card();
	private card two = new card();
	private boolean content = false;
	
	public hand(){
		one.set(0,0);
		two.set(0,1);
	}
	
	public hand(int f1, int s1, int f2, int s2){
		if(f1 > -1 && f2 > -1 && f2 < 13 && f1 < 13 && s1 > -1 && s2 > -1 && s2 < 4 && s1 < 4 && ((f1 == f2 && s1 != s2 ) || (f1!=f2)) ){ 
		one = new card(f1, s1);
		two = new card(f2, s2);
		content=true;
		}
	}
	
	public hand(card c1, card c2){
		one=c1;
		two=c2;
		content=true;
	}
	
	public boolean isContent(){
		return content;
	}
	
	public String view(){
		String a, b, c;
		a = one.view();
		b = two.view();
		c = a + b;
		return c;
	}
	
	public boolean isDifferent( hand tempHand ){
		if( 	one.equals(tempHand.one) ||
				one.equals(tempHand.two) ||
				two.equals(tempHand.one) ||
				two.equals(tempHand.two) ||
				one.equals(two) ||
				tempHand.one.equals(tempHand.two) )
			return false;
		else
			return true;
	}
	
	public card card1(){
		return one;
	}
	
	public card card2(){
		return two;
	}
}
