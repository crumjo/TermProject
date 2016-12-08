package release1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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

/**
 * 
 * @author Patton Finley, Josh Crum, Paul Magee
 *
 */
public class SpeedTyping {

	/**
	 * Adjectives arraylist.
	 */
	private ArrayList<String> adjectives;
	/**
	 * Adverbs arraylist.
	 */
	private ArrayList<String> adverbs;
	/**
	 * Nouns arraylist.
	 */
	private ArrayList<String> nouns;
	/**
	 * Verbs arraylist.
	 */
	private ArrayList<String> verbs;

	/**
	 * Frame object.
	 */
	private JFrame frame;
	/**
	 * textPanel object.
	 */
	private JPanel textPanel;
	/**
	 * typePanel object.
	 */
	private JPanel typePanel;
	/**
	 * enterPanel.
	 */
	private JPanel enterPanel;
	/**
	 * textField object.
	 */
	private JTextArea textField;
	/**
	 * timeField object.
	 */
	private JTextArea timeField;
	/**
	 * typeField object.
	 */
	private JTextField typeField;
	/**
	 * resetButton object.
	 */
	private JButton resetButton;
	/**
	 * enterButton object.
	 */
	private JButton enterButton;

	/**
	 * String for sentenceToType.
	 */
	private String sentenceToType;

	/**
	 * Long for the startTime.
	 */
	private long startTime;
	/**
	 * Long for the eslapsedTime.
	 */
	private long elapsedTime;
	/**
	 * Magic Number.
	 */
	public static final int TEN = 10;
	/**
	 * Magic Number.
	 */
	public static final int FOURTY = 40;
	/**
	 * Magic Number.
	 */
	public static final int FIFTY = 50;
	/**
	 * Magic Number.
	 */
	public static final int HUNDRED = 100;
	/**
	 * Magic Number.
	 */
	public static final int THOUSAND = 1000;
	/**
	 * Magic Number.
	 */
	public static final int FIFTEEN = 15;

	/**
	 * SpeedTyping Constructor.
	 */
	public SpeedTyping() {

		this.adjectives = new ArrayList<String>();
		this.adverbs = new ArrayList<String>();
		this.nouns = new ArrayList<String>();
		this.verbs = new ArrayList<String>();

		this.build();
	}

	/**
	 * To get the adjectives.
	 * @return adjectives 
	 */
	public final ArrayList<String> getAdjectives() {
		return adjectives;
	}

	/**
	 * To get the adverbs.
	 * @return adverbs 
	 */
	public final ArrayList<String> getAdverbs() {
		return adverbs;
	}

	/**
	 * To get the nouns.
	 * @return nouns 
	 */
	public final ArrayList<String> getNouns() {
		return nouns;
	}

	/**
	 * To get the verbs.
	 * @return verbs 
	 */
	public final ArrayList<String> getVerbs() {
		return verbs;
	}
	
	/**
	 * Build method.
	 */
	public final void build() {

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

		Border padding = BorderFactory.createEmptyBorder(TEN, TEN, TEN, 
				TEN);

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

		this.typeField = new JTextField(FOURTY);
		this.typeField.setHorizontalAlignment(JTextField.LEFT);
		this.typeField.addKeyListener(kListener);
		DocsListener dl = new DocsListener();
		this.typeField.getDocument().addDocumentListener(dl);

		this.textField = new JTextArea(this.sentenceToType, 1, FIFTY);
		this.textField.setMargin(new Insets(TEN, TEN, TEN, TEN));
		this.textField.setEditable(false);
		this.textField.setBackground(Color.YELLOW);

		this.timeField = new JTextArea("Time: ", 1, TEN + 1);
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

	/**
	 * Reset method.
	 */
	public final void reset() {
		this.frame.dispose();
		new SpeedTyping();
	}

	/**
	 * To build the arraylist.
	 * @param listType 
	 * @param fileName 
	 * @throws IOException 
	 */
	public final void buildArrayList(final String listType,
			final String fileName) 
			throws IOException {

		BufferedReader reader = 
				new BufferedReader(new FileReader(fileName));

		String line;

		while ((line = reader.readLine()) != null) {
			buildList(listType, line);
		}

		reader.close();
	}

	/**
	 * To build the list.
	 * @param listType  
	 * @param word 
	 */
	private void buildList(final String listType, final String word) {

		if (listType.equals("adjective")) {
			adjectives.add(word);
		}

		if (listType.equals("adverb")) {
			adverbs.add(word);
		}

		if (listType.equals("noun")) {
			nouns.add(word);
		}

		if (listType.equals("verb")) {
			verbs.add(word);
		}
	}

	/**
	 * To build the sentence.
	 * @return temp 
	 */
	private String buildSentence() {

		String temp = "";
		String adjective = this.pullWord(adjectives);
		String adverb = this.pullWord(this.adverbs);
		String noun1 = this.pullWord(this.nouns);
		String noun2 = this.pullWord(this.nouns);
		String noun3 = this.pullWord(this.nouns);
		String verb = this.pullWord(this.verbs);

		//Make this more intricate at some point.
		temp = "The " + adverb + " " + adjective + " " + noun1 + " " 
				+ verb + " to the " + noun2 + " to get a " + noun3 + ".";

		return temp;
	}

	/**
	 * To round off the time.
	 * @param value 
	 * @param places 
	 * @return round 
	 */
	public final double round(double value, final int places) {
		if (places < 0) {
			throw new IllegalArgumentException();
		}

		long factor = (long) Math.pow(TEN, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	/**
	 * To build the frame.
	 */
	private void buildFrame() {
		frame = new JFrame("Speed Typing");
	}

	/**
	 * To check the list.
	 * @param list 
	 * @return true or false 
	 */
	public final Boolean checkLists(final ArrayList<String> list) {
		if (list.size() > 0) {
			return true;
		} 
		return false;
	}

	/**
	 * To pull the words.
	 * @param list 
	 * @return temp 
	 */
	public final String pullWord(final ArrayList<String> list) {
		Random random = new Random();
		String temp = "";

		if (this.checkLists(list)) {
			int length = list.size();
			int rand = random.nextInt(length);
			temp = list.get(rand);
		}

		return temp;
	}

	/**
	 * To check the accuracy of the player.
	 * @param passed 
	 * @param target 
	 * @return temp 
	 */
	final String checkAccuracy(final String passed, final String target) {
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

		accuracy = (count / numChars) * HUNDRED; 
		accuracy = this.round(accuracy, 2);

		temp += accuracy + "%";

		return temp;
	}

	/**
	 * To listen to the player.
	 * @author Patton Finley, Josh Crum, Pual Magee
	 *
	 */
	private class DocsListener implements DocumentListener {
		/**
		 * @param e 
		 */
		public void changedUpdate(final DocumentEvent e) {

		}
		/**
		 * @param e 
		 */
		public void removeUpdate(final DocumentEvent e) {

		}
		/**
		 * @param e 
		 */
		public void insertUpdate(final DocumentEvent e) {
			warn(e);
		}
		/**
		 * @param e 
		 */
		public void warn(final DocumentEvent e) {
			if (e.getDocument().getLength() == 1) {
				startTime = System.currentTimeMillis();
			}
		}
	}

	/**
	 * 
	 * @author Patton Finley, Josh Crum, Pual Magee
	 *
	 */
	private class ButtonListener implements ActionListener {
		
		/**
		 * @param event 
		 */
		public void actionPerformed(final ActionEvent event) {

			if (event.getSource() == enterButton) {

				elapsedTime = System.currentTimeMillis();
				long totalTime = (elapsedTime - startTime) / THOUSAND;

				String entered = typeField.getText();
				String s = checkAccuracy(entered, sentenceToType);

				if (entered.equals("")) {
					timeField.setText("Time: NA");
					timeField.setBackground(Color.RED);

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

					if (gameOver == JOptionPane.YES_OPTION) {
						reset();
					}

				} else {

					if (totalTime == 1) {
						timeField.setText("Time: " + totalTime 
								+ " Second.");
					} else {
						timeField.setText("Time: " + totalTime 
								+ " Seconds.");

					}

					if (totalTime <= TEN) {
						timeField.setBackground(Color.green);
					} else if (totalTime <= FIFTEEN) {
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
			}

			if (event.getSource() == resetButton) {
				reset();
			}
		}
	}


}