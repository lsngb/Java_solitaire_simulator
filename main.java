package project1;
import java.util.ArrayList;

public class main {
	public static void main(String[] args){		
		//Setup Game
		
		//Create deck
		MakeDeck Deck = new MakeDeck();
		//Create 7 Piles
		PileOfCards[] Pile = new PileOfCards[7];
		//Create New Deck1 same as shuffled Deck
		ArrayList<CardOperations> NewDeck1 = new ArrayList<CardOperations>(Deck.Shuffle());
		//Create another empty deck 
		ArrayList<CardOperations> NewDeck2 = new ArrayList<CardOperations>();
		//Create four card holders
		PileOfCards[] Holder = new PileOfCards[4];
		Game Agame=new Game(NewDeck1,NewDeck2, Pile, Holder);
		Agame.Print(NewDeck1, NewDeck2, Pile, Holder);
		//finish Game Setup
		
		//play game
		while(Agame.Continue()==1){
			//Set a flag=1 every time after press enter and change it to 0 whenever there's operation
			int flag=1;
			flag=Agame.MovePileAs(flag, NewDeck1, NewDeck2, Pile, Holder);
			flag=Agame.MoveDeckAs(flag, NewDeck1, NewDeck2, Pile, Holder);
			flag=Agame.MoveCardsToHolder(flag, NewDeck1, NewDeck2, Pile, Holder);
			flag=Agame.MoveCards(flag, NewDeck1, NewDeck2, Pile, Holder);
			flag=Agame.MoveKs(flag, NewDeck1, NewDeck2, Pile, Holder);
			flag=Agame.FlipCard(flag, NewDeck1, NewDeck2, Pile, Holder);
		}
	}
}