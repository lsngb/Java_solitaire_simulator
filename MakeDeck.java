package project1;
import java.util.ArrayList;
import java.util.Collections;

public class MakeDeck {
	private ArrayList<CardOperations> Deck = new ArrayList<CardOperations>();
	private CardOperations c = new CardOperations('x',0,false);
	/*	PileOfCards MakeDeck( )
    pre - Pile exists
    post - Pile exists and has been initialized as standard 52 card deck*/
	public MakeDeck(){
		int w;
		for (w=0;w<13;w++){
			CardOperations[] s = new CardOperations[13];
			CardOperations[] h = new CardOperations[13];
			CardOperations[] c = new CardOperations[13];
			CardOperations[] d = new CardOperations[13];
			s[w]=new CardOperations('s',w+1,false);
			h[w]=new CardOperations('h',w+1,false);
			c[w]=new CardOperations('c',w+1,false);
			d[w]=new CardOperations('d',w+1,false);
			Deck.add(s[w]);
			Deck.add(h[w]);
			Deck.add(c[w]);
			Deck.add(d[w]);
		}
	}
	/*PileOfCards Shuffle( )
    pre - Pile exists
    post - a pseudo random ordering has been assigned to N
           Shuffle should be performed from a normalized dec k; i.e.
           one that is ordered by suit and value within suit. Whenever
           a deck needs to be shuffled it should be put into normal
           order before shuffling.*/
	public ArrayList<CardOperations> Shuffle(){
		Collections.shuffle(Deck);
		return Deck;
	}
	public CardOperations Get(int i){
		return Deck.get(i);
	}
}