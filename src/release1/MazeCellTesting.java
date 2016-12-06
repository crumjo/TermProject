package release1;

import static org.junit.Assert.*;

import org.junit.Test;



public class MazeCellTesting {
  
  @Test
  public void constructerTest() {
    MazeCell test = new MazeCell();
    assertEquals(test.isExplored(), false);
    assertEquals(test.isStart(), false);
    assertEquals(test.isFinish(), false);
    assertEquals(test.isPath(), false);
    assertEquals(test.getCount(), 0);
  }
  
  @Test
  public void startTest() {
    MazeCell test = new MazeCell();
    test.setStart(true);
    assertEquals(true, test.isStart());
  }
  
  @Test
  public void finishTest() {
    MazeCell test = new MazeCell();
    test.setFinish(true);
    assertEquals(true, test.isFinish());
  }
  
  @Test
  public void pathTest() {
    MazeCell test = new MazeCell();
    test.setPath(true);
    assertEquals(true, test.isPath());
  }
  
  @Test
  public void exploredTest() {
    MazeCell test = new MazeCell();
    test.setExplored(true);
    assertEquals(true, test.isExplored());
  }
  
  @Test
  public void countTest() {
    MazeCell test = new MazeCell();
    assertEquals(test.getCount(), 0);
    test.countUp();
    assertEquals(test.getCount(), 1);
    for(int i = 0; i < 11; i ++){
      test.countUp();
    }
    assertEquals(12, test.getCount());
  }
  
}
