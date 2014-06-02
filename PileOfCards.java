package project1;
import java.util.ArrayList;

public class PileOfCards {
	private ArrayList<CardOperations> pile =new ArrayList<CardOperations>();
	private CardOperations c = new CardOperations('x',0,false);
	private ArrayList<CardOperations> p = new ArrayList<CardOperations>();
/*	constructor()
    pre - Pile does not exist
    post - Pile exists but contains no cards*/
	public PileOfCards(){
		pile.clear();
	}
	/*card TakeTopCard()
    pre - Card c and PileOfCards p exist
    post - the top card in p is removed from p and its s,v,f attributes are assigned to C*/
	public CardOperations TakeTopCard(){
		c = pile.get(pile.size()-1);
		pile.remove(pile.size()-1);
		return c;
	}
	/*void AddCardToPile(card c)
    pre - Card c and PileOfCards p exist
    post - card c is added to the top of PileOfCards p; c loses its own identity*/
	public void AddCardToPile(CardOperations c){
		pile.add(c);
		c = this.c;
	}
	public int a(){
		int j;
		for (j = 0; j<pile.size();j++){
			if(pile.get(j).CardStatus()==true){
				break;
			}
		}
		return j;
	}
	//take cards from pile(a) to the end and add them to p, order backwards
	public  ArrayList<CardOperations> TakePile(int a){
		//System.out.println("YYYYYYYY");
		int x =pile.size()-1;
		for (int i =x; i > (a-1);i--){
			p.add(pile.get(i));
			pile.remove(i);
		}
		return p;
	}
	//add p to another pile, order back
	public void AddPile(ArrayList<CardOperations> p){
		int x = p.size();
		for(int i=x;i>0;i--){
			//System.out.println("XXXXXXXXX");
			pile.add(p.get(i-1));
		}
		p.clear();
	}
	
	public void Add(CardOperations x){
		pile.add(x);
	}
	public CardOperations Get(int i){
		return pile.get(i);
	}
	public int Size(){
		return pile.size();
	}
	
	//for junit test
	public void Clear(){
		pile.clear();
	}
}
