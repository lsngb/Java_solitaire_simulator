package project1;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private int flag=1;
	//setup game
	public Game(ArrayList<CardOperations> NewDeck1,ArrayList<CardOperations> NewDeck2,PileOfCards[] Pile, PileOfCards[] Holder){
		//put card into piles
		//pile1 1card, pile2 2cards..........pile7 7cards
		for (int i=0;i<7;i++){
			Pile[i] = new PileOfCards();
			for (int k=0;k<=i;k++){
				//make the last card in a pile face up
				if(i==k){
					NewDeck1.get(0).Faceup();
				}
				Pile[i].Add(NewDeck1.get(0));
				NewDeck1.remove(0);
			}
					
		}
		for(int i=0;i<4;i++){
			Holder[i] = new PileOfCards();
		}
	}
	//setup print format
	public void Print(ArrayList<CardOperations> NewDeck1,ArrayList<CardOperations> NewDeck2,PileOfCards[] Pile, PileOfCards[] Holder){
		//print head line
		if (NewDeck1.size()==0){System.out.print("анан"+"\t");}
		else{System.out.print(NewDeck1.get(NewDeck1.size()-1).toString());}
				
		if (NewDeck2.size()==0){System.out.print("анан"+"\t"+"\t");}
		else{System.out.print(NewDeck2.get(NewDeck2.size()-1).toString()+"\t");}
		for(int i=0;i<4;i++){
			if (Holder[i].Size()==0){
				System.out.print("анан"+"\t");
			}
			else{System.out.print(Holder[i].Get(Holder[i].Size()-1).toString());}
		}
		System.out.print("\n");
		
		//find biggest pile size
		int k=-1;
		for (int i=0;i<7;i++){
			if(k<Pile[i].Size()){
				k=Pile[i].Size();
			}
		}
		//print piles
		System.out.print("\n");
		for (int j=0;j<k;j++){
			for (int i=0;i<7;i++){
				if(j==0 && Pile[i].Size()==0){
					System.out.print("анан"+"\t");
				}
				else if(j != 0 && Pile[i].Size()==0){
					System.out.print("  "+"\t");
				}
				else if (Pile[i].Size()<j+1){
					System.out.print("\t");
				}
				else{
					System.out.print(Pile[i].Get(j).toString());
				}
			}
			System.out.print("\n");
		}
	}
	
	//tell continue or quit from user input
	public int Continue(){
		flag=1;
		Scanner input =new Scanner(System.in);
		System.out.print("Input Q to quit or press Enter to continue ");
		String in = input.nextLine();
		if (in.equals("Q")){
			flag=0;
		}
		return flag;
	}
	//move A from piles to holders
	public int MovePileAs(int flag,ArrayList<CardOperations> NewDeck1,ArrayList<CardOperations> NewDeck2,PileOfCards[] Pile, PileOfCards[] Holder){
		if(flag==1){
			for (int i=0;i<7;i++){
				if(flag==1 && Pile[i].Size() != 0 && Pile[i].Get(Pile[i].Size()-1).CardValue()==1){
					for(int j=0;j<4;j++){
						if (Holder[j].Size()==0){
							Holder[j].Add(Pile[i].TakeTopCard());
							break;
						}
					}
					if(Pile[i].Size() != 0){
					Pile[i].Get(Pile[i].Size()-1).Faceup();}
					this.Print(NewDeck1, NewDeck2, Pile, Holder);
					flag=0;
					break;
				}
			}
		}
		return flag;
	}
	//move A from deck to holders
	public int MoveDeckAs(int flag,ArrayList<CardOperations> NewDeck1,ArrayList<CardOperations> NewDeck2,PileOfCards[] Pile, PileOfCards[] Holder){
		if(flag==1 && NewDeck2.size() != 0 && NewDeck2.get(NewDeck2.size()-1).CardValue()==1){
			for(int j=0;j<4;j++){
				if (Holder[j].Size()==0){
					CardOperations c = 	NewDeck2.get(NewDeck2.size()-1);
					NewDeck2.remove(NewDeck2.size()-1);
					Holder[j].Add(c);
					this.Print(NewDeck1, NewDeck2, Pile, Holder);
					flag =0;
					break;
				}
			}
		}
		return flag;
	}
	public int MoveCardsToHolder(int flag,ArrayList<CardOperations> NewDeck1,ArrayList<CardOperations> NewDeck2,PileOfCards[] Pile, PileOfCards[] Holder){
		if(flag==1){
			for (int j=0;j<4;j++){
				if(flag==1 && Holder[j].Size() !=0 && Holder[j].Get(Holder[j].Size()-1).CardSuit()=='s'){
					//move appropriate s cards in pile to holders
					for(int i=0;i<7;i++){
						if (Pile[i].Size() != 0 && Pile[i].Get(Pile[i].Size()-1).CardSuit()=='s' && Pile[i].Get(Pile[i].Size()-1).CardValue()==Holder[j].Get(Holder[j].Size()-1).CardValue()+1){
							Holder[j].Add(Pile[i].TakeTopCard());
							if(Pile[i].Size() != 0){
								Pile[i].Get(Pile[i].Size()-1).Faceup();}
							this.Print(NewDeck1, NewDeck2, Pile, Holder);
							flag=0;
							break;
						}
					}
					//move appropriate s cards in newdeck2 to holders
					if(flag==1 && NewDeck2.size() != 0 && NewDeck2.get(NewDeck2.size()-1).CardSuit()=='s' && NewDeck2.get(NewDeck2.size()-1).CardValue()==Holder[j].Get(Holder[j].Size()-1).CardValue()+1){
						CardOperations c = 	NewDeck2.get(NewDeck2.size()-1);
						NewDeck2.remove(NewDeck2.size()-1);
						Holder[j].Add(c);
						this.Print(NewDeck1, NewDeck2, Pile, Holder);
						flag =0;
						break;
					}
				}
				//move appropriate h cards in pile to holders
				if(flag==1 && Holder[j].Size() !=0 && Holder[j].Get(Holder[j].Size()-1).CardSuit()=='h'){
					for(int i=0;i<7;i++){
						if (Pile[i].Size() != 0 && Pile[i].Get(Pile[i].Size()-1).CardSuit()=='h' && Pile[i].Get(Pile[i].Size()-1).CardValue()==Holder[j].Get(Holder[j].Size()-1).CardValue()+1){
							Holder[j].Add(Pile[i].TakeTopCard());
							if(Pile[i].Size() != 0){
								Pile[i].Get(Pile[i].Size()-1).Faceup();}
							this.Print(NewDeck1, NewDeck2, Pile, Holder);
							flag=0;
							break;
						}
					}
					//move appropriate h cards in newdeck2 to holders
					if(flag==1 && NewDeck2.size() != 0 && NewDeck2.get(NewDeck2.size()-1).CardSuit()=='h' && NewDeck2.get(NewDeck2.size()-1).CardValue()==Holder[j].Get(Holder[j].Size()-1).CardValue()+1){
						CardOperations c = 	NewDeck2.get(NewDeck2.size()-1);
						NewDeck2.remove(NewDeck2.size()-1);
						Holder[j].Add(c);
						this.Print(NewDeck1, NewDeck2, Pile, Holder);
						flag =0;
						break;
					}
				}
				//move appropriate c cards in pile to holders
				if(flag==1 && Holder[j].Size() !=0 && Holder[j].Get(Holder[j].Size()-1).CardSuit()=='c'){
					for(int i=0;i<7;i++){
						if (Pile[i].Size() != 0 && Pile[i].Get(Pile[i].Size()-1).CardSuit()=='c' && Pile[i].Get(Pile[i].Size()-1).CardValue()==Holder[j].Get(Holder[j].Size()-1).CardValue()+1){
							Holder[j].Add(Pile[i].TakeTopCard());
							if(Pile[i].Size() != 0){
								Pile[i].Get(Pile[i].Size()-1).Faceup();}
							this.Print(NewDeck1, NewDeck2, Pile, Holder);
							flag=0;
							break;
						}
					}
					//move appropriate c cards in newdeck2 to holders
					if(flag==1 && NewDeck2.size() != 0 && NewDeck2.get(NewDeck2.size()-1).CardSuit()=='c' && NewDeck2.get(NewDeck2.size()-1).CardValue()==Holder[j].Get(Holder[j].Size()-1).CardValue()+1){
						CardOperations c = 	NewDeck2.get(NewDeck2.size()-1);
						NewDeck2.remove(NewDeck2.size()-1);
						Holder[j].Add(c);
						this.Print(NewDeck1, NewDeck2, Pile, Holder);
						flag =0;
						break;
					}
				}
				//move appropriate d cards in pile to holders
				if(flag==1 && Holder[j].Size() !=0 && Holder[j].Get(Holder[j].Size()-1).CardSuit()=='d'){
					for(int i=0;i<7;i++){
						if (Pile[i].Size() != 0 && Pile[i].Get(Pile[i].Size()-1).CardSuit()=='d' && Pile[i].Get(Pile[i].Size()-1).CardValue()==Holder[j].Get(Holder[j].Size()-1).CardValue()+1){
							Holder[j].Add(Pile[i].TakeTopCard());
							if(Pile[i].Size() != 0){
								Pile[i].Get(Pile[i].Size()-1).Faceup();}
							this.Print(NewDeck1, NewDeck2, Pile, Holder);
							flag=0;
							break;
						}
					}
					//move appropriate d cards in newdeck2 to holders
					if(flag==1 && NewDeck2.size() != 0 && NewDeck2.get(NewDeck2.size()-1).CardSuit()=='d' && NewDeck2.get(NewDeck2.size()-1).CardValue()==Holder[j].Get(Holder[j].Size()-1).CardValue()+1){
						CardOperations c = 	NewDeck2.get(NewDeck2.size()-1);
						NewDeck2.remove(NewDeck2.size()-1);
						Holder[j].Add(c);
						this.Print(NewDeck1, NewDeck2, Pile, Holder);
						flag =0;
						break;
					}
				}
			}
		}
		return flag;
	}
	public int MoveCards(int flag,ArrayList<CardOperations> NewDeck1,ArrayList<CardOperations> NewDeck2,PileOfCards[] Pile, PileOfCards[] Holder){
		if (flag==1){
			for(int i=0;i<7;i++){
				//move between piles
				if (flag==1 && Pile[i].Size() != 0 && (Pile[i].Get(Pile[i].Size()-1).CardSuit()=='s' || Pile[i].Get(Pile[i].Size()-1).CardSuit()=='c')){
					for (int j=0;j<7;j++){
						if(Pile[j].Size() != 0 && 
								(Pile[j].Get(Pile[j].a()).CardSuit()=='h' || Pile[j].Get(Pile[j].a()).CardSuit()=='d') &&
								Pile[j].Get(Pile[j].a()).CardValue()==Pile[i].Get(Pile[i].Size()-1).CardValue()-1){
							Pile[i].AddPile(Pile[j].TakePile(Pile[j].a()));
							if (Pile[j].Size() != 0){
							Pile[j].Get(Pile[j].Size()-1).Faceup();}
							this.Print(NewDeck1, NewDeck2, Pile, Holder);
							flag =0;
							break;
						}
					}
					//move from NeDeck2 to pile
					if (flag==1 && NewDeck2.size() != 0 && 
							(NewDeck2.get(NewDeck2.size()-1).CardSuit()=='h' || NewDeck2.get(NewDeck2.size()-1).CardSuit()=='d') &&
							NewDeck2.get(NewDeck2.size()-1).CardValue() == Pile[i].Get(Pile[i].Size()-1).CardValue()-1){
						Pile[i].AddCardToPile(NewDeck2.get(NewDeck2.size()-1));
						NewDeck2.remove(NewDeck2.size()-1);
						this.Print(NewDeck1, NewDeck2, Pile, Holder);
						flag =0;
						break;
					}
				}
				//move between piles
				if (flag==1 && Pile[i].Size() != 0 && (Pile[i].Get(Pile[i].Size()-1).CardSuit()=='h' || Pile[i].Get(Pile[i].Size()-1).CardSuit()=='d')){
					for (int j=0;j<7;j++){
						if(Pile[j].Size() != 0 &&
								(Pile[j].Get(Pile[j].a()).CardSuit()=='s' || Pile[j].Get(Pile[j].a()).CardSuit()=='c') &&
								Pile[j].Get(Pile[j].a()).CardValue()==Pile[i].Get(Pile[i].Size()-1).CardValue()-1){
							Pile[i].AddPile(Pile[j].TakePile(Pile[j].a()));
							//System.out.println(Pile[j].Size()-1);
							if (Pile[j].Size() != 0){
								Pile[j].Get(Pile[j].Size()-1).Faceup();}
							this.Print(NewDeck1, NewDeck2, Pile, Holder);
							flag =0;
							break;
						}
					}
					//move from NeDeck2 to pile
					if (flag==1 && NewDeck2.size() != 0 && 
							(NewDeck2.get(NewDeck2.size()-1).CardSuit()=='s' || NewDeck2.get(NewDeck2.size()-1).CardSuit()=='c') &&
							NewDeck2.get(NewDeck2.size()-1).CardValue() == Pile[i].Get(Pile[i].Size()-1).CardValue()-1){
						Pile[i].AddCardToPile(NewDeck2.get(NewDeck2.size()-1));
						NewDeck2.remove(NewDeck2.size()-1);
						this.Print(NewDeck1, NewDeck2, Pile, Holder);
						flag =0;
						break;
					}
				}
			}
		}
		return flag;
	}
	public int MoveKs(int flag,ArrayList<CardOperations> NewDeck1,ArrayList<CardOperations> NewDeck2,PileOfCards[] Pile, PileOfCards[] Holder){
		//move K from pile to empty pile
		if (flag==1){
			for (int i=0;i<7;i++){
				if (Pile[i].Size()==0){
					for(int j=0;j<7;j++){
						if (Pile[j].a() !=0 && Pile[j].Get(Pile[j].a()).CardValue()==13){
							Pile[i].AddPile(Pile[j].TakePile(Pile[j].a()));
							if (Pile[j].Size() != 0){
								Pile[j].Get(Pile[j].Size()-1).Faceup();}
							this.Print(NewDeck1, NewDeck2, Pile, Holder);
							flag =0;
							break;
						}
					}
					//move K from NewDeck2 to empty pile
					if(flag==1 && NewDeck2.size() != 0 && NewDeck2.get(NewDeck2.size()-1).CardValue()==13){
						Pile[i].AddCardToPile(NewDeck2.get(NewDeck2.size()-1));
						NewDeck2.remove(NewDeck2.size()-1);
						this.Print(NewDeck1, NewDeck2, Pile, Holder);
						flag =0;
						break;
					}
				}
			}
		}
		return flag;
	}
	public int FlipCard(int flag,ArrayList<CardOperations> NewDeck1,ArrayList<CardOperations> NewDeck2,PileOfCards[] Pile, PileOfCards[] Holder){
		//flip cards in deck
		if (flag==1){
			if(NewDeck1.size() != 0 ){
			NewDeck1.get(NewDeck1.size()-1).Faceup();
			NewDeck2.add(NewDeck1.get(NewDeck1.size()-1));
			NewDeck1.remove(NewDeck1.size()-1);}
			//put cards back to NewDeck1
			else if (NewDeck2.size() != 0){
				ArrayList<CardOperations> NewDeck = new ArrayList<CardOperations>(NewDeck2);
				NewDeck2.clear();
				int x= NewDeck.size()-1;
				for(int i=x;i>= 0;i--){
					NewDeck.get(i).FaceDown();
					NewDeck1.add(NewDeck.get(i));
				}
			}
			this.Print(NewDeck1, NewDeck2, Pile, Holder);
			flag =0;
		}
		return flag;
	}
}