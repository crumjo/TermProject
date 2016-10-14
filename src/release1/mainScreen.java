package release1;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class mainScreen extends JPanel{

	public mainScreen(){
	Renderer renderer = new Renderer();
	final int WIDTH = 800;
	final int HEIGHT = 800;
	
	JFrame frame = new JFrame("Mind Games");

	frame.setSize(WIDTH + 8, HEIGHT + 30);
	
	frame.setResizable(false);
	frame.add(renderer);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	frame.setVisible(true);
	}
}
