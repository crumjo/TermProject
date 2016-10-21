package release1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



/*****************************************************************
 * @author Patton Finley, Josh Crum, Pual Magee
 * 
 * 
 *         A Home Screen for mind games.
 ****************************************************************/

public class MainScreen extends JPanel {

  private static final long serialVersionUID = 1L;
  public static MainScreen mainScreen;
  // JFrame frame used for the gui
  private JFrame frame;
  // JButton made to select simon says
  private JButton simonbutton;
  // JButton made to select guess who
  private JButton guessbutton;
  //JButton made to select maze
  private JButton mazebutton;
  // JButton made to select speed typing
  private JButton typebutton;

  /*****************************************************************
   * A mainScreen constructor used to build the main screen.
   *****************************************************************/
  public MainScreen() {

  

    // sets up button names
    simonbutton = new JButton("Simon Says");
    guessbutton = new JButton("Guess Who");
    mazebutton = new JButton("Maze");
    typebutton = new JButton("Speed Typing");

    // makes ints for the mainscreen size
    final int width = 800;
    final int height = 800;

    // builds main frame outside
    frame = new JFrame("Mind Games");
    frame.setSize(width + 8, height + 30);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // sets up listener
    ButtonListener listener = new ButtonListener();
    
    // adds listener to button
    simonbutton.addActionListener(listener);
    guessbutton.addActionListener(listener);
    mazebutton.addActionListener(listener);
    typebutton.addActionListener(listener);

    // sets button size
    this.simonbutton.setSize(20, 20);
    this.guessbutton.setSize(20, 20);
    this.mazebutton.setSize(20, 20);
    this.typebutton.setSize(20, 20);

    // builds mainframe inside
    frame.setLayout(new GridLayout(2, 1));
    frame.add(simonbutton);
    frame.add(guessbutton);
    frame.add(mazebutton);
    frame.add(typebutton);

    frame.setVisible(true);

  }

  /*****************************************************************
   * A private class for the button listener.
   *****************************************************************/
  private class ButtonListener implements ActionListener {

    public void actionPerformed(ActionEvent response) {
      // checks simon button
      if (response.getSource() == simonbutton) {
        Simon.simon = new Simon();
        frame.dispose();
      }
      // checks guesswho button
      if (response.getSource() == guessbutton) {
        GuessWho.guesswho = new GuessWho();
        frame.dispose();
      }
      // checks maze button
      if (response.getSource() == mazebutton) {
        JOptionPane.showMessageDialog(frame, "Maze is coming soon!");
      }
      // checks speedtyping button
      if (response.getSource() == typebutton) {
        JOptionPane.showMessageDialog(frame, "Speed typing is " 
            + "coming soon!");
      }
    }
  }

}