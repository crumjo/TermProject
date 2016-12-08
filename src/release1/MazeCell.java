package release1;
/**
 * 
 * @author Patton Finley, Josh Crum, Paul Magee
 *
 */
public class MazeCell {
 
  /**
   * this boolean is if the cell is a starting point.
   */
  private boolean isStart;
  /**
   * this boolean is if the cell is a ending point.
   */
  private boolean isFinish;
  /**
   * this boolean is if the cell is a wall.
   */
  private boolean isPath;
  /**
   * this boolean is if you have explored the cell.
   */
  /**
   * you can not move to a cell thats not connected 
   * to a cell that has not been explored.
   */
  private boolean isExplored;
  /**
   * this is used for when creating the path.
   */
  private int count;
  /**
   * MazeCell constructor.
   */
  public MazeCell() {
    isStart = false;
    isFinish = false;
    isPath = false;
    isExplored = false;
    count = 0;
  }
  
  /**
   * returns the value of start.
   * @return isStart
   */
  public final boolean isStart() {
    return isStart;
  }
  
  /**
   * sets the value of start.
   * @param sIsStart 
   */
  public final void setStart(final boolean sIsStart) {
    this.isStart = sIsStart;
  }
  
  /**
   * returns the value of finish.
   * @return isFinish
   */
  public final boolean isFinish() {
    return isFinish;
  }

  /**
   * sets the value of finish.
   * @param sIsFinish 
   */
  public final void setFinish(final boolean sIsFinish) {
    this.isFinish = sIsFinish;
  }

  /**
   * returns the value of wall.
   * @return isPath
   */
  public final boolean isPath() {
    return isPath;
  }

  /**
   * sets the value of wall.
   * @param sIsPath 
   */
  public final void setPath(final boolean sIsPath) {
    this.isPath = sIsPath;
  }

  /**
   * returns if the cell has been explored.
   * @return isExplored
   */
  public final boolean isExplored() {
    return isExplored;
  }
  
  /**
   * sets the cell if it has been explored.
   * @param sIsExplored 
   */
  public final void setExplored(final boolean sIsExplored) {
    this.isExplored = sIsExplored;
  }

  /**
   * increase count by one.
   */
  public final void countUp() {
    count++;
  }

  /**
   * returns count.
   * @return count
   */
  public final int getCount() {
    return count;
  }
  /**
   * 
   * @param args 
   */
  public static void main(final String[] args) {
    // TODO Auto-generated method stub

  }

}
