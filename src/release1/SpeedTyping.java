package release1;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

	private ArrayList<String> adverbs;
	private ArrayList<String> nouns;
	private ArrayList<String> other;
	private ArrayList<String> pronouns;
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
		this.adverbs = new ArrayList<String>();
		this.nouns = new ArrayList<String>();
		this.other = new ArrayList<String>();
		this.pronouns = new ArrayList<String>();
		this.sentence = new ArrayList<String>();
		this.verbs = new ArrayList<String>();
		this.sentenceToType = buildSentence();

		this.build();
	}


	public void build() {
		KeyListener kListener = null;
		ButtonListener listener = new ButtonListener();

		Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);

		this.frame = new JFrame("Speed Typing");
		this.frame.setLayout(new BorderLayout());

		this.textPanel = new JPanel(); //What to type.
		this.textPanel.setLayout(new BorderLayout());
		this.textPanel.setBorder(padding);

		this.typePanel = new JPanel(); //Where to type it.
		this.typePanel.setLayout(new BorderLayout());
		this.typePanel.setBorder(padding);

		this.enterPanel = new JPanel();
		this.enterPanel.setLayout(new BorderLayout());
		this.enterPanel.setBorder(padding);

		this.typeField = new JTextField(40); //Insert size of field as number of characters
		this.typeField.setHorizontalAlignment(JTextField.LEFT);
		this.typeField.addKeyListener(kListener);
		DocsListener dl = new DocsListener();
		this.typeField.getDocument().addDocumentListener(dl);

		this.textField = new JTextArea("" + this.buildSentence(), 1, 50); //~2X height of JTextField
		this.textField.setMargin(new Insets(10, 10, 10, 10));
		this.textField.setEditable(false);

		this.timeField = new JTextArea("Time: ", 1, 11); //Same height as textField
		this.timeField.setEditable(false);

		this.resetButton = new JButton("Reset"); //Add image here for reset
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


	private void buildList(ArrayList list, String word) {
		if (list.equals(adverbs)) {
			adverbs.add(word);
		}

		if (list.equals(nouns)) {
			nouns.add(word);
		}

		if (list.equals(other)) {
			other.add(word);
		}

		if (list.equals(pronouns)) {
			pronouns.add(word);
		}

		if (list.equals(verbs)) {
			verbs.add(word);
		}
	}


	private String buildSentence() {
		String temp = "";
		String adverb = this.pullWord(this.adverbs);
		String noun = this.pullWord(this.nouns);
		String other = this.pullWord(this.other);
		String pronoun = this.pullWord(this.pronouns);
		String verb = this.pullWord(this.verbs);

		//Make this more intricate at some point.
		temp = "The " + adverb + " " + noun + " " + verb + " to the " + 
				noun + " to get a " + noun + ".";

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

				System.out.println(sentenceToType);
				System.out.println(entered);
				System.out.println(totalTime);

				String s = checkAccuracy(entered, sentenceToType);

				if (totalTime == 1) {
					timeField.setText("Time: " + totalTime + 
							" Second.");
				} else {
					timeField.setText("Time: " + totalTime + 
							" Seconds.");

				}
				JOptionPane.showMessageDialog(null, s);

			}

			if (event.getSource() == resetButton) {
				reset();
				//codeninja 2013 was here
			}

		}

	}


}
