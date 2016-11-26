package release1;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/*****************************************************************
 * @author Patton Finley, Josh Crum, Pual Magee
 * 
 * 
 *         Just a renderer that is used for simon says.
 *     ************************************************************/
@SuppressWarnings("serial")
public class Renderer extends JPanel {

  @Override
  protected final void paintComponent(final Graphics g1) {
    super.paintComponent(g1);

    if (Simon.simon != null) {
      Simon.simon.paint((Graphics2D) g1);
    }
  }

}