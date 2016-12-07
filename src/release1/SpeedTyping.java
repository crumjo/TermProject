package release1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SpeedTyping {

	private ArrayList<String> adjectives;
	private ArrayList<String> adverbs;
	private ArrayList<String> nouns;
	private ArrayList<String> other;
	private ArrayList<String> sentence;
	private ArrayList<String> verbs;

	private JFrame frame;
	private JPanel textPanel;
	private JPanel typePanel;
	private JPanel enterPanel;
	private JTextArea textField;
	private JTextArea timeField;
	private JTextField typeField;
	private JButton resetButton;
	private JButton enterButton;

	private String sentenceToType;

	private long startTime;
	private long elapsedTime;



	public SpeedTyping() {

		this.adjectives = new ArrayList<String>();
		this.adverbs = new ArrayList<String>();
		this.nouns = new ArrayList<String>();
		this.other = new ArrayList<String>();
		this.sentence = new ArrayList<String>();
		this.verbs = new ArrayList<String>();

		this.build();
	}


	public void build() {

		try {
			this.buildArrayList("adjective", "Adjectives.txt");
			this.buildArrayList("adverb", "Adverbs.txt");
			this.buildArrayList("noun", "Nouns.txt");
			this.buildArrayList("verb", "Verbs.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.sentenceToType = buildSentence();

		KeyListener kListener = null;
		ButtonListener listener = new ButtonListener();

		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		this.frame = new JFrame("Speed Typing");
		this.frame.setLayout(new BorderLayout());

		this.textPanel = new JPanel();
		this.textPanel.setLayout(new BorderLayout());
		this.textPanel.setBorder(padding);

		this.typePanel = new JPanel();
		this.typePanel.setLayout(new BorderLayout());
		this.typePanel.setBorder(padding);

		this.enterPanel = new JPanel();
		this.enterPanel.setLayout(new BorderLayout());
		this.enterPanel.setBorder(padding);

		this.typeField = new JTextField(40);
		this.typeField.setHorizontalAlignment(JTextField.LEFT);
		this.typeField.addKeyListener(kListener);
		DocsListener dl = new DocsListener();
		this.typeField.getDocument().addDocumentListener(dl);

		this.textField = new JTextArea(this.sentenceToType, 1, 50);
		this.textField.setMargin(new Insets(10, 10, 10, 10));
		this.textField.setEditable(false);
		this.textField.setBackground(Color.YELLOW);

		this.timeField = new JTextArea("Time: ", 1, 11);
		this.timeField.setEditable(false);

		this.resetButton = new JButton("Reset");
		this.resetButton.addActionListener(listener);

		this.enterButton = new JButton("Enter");
		this.enterButton.addActionListener(listener);

		this.textPanel.add(this.textField, BorderLayout.CENTER);

		this.enterPanel.add(this.enterButton, BorderLayout.CENTER);

		this.typePanel.add(this.typeField, BorderLayout.WEST);
		this.typePanel.add(this.timeField, BorderLayout.CENTER);
		this.typePanel.add(this.resetButton, BorderLayout.EAST);

		this.frame.add(this.textPanel, BorderLayout.NORTH);
		this.frame.add(this.typePanel, BorderLayout.CENTER);
		this.frame.add(this.enterPanel, BorderLayout.SOUTH);

		frame.getRootPane().setDefaultButton(this.enterButton);

		frame.pack();
		frame.setVisible(true);
	}


	public void reset() {
		this.frame.dispose();
		new SpeedTyping();
	}


	public void buildArrayList(String listType, String fileName) 
			throws IOException {

		BufferedReader reader = 
				new BufferedReader(new FileReader(fileName));

		String line;

		while ((line = reader.readLine()) != null) {
			buildList(listType, line);
		}

		reader.close();
	}


	private void buildList(String listType, String word) {

		if (listType == "adjective") {
			adjectives.add(word);
		}

		if (listType == "adverb") {
			adverbs.add(word);
		}

		if (listType == "noun") {
			nouns.add(word);
		}

		if (listType == "other") {
			other.add(word);
		}

		if (listType == "verb") {
			verbs.add(word);
		}
	}


	private String buildSentence() {

		String temp = "";
		String adjective = this.pullWord(adjectives);
		String adverb = this.pullWord(this.adverbs);
		String noun1 = this.pullWord(this.nouns);
		String noun2 = this.pullWord(this.nouns);
		String noun3 = this.pullWord(this.nouns);
		String other = this.pullWord(this.other);
		String verb = this.pullWord(this.verbs);

		//Make this more intricate at some point.
		temp = "The " + adverb + " " + adjective + " " + noun1 + " " + 
				verb + " to the " + noun2 + " to get a " + noun3 + ".";

		return temp;
	}


	public double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}


	private void buildFrame() {
		frame = new JFrame("Speed Typing");
		final JTextField typingPrompt = new JTextField(sentence.size());
	}


	private Boolean checkLists(ArrayList<String> list) {
		if (list.size() > 0) {
			return true;
		} 
		return false;
	}


	public String pullWord(ArrayList<String> list) {
		Random random = new Random();
		String temp = "";

		if (this.checkLists(list) == true) {
			int length = list.size();
			int rand = random.nextInt(length);
			temp = list.get(rand);
		}

		return temp;
	}


	String checkAccuracy(String passed, String target) {
		double accuracy = 0;
		double numChars = target.length();
		double count = 0;
		String temp = "";

		for (int i = 0; i < target.length(); i++) {
			if (i < passed.length()) {
				if (target.charAt(i) == (passed.charAt(i))) {
					count++;
				}
			}
		}

		accuracy = (count / numChars) * 100; 
		accuracy = this.round(accuracy, 2);

		temp += accuracy + "%";

		return temp;
	}


	private class DocsListener implements DocumentListener{
		public void changedUpdate(DocumentEvent e) {

		}
		public void removeUpdate(DocumentEvent e) {

		}
		public void insertUpdate(DocumentEvent e) {
			warn(e);
		}

		public void warn(DocumentEvent e ) {
			if (e.getDocument().getLength() == 1){
				startTime = System.currentTimeMillis();
			}
		}
	}


	private class ButtonListener implements ActionListener {

		public void actionPerformed(final ActionEvent event) {

			if (event.getSource() == enterButton) {

				elapsedTime = System.currentTimeMillis();
				long totalTime = (elapsedTime - startTime) / 1000;

				String entered = typeField.getText();
				String s = checkAccuracy(entered, sentenceToType);

				if (totalTime == 1) {
					timeField.setText("Time: " + totalTime + 
							" Second.");
				} else {
					timeField.setText("Time: " + totalTime + 
							" Seconds.");

				}

				if (totalTime <= 10) {
					timeField.setBackground(Color.green);
				} else if (totalTime <= 15) {
					timeField.setBackground(Color.yellow);
				} else {
					timeField.setBackground(Color.red);
				}

				int gameOver = JOptionPane.showConfirmDialog(null, 
						s + "\nWould You Like To Play Again?", 
						"Game Over.", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE);

				enterButton.setEnabled(false);
				
				if (gameOver == JOptionPane.NO_OPTION) {
					frame.dispose();
					new MainScreen();
				}

			}

			if (event.getSource() == resetButton) {
				reset();
				//codeninja 2013 was here
			}

		}

	}


}
