package release1;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GuessWho {

	public static GuessWho guesswho;
	private JFrame frame;
	private JLabel names;
	private JComboBox quest;
	private ArrayList<Charcter> Charcters;
	private ArrayList<Question> Questions;
	private Charcter Victim;


	public GuessWho(){
	
	//arraylist for charcters to try to guess
	Charcters = new ArrayList<Charcter>();
	Questions = new ArrayList<Question>();
	
	//build the charcters
	Charcter Patton = new Charcter();
	Charcter Josh = new Charcter("Josh", "Short", "Brown", "Brown");
	Charcter Pual = new Charcter("Pual", "Mid", "Blue", "Blonde");
	Charcter Sally = new Charcter("Sally", "Long", "Brown", "Black");
	Charcter Sue = new Charcter("Sue", "Long", "Green", "Red");
	
	//adds the charcters to the list of charcters
	Charcters.add(Patton);
	Charcters.add(Josh);
	Charcters.add(Pual);
	Charcters.add(Sally);
	Charcters.add(Sue);
	
	//builds the questions and the answers
	Question HairC = new Question("Is the color of their hair ",
			"Red Black Blonde Brown");
	Question Eyes = new Question("Is the color of their eyes ",
			"Blue Brown Green");
	Question HairL = new Question("Is the color of their eyes ",
			"Blue Brown Green");
	
	//adds the questions to the array of questions
	Questions.add(HairC);
	Questions.add(Eyes);
	Questions.add(HairL);
	
	//add random selector to pick who you must guess
	Random selector = new Random();
	int temp = selector.nextInt() % Charcters.size();
	
	//makes sure the number picked is positive
	if(temp < 0){
		temp = temp * -1;
	}
	
	Victim = Charcters.get(temp);
    
	this.BuildFirst();
	}
	
	
	private void BuildFirst(){
		//builds the screen to look at the charcters for 30 secs
		frame = new JFrame("Guess Who");
		final int WIDTH = 800;
		final int HEIGHT = 800;
		
		frame.setSize(WIDTH + 8, HEIGHT + 30);

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(0, 5));
		
		
		for(int i = 0; i < Charcters.size(); i++){
			names = new JLabel(" ");
			names.setText(Charcters.get(i).getName());
			frame.add(names);
		}
		
		frame.setVisible(true);
	}
	
	private void BuildSecond(){
		frame = new JFrame("Guess Who");
		names = new JLabel(" ");
		final int WIDTH = 800;
		final int HEIGHT = 800;
		
		frame.setSize(WIDTH + 8, HEIGHT + 30);

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(0, 5));
		
		//should i flip to arrays over arraylist??
		//quest = new JComboBox(Questions);
		
		frame.setVisible(true);
	}
}
