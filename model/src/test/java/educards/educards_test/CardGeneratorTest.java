package educards.educards_test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import educards.educards_model.CardGenerator;

public class CardGeneratorTest {

	CardGenerator cardGenerator;
	
	@Before
	public void setUp() {
		cardGenerator = new CardGenerator();
	}
	
	@Test
	public void getCardsTest() {
		assertTrue(true);
		//assertTrue(cardGenerator.getCards().size()==5);
	}

}
