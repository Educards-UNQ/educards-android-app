package educards.educards_test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import educards.educards_model.Player;

public class PlayerTest {
 	Player player;
	
	@Before
	public void setUp() {
		player = new Player(1,"pepe");
	}
	
	@Test
	public void builderTest() {
		assertTrue("pepe" == player.getUsername());
		assertTrue(1 == player.getId());
	}
 	
	@Test
	public void saveHiScoreTest() {
		player.saveHiScore(40);
		assertTrue(40 == player.getHiScore());
	}
}
