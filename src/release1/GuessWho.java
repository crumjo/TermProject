package release1;

import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*****************************************************************
 * @author Patton Finley, Josh Crum, Pual Magee
 * 
 * 
 *         A Game of guess who.
 *     ***********************************************************/
public class GuessWho {

  /**
   * 
   */
  private static GuessWho guesswho;
  /**
   * Frame object.
   */
  private JFrame frame;
  /**
   * the other frame object.
   */
  private JFrame secondBuild;
  /**
   * Label for the names.
   */
  private JLabel names;
  /**
   * Buttons for the questions.
   */
  private JButton[][] quest;
  /**
   * Buttons for the answers.
   */
  private JButton[][] answers;
  /**
   * ArrayList for the characters.
   */
  private ArrayList<Character> characters;
  /**
   * ArrayList for the questions.
   */
  private ArrayList<Question> questions;
  /**
   * ArrayList for the users answers.
   */
  private ArrayList<String> userAnswers;
  /**
   * ArrayList of the filters.
   */
  private ArrayList<Boolean> filters;
  /**
   * Poor character.
   */
  private Character victim;
  /**
   * The hair Color.
   */
  private Question hairC;
  /**
   * The Hair Length.
   */
  private Question hairL;
  /**
   * Their eye color.
   */
  private Question eyes;
  /**
   * String for hair color.
   */
  private String hairColorQ = "Is the color of their hair ";
  /**
   * String for eye color.
   */
  private String eyeColorQ = "Is the color of their eyes ";
  /**
   * string for the hair length.
   */
  private String hairLengthQ = "Is the length of their hair ";
  /**
   * string for the name.
   */
  private String nameQ = "Would you like to guess?";
  /**
   * String for the current question.
   */
  private String currentQuestion;
  /**
   * String for entered answers.
   */
  private String enteredAnswers = "";
  /**
   * Integer for width.
   */
  private final int width;
  /**
   * Integer for height.
   */
  private final int height;
  /**
   * Magic Number.
   */
  public static final int THREE = 3;
  /**
   * Magic Number.
   */
  public static final int EIGHT = 8;
  /**
   * Magic Number.
   */
  public static final int THIRTY = 30;
  /**
   * Magic Number.
   */
  public static final int FOUR = 4;
  /**
   * Magic Number.
   */
  public static final int FIVE = 5;
  /**
   * Magic Number.
   */
  public static final int FOURTY = 40;
  /**
   * Magic Number.
   */
  public static final int THIRTYK = 30000;
  /**
   * Magic Number.
   */
  public static final int EIGHTHUNDRED = 800;

  /*****************************************************************
   * A Method that creates a game of guess who.
   *****************************************************************/
  public GuessWho() {

    // ArrayList for characters to try to guess
    characters = new ArrayList<Character>();
    questions = new ArrayList<Question>();

    // build the characters

    Character patton = new Character();
    Character josh = new Character("Josh", "Short", "Brown", "Brown");
    Character paul = new Character("Pual", "Medium", "Blue", "Blonde");
    Character sally = new Character("Sally", "Long", "Brown", "Black");
    Character sue = new Character("Sue", "Long", "Green", "Red");

    // adds the characters to the list of characters
    characters.add(patton);
    characters.add(josh);
    characters.add(paul);
    characters.add(sally);
    characters.add(sue);

    // create the pictures

    // creates Width and Height

    width = EIGHTHUNDRED;
    height = EIGHTHUNDRED;
    // builds the questions and the answers
    hairC = new Question("Is the color of their hair ", 
        "Red Black Blonde Brown");
    questions.add(hairC);

    eyes = new Question("Is the color of their eyes ", 
        "Blue Brown Green");
    questions.add(eyes);

    hairL = new Question("Is the length of their hair ", 
        "Short Medium Long");
    questions.add(hairL);

    // build the filters
    this.filters = new ArrayList<Boolean>();
    this.filters.add(true);
    this.filters.add(true);
    this.filters.add(true);

    this.selectVictim();

    this.buildFirst();
    Timer screenTimer = new Timer();
    screenTimer.schedule(new TimerTask() {

      @Override
      public void run() {
        frame.dispose();
        guesswho.buildSecond();
      }
    }, THIRTYK);

  }

  /*****************************************************************
   * Creates a new ArrayList if one does not exist or returns an
   * existing one.
   * 
   * @return userAnswers
   *            creates the instance for ArrayList.
   *****************************************************************/
  public final ArrayList<String> getInstance() {
    if (userAnswers == null) {
      userAnswers = new ArrayList<String>();
    }
    return userAnswers;
  }
  /**
   * 
   * @param data
   *          adds the string to the ArrayList.
   */
  public final void appendAnswers(final String data) {
    this.enteredAnswers += data;
  }

  /**
   * 
   */
  public final void frameDispose() {
    frame.dispose();
  }
  
  /**
   * 
   */
  private void buildFirst() {

    // builds the screen to look at the characters for 30 seconds.
    frame = new JFrame("Guess Who");
    final JPanel topPanel = new JPanel();
    final JPanel bottomPanel = new JPanel();

    final int bWidth = 1000;
    final int bHeight = 400;

    frame.setSize(bWidth, bHeight);

    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new GridLayout(2, FIVE));

    topPanel.setLayout(new GridLayout(1, FIVE));
    bottomPanel.setLayout(new GridLayout(1, FIVE));

    topPanel.add(new JLabel(new ImageIcon("PattonPic.png")));
    topPanel.add(new JLabel(new ImageIcon("JoshPic.png")));
    topPanel.add(new JLabel(new ImageIcon("PaulPic.png")));
    topPanel.add(new JLabel(new ImageIcon("SallyPic.png")));
    topPanel.add(new JLabel(new ImageIcon("SuePic.png")));

    for (int i = 0; i < characters.size(); i++) {
      names = new JLabel(" ", JLabel.CENTER);
      names.setVerticalAlignment(JLabel.TOP);
      names.setFont(new Font("Serif", Font.BOLD, FOURTY));
      names.setText(characters.get(i).getName());
      bottomPanel.add(names);
    }
    frame.add(topPanel);
    frame.add(bottomPanel);
    frame.pack();
    frame.setVisible(true);
  }

  /**
   * 
   */
  private void buildSecond() {

    this.secondBuild = new JFrame("Guess Who");
    quest = new JButton[1][FOUR];
    ButtonListener listener = new ButtonListener();

    this.secondBuild.setSize(width + EIGHT, height + THIRTY);

    this.secondBuild.setResizable(false);
    this.secondBuild.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.secondBuild.setLayout(new GridLayout(0, 1));

    for (int i = 0; i < questions.size(); i++) {
      quest[0][i] = new JButton();
      quest[0][i].setText(questions.get(i).getQuestion());
      quest[0][i].addActionListener(listener);
      this.secondBuild.add(quest[0][i]);
    }

    quest[0][THREE] = new JButton();
    quest[0][THREE].setText("Would you like to guess?");
    quest[0][THREE].addActionListener(listener);
    this.secondBuild.add(quest[0][THREE]);

    JLabel localAnswers = new JLabel("Answers: " + this.enteredAnswers);

    this.secondBuild.add(localAnswers);
    this.secondBuild.setVisible(true);
  }
  /**
   * 
   * @param input
   *            takes the users input.
   */   
  private void buildQuestion(final int input) {
    frame = new JFrame(questions.get(input).getQuestion());

    answers = new JButton[1][FOUR];
    ButtonListener listener = new ButtonListener();

    frame.setSize(width + EIGHT, height + THIRTY);

    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new GridLayout(0, 1));
    ArrayList<String> temp = questions.get(input).getAnswers();
    for (int i = 0; i < temp.size(); i++) {
      answers[0][i] = new JButton();
      answers[0][i].setText(temp.get(i));
      answers[0][i].addActionListener(listener);
      frame.add(answers[0][i]);
    }

    frame.setVisible(true);
  }

  /**
   * Method to build the guesses.
   */
  private void buildGuess() {
    frame = new JFrame("Guess what Character you think it is!");
    answers = new JButton[1][characters.size()];
    ButtonListener listener = new ButtonListener();

    frame.setSize(width + EIGHT, height + THIRTY);

    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new GridLayout(0, 1));

    for (int i = 0; i < characters.size(); i++) {
      answers[0][i] = new JButton();
      answers[0][i].setText(characters.get(i).getName());
      answers[0][i].addActionListener(listener);
      frame.add(answers[0][i]);
    }

    JLabel localAnswers = new JLabel("Answers: " + "\n" 
        + this.enteredAnswers);
    frame.add(localAnswers);

    frame.setVisible(true);
  }
  
  /**
   * Method to select the character.
   */
  private void selectVictim() {
    Random selector = new Random();
    int temp = selector.nextInt(characters.size());
    this.victim = this.characters.get(temp);
    System.out.println(this.victim.getName());
  }

  /**
   * method to show the try again popup.
   */
  private void tryAgainMessage() {
    JOptionPane.showMessageDialog(null, "Try a different answer.");
  }

  /**
   * Method for the winner.
   */
  private void winner() {
    int gameover = JOptionPane.showConfirmDialog(null, "YOU WIN! " 
        + "Want to Play Again?",
        "Game Over", JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE);
    if (gameover == JOptionPane.YES_OPTION) {
      this.frameDispose();
      new GuessWho();
    } else {
      this.frameDispose();
      this.secondBuild.dispose();
      new MainScreen();
    }
  }

  /**
   * Method to show the loser..Loser.
   */
  private void loser() {
    int gameover = JOptionPane.showConfirmDialog(null, "YOU LOSE! " 
        + "Want to Play Again?",
        "Game Over", JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE);
    if (gameover == JOptionPane.YES_OPTION) {
      this.frameDispose();
      new GuessWho();
    } else {
      this.frameDispose();
      this.secondBuild.dispose();
      new MainScreen();
    }
  }

  /**
   * 
   * @author Patton Finley, Josh Crum, Pual Magee
   *      Not quite sure why it wanted the author here in javadoc.
   */
  private class ButtonListener implements ActionListener {

    /**
     * @param clicked
     *            checks for the users mouse click.
     */
    public void actionPerformed(final ActionEvent clicked) {
      for (int i = 0; i < THREE; i++) {
        if (clicked.getSource() == quest[0][i]) {
          if (filters.get(i)) {
            guesswho.secondBuild.dispose();
            guesswho.buildQuestion(i);
            currentQuestion = quest[0][i].getText();
          } else {
            JOptionPane.showMessageDialog(null, "You have already " 
                + "guessed this!");
          }
        }
      }

      if (clicked.getSource() == quest[0][THREE]) {
        guesswho.secondBuild.dispose();
        guesswho.buildGuess();
        currentQuestion = quest[0][THREE].getText();
      }

      int length = (currentQuestion == nameQ) ? FIVE : FOUR;

      for (int i = 0; i < length; i++) {
        if (clicked.getSource() == answers[0][i]) {
          if (currentQuestion == hairColorQ) {
            if (answers[0][i].getText().replace(" ", "")
                .equals(victim.getHairColor())) {
              if (!guesswho.getInstance().contains(victim
                  .getHairColor())) {
                guesswho.getInstance().add(victim.getHairColor());
                guesswho.appendAnswers("Hair Color: " + victim
                    .getHairColor() + ". ");
                filters.set(0, false);
                JOptionPane.showMessageDialog(null, "Correct!");
              }
            } else {
              guesswho.tryAgainMessage();
            }
          }

          if (currentQuestion.equals(eyeColorQ)) {
            if (answers[0][i].getText().replace(" ", "")
                .equals(victim.getEyes())) {
              if (!guesswho.getInstance().contains(victim.getEyes())) {
                guesswho.getInstance().add(victim.getEyes());
                guesswho.appendAnswers("Eye Color: " + victim
                    .getEyes() + ". ");
                filters.set(1, false);
                JOptionPane.showMessageDialog(null, "Correct!");
              }
            } else {
              guesswho.tryAgainMessage();
            }
          }

          if (currentQuestion.equals(hairLengthQ)) {
            if (answers[0][i].getText().replace(" ", "").equals(victim
                .getHair())) {
              if (!guesswho.getInstance().contains(victim.getHair())) {
                guesswho.getInstance().add(victim.getHair());
                guesswho.appendAnswers("Hair Length: " + victim
                    .getHair() + ". ");
                filters.set(2, false);
                JOptionPane.showMessageDialog(null, "Correct!");
              }
            }
          }
          if (currentQuestion.equals(nameQ)) {
            if (answers[0][i].getText().equals(guesswho.victim
                .getName())) {
              guesswho.winner();
              return;
            } else {
              guesswho.loser();
              return;
            }
          }

          guesswho.frameDispose();
          guesswho.buildSecond();
        }
      }
    }
  }

}