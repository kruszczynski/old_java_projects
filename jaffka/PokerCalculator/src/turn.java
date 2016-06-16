
public class turn {
	private card four = new card();
	private boolean content = false;
	
	public turn(){
		
	}
	
	public turn( card tfour ){
		four = tfour;
		if( tfour.isContent() == true){
			content = true;
		}
	}
	
	public boolean iscontent(){
		return content;
	}
	
	public card getTurn(){
		return four;
	}
	
	public void set( card tfour ){
		four = tfour;
		if( tfour.isContent() == true){
			content = true;
		}
	}

}
