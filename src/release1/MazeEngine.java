package release1;

import java.util.Random;


public class MazeEngine {
  // a grid of cells
  private MazeCell[][] grid;
  // a size of the board
  private int gSize;
  //start row and col
  private int sRow;
  private int sCol;
  //finish row and col
  private int fRow;
  private int fCol;

  // builds a defualt array of cells as 10/10
  public MazeEngine() {
    gSize = 10;
    this.grid = new MazeCell[gSize][gSize];
    this.Buildgrid();
    this.genStart();
    this.genfinish();
    // this.buildPath();
  }

  public MazeEngine(int size) {
    //size is what they choose
    gSize = size;
    //iniatilize the grid
    this.grid = new MazeCell[gSize][gSize];
    //builds the grid and makes the start and finish
    this.Buildgrid();
    this.genStart();
    this.genfinish();
    // builds random path all over math
    for(int i = 0; i<(gSize/2);i++){
    this.buildPath();
    }
   
    //builds one greedy path that finds the end for sure
    this.greedyPath(sRow,sCol,fRow,fCol);
  }

  private void Buildgrid() {
    //nested for loops to make its slot a cell
    for (int row = 0; row < gSize; row++) {
      for (int col = 0; col < gSize; col++) {
        grid[row][col] = new MazeCell();
      }
    }
  }

  // you can start anywhere in the maze
  private void genStart() {
    //randomly picks where you start on the map
    Random selector = new Random();
    //stores where the start is
    sRow = selector.nextInt(gSize);
    sCol = selector.nextInt(gSize);
    //sets values for start
    this.grid[sRow][sCol].setStart(true);
    this.grid[sRow][sCol].setExplored(true);
  }

  // you can only finish on the outside of the maze
  private void genfinish() {
    //random to choose where you are
    Random selector = new Random();
    boolean placed = false;
    //loops to make sure that final is placed on edge
    while (placed != true) {
      fRow = selector.nextInt(gSize);
      fCol = selector.nextInt(gSize);
      //checks cols edge
      if (fCol == 0 || fCol == gSize) {
        this.grid[fRow][fCol].setFinish(true);
        placed = true;
      }
      //checks rows edge
      if (fRow == 0 || fRow == gSize) {
        this.grid[fRow][fCol].setFinish(true);
        placed = true;
      }
      //makes sure it isnt put on start
      if (fRow == sRow && fCol == sCol) {
        placed = false;
      }
    }
  }

  //greed is the best. Finds the most derict route
  private void greedyPath(int sr, int sc, int fr, int fc) {
    //boolean to check if its done
    boolean done = false;
    //row and col used to figure out if 
    int col = 0;
    int row = 0;
    //rowTemp and colTemp set to the starting spot
    int rowTemp = sr;
    int colTemp = sc;
    //loops to build path
    while (!done) {
      //determines which way to move
      col = fc - colTemp;
      row = fr - rowTemp;
      //this are to decide where to move
      int cd = 1;
      int rd = 1;
      //figures out if its up or down
      if (col < 0) {
        col = col * -1;
        cd = -1;
      }
      //figures out if its to the left of right
      if (row < 0) {
        row = row * -1;
        rd = -1;
      }
      //moves until its in the right column
      if (col > row) {
        while (fc - colTemp != 0) {
          this.grid[rowTemp][colTemp + cd].setPath(true);
          colTemp = colTemp + cd;
        }
      }

      else {
        //moves until its in the right row
        while (fr - rowTemp != 0) {
          this.grid[rowTemp + rd][colTemp].setPath(true);
          rowTemp += rd;
        }
      }
      //ends loop
      if (this.grid[rowTemp][colTemp] == this.grid[fr][fc]) {
        done = true;
      }
    }

  }

  private void buildPath() {
    // picks what direction to move
    Random selector = new Random();
    // int for path number
    // int for amount walked
    int walked = 0;
    // holds the postion as you map through the grid
    int rowTemp = selector.nextInt(gSize);
    int colTemp = selector.nextInt(gSize);
    // this while loop builds the path
    while (walked!=gSize) {
      walked++;
      int direction = 0;
      // randomly chooses up or down
      if (selector.nextInt(2) % 2 == 0) {
        direction = -1;
        // else it move forward or up
      } else {
        direction = 1;
      }
      // moves up or down

      if (selector.nextInt(2) % 2 == 0) {
        // checks to confirm the cell you are grabbing isnt null
        //first checks if in the top row
        if (rowTemp == 0) {
          direction = 1;
        }
        //then checks if in the bottom row
        if (rowTemp == gSize - 1) {
          direction = -1;
        }
        //checks if the path has already been stepped on
        if (this.grid[rowTemp + direction][colTemp].getCount() < 1) {
          //says the path has been walked on and moves it
          this.grid[rowTemp + direction][colTemp].countUp();
          this.grid[rowTemp + direction][colTemp].setPath(true);
          rowTemp = rowTemp + direction;
        }
        //if its not moving row its moving columns
      } else {
        //checks if its in left column
        if (colTemp == 0) {
          direction = 1;
        }
        //checks if its in right column
        if (colTemp == gSize - 1) {
          direction = -1;
        }
        //makes sure the path hasnt already been walked on
        if (this.grid[rowTemp][colTemp + direction].getCount() < 1) {
          //moves up count and moves path
          this.grid[rowTemp ][colTemp+ direction].countUp();
          this.grid[rowTemp][colTemp + direction].setPath(true);
          colTemp = colTemp + direction;
        }

      }
    }
    //runs greedy path to connect
    this.greedyPath(sRow, sRow, rowTemp, colTemp);
  }

  //gets the cell at a given spot int he grid
  public MazeCell getCell(int row, int col) {
    return grid[row][col];
  }

  //looks to see if you won
  public boolean foundEnd(int row, int col) {
    if (grid[row][col].isFinish()) {
      return true;
    }
    return false;
  }

  //used to look around the selected cell if its been explored yet or not
  //cant move to if it the cell hasnt been explored
  public boolean lookAround(int r, int c) {
    //looks at the cell put in
    if (grid[r][c].isExplored())
      return true;
    //checks to ensure you are not in the top row
    if (r != 0) {
      if (grid[r - 1][c].isExplored()) {
        //sets the cell to explored and returns it is
        grid[r][c].setExplored(true);
        return true;
      }
    }
    //checks to make sure you are not in the bottom row
    if (r != gSize - 1) {
      if (grid[r + 1][c].isExplored()) {
        //sets the cell to explored and returns it is
        grid[r][c].setExplored(true);
        return true;
      }
    }

    //checks to make sure you are not in the right column
    if (c != gSize - 1) {
      if (grid[r][c + 1].isExplored()) {
      //sets the cell to explored and returns it is
        grid[r][c].setExplored(true);
        return true;
      }
    }

    //checks to make sure you are not in the left column
    if (c != 0) {
      if (grid[r][c - 1].isExplored()) {
        //sets the cell to explored and returns it is
        grid[r][c].setExplored(true);
        return true;
      }
    }

    //returns false if its not near a cell thats been explored
    return false;
  }
  
 
  
}
