package release1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

public class GuessWho {

	public static GuessWho guesswho;
	private JFrame frame;
	private JFrame SecondBuild;
	private JLabel names;
	private JButton[][] quest;
	private JButton[][] answers;
	private ArrayList<Charcter> Charcters;
	private ArrayList<Question> Questions;
	private ArrayList<String> UserAnswers;
	private Charcter Victim;
	private Question HairC;
	private Question HairL;
	private Question Eyes;
	private String hairColorQ = "Is the color of their hair ";
	private String eyeColorQ = "Is the color of their eyes ";
	private String hairLengthQ = "Is the length of their hair ";
	private String currentQuestion;
	private String Answers = "";

	public GuessWho() {

		//arraylist for charcters to try to guess
		Charcters = new ArrayList<Charcter>();
		Questions = new ArrayList<Question>();

		//build the characters
		Charcter Patton = new Charcter();
		Charcter Josh = new Charcter("Josh", "Short", "Brown", "Brown");
		Charcter Pual = new Charcter("Pual", "Medium", "Blue", "Blonde");
		Charcter Sally = new Charcter("Sally", "Long", "Brown", "Black");
		Charcter Sue = new Charcter("Sue", "Long", "Green", "Red");

		//adds the charcters to the list of charcters
		Charcters.add(Patton);
		Charcters.add(Josh);
		Charcters.add(Pual);
		Charcters.add(Sally);
		Charcters.add(Sue);

		//builds the questions and the answers
		HairC = new Question("Is the color of their hair ",
				"Red Black Blonde Brown");
		Questions.add(HairC);

		Eyes = new Question("Is the color of their eyes ",
				"Blue Brown Green");
		Questions.add(Eyes);

		HairL = new Question("Is the length of their hair ",
				"Short Medium Long");
		Questions.add(HairL);	

		//add random selector to pick who you must guess
		Random selector = new Random();
		int temp = selector.nextInt(Charcters.size());
		this.Victim = this.Charcters.get(temp);
		System.out.println(this.Victim.getName());
		
		this.BuildFirst();
		Timer screenTimer = new Timer();
		screenTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				frame.dispose();
				guesswho.BuildSecond();
			}
		}, 30000);
		
	}

	private ArrayList<String> getInstance() {
		if (UserAnswers == null) {
			UserAnswers = new ArrayList<String>();
		}
		return UserAnswers;
	}

	private void appendAnswers(String data) {
		this.Answers += data;
	}

	public void frameDispose(){
		frame.dispose();
	}

	private void BuildFirst() {
		//builds the screen to look at the charcters for 30 secs
		frame = new JFrame("Guess Who");
		final int WIDTH = 800;
		final int HEIGHT = 800;

		frame.setSize(WIDTH + 8, HEIGHT + 30);

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new GridLayout(1, 5));

		for(int i = 0; i < Charcters.size(); i++){
			names = new JLabel(" ");
			names.setText(Charcters.get(i).getName());
			frame.add(names);
		}

		frame.setVisible(true);
	}

	private void BuildSecond(){

		this.SecondBuild = new JFrame("Guess Who");
		quest = new JButton[1][4];
		ButtonListener listener = new ButtonListener();
		final int WIDTH = 800;
		final int HEIGHT = 800;

		this.SecondBuild.setSize(WIDTH + 8, HEIGHT + 30);

		this.SecondBuild.setResizable(false);
		this.SecondBuild.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.SecondBuild.setLayout(new GridLayout(0,1));

		for(int i = 0; i < Questions.size(); i++){
			quest[0][i] = new JButton();
			System.out.println(Questions.get(i).getQuestion() +" " + i);
			quest[0][i].setText(Questions.get(i).getQuestion());
			quest[0][i].addActionListener(listener);
			this.SecondBuild.add(quest[0][i]);
		}
		
		quest[0][3] = new JButton();
		quest[0][3].setText("Would you like to guess?");
		quest[0][3].addActionListener(listener);
		this.SecondBuild.add(quest[0][3]);

		JLabel Answers = new JLabel("Answers :" + this.Answers);
		this.SecondBuild.add(Answers);

		this.SecondBuild.setVisible(true);
	}

	private void BuildQuestion(int input){
		frame = new JFrame(Questions.get(input).getQuestion());
		ArrayList<String> temp = Questions.get(input).getAnswers();
		answers = new JButton[1][4];
		ButtonListener listener = new ButtonListener();
		final int WIDTH = 800;
		final int HEIGHT = 800;

		frame.setSize(WIDTH + 8, HEIGHT + 30);

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new GridLayout(0,1));

		for(int i = 0; i < temp.size(); i++){
			answers[0][i] = new JButton();
			answers[0][i].setText(temp.get(i));
			answers[0][i].addActionListener(listener);
			frame.add(answers[0][i]);
		}

		JLabel Answers = new JLabel("Answers : " + this.Answers);
		frame.add(Answers);

		frame.setVisible(true);
	}

	private void BuildGuess(){
		frame = new JFrame("Guess what charcter you think it is!");
		answers = new JButton[1][Charcters.size()];
		ButtonListener listener = new ButtonListener();
		final int WIDTH = 800;
		final int HEIGHT = 800;

		frame.setSize(WIDTH + 8, HEIGHT + 30);

		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new GridLayout(0,1));

		for(int i = 0; i < Charcters.size(); i++){
			answers[0][i] = new JButton();
			answers[0][i].setText(Charcters.get(i).getName());
			answers[0][i].addActionListener(listener);
			frame.add(answers[0][i]);
		}

		JLabel Answers = new JLabel("Answers : " + this.Answers);
		frame.add(Answers);

		frame.setVisible(true);
	}

	private void tryAgainMessage() {
		JOptionPane.showMessageDialog(null, "Try Another Answer.");
	}

	private String printList() {
		String temp = String.join(" , ", this.Answers);
		return temp;
	}
	
	private void TimerListener(ActionEvent e) {
		this.frameDispose();
		this.BuildSecond();
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < 3; i++){
				if(e.getSource() == quest[0][i]) {
					guesswho.SecondBuild.dispose();
					guesswho.BuildQuestion(i);
					currentQuestion = quest[0][i].getText();
				}
			}

			if(e.getSource() == quest[0][3]){
				guesswho.SecondBuild.dispose();
				guesswho.BuildGuess();
				currentQuestion = quest[0][3].getText();
			}

			for (int i = 0; i < 4; i++) {
				if(e.getSource() == answers[0][i]) {

					//take there answer compare to victims info 
					//if true add to cue if false tell them
					if (currentQuestion == hairColorQ) {
						if (answers[0][i].getText().replace(" ", "").equals(Victim.getHairColor())) {
							//System.out.println("Worked 1");
							if (!guesswho.getInstance().contains(Victim.getHairColor())) {
								guesswho.getInstance().add(Victim.getHairColor());
								guesswho.appendAnswers("Hair Color: " + Victim.getHairColor() + ". ");
							}
						} else {
							guesswho.tryAgainMessage();
						}
					}

					if (currentQuestion == eyeColorQ) {
						if (answers[0][i].getText().replace(" ", "").equals(Victim.getEyes())) {
							//System.out.println("Worked 2");
							if (!guesswho.getInstance().contains(Victim.getEyes())) {
								guesswho.getInstance().add(Victim.getEyes());
								guesswho.appendAnswers("Eye Color: " + Victim.getEyes() + ". ");
							}
						} else {
							guesswho.tryAgainMessage();
						}
					}

					if (currentQuestion == hairLengthQ) {
						if (answers[0][i].getText().replace(" ", "").equals(Victim.getHair())) {
							//System.out.println("Worked 3");
							if (!guesswho.getInstance().contains(Victim.getHair())) {
								guesswho.getInstance().add(Victim.getHair());
								guesswho.appendAnswers("Hair Length: " + Victim.getHair() + ". ");
							}
						}
						if (currentQuestion.replace(" ", "").equals("Guess what charcter you think it is!")) {
							if(answers[0][i].getText().equals(guesswho.Victim.getName())){
								System.out.println("you win");
							}else{
								guesswho.tryAgainMessage();
							}
						}
					}
					guesswho.frameDispose();
					guesswho.BuildSecond();
				}
			}
		}
	}
}


