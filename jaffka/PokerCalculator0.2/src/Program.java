//import java.util.ArrayList;


public class Program {
	public static void main(String[] args) {
		Situation test = new Situation();
//		Hand h1 = new Hand( new Card (12), new Card(51));
//		Hand h2 = new Hand( new Card (25), new Card(38));
		Hand h1 = new Hand( new Card (14), new Card(3));
		Hand h2 = new Hand( new Card (25), new Card(39));
//		Hand h3 = new Hand(new Card(3), new Card(19));
	/*	test.addCommunityCards(new Card(6));
		test.addCommunityCards(new Card(19));
		test.addCommunityCards(new Card(32));
	/*	test.addCommunityCards(new Card(30));
		test.addCommunityCards(new Card(20));*/
		test.addHand(h1);
		test.addHand(h2);
//		test.addHand(h3);
		System.out.println(test.boardCount());
		System.out.print(test.finalMethod());
		System.out.println(test.boardView());

	}
}
