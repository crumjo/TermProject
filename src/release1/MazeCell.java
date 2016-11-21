package release1;

public class MazeCell {
 
  //this boolean is if the cell is a starting point
  private boolean isStart;
  //this boolean is if the cell is a ending point
  private boolean isFinish;
  //this boolean is if the cell is a wall
  private boolean isWall;
  //this boolean is if you have explored the cell
  //you can not move to a cell thats not connected to a cell that has not been explored
  private boolean isExplored;
  
  public MazeCell(){
    isStart = false;
    isFinish = false;
    isWall = false;
    isExplored = false;
  }
  
  //returns the value of start
  public boolean isStart() {
    return isStart;
  }
  
  //sets the value of start
  public void setStart(boolean isStart) {
    this.isStart = isStart;
  }
  
  //returns the value of finish
  public boolean isFinish() {
    return isFinish;
  }

  //sets the value of finish
  public void setFinish(boolean isFinish) {
    this.isFinish = isFinish;
  }

  //returns the value of wall
  public boolean isWall() {
    return isWall;
  }

  //sets the value of wall
  public void setWall(boolean isWall) {
    this.isWall = isWall;
  }

  //returns if the cell has been explored
  public boolean isExplored() {
    return isExplored;
  }
  
  //sets the cell if it has been explored
  public void setExplored(boolean isExplored) {
    this.isExplored = isExplored;
  }





  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
