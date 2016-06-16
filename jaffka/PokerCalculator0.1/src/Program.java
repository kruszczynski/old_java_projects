//import java.util.ArrayList;

public class Program {
	public static void main(String[] args) {
		Situation test = new Situation();
		Hand h1 = new Hand( new Card (0), new Card(13));
		Hand h2 = new Hand( new Card (26), new Card(39));
		test.addCommunityCards(new Card(4));
		test.addCommunityCards(new Card(17));
		test.addCommunityCards(new Card(30));
	/*	test.addCommunityCards(new Card(30));
		test.addCommunityCards(new Card(20));*/
		System.out.println(test.boardCount());
		test.addHand(h1);
		test.addHand(h2);
		System.out.print(test.finalMethod());
		System.out.println(test.boardView());
		/*Board jas = new Board();
		jas.add(new Card(4));
		jas.add(new Card(49));
		jas.add(new Card(34));
		jas.add(new Card(14));
		jas.add(new Card(0));
		jas.add(new Card(13));
		jas.add(new Card(0));
		System.out.println(jas.view());
		jas.sort();
		System.out.println(jas.view());*/
		
	}
}
