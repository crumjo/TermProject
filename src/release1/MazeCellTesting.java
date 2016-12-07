package release1;

import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.*;

import org.junit.Test;


/**
 * 
 * @author Patton Finley, Josh Crum, Paul Magee
 *
 */
public class MazeCellTesting {

	/**
	 * Magic Number.
	 */
	  public static final int ELEVEN = 11;
	/**
	 * Magic Number.
	 */
	  public static final int TWELVE = 12;
	
	/**
	 * Constructor Test.
	 */
  @Test
public final void constructerTest() {
    MazeCell test = new MazeCell();
    assertEquals(test.isExplored(), false);
    assertEquals(test.isStart(), false);
    assertEquals(test.isFinish(), false);
    assertEquals(test.isPath(), false);
    assertEquals(test.getCount(), 0);
  }
  /**
   * Starting block test.
   */
  @Test
public final void startTest() {
    MazeCell test = new MazeCell();
    test.setStart(true);
    assertEquals(true, test.isStart());
  }
  /**
   * Finish block test.
   */
  @Test
public final void finishTest() {
    MazeCell test = new MazeCell();
    test.setFinish(true);
    assertEquals(true, test.isFinish());
  }
  /**
   * Path testing.
   */
  @Test
public final void pathTest() {
    MazeCell test = new MazeCell();
    test.setPath(true);
    assertEquals(true, test.isPath());
  }
  /**
   * explored testing.
   */
  @Test
public final void exploredTest() {
    MazeCell test = new MazeCell();
    test.setExplored(true);
    assertEquals(true, test.isExplored());
  }
  /**
   * counting test.
   */
  @Test
public final void countTest() {
    MazeCell test = new MazeCell();
    assertEquals(test.getCount(), 0);
    test.countUp();
    assertEquals(test.getCount(), 1);
    for (int i = 0; i < ELEVEN; i++) {
      test.countUp();
    }
    assertEquals(TWELVE, test.getCount());
  }
  
}
