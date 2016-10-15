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

public class Simon implements ActionListener, MouseListener
{

	public static Simon simon;
	Renderer renderer = new Renderer();
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	public int flashed = 0;
	public int dark, ticks, index;
	public boolean creatingSequence = true;
	public ArrayList<Integer> sequence;
	public Random random;
	private boolean gameOver;
	private JFrame frame;

	public Simon()
	{
		frame = new JFrame("Simon Says");
		Timer timer = new Timer(20, this);

		frame.setSize(WIDTH + 8, HEIGHT + 30);
		
		frame.addMouseListener(this);
		frame.setResizable(false);
		frame.add(renderer);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//int start = JOptionPane.showConfirmDialog(null, "Ready?", "Start", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		frame.setVisible(true);
		start();
		timer.start();
		
		
		//if(start == JOptionPane.YES_OPTION)
	//	{
		//	start();
		//	timer.start();
	//	}
	}

	public void frameDispose(){
		frame.dispose();
	}
	
	public void start()
	{
		random = new Random();
		sequence = new ArrayList<Integer>();
		index = 0;
		dark = 2;
		flashed = 0;
		ticks = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		ticks++;

		if (ticks % 20 == 0)
		{
			flashed = 0;

			if (dark >= 0)
			{
				dark--;
			}
		}

		if (creatingSequence)
		{
			if (dark <= 0)
			{
				if (index >= sequence.size())
				{
					flashed = random.nextInt(40) % 4 + 1;
					sequence.add(flashed);
					index = 0;
					creatingSequence = false;
				}
				else
				{
					flashed = sequence.get(index);
					index++;
				}

				dark = 2;
			}
		}
		else if (index == sequence.size())
		{
			creatingSequence = true;
			index = 0;
			dark = 2;
		}

		renderer.repaint();
	}

	
	
	public void paint(Graphics2D g)
	{
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (flashed == 1)
		{
			g.setColor(Color.GREEN);
		}
		else
		{
			g.setColor(Color.GREEN.darker());
		}

		g.fillRect(0, 0, WIDTH / 2, HEIGHT / 2);

		if (flashed == 2)
		{
			g.setColor(Color.RED);
		}
		else
		{
			g.setColor(Color.RED.darker());
		}

		g.fillRect(WIDTH / 2, 0, WIDTH / 2, HEIGHT / 2);

		if (flashed == 3)
		{
			g.setColor(Color.ORANGE);
		}
		else
		{
			g.setColor(Color.ORANGE.darker());
		}

		g.fillRect(0, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);

		if (flashed == 4)
		{
			g.setColor(Color.BLUE);
		}
		else
		{
			g.setColor(Color.BLUE.darker());
		}

		g.fillRect(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);
		
		g.setColor(Color.BLACK);
		g.setColor(Color.GRAY);
		g.setStroke(new BasicStroke(200));
		g.drawOval(-100, -100, WIDTH + 200, HEIGHT + 200);

		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(10));
		g.drawOval(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", 1, 142));

		if (gameOver)
		{
			g.drawString("Game Over", WIDTH / 2 - 400, HEIGHT / 2 + 42);
		}
		else
		{
			g.drawString(index + "/" + sequence.size(), WIDTH / 2 - 100, HEIGHT / 2 + 42);
		}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		int x = e.getX(), y = e.getY();

		if (!creatingSequence && !gameOver)
		{
			if (x > 0 && x < WIDTH / 2 && y > 0 && y < HEIGHT / 2)
			{
				flashed = 1;
				ticks = 1;
			}
			else if (x > WIDTH / 2 && x < WIDTH && y > 0 && y < HEIGHT / 2)
			{
				flashed = 2;
				ticks = 1;
			}
			else if (x > 0 && x < WIDTH / 2 && y > HEIGHT / 2 && y < HEIGHT)
			{
				flashed = 3;
				ticks = 1;
			}
			else if (x > WIDTH / 2 && x < WIDTH && y > HEIGHT / 2 && y < HEIGHT)
			{
				flashed = 4;
				ticks = 1;
			}

			if (flashed != 0)
			{
				if (sequence.get(index) == flashed)
				{
					index++;
				}
				else
				{
					gameOver = true;
				}
			}
		}
		else if (gameOver)
		{
			int gameover = JOptionPane.showConfirmDialog(null, "Want to Play Again?", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(gameover == JOptionPane.YES_OPTION){
				start();
				gameOver = false;
			}
			else{
				this.frameDispose();
			}
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}

}