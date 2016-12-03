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
   * 
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
   * @param isStart
   */
  public final void setStart(boolean isStart) {
    this.isStart = isStart;
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
   * @param isFinish
   */
  public final void setFinish(final boolean isFinish) {
    this.isFinish = isFinish;
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
   * @param isPath 
   */
  public final void setPath(final boolean isPath) {
    this.isPath = isPath;
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
   * @param isExplored 
   */
  public final void setExplored(final boolean isExplored) {
    this.isExplored = isExplored;
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
