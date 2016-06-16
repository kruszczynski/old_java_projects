
public class river {
	private card five = new card();
	private boolean content = false;
	
	public river(){
		
	}
	
	public river( card tfive ){
		five = tfive;
		if( tfive.isContent() == true){
			content = true;
		}
	}
	
	public boolean iscontent(){
		return content;
	}
	
	public void set( card tfive ){
		five = tfive;
		if( tfive.isContent() == true){
			content = true;
		}
	}
	
	public card getRiver(){
		return five;
	}
	
}
