package release1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * this class is real aMAZING, its the gui for maze 
 * @author Patton Finley, Josh Crum, Paul Magee
 *
 */
public class MazePanel extends JFrame {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  // this class is for the maze game
  // its amazing,

  /**
   *  determines the size of the maze grid.
   */
  private final int size;
  /**
   *  private MazeEngine to run the game.
   */
  private MazeEngine game;
  /**
   *  JFrame to host the maze grid.
   */
  private JFrame frame;
  /**
   *  panel to hold grid to be added to frame.
   */
  private JPanel panel;
  /**
   *  double array of jbuttons to build a grid.
   */
  private JButton[][] grid;
  /**
   *  MazeCell used to fill in the board.
   */
  private MazeCell cell;
  
  /**
   * Magic number.
   */
  public static final int TWENTYFIVE = 25;
  /**
   * Magic number.
   */
  public static final int EIGHTOEIGHT = 808;
  /**
   * Magic number.
   */
  public static final int EIGHTTHIRTY = 830;
  /**
   * Magic number.
   */
  public static final int FIFTY = 50;
  /**
   * Magic number.
   */
  public static final int SIXTY = 60;
  /**
   * 
   */
  public MazePanel() {
    // sets maze size to 10/10 for now can ask them later
    this.size = TWENTYFIVE;
    // builds frame then fills in grid with either a
    //blank, a wall or a start/finish point
    this.frame = new JFrame("Maze");
    this.frame.setSize(EIGHTOEIGHT, EIGHTTHIRTY);
    this.frame.setResizable(true);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.grid = new JButton[size][size];
    this.panel = new JPanel();
    this.panel.setLayout(new GridLayout(size, size));
    this.buildGrid();
    this.frame.add(panel);
    this.frame.setVisible(true);
    // Initialize MazeEngine
    this.game = new MazeEngine(size);
    this.displayboard();
  }

  /**
   *  builds the grid with nested for loops and adds them to the frame.
   */
  private void buildGrid() {
    // listener for when the button is clicked
    ButtonListener listener = new ButtonListener();
    // sets the prefered size of the button
    Dimension preferredSize = new Dimension(FIFTY, SIXTY);
    // nested for loop for all the slowness
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        this.grid[row][col] = new JButton("");
        this.grid[row][col].addActionListener(listener);
        this.grid[row][col].setPreferredSize(preferredSize);
        this.panel.add(grid[row][col]);
        this.grid[row][col].setBackground(Color.GRAY);
        // here sets them un-enabled
        this.grid[row][col].setEnabled(false);
      }
    }
  }

  /**
   * sets up the board .
   */
  private void displayboard() {
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        cell = game.getCell(row, col);
        if (cell.isPath()) {
          //sets up the path
          this.grid[row][col].setEnabled(true);
          this.grid[row][col].setBackground(Color.WHITE);
        }
        if (cell.isStart()) {
          //sets up the start
          this.grid[row][col].setEnabled(true);
          this.grid[row][col].setBackground(Color.RED);
        }
        if (cell.isFinish()) {
          //sets up the finish
          this.grid[row][col].setEnabled(true);
          this.grid[row][col].setBackground(Color.BLUE);
        }
      }
    }
  }

 
  /**
   * used in the buttonlistener turns off cell.
   * @param row 
   * @param col 
   */
  public final void setunEnabled(final int row, final int col) {
    this.grid[row][col].setEnabled(false);
  }
  
  /**
   * buttonlistener.
   * @author 
   *
   */
  private class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(final ActionEvent e) {
      //nested for loop yet again(dreadful)
      for (int row = 0; row < size; row++) {
        for (int col = 0; col < size; col++) {
          //checks if its selected cell 
          if (e.getSource() == grid[row][col]) {
            //uses look around to find out if it can be clicked on
            if (game.lookAround(row, col)) {
              setunEnabled(row, col);
              //sets the color to red as explored
            grid[row][col].setBackground(Color.RED);
            
            //checks to see if you won yet
            if (game.foundEnd(row, col)) {
                gWon();
        }   
          }
        }
      }

  }

  }
  
    /**
     * this just pops up when you win and restarts it.
     */
  private void gWon() {
    int gameover = JOptionPane.showConfirmDialog(null, 
        "Want to Play Again?", "You won", JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE);
    if (gameover == JOptionPane.YES_OPTION) {
      frame.dispose();
      new MazePanel();
    } else {
      frame.dispose();
      new MainScreen();
    }

  }
  }
  }
