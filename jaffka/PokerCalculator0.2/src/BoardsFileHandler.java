import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class BoardsFileHandler {
	private Formatter x;
	private Scanner y;
	
	public BoardsFileHandler(){}
	
	public void create(int length){
		try{
			x = new Formatter("AllBoards10h.txt");
			System.out.println("You got it");
		}
		catch(Exception e){
			System.out.println("error");
		}
		
		for( int i = 0; i<length-4;i++){
			for(int j = i + 1; j<length-3;j++){
				for(int k = j + 1; k<length-2;k++){
					for(int l = k + 1; l<length-1; l++){
						for(int m = l + 1; m<length;m++){
							String s = i + " " + j + " " + k + " " + l + " " + m +"\n"; 
							x.format("%s", s);
						}
					}
				}
			}
		}
		x.close();
	}
	
	public void setScanner(int handsNum){
		switch(handsNum){
		case 2:
			try{
				y = new Scanner(new File("AllBoards2h.txt"));
			}
			catch(Exception e){
				System.out.println("error bitch");
			}
			break;
		
		case 3:
			try{
				y = new Scanner(new File("AllBoards3h.txt"));
			}
			catch(Exception e){
				System.out.println("error bitch");
			}
			break;
		case 4:
			try{
				y = new Scanner(new File("AllBoards4h.txt"));
			}
			catch(Exception e){
				System.out.println("error bitch");
			}
			break;
		case 5:
			try{
				y = new Scanner(new File("AllBoards5h.txt"));
			}
			catch(Exception e){
				System.out.println("error bitch");
			}
			break;
		case 6:
			try{
				y = new Scanner(new File("AllBoards6h.txt"));
			}
			catch(Exception e){
				System.out.println("error bitch");
			}
			break;
		case 7:
			try{
				y = new Scanner(new File("AllBoards7h.txt"));
			}
			catch(Exception e){
				System.out.println("error bitch");
			}
			break;
		case 8:
			try{
				y = new Scanner(new File("AllBoards8h.txt"));
			}
			catch(Exception e){
				System.out.println("error bitch");
			}
			break;
		case 9:
			try{
				y = new Scanner(new File("AllBoards9h.txt"));
			}
			catch(Exception e){
				System.out.println("error bitch");
			}
			break;
		case 10:
			try{
				y = new Scanner(new File("AllBoards10h.txt"));
			}
			catch(Exception e){
				System.out.println("error bitch");
			}
			break;
		}
	}
	
	public String getCards(){
		String s="";
		try{
			s = y.next();
		}
		catch(Exception e){
			s = "end";
		}
		return s;
	}
}
