package release1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class mainScreen extends JPanel{

	public static mainScreen mainScreen;
	Renderer renderer = new Renderer();
	private JButton Simon = new JButton("Simon");
	
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
	
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == Simon){
				
			}
			}
}
}