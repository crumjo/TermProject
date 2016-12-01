package release1;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*****************************************************************
 * @author Patton Finley, Josh Crum, Pual Magee
 * 
 * 
 *         A Game of simon says.
 *     ***********************************************************/
public class Simon implements ActionListener, MouseListener {

  /**
   * 
   */
  protected static Simon simon;
  /**
   * Renderer object from the Renderer class.
   */
  private Renderer renderer = new Renderer();
  /**
   * Width integer for frame.
   */
  public static final int WIDTH = 800;
  /**
   * Height integer for frame.
   */
  public static final int HEIGHT = 800;
  /**
   * Variable that holds how many time the colors flash.
   */
  public int flashed = 0;
  /**
   * variable to determine if the color is dark or light up.
   */
  public int dark;
  /**
   * Variable that hold how many times the player got the color
   * correct.
   */
  public int ticks;
  /**
   * Variable to index the array list.
   */
  public int index;
  /**
   * Variable to determine of the array list is created.
   */
  public boolean creatingSequence = true;
  /**
   * Array list to hold all the color sequences.
   */
  public ArrayList<Integer> sequence;
  /**
   * Random generator object.
   */
  public Random random;
  /**
   * Variable to determine if the game is over.
   */
  private boolean gameOver;
  /**
   * The frame object.
   */
  private JFrame frame;

  /*****************************************************************
   * A game of Simon where the player has to remember which colors
   * light up in a wheel and then click them in the correct order.
   *****************************************************************/
  public Simon() {
    frame = new JFrame("Simon Says");
    final Timer timer = new Timer(20, this);

    frame.setSize(WIDTH + 8, HEIGHT + 30);

    frame.addMouseListener(this);
    frame.setResizable(false);
    frame.add(renderer);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    //int start = JOptionPane.showConfirmDialog(null, "Ready?", 
    //"Start", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    frame.setVisible(true);
    start();
    timer.start();


    //if(start == JOptionPane.YES_OPTION) {
    // start();
    //timer.start();
    //}
  }
  /**
   * 
   */
  public final void frameDispose() {
    frame.dispose();
  }

  /*****************************************************************
   * Starts the timer by flashing the different quadrants of the
   * circle.
   *****************************************************************/
  public final void start() {
    random = new Random();
    sequence = new ArrayList<Integer>();
    index = 0;
    dark = 2;
    flashed = 0;
    ticks = 0;
  }

  @Override
  public final void actionPerformed(final ActionEvent e1) {
    ticks++;

    if (ticks % 20 == 0) {
      flashed = 0;

      if (dark >= 0) {
        dark--;
      }
    }

    if (creatingSequence) {
      if (dark <= 0) {
        if (index >= sequence.size()) {
          flashed = random.nextInt(40) % 4 + 1;
          sequence.add(flashed);
          index = 0;
          creatingSequence = false;
        } else {
          flashed = sequence.get(index);
          index++;
        }

        dark = 2;
      }
    } else if (index == sequence.size()) {
      creatingSequence = true;
      index = 0;
      dark = 2;
    }

    renderer.repaint();
  }



  /*****************************************************************
   * Creates the color wheel screen.
   * 
   * @param g1 
   *****************************************************************/
  public final void paint(final Graphics2D g1) {
    g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
        RenderingHints.VALUE_ANTIALIAS_ON);

    if (flashed == 1) {
      g1.setColor(Color.GREEN);
    } else {
      g1.setColor(Color.GREEN.darker());
    }

    g1.fillRect(0, 0, WIDTH / 2, HEIGHT / 2);

    if (flashed == 2) {
      g1.setColor(Color.RED);
    } else {
      g1.setColor(Color.RED.darker());
    }

    g1.fillRect(WIDTH / 2, 0, WIDTH / 2, HEIGHT / 2);

    if (flashed == 3) {
      g1.setColor(Color.ORANGE);
    } else {
      g1.setColor(Color.ORANGE.darker());
    }

    g1.fillRect(0, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);

    if (flashed == 4) {
      g1.setColor(Color.BLUE);
    } else {
      g1.setColor(Color.BLUE.darker());
    }

    g1.fillRect(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);

    g1.setColor(Color.BLACK);
    g1.setColor(Color.GRAY);
    g1.setStroke(new BasicStroke(200));
    g1.drawOval(-100, -100, WIDTH + 200, HEIGHT + 200);

    g1.setColor(Color.BLACK);
    g1.setStroke(new BasicStroke(10));
    g1.drawOval(0, 0, WIDTH, HEIGHT);

    g1.setColor(Color.WHITE);
    g1.setFont(new Font("Arial", 1, 142));

    if (gameOver) {
      g1.drawString("Game Over", WIDTH / 2 - 400, HEIGHT / 2 + 42);
    } else {
      g1.drawString(index + "/" + sequence.size(),
          WIDTH / 2 - 100, HEIGHT / 2 + 42);
    }
  }

  @Override
  public final void mousePressed(final MouseEvent e1) {
    int x1 = e1.getX();
    int y1 = e1.getY();

    if (!creatingSequence && !gameOver) {
      if (x1 > 0 && x1 < WIDTH / 2 && y1 > 0 && y1 < HEIGHT / 2) {
        flashed = 1;
        ticks = 1;
      } else if (x1 > WIDTH / 2 && x1 < WIDTH && y1 > 0 
          && y1 < HEIGHT / 2) {
        flashed = 2;
        ticks = 1;
      } else if (x1 > 0 && x1 < WIDTH / 2 && y1 > HEIGHT / 2 
          && y1 < HEIGHT) {
        flashed = 3;
        ticks = 1;
      } else if (x1 > WIDTH / 2 && x1 < WIDTH && y1 > HEIGHT / 2 
          && y1 < HEIGHT) {
        flashed = 4;
        ticks = 1;
      }

      if (flashed != 0) {
        if (sequence.get(index) == flashed) {
          index++;
        } else {
          gameOver = true;
        }
      }
    } else if (gameOver) {
      int gameover = JOptionPane.showConfirmDialog(null, 
          "Want to Play Again?", "Game Over", JOptionPane.YES_NO_OPTION, 
          JOptionPane.QUESTION_MESSAGE);
      if (gameover == JOptionPane.YES_OPTION) {
        start();
        gameOver = false;
      } else {
        this.frameDispose();
        new MainScreen();
      }

    }
  }

  @Override
  public void mouseClicked(final MouseEvent e1) {
  }

  @Override
  public void mouseReleased(final MouseEvent e1) {
  }

  @Override
  public void mouseEntered(final MouseEvent e1) {
  }

  @Override
  public void mouseExited(final MouseEvent e1) {
  }

}