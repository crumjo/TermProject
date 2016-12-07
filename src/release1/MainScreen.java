package release1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import javax.swing.JPanel;



/*****************************************************************
 * @author Patton Finley, Josh Crum, Paul Magee
 * 
 * 
 *         A Home Screen for mind games.
 *     **********************************************************/

public class MainScreen extends JFrame {

  private static final long serialVersionUID = 1L;
  /** 
   * JFrame frame used for the gui.
   */
  private JFrame frame;
  /**
   * JButton made to select Simon says.
   */
  private JButton simonbutton;
  /**
   * JButton made to select guess who.
   */
  private JButton guessbutton;
  /**
   * JButton made to select maze.
   */
  private JButton mazebutton;
  /**
   * JButton made to select speed typing.
   */
  private JButton typebutton;
  /**
   * Magic Number.
   */
  public static final int EIGHT = 8;
  /**
   * Magic Number.
   */
  public static final int THIRTY = 30;
  /**
   * Magic Number.
   */
  public static final int TWENTY = 20;


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
    frame.setSize(width + EIGHT, height + THIRTY);
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
    this.simonbutton.setSize(TWENTY, TWENTY);
    this.guessbutton.setSize(TWENTY, TWENTY);
    this.mazebutton.setSize(TWENTY, TWENTY);
    this.typebutton.setSize(TWENTY, TWENTY);

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

    /**
     * @param response
     *          Takes the users mouse click to select game.
     */
    public void actionPerformed(final ActionEvent response) {
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
        MazePanel panel = new MazePanel();
        frame.dispose();
      }
      // checks speedtyping button
      if (response.getSource() == typebutton) {
        new SpeedTyping();
        frame.dispose();
      }
    }
  }

}