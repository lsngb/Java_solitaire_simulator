package project1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMakeDeck {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMakeDeck() {
		MakeDeck d = new MakeDeck();
		CardOperations p0 = new CardOperations('s',1,true);
		CardOperations p1 = new CardOperations('h',1,true);
		CardOperations p2 = new CardOperations('c',1,true);
		CardOperations p3 = new CardOperations('d',1,true);
		CardOperations p21 = new CardOperations('h',6,true);
		CardOperations p30 = new CardOperations('c',8,true);
		d.Get(0).Faceup();
		d.Get(1).Faceup();
		d.Get(2).Faceup();
		d.Get(3).Faceup();
		d.Get(21).Faceup();
		d.Get(30).Faceup();
		assertEquals("card at position 0",p0.toString(),d.Get(0).toString());
		assertEquals("card at position 1",p1.toString(),d.Get(1).toString());
		assertEquals("card at position 2",p2.toString(),d.Get(2).toString());
		assertEquals("card at position 3",p3.toString(),d.Get(3).toString());
		assertEquals("card at position 21",p21.toString(),d.Get(21).toString());
		assertEquals("card at position 30",p30.toString(),d.Get(30).toString());
	}

}
