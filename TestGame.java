package project1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class TestGame {
	private CardOperations a = new CardOperations('h',1,true);
	private CardOperations b = new CardOperations('h',13,true);
	private CardOperations c = new CardOperations('s',3,true);
	private CardOperations e = new CardOperations('h',2,true);
	private CardOperations h = new CardOperations('d',4,false);
	private PileOfCards[] Pile = new PileOfCards[7];
	private MakeDeck Deck = new MakeDeck();
	private ArrayList<CardOperations> NewDeck1 = new ArrayList<CardOperations>();
	private ArrayList<CardOperations> NewDeck2 = new ArrayList<CardOperations>();
	private PileOfCards[] Holder = new PileOfCards[4];
	private int flag =1;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testContinue() {
		NewDeck1.addAll(Deck.Shuffle());
		Game g = new Game(NewDeck1, NewDeck1, Pile, Holder);
		System.out.println("first input Q, second press Enter");
		assertEquals("input Q",0, g.Continue());
		assertEquals("press Enter",1, g.Continue());
	}

	@Test
	public void testMovePileAs() {
		NewDeck1.addAll(Deck.Shuffle());
		Game g = new Game(NewDeck1, NewDeck1, Pile, Holder);
		Pile[0].Add(a);
		g.MovePileAs(flag, NewDeck1, NewDeck2, Pile, Holder);
		assertEquals("Holder 1 size", 1, Holder[0].Size());
	}

	@Test
	public void testMoveDeckAs() {
		NewDeck1.addAll(Deck.Shuffle());
		Game g = new Game(NewDeck1, NewDeck1, Pile, Holder);
		NewDeck2.add(a);
		g.MoveDeckAs(flag, NewDeck1, NewDeck2, Pile, Holder);
		assertEquals("Holder 1 size", 1, Holder[0].Size());
	}

	@Test
	public void testMoveCardsToHolder() {
		NewDeck1.addAll(Deck.Shuffle());
		Game g = new Game(NewDeck1, NewDeck1, Pile, Holder);
		Holder[0].Add(a);
		NewDeck2.add(e);
		g.MoveCardsToHolder(flag, NewDeck1, NewDeck2, Pile, Holder);
		assertEquals("Holder 1 size", 2, Holder[0].Size());
	}

	@Test
	public void testMoveCards() {
		NewDeck1.addAll(Deck.Shuffle());
		Game g = new Game(NewDeck1, NewDeck1, Pile, Holder);
		for(int i=0;i<7;i++){
			Pile[i].Clear();
		}
		Pile[0].Add(c);
		NewDeck1.clear();
		NewDeck2.add(e);
		g.MoveCards(flag, NewDeck1, NewDeck2, Pile, Holder);
		assertEquals("Pile 1 last element", e.toString(), Pile[0].Get(Pile[0].Size()-1).toString());
		
	}

	@Test
	public void testMoveKs() {
		NewDeck1.addAll(Deck.Shuffle());
		Game g = new Game(NewDeck1, NewDeck1, Pile, Holder);
		for(int i=0;i<7;i++){
			Pile[i].Clear();
		}
		NewDeck2.add(b);
		g.MoveKs(flag, NewDeck1, NewDeck2, Pile, Holder);
		assertEquals("Pile 1 last element", b.toString(), Pile[0].Get(0).toString());
	}

	@Test
	public void testFlipCard() {
		NewDeck1.addAll(Deck.Shuffle());
		Game g = new Game(NewDeck1, NewDeck1, Pile, Holder);
		for(int i=0;i<7;i++){
			Pile[i].Clear();
		}
		NewDeck1.add(h);
		g.FlipCard(flag, NewDeck1, NewDeck2, Pile, Holder);
		assertEquals("NewDeck2", h.toString(), NewDeck2.get(0).toString());
		NewDeck1.clear();
		g.FlipCard(flag, NewDeck1, NewDeck2, Pile, Holder);
		assertEquals("NewDeck1", h.toString(), NewDeck1.get(0).toString());
	}
}
