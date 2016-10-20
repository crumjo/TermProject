package release1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class mainScreen extends JPanel {

  public static mainScreen mainScreen;
  Renderer renderer = new Renderer();
  private JFrame frame;
  private JButton SimonButton;
  private JButton GuessButton;
  private JButton MazeButton;
  private JButton TypeButton;

  public mainScreen() {

    //sets up listener
    ButtonListener listener = new ButtonListener();
    //sets up button names
    SimonButton = new JButton("Simon Says");
    GuessButton = new JButton("Guess Who");
    MazeButton = new JButton("Maze");
    TypeButton = new JButton("Speed Typing");

    final int WIDTH = 800;
    final int HEIGHT = 800;

    frame = new JFrame("Mind Games");
    frame.setSize(WIDTH + 8, HEIGHT + 30);

    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // adds listener to button
    SimonButton.addActionListener(listener);
    GuessButton.addActionListener(listener);
    MazeButton.addActionListener(listener);
    TypeButton.addActionListener(listener);

    //sets button size
    this.SimonButton.setSize(20,20);
    this.GuessButton.setSize(20,20);
    this.MazeButton.setSize(20, 20);
    this.TypeButton.setSize(20,20);


    frame.setLayout(new GridLayout(2, 1));
    frame.add(SimonButton);
    frame.add(GuessButton);
    frame.add(MazeButton);
    frame.add(TypeButton);

    frame.setVisible(true);

  }

  private class ButtonListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == SimonButton) {
        Simon.simon = new Simon();
        frame.dispose();
      }
      if (e.getSource() == GuessButton) {
        GuessWho.guesswho = new GuessWho();
        frame.dispose();
      }
      if (e.getSource() == MazeButton) {
        JOptionPane.showMessageDialog(frame,
            "Maze is coming soon!");
      }
      if (e.getSource() == TypeButton) {
        JOptionPane.showMessageDialog(frame,
            "Speed typing is coming soon!");
      }
    }
  }

}