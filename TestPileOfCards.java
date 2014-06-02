package project1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestPileOfCards {
	private CardOperations a = new CardOperations('s',1,true);
	private CardOperations b = new CardOperations('h',2,true);
	private CardOperations c = new CardOperations('c',3,true);
	private CardOperations d = new CardOperations('d',4,true);
	private CardOperations e = new CardOperations('s',1,false);
	private CardOperations f = new CardOperations('h',2,false);
	private CardOperations g = new CardOperations('c',3,false);
	private CardOperations h = new CardOperations('d',4,false);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPileOfCards() {
		PileOfCards p =new PileOfCards();
		assertEquals("p size",0 ,p.Size());
		
	}

	@Test
	public void testTakeTopCard() {
		PileOfCards p =new PileOfCards();
		p.Add(a);
		p.Add(b);
		p.Add(c);
		p.Add(d);
		CardOperations x=p.TakeTopCard();
		assertEquals("Take top card",d,x);
		assertEquals("P size",3,p.Size());
	}

	@Test
	public void testAddCardToPile() {
		PileOfCards p =new PileOfCards();
		p.Add(a);
		p.Add(b);
		p.Add(c);
		p.AddCardToPile(d);
		assertEquals("P size",4,p.Size());
		assertEquals("Take top card",d,p.Get(p.Size()-1));
	}

	@Test
	public void testA() {
		PileOfCards p =new PileOfCards();
		p.Add(h);
		p.Add(g);
		p.Add(f);
		p.Add(e);
		p.Add(d);
		p.Add(c);
		p.Add(b);
		p.Add(a);
		assertEquals("a",4,p.a());
	}

	@Test
	public void testTakePile() {
		PileOfCards p =new PileOfCards();
		p.Add(h);
		p.Add(g);
		p.Add(f);
		p.Add(e);
		p.Add(d);
		p.Add(c);
		p.Add(b);
		p.Add(a);
		ArrayList<CardOperations> x = new ArrayList<CardOperations>(p.TakePile(p.a()));
		assertEquals("p size",4,p.Size());
		assertEquals("x at 0",a,x.get(0));
		assertEquals("x at 1",b,x.get(1));
		assertEquals("x at 2",c,x.get(2));
		assertEquals("x at 3",d,x.get(3));
	}

	@Test
	public void testAddPile() {
		PileOfCards p =new PileOfCards();
		PileOfCards q =new PileOfCards();
		p.Add(h);
		p.Add(g);
		p.Add(f);
		p.Add(e);
		p.Add(d);
		p.Add(c);
		p.Add(b);
		p.Add(a);
		q.AddPile(p.TakePile(p.a()));
		assertEquals("q size",4,q.Size());
		assertEquals("q at 0",d,q.Get(0));
		assertEquals("q at 1",c,q.Get(1));
		assertEquals("q at 2",b,q.Get(2));
		assertEquals("q at 3",a,q.Get(3));
		
	}

	@Test
	public void testAdd() {
		PileOfCards p =new PileOfCards();
		p.Add(a);
		assertEquals("ele in p",a,p.Get(0));
	}

}
