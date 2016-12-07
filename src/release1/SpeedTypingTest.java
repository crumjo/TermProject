package release1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SpeedTypingTest {
	
	private static final double DELTA = 1e-15;
	
	

	@Test
	public void constructorTest1() {
		SpeedTyping test = new SpeedTyping();
		assertEquals(689, test.getAdjectives().size());
	}
	
	
	@Test
	public void constructorTest2() {
		SpeedTyping test = new SpeedTyping();
		assertEquals(168, test.getAdverbs().size());
	}
	
	
	@Test
	public void constructorTest3() {
		SpeedTyping test = new SpeedTyping();
		assertEquals(5865, test.getNouns().size());
	}
	
	
	@Test
	public void constructorTest4() {
		SpeedTyping test = new SpeedTyping();
		assertEquals(3719, test.getVerbs().size());
	}
	
	
	@Test
	public void checkListTest() {
		SpeedTyping test = new SpeedTyping();
		ArrayList<String> testList = new ArrayList<String>();
		assertFalse(test.checkLists(testList));
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void roundTest1() {
		SpeedTyping test = new SpeedTyping();
		test.round(10, -1);
	}
	
	@Test
	public void roundTest2() {
		SpeedTyping test = new SpeedTyping();
		assertEquals(test.round(10, 1), 10, DELTA);
	}
	
	@Test
	public void roundTest3() {
		SpeedTyping test = new SpeedTyping();
		assertEquals(test.round(10.1111, 2), 10.11, DELTA);
	}
	
	
	@Test
	public void checkAccuracyTest1() {
		SpeedTyping test = new SpeedTyping();
		String target = "Target";
		String entered = "Targex";
		assertEquals("83.33%", test.checkAccuracy(entered, target));
	}
	
	
	@Test
	public void checkAccuracyTest2() {
		SpeedTyping test = new SpeedTyping();
		String target = "Target";
		String entered = "Target";
		assertEquals("100.0%", test.checkAccuracy(entered, target));
	}
	
	
}
