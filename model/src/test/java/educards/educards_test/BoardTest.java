package educards.educards_test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import educards.educards_model.Board;
import educards.educards_model.Card;

public class BoardTest {
 	Board board;
	Card mockCard;
	Card mockCard2;
	Card mockCard3;
	Card mockCard4;
	Card mockCard5;
	
	@Before
	public void setUp() {
		mockCard = new Card(null, 1,"mc1","h1",1543, null);
		mockCard2 = new Card(null, 2,"mc2","h2",1852, null);
		mockCard3 = new Card(null, 3,"mc3","h3",-460, null);
		mockCard4 = new Card(null, 4,"mc4","h4",289, null);
		mockCard5 = new Card(null, 5,"mc5","h5",1950, null);
		
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(mockCard);
		cards.add(mockCard2);
		cards.add(mockCard3);
		cards.add(mockCard4);
		cards.add(mockCard5);
		
		board = new Board(cards);
	}
	
	@Test
	public void generateCorrectOrderTest() {
		assertEquals(mockCard3.getYear(), board.getCorrectOrder().get(0));
		assertEquals(mockCard4.getYear(), board.getCorrectOrder().get(1));
		assertEquals(mockCard.getYear(), board.getCorrectOrder().get(2));
		assertEquals(mockCard2.getYear(), board.getCorrectOrder().get(3));
		assertEquals(mockCard5.getYear(), board.getCorrectOrder().get(4));
	}
	
	@Test
	public void playACardTest() {
		board.playCard(1, mockCard);
		assertEquals(1, board.getPlayedCards().size());
		assertEquals(4, board.getCardsToPlay().size());
		assertEquals(mockCard,board.getPlayedCards().get(1));
	}
	
	@Test
	public void playDuplicatedCardTest() {
		board.playCard(1, mockCard);
		board.playCard(1, mockCard2);
		assertTrue(board.getCardsToPlay().contains(mockCard));
		assertEquals(board.getPlayedCards().get(1),mockCard2);
	}
	
	@Test
	public void checkPlayedCardsTest() {
		board.playCard(3, mockCard);
		board.playCard(2, mockCard2);
		board.playCard(4, mockCard3);
		board.playCard(5, mockCard4);
		board.playCard(1, mockCard5);
		
		ArrayList<Boolean> results = board.checkPlayedCards();
		assertFalse(results.get(0));
		assertFalse(results.get(1));
		assertTrue(results.get(2));
		assertFalse(results.get(3));
		assertFalse(results.get(4));
	}
}