package release1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

//import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
/**
 * 
 * @author Patton Finley, Josh Crum, Paul Magee
 *
 */
public class SpeedTypingTest {
	
	/**
	 * Magic Number for Delta.
	 */
	private static final double DELTA = 1e-15;
	/**
	 * Magic Number.
	 */
	public static final int SIXEIGHTNINE = 689;
	/**
	 * Magic Number.
	 */
	public static final int THREESEVENONENINE = 3719;
	/**
	 * Magic Number.
	 */
	public static final int TEN = 10;
	/**
	 * Magic Number.
	 */
	public static final double TENONEONEONEONE = 10.1111;
	/**
	 * Magic Number.
	 */
	public static final int FIVEEIGHTSIXFIVE = 5865;
	/**
	 * Magic Number.
	 */
	public static final double TENONEONE = 10.11;
	/**
	 * Magic Number.
	 */
	public static final int ONESIXEIGHT = 168;
	
	/**
	 * Constructor Test 1.
	 */
	@Test
	public final void constructorTest1() {
		SpeedTyping test = new SpeedTyping();
		assertEquals(SIXEIGHTNINE, test.getAdjectives().size());
	}
	
	/**
	 * Constructor Test 2.
	 */
	@Test
	public final void constructorTest2() {
		SpeedTyping test = new SpeedTyping();
		assertEquals(ONESIXEIGHT, test.getAdverbs().size());
	}
	
	/**
	 * Constructor Test 3.
	 */
	@Test
	public final void constructorTest3() {
		SpeedTyping test = new SpeedTyping();
		assertEquals(FIVEEIGHTSIXFIVE, test.getNouns().size());
	}
	
	/**
	 * Constructor Test 4.
	 */
	@Test
	public final void constructorTest4() {
		SpeedTyping test = new SpeedTyping();
		assertEquals(THREESEVENONENINE, test.getVerbs().size());
	}
	
	/**
	 * Check List Test.
	 */
	@Test
	public final void checkListTest() {
		SpeedTyping test = new SpeedTyping();
		ArrayList<String> testList = new ArrayList<String>();
		assertFalse(test.checkLists(testList));
	}
	
	/**
	 * Round Test 1.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void roundTest1() {
		SpeedTyping test = new SpeedTyping();
		test.round(TEN, -1);
	}
	/**
	 * Round Test 2.
	 */
	@Test
	public final void roundTest2() {
		SpeedTyping test = new SpeedTyping();
		assertEquals(test.round(TEN, 1), TEN, DELTA);
	}
	/**
	 * Round Test 3.
	 */
	@Test
	public final void roundTest3() {
		SpeedTyping test = new SpeedTyping();
		assertEquals(test.round(TENONEONEONEONE, 2), TENONEONE, DELTA);
	}
	/**
	 * Check Accuracy Test 1.
	 */
	@Test
	public final void checkAccuracyTest1() {
		SpeedTyping test = new SpeedTyping();
		String target = "Target";
		String entered = "Targex";
		assertEquals("83.33%", test.checkAccuracy(entered, target));
	}
	/**
	 * Check Accuracy Test 2.
	 */
	@Test
	public final void checkAccuracyTest2() {
		SpeedTyping test = new SpeedTyping();
		String target = "Target";
		String entered = "Target";
		assertEquals("100.0%", test.checkAccuracy(entered, target));
	}
	
	
}
