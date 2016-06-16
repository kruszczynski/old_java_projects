import java.util.Arrays;


public class board {
	private flop f = new flop();
	private turn t = new turn();
	private river r = new river();
	private boolean allContent = false;
	private boolean onTurnContent = false;
	private boolean justFlopContent = false;

	public board(){	
	}
	
	public board( flop flop, card c1, card c2){
		f = flop;
		t.set(c1);
		r.set(c2);
		allContent = true;
	}
	
	public board( flop flop, turn turn){
		f = flop;
		t = turn;
	}
	public board( flop flop){
		f=flop;
	}
	public board( card a, card b,  card c, card d, card e){
		if(a.isContent() == true && b.isContent() == true && c.isContent() == true && d.isContent() == true && e.isContent() == true){
			f.set( a, b, c);
			t.set( d );
			r.set( e );
			allContent = true;
			onTurnContent = false;
			justFlopContent = false;
		}
	}
	public board( card a, card b,  card c, card d ){
		if(a.isContent() == true && b.isContent() == true && c.isContent() == true && d.isContent() == true ){
			f.set( a, b, c);
			t.set( d );
			onTurnContent = true;
			allContent = false;
			justFlopContent = false;
		}
	}
	public board( card a, card b,  card c ){
		if(a.isContent() == true && b.isContent() == true && c.isContent() == true ){
			f.set( a, b, c);
			justFlopContent = true;
			allContent = false;
			onTurnContent = false;
		}
	}
	
	public void setRiver( card c ){
		if( onTurnContent == true){	
			r=new river(c);
			allContent = true;
			onTurnContent = false;
		}
	}
	
	public void setTurn( card c ){
		if( justFlopContent == true){
			t=new turn(c);
			justFlopContent = false;
			onTurnContent = true;
		}
	}
	
	public card[] getBoard(){
		if(f.iscontent() && !t.iscontent() && !r.iscontent() ){
			card res[] = new card[3];
			card tflop[] = new card[3];
			tflop = f.getFlop();
			for( int i=0; i<=2; i++){
				res[i] = tflop[i];
			}
			return res;
		}
		if(f.iscontent() && t.iscontent()  && !r.iscontent() ){
			card res[] = new card[4];
			card tflop[] = new card[3];
			tflop = f.getFlop();
			for( int i=0; i<=2; i++){
				res[i] = tflop[i];
			}
			res[3] = t.getTurn();
			return res;
		}
		if(f.iscontent()  && t.iscontent()  && r.iscontent() ){
			card res[] = new card[5];
			card tflop[] = new card[3];
			tflop = f.getFlop();
			for( int i=0; i<=2; i++){
				res[i] = tflop[i];
			}
			res[3] = t.getTurn();
			res[4] = r.getRiver();
			return res;
		}
		else{
			card a = new card();
			card res[] = new card[1];
			res[0]=a;
			return res;
		}
	}
	
	public int whoWins( hand h1, hand h2){
		if( 	h1.isContent() == true &&
				h2.isContent() == true &&
				allContent == true ){
			int a[],b[];
			a = handInt( h1 );
			b = handInt( h2 );
			if( a[0] > b[0] )
				return 0;
			else if( a[0] < b[0] )
				return 1;
			else{
				if( a[1] == b[1] ){
					if( a[0] == 2 || a[0] == 6){					
						if(a[2] > b[2])
							return 0;
						else if( a[2] < b[2] )
							return 1;
						else
							return 2;
					}
					else if( a[0] == 5){
						int temp = 2;
						for( int i=1; i<6; i++){
							if( temp != 2)
								break;
							else{
								if( a[i] == b[i])
									temp =2;
								else if( a[i] > b[i] )
									temp = 0;
								else 
									temp = 1;
							}
						}
						return temp;
					}
					else
						return 2;
				}
				else if( a[1] == 0 || (a[1] > b[1] && b[1] != 0 ))
					return 0;
				else if( b[1] == 0 || b[1] > a[1])
					return 1;
				else
					return 2;
			}
		}
		else
			return -1;
	}
	
	public int[] handInt( hand tempHand ){
		if(		allContent == true &&					//sprawdzamy czy jest 7 kart
				tempHand.isContent() == true){
			card cStr[] = new card[7];
			cStr[0] = tempHand.card1();
			cStr[1] = tempHand.card2();
			cStr[2] = f.getOne();
			cStr[3] = f.getTwo();
			cStr[4] = f.getThree();
			cStr[5] = t.getTurn();
			cStr[6] = r.getRiver();
			int figs[] = new int[7],
				suits[] = new int[7];
			for(int i=0; i<7; i++){
				figs[i]=cStr[i].getFig();					//tworzymy arraye kolorow i figur
				suits[i]=cStr[i].getSuit();
			}
			Arrays.sort(suits);								//sortujemy je
			Arrays.sort(figs);
			
			//STRIT
			
			boolean isStraight = false;							//czy jest strit? (bool)
			int strCnt = 1;									//licznik
			int straightHc = -1;										//int najwyzszej karty strita
			for(int i=1; i<7; i++){
				if( (figs[i] == figs[i-1] + 1)){		
					strCnt++;
					if( strCnt > 4 ){
						straightHc = figs[i];		
						isStraight = true;
						}
					if( figs[i] == 12 && strCnt > 3 && figs[0] == 0){
						isStraight = true;
						straightHc = 0;
					}
				}
				else if( figs[i] == figs[i-1]){
				}
				else{
					strCnt = 1;
				}
			}
			//Summary: isStraight - bool, straightHc - najwyzsza karta
			
			// KOLOR
			
			int fl = 1;
			boolean isFlush = false;
			int flSuit = -1;
			for( int i=1;i<7;i++ ){
				if( suits[i] == suits[i-1]){
					fl++;
					if( fl > 4){
						flSuit = suits[i];
						isFlush = true;
					}
				}
				else{
					fl = 1;
				}
			}	
			int lic=7;
			for(int i=0;i<7;i++){
				if( cStr[i].getSuit() != flSuit)
					lic--;
			}
			int kolory[] = new int[lic];
			for(int i=0;i<lic;i++)
				kolory[i]=-1;
			lic=0;
			int n = 7;
			if( isFlush == true){
				for(int i=0;i<7;i++){
					if( cStr[i].getSuit() == flSuit){
						kolory[lic] = cStr[i].getFig();
						lic++;
					}
				}
				int m = lic-1;
				n = m;
				Arrays.sort( kolory );
				if( kolory[0] == 0){
					int temp = kolory[m];
					kolory[m] = 0;
					for( int i=m-1;i>0;i--){
						int temp2 = kolory[i];
						kolory[i] = temp;
						temp = temp2;
						if( i == 1)
							kolory[0] = temp;
					}
				}
			}
			
			// Summary: isFlush, flushHc, flSuit
			
			// ROYAL/STRAIGHT FLUSH
			boolean isSFlush = false,
					isRFlush = false;
			int royHc = -1;										//int najwyzszej karty pokera
			if( isFlush == true && isStraight == true){
				int royFig[] = new int[7];
				int royCnt = 0;
				for(int i=0;i<7;i++){
					if( cStr[i].getSuit() == flSuit ){
						royFig[royCnt] = cStr[i].getFig();
						royCnt++;
					}
				}
				Arrays.sort(royFig);

				// algorytm z strita do wyznaczenia najwyzszej karty sposrod kart tego koloru
				int royCnt2 = 1;									//licznik
				for(int i=1; i<7; i++){
					if(royFig[i] == royFig[i-1] + 1){
						royCnt2++;
						if( royCnt2 > 4 ){
							royHc = royFig[i];
							isSFlush = true;
						}
						if( royFig[i] == 12 && royCnt2 > 3 && royFig[0] == 0 ){
							isRFlush = true;
							royHc = 0;
						}
					}
					else{
						royCnt2 = 1;
					}
				}
			}
			// summary: isRFlush,isSFlush,royHc, kolor z flSuit
			
			// QUADS OR FULL HOUSE OR TRIPS OR TWO PAIR OR PAIR 
			
			int fullArray[] = new int[13];
			for(int i=0;i<13;i++){
				fullArray[i] = 0;
			}
			for( int i=0;i<13;i++ ){
				for( int j=0;j<7;j++ ){
					if( cStr[j].getFig() == i ){
						fullArray[i]++;
					}
				}
			}
			// QUADS
			boolean isQuads = false;
			int quadsHc = -1;
			for( int i=0;i<13;i++){
				if( fullArray[i] == 4){
					quadsHc = i;
					isQuads = true;
				}
			}
			boolean isFull = false;
			boolean hiFull = false;
			boolean loFull = false;
			int fullHc = -1;
			int fullLc = -1;
			boolean isOnePair = false;
			boolean isTwoPair = false;
			boolean isTrips = false;
			int onePairHc = -1;
			int tripsHc = -1;
			int twoPairHc = -1,
				twoPairLc = -1;
			int highCard = -1;
			if(!isQuads ){
				// booleanskie wektory dla reszty
				boolean trips[] = new boolean[13];
				boolean pairs[] = new boolean[13];
				for(int i=0;i<13;i++){
					if( fullArray[i] == 3){
						trips[i] = true;
						pairs[i] = true;
					}
					else if( fullArray[i] == 2 ){
						pairs[i] = true;
						trips[i] = false;
					}
					else{
						pairs[i] = false;
						trips[i] = false;
					}
				}
				// Full
				
				
				if( trips[0] == true ){
					hiFull = true;
					fullHc = 0;
				}
				else if( pairs[0] == true && trips[0] == false){
					loFull = true;
					fullLc = 0;
				}
				for(int i=12;i>0;i--){
					if( trips[i] == true ){
							hiFull = true;
							if( i > fullHc && fullHc != 0 ){
								fullHc = i;
						}
					}
					if( pairs[i] == true && i != fullHc ){
							loFull = true;
							if( i > fullLc && fullLc != 0){
								fullLc = i;
						}
					}
				}
				
				if( hiFull == true && loFull == true ){
					isFull = true;
				}
				
				if( !isFull && !isQuads && !isStraight && !isFlush){
					// Trips
					if( loFull == false && hiFull == true ){
						isTrips = true;
						tripsHc = fullHc;
					}
					//2Pair
					if( isTrips == false ){
						if( pairs[0] == true ){
							twoPairHc = 0;
							for( int i = 1; i < 13; i++){
								if(pairs[i] == true ){
									twoPairLc = i;
								}
							}
							if( twoPairLc > -1 ){
								isTwoPair = true;
							}
						}
						else{
							for( int i = 1; i < 13; i++ ){
								if( pairs[i] == true ){
									twoPairLc = twoPairHc;
									twoPairHc = i;
								}
							}
							if( twoPairLc > -1 && twoPairHc > -1 ){
								isTwoPair = true;
							}
						}
					}
					// Pair
					if( pairs[0] == true ){
						onePairHc = 0;
						isOnePair = true;
					}
					else{
						for( int i = 1; i<13; i++ ){
							if( pairs[i] == true ){
								onePairHc = i;
								isOnePair = true;
							}
						}
					}
					
					// summary:
					//	quads: isQuads, quadsHc
					//	full: isFull, fullHc, fullLc
					//	trips: isTrips, tripsHc
					//	2pair: isTwoPair, twoPairHc, twoPairLc
					//	Pair: isOnePair, onePairHc
					
					// High Card
					if( figs[0] == 0){
						highCard = 0;
					}
					else{
						highCard = figs[6];
					}
				}
			}
			
			//summary: highCard
			
			//Algorytm zwracajacy nam nasz uklad tu:
			
			/* 0 high card
			 * 1 pair
			 * 2 2 pair
			 * 3 trips
			 * 4 straight
			 * 5 flush
			 * 6 full house
			 * 7 quads
			 * 8 straight flush
			 * 9 royal flush
			*/
			
			if( isRFlush == true ){
				int result[] = { 9 , 0};
				return result;
			}
			else if( isSFlush == true ){
				int result[] = { 8, royHc };
				return result;
			}
			else if( isQuads == true ){
				int result[] = { 7, quadsHc };
				return result;
			}
			else if( isFull == true ){
				int result[] = { 6, fullHc, fullLc};
				return result;
			}
			else if( isFlush == true ){
				int result[] = { 5, kolory[n], kolory[n-1], kolory[n-2], kolory[n-3], kolory[n-4] };
				return result;
			}
			else if( isStraight == true ){
				int result[] = { 4, straightHc };
				return result;
			}
			else if( isTrips == true ){
				int result[] = { 3, tripsHc };
				return result;
			}
			else if( isTwoPair == true ){
				int result[] = { 2, twoPairHc, twoPairLc};
				return result;
			}
			else if( isOnePair == true ){
				int result[] = { 1, onePairHc };
				return result;
			}
			else{
				int result[] = { 0, highCard };
				return result;
			}
		}
		else{
			int c[] = {-1,-1};
			return c;
		}
	}
	
	public float[] finalMethod(hand h1, hand h2){
		if( allContent ){
			stack st = new stack();
			st.push(f.getOne());
			st.push(f.getTwo());
			st.push(f.getThree());
			st.push(t.getTurn());
			st.push(r.getRiver());
			st.push(h1.card1());
			st.push(h1.card2());
			st.push(h2.card1());
			st.push(h2.card2());
			if(st.getNumber() !=9){
				float a[]={-1,-1};
				return a;
			}
			else{
				int b;
				b = whoWins(h1,h2);
				if( b == 2){
					float a[] = {50,50};
					return a;
				}
				else if( b == 0){
					float a[] = {100,0};
					return a;
				}
				else{
					float a[] = {0,100};
					return a;
				}
			}
		}
		
		else if( onTurnContent ){
			stack st = new stack();
			st.push(f.getOne());
			st.push(f.getTwo());
			st.push(f.getThree());
			st.push(t.getTurn());
			st.push(h1.card1());
			st.push(h1.card2());
			st.push(h2.card1());
			st.push(h2.card2());
			if( st.getNumber() != 8){
				float a[] = {-1,-1};
				return a;
			}
			else{
				float h1Cnt = 0,
					h2Cnt = 0,
					TotCnt = 0;
				for(int i = 0; i<13; i++){
					for( int j = 0; j<4; j++){
						card a = new card(i,j);
						if( !st.isInStack(a) ){
							st.push(a);
							board temp = new board(f, t.getTurn(), a);
							int b;
							b = temp.whoWins(h1, h2);
							System.out.print(b + " " + a.view() + " "+ h1Cnt + " " + h2Cnt+ " " + TotCnt + "\n" );
							if( b == -1)
								break;
							else if( b == 0){
								h1Cnt++;
								TotCnt++;
							}
							else if(b == 1){
								h2Cnt++;
								TotCnt++;
							}
							else
								TotCnt++;
						}
					}
				}
				System.out.println(h1Cnt + " " + h2Cnt + " " + TotCnt);
				float a[] = {100*h1Cnt/TotCnt,100*h2Cnt/TotCnt};
				return a;
			}
		}
		
		else if( justFlopContent ){ 
			stack st = new stack();
			st.push(f.getOne());
			st.push(f.getTwo());
			st.push(f.getThree());
			st.push(h1.card1());
			st.push(h1.card2());
			st.push(h2.card1());
			st.push(h2.card2());
			if(st.getNumber() !=7){
				float a[]={-1,-1};
				return a;
			}
			else{
				float h1Cnt=0,
					h2Cnt=0,
					TotCnt=0;
				for( int i =0; i<13; i++){
					for( int j = 0; j<4; j++){
						card a = new card(i,j);
						if( !st.isInStack(a) ){
							stack stTemp = new stack();
							stTemp.push(f.getOne());
							stTemp.push(f.getTwo());
							stTemp.push(f.getThree());
							stTemp.push(h1.card1());
							stTemp.push(h1.card2());
							stTemp.push(h2.card1());
							stTemp.push(h2.card2());
							stTemp.push(a);
							for(int k=0;k<13;k++){
								for(int l=0; l<4; l++){
									card b = new card(k,l);
									if( !stTemp.isInStack(b)){
										board temp = new board( f, a,b);
										int c=-1;
										c=temp.whoWins(h1,h2);
										System.out.println(c + " " + a.view() + b.view());
										if( c == -1)
											break;
										else if( c == 0){
											h1Cnt++;
											TotCnt++;
										}
										else if(c == 1){
											h2Cnt++;
											TotCnt++;
										}
										else
											TotCnt++;
									}
								}
							}
							
						}
					}
				}
				float a[]={100*h1Cnt/TotCnt,100*h2Cnt/TotCnt};
				return a;
			}
		}
		
		else if( !justFlopContent && !onTurnContent && !allContent){
			stack st = new stack();
			st.push(h1.card1());
			st.push(h1.card2());
			st.push(h2.card1());
			st.push(h2.card2());
			if( st.getNumber() != 4){
				float a[] = {-1,-1};
				return a;
			}
			else{
				long 	h1Cnt = 0,
						h2Cnt = 0,
						TotCnt = 0;
				for(int i=0; i<13; i++){
					for( int j=0; j<4; j++){
						card a = new card(i,j);
							for(int k=0; k<13; k++){
								for(int l=0; l<4; l++){
									card b = new card( k, l);
										for(int m = 0; m < 13; m++){
											for( int n = 0; n < 4; n++){
												card c = new card( m, n);
													for( int o = 0; o < 13; o++){
														for( int p = 0; p < 4; p++){
															card d = new card( o, p);
																for( int q = 0; q < 13; q ++){
																	for( int r = 0; r < 4; r++){
																		stack stTemp5 = new stack();
																		stTemp5.push(h1.card1());
																		stTemp5.push(h1.card2());
																		stTemp5.push(h2.card1());
																		stTemp5.push(h2.card2());
																		card e = new card (q,r);
																		if( !stTemp5.isInStack(e)){
																			stTemp5.push(e);
																			if( !stTemp5.isInStack(d)){
																				stTemp5.push(d);
																				if(!stTemp5.isInStack(c)){
																					stTemp5.push(c);
																					if(!stTemp5.isInStack(b)){
																						stTemp5.push(b);
																						if(!stTemp5.isInStack(a)){
																							stTemp5.push(a);
																							board temp = new board( a, b, c, d, e);
																							int f = -1;
																							f = temp.whoWins(h1,h2);
																							if( f == -1)
																								break;
																							else if( f == 0){
																								h1Cnt++;
																								TotCnt++;
																							}
																							else if(f == 1){
																								h2Cnt++;
																								TotCnt++;
																							}
																							else if(f == 2)
																								TotCnt++;
																							// System.out.print("\n" + f + " " + a.view() + " " + b.view() + " " + c.view() + " " + d.view() + " " + e.view() + " " + h1Cnt + " " + h2Cnt + " " + TotCnt);
																						}
																					}
																				}
																			}
																			
																			
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
				float h1f=h1Cnt,
					h2f=h2Cnt,
					totf=TotCnt;
				System.out.print(h1f + " " + h1Cnt + " " + h2f + " " + h2Cnt + " " + totf + " " + TotCnt);
				float a[]={100*h1f/totf,100*h2f/totf};
				return a;
			}
		}
		else{
			float a[] = {-1,-1};
			return a;
		}		
	}
}
