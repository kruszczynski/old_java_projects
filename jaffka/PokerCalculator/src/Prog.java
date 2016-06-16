import java.util.Arrays;
public class Prog {
	public static void main(String[] args){
		hand test1 = new hand( 0,2,11,2);
		hand test11 = new hand( 12,2,10,2);
		card b1 = new card( 7,3);
		card b2 = new card( 11,1);
		card b3 = new card( 2,0);
		card b4 = new card(5, 2);
		card b5 = new card( 0,0);
		System.out.println( test1.view() + " " + test11.view());
		System.out.println();
		board lest = new board();
		float tu[];
		tu=lest.finalMethod(test1, test11);
		System.out.print("Nasz test: ");
		for(int i = 0; i<2;i++){
			System.out.print("Reka " + (i+1) + " ma " + tu[i] + "% szans na zwyciestwo.\n");
		}
	}
}
