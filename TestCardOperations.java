package project1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCardOperations {
	private char s = 'h';
	private int v = 1;
	private boolean f=true;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCardOperations() {
		CardOperations c = new CardOperations(s,v,f);
		assertEquals("Suit",'h',c.CardSuit());
		assertEquals("Value",1,c.CardValue());
		assertEquals("Status",true,c.CardStatus());
	}

	@Test
	public void testFaceup() {
		CardOperations c = new CardOperations(s,v,false);
		c.Faceup();
		assertEquals("Status",true,c.CardStatus());
	}

	@Test
	public void testFaceDown() {
		CardOperations c = new CardOperations(s,v,true);
		c.FaceDown();
		assertEquals("Status",false,c.CardStatus());
	}

	
	@Test
	public void testToString() {
		CardOperations c = new CardOperations(s,v,f);
		assertEquals("toString","hA"+"\t",c.toString());
	}

}
