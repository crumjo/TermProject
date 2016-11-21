package release1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



//this class is real aMAZING, its the gui for maze 
public class MazePanel extends JFrame{

  //this class is for the maze game
  //its amazing, 
  
  //determines the size of the maze grid
  final int size;
  //JFrame to host the maze grid
  private JFrame frame;
  //double array of jbuttons to build a grid
  private JButton[][] grid;
  //MazeCell used to fill in the board
  private MazeCell Cell;
  
  public MazePanel(){
    //sets maze size to 10/10 for now can ask them later
    size = 10;
    //builds frame then fills in grid with either a blank, a wall or a start/finish point
    frame = new JFrame("Maze");
    frame.setSize(808, 830);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.buildGrid();
  }
  
  //builds the grid with nested for loops and adds them to the frame
  private void buildGrid(){
    //listener for when the button is clicked
    ButtonListener listener = new ButtonListener();
    //nested for loop for all the slowness
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        grid[row][col] = new JButton ("");
        grid[row][col].addActionListener(listener);
        this.frame.add(grid[row][col]);
      }
    }
  }
  
  private class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent arg0) {
      // TODO Auto-generated method stub
  
    }
    
    
  }

}
