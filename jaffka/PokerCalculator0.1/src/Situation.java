import java.util.ArrayList;

public class Situation {
	
	private ArrayList<Hand> HandList = new ArrayList<Hand>();
	private ArrayList<Card> Board = new ArrayList<Card>();
	private Board toCalculate = new Board();
	
	public Situation(){
	}
	
	public void addHand( Hand newHand ){
		if( newHand.isProper() && !HandList.contains(newHand))
			HandList.add(newHand);
	}
	
	public void addCommunityCards(Card newCard){
		if(Board.size() < 5 && !Board.contains(newCard))
		Board.add(newCard);
	}
	
	public String boardView(){
		String res = "";
		for(Card temp : Board){
			res = res + temp.view();
		}
		return res;
	}
	
	public String boardCount(){
		if( Board.size() == 3)
			return "Flop";
		else if( Board.size() == 4)
			return "Turn";
		else if( Board.size() == 5)
			return "River";
		else if( Board.size() == 0)
			return "PreFlop";
		else
			return "wrong data";
	}
	
	public int[] result2Int(int handNum){
		int res[] = {-1,-1,-1,-1,-1};
		if(Board.size() == 5 && handNum < HandList.size()){
			toCalculate.clear();
			toCalculate.add(Board);
			toCalculate.add(HandList.get(handNum));
			//System.out.print(tempBoard.view() + " ");
			toCalculate.sort();
			//System.out.println(toCalculate.view());
			if(toCalculate.size() ==7){
				//for(int i = 8; i>-1;i--){
					/*if(res[0] > 0){
						break;
					}*/
				int i = 8;
					switch(i){
					case 8:
						if( toCalculate.testStraightFlush() != -1){
							res[0] = 8;
							res[1] = toCalculate.testStraightFlush();
					//		if(res[1]>-1)
							break;
						}
					case 7:
						if( toCalculate.testQuads()[0] != -1 &&
								 toCalculate.testQuads()[1] != -1){
							res[0] = 7;
							int temp[] = toCalculate.testQuads();
							res[1] = temp[0];
							res[2] = temp[1];
					//		if(res[1]>-1 && res[2] > -1)
							break;
						}
					case 6:
						if( toCalculate.testFullHouse()[0] != -1 &&
								 toCalculate.testFullHouse()[1] != -1){
							res[0] = 6;
							int temp[] = toCalculate.testFullHouse();
							res[1] = temp[0];
							res[2] = temp[1];
					//		if(res[1]>-1 && res[2]>-1)
								break;
						}
					case 5:
						if( toCalculate.testFlush() != -1){
							res[0] = 5;
							res[1] = toCalculate.testFlush();
					//		if(res[1]>-1)
							break;
						}
					case 4:
						if( toCalculate.testStraight() != -1){
							res[0] = 4;
							res[1] = toCalculate.testStraight();
					//		if(res[1] > -1)
							break;
						}
					case 3:
						if( 	toCalculate.testTrips()[0] != -1 &&
								toCalculate.testTrips()[1] != -1 &&
								toCalculate.testTrips()[2] != -1){
							res[0] = 3;
							int temp[] = toCalculate.testTrips();
							res[1] = temp[0];
							res[2] = temp[1];
							res[3] = temp[2];
					//		if(res[1] > -1 && res[2] > -1 && res[3] > -1)
							break;
						}
					case 2:
						if( toCalculate.testTwoPair()[0] != -1 && 
								toCalculate.testTwoPair()[1] != -1 &&
								toCalculate.testTwoPair()[2] != -1){
							int temp[] = toCalculate.testTwoPair();
							res[0] = 2;
							res[1] = temp[0];
							res[2] = temp[1];
							res[3] = temp[2];
					//		if(res[1] > -1 && res[2] > -1 && res[3] > -1)
							break;
						}
					case 1:
						if(	toCalculate.testOnePair()[0] != -1 &&
								toCalculate.testOnePair()[1] != -1 &&
								toCalculate.testOnePair()[2] != -1 &&
					 			toCalculate.testOnePair()[3] != -1){
							res[0] = 1;
							int temp[] = toCalculate.testOnePair();
							res[1] = temp[0];
							res[2] = temp[1];
							res[3] = temp[2];
							res[4] = temp[3];
					//		if(res[1] > -1 && res[2] > -1 && res[3] > -1 && res[4] > -1)
							break;
						}
					case 0:
						res[0] = 0;
						res[1] = toCalculate.testHighCard();
						break;
					}
			//	}
			}

		}
		return res;
	}
	
	public int[] whoWins(){
		ArrayList<int[]> results = new ArrayList<int[]>();
		for(int i = 0; i<HandList.size(); i++){
			results.add( result2Int(i) );
		}
		int winner[] = {-1,-1,-1,-1};
		int winnerNumber = -1;
		int tieList[] = new int[(HandList.size()+1)];
		tieList[0] = -1;
		int counter = 0;
		int tieCounter = 0;
		for( int[] Temp : results){
			if(Temp[0] < 0){
				winner[0] = 100;
				winnerNumber = 100;
			}else if (Temp[0] > winner[0]){
				winner = Temp;
				winnerNumber = counter;
			}else if( Temp[0] == winner[0]){
				if(winner[1] == 0 && Temp[1] != 0){
				}else if( Temp[1] > winner[1] || (Temp[1] == 0 && winner[1]!=0)){
					winner = Temp;
					winnerNumber = counter;
				}
				else if( Temp[1] == winner[1]){
					if(winner[2] == 0 && Temp[1] != 0){
					}else if(Temp[2] > winner[2] || (Temp[2] == 0 && winner[2] !=0)){
						winner = Temp;
						winnerNumber = counter;
					}
					else if( Temp[2] == winner[2]){
						if(winner[3] ==0 && Temp[3]!=0){
						}else if(Temp[3] > winner [3] || (Temp[3] == 0 && winner[3] !=0)){
							winner = Temp;
							winnerNumber = counter;
						}
						else if(Temp[3] == winner [3]){
							if(winner[4] == 0 && Temp[4] != 0){
							}else if(Temp[4] > winner[4] || (Temp[4] == 0 && winner[4] != 0)){
								winner = Temp;
								winnerNumber = counter;
							}
							else if(Temp[4] == winner[4]){
								if( Temp[0] > tieList[0] ){
									tieList[0] = Temp[0];
									tieCounter = 1;
									tieList[1] = counter;
								}
								else if(Temp[0] == tieList[0]){
									tieList[tieCounter] = counter;
									tieCounter++;
								}
							}
						}
					}
				}
				
			}
			counter++;
		}
		if(tieList[0] < winner[0]){
			int[] temp = {winnerNumber};
			return temp;
		}
		else
			return tieList;
	}
	
	public String finalMethod(){
		if( boardCount() == "River"){
			int[] temp = whoWins();
			if(temp[0] > 10){
				return "wrong data\n";
			}else{
				int result[] = new int[HandList.size()];
				if( temp.length == 1){
					for(int i=0; i<HandList.size();i++){
						if( i==temp[0])
							result[i] = 100;
						else
							result[i] =0;
						System.out.println(i+" "+ result[i] + " " + temp[0]);
					}
				}
				else{
					for(int i = 0; i<HandList.size();i++)
						result[i] = 0;
					for(int i = 1; i<temp.length;i++){
						result[temp[i]] = 100;
					}
				}
				String res = "";
				for(int i = 0; i<HandList.size(); i++){
					res = res + "Hand number " + (i+1) + ": " + HandList.get(i).view() + " has " + result[i] + " % chance of winning \n";			
				}
				return res;
			}
		}
		else if( boardCount() == "Turn"){
			int opponents = HandList.size();
			float hands[] = new float[opponents];
			for( int i = 0; i<opponents;i++){
				hands[i] = 0;
			}
			int Counter = 0;
			for(int j = 0; j<52;j++){
				Deck deckOfCards = new Deck();
				deckOfCards.add(Board);
				deckOfCards.addHands(HandList);
				if(!deckOfCards.contains(new Card(j))){
					deckOfCards.add(new Card(j));
					Board.add(new Card(j));
					int temp[] = whoWins();
					if(temp[0] > 10){
					}else{
						if( temp.length == 1){
							for(int i=0; i<opponents;i++){
								if( i==temp[0])
									hands[i]+=opponents;
							}
							Counter+=opponents;
						}
						else{
							for(int i = 1; i<temp.length;i++){
								hands[temp[i]]++;
							}
							Counter+=opponents;
						}
					}
					Board.remove(new Card(j));
					deckOfCards.remove(new Card(j));
				}
			}
			String res="";
			for(int i = 0; i<opponents;i++){
				res = res + "Hand no " + (i+1) + " " + HandList.get(i).view() + " chance of winning is " + ((float)Math.round((hands[i]/Counter)*10000))/100 + "%\n";
			}
			return res;
		}else if(boardCount() == "Flop"){
			int opponents = HandList.size();
			float hands[] = new float[opponents];
			for( int i = 0; i<opponents;i++){
				hands[i] = 0;
			}
			System.out.println(opponents);
			int Counter = 0;
			Deck deckOfCards = new Deck();
			deckOfCards.add(Board);
			deckOfCards.addHands(HandList);
			for(int k =0; k<52;k++){
				if(!deckOfCards.contains(new Card(k))){
					deckOfCards.add(new Card(k));
					Board.add(new Card(k));
					for(int j = 0; j<52;j++){
						if(!deckOfCards.contains(new Card(j))){
							deckOfCards.add(new Card(j));
							Board.add(new Card(j));
							int temp[] = whoWins();
							if(temp[0] > 10){
							}else{
								if( temp.length == 1){
									for(int i=0; i<opponents;i++){
										if( i==temp[0])
											hands[i]+=opponents;
									}
									Counter+=opponents;
								}
								else{
									for(int i = 1; i<temp.length;i++){
										hands[temp[i]]++;
									}
									Counter+=opponents;
								}
							}
							deckOfCards.remove(new Card(j));
							Board.remove(new Card(j));
						}
					}
					deckOfCards.remove(new Card(k));
					Board.remove(new Card(k));
				}
			}
			String res="";
			for(int i = 0; i<opponents;i++){
				res = res + "Hand no " + (i+1) + " " + HandList.get(i).view() + " chance of winning is " + ((float)Math.round((hands[i]/Counter)*10000))/100 + "%\n";
			}
			return res;
		}else if( boardCount() == "PreFlop"){
			Deck toCheck = new Deck();
			toCheck.addHands(HandList);
			Deck toGenerate = new Deck();
			for( int i = 0; i<52;i++){
				if(!toCheck.contains(new Card(i))){
					toGenerate.add(new Card(i));
				}
			}
			int cardsLeft = toGenerate.size();
			int opponents = HandList.size();
			float hands[] = new float[opponents];
			for( int i = 0; i<opponents;i++){
				hands[i] = 0;
			}
			int Counter = 0;
			Card temp1 = new Card();
			Card temp2 = new Card();
			Card temp3 = new Card();
			Card temp4 = new Card();
			Card temp5 = new Card();
			for( int i = 0; i< cardsLeft-4;i++){
				temp1.set(toGenerate.get(i).getValue());
				Board.add(temp1);
				System.out.println(temp1.view());
				for(int j = i + 1; j<cardsLeft-3;j++){
					temp2.set(toGenerate.get(j).getValue());
					Board.add(temp2);
					for(int k = j + 1; k<cardsLeft-2;k++){
						temp3.set(toGenerate.get(k).getValue());
						Board.add(temp3);
						for(int l = k + 1; l<cardsLeft-1; l++){
							temp4.set(toGenerate.get(l).getValue());
							Board.add(temp4);
							for(int m = l + 1; m<cardsLeft;m++){
								temp5.set(toGenerate.get(m).getValue());
								Board.add(temp5);
								int temp[] = whoWins();
								if(temp[0] > 10){
								}else{
									if( temp.length == 1){
										hands[temp[0]]+= opponents;
										Counter+=opponents;
									}
									else{
										for(int z = 1; z<temp.length;z++){
											hands[temp[z]]++;
										}
										Counter+=opponents;
									}
								}
								Board.remove(4);
							}
							Board.remove(3);
						}
						Board.remove(2);
					}
					Board.remove(1);							
				}
				Board.remove(0);
			}
			System.out.println(Counter);
			String res="";
			for(int i = 0; i<opponents;i++){
				res = res + "Hand no " + (i+1) + " " + HandList.get(i).view() + " chance of winning is " + ((float)Math.round((hands[i]/Counter)*10000))/100 + "%\n";
			}
			return res;
		}
		else
			return "Wrong data you idiot\n";
	}
	
}
