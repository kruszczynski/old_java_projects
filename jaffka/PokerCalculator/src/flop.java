
public class flop {
	private card one = new card();
	private card two = new card();
	private card three = new card();
	private boolean content = false;
	
	public flop(){
		
	}
	
	public flop( card tone , card ttwo , card tthree ){
		one=tone;
		two=ttwo;
		three=tthree;
		if(tone.isContent() == true && ttwo.isContent() == true && tthree.isContent() == true){
			content = true;
		}
	}
	
	public boolean iscontent(){
		return content;
	}
	
	public card getOne(){
		return one;
	}
	
	public card getTwo(){
		return two;
	}
	
	public card getThree(){
		return three;
	}
	
	public card[] getFlop(){
		
		card ret[] = new card[3];
		ret[0] = one;
		ret[1] = two;
		ret[2] = three;
		return ret;
	}
	
	/*public boolean isDifferent(){
		if( 	one.equals(two) ||
				one.equals(three) ||
				two.equals(three) )
			return false;
		else
			return true;
	}*/
	
	public void set( card tone , card ttwo , card tthree ){
		one=tone;
		two=ttwo;
		three=tthree;
		if(tone.isContent() == true && ttwo.isContent() == true && tthree.isContent() == true){
			content = true;
		}
	}

}
