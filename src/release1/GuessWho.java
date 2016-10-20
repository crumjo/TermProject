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
  private JFrame secondBuild;
  private JLabel names;
  private JButton[][] quest;
  private JButton[][] answers;
  private ArrayList<Charcter> charcters;
  private ArrayList<Question> questions;
  private ArrayList<String> userAnswers;
  private ArrayList<Boolean> filters;
  private Charcter victim;
  private Question hairC;
  private Question hairL;
  private Question eyes;
  private String hairColorQ = "Is the color of their hair ";
  private String eyeColorQ = "Is the color of their eyes ";
  private String hairLengthQ = "Is the length of their hair ";
  private String nameQ = "Would you like to guess?";
  private String currentQuestion;
  private String enteredAnswers = "";



  public GuessWho() {

    //ArrayList for characters to try to guess
    charcters = new ArrayList<Charcter>();
    questions = new ArrayList<Question>();

    //build the characters
    Charcter Patton = new Charcter();
    Charcter Josh = new Charcter("Josh", "Short", "Brown", "Brown");
    Charcter Pual = new Charcter("Pual", "Medium", "Blue", "Blonde");
    Charcter Sally = new Charcter("Sally", "Long", "Brown", "Black");
    Charcter Sue = new Charcter("Sue", "Long", "Green", "Red");

    //adds the characters to the list of characters
    charcters.add(Patton);
    charcters.add(Josh);
    charcters.add(Pual);
    charcters.add(Sally);
    charcters.add(Sue);

    //builds the questions and the answers
    hairC = new Question("Is the color of their hair ",
        "Red Black Blonde Brown");
    questions.add(hairC);

    eyes = new Question("Is the color of their eyes ",
        "Blue Brown Green");
    questions.add(eyes);

    hairL = new Question("Is the length of their hair ",
        "Short Medium Long");
    questions.add(hairL);

    //build the filters
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
    }, 3000);

  }


  private ArrayList<String> getInstance() {
    if (userAnswers == null) {
      userAnswers = new ArrayList<String>();
    }
    return userAnswers;
  }


  private void appendAnswers(String data) {
    this.enteredAnswers += data;
  }


  public void frameDispose() {
    frame.dispose();
  }


  private void buildFirst() {

    //builds the screen to look at the characters for 30 seconds.
    frame = new JFrame("Guess Who");
    final int WIDTH = 800;
    final int HEIGHT = 800;

    frame.setSize(WIDTH + 8, HEIGHT + 30);

    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new GridLayout(1, 5));

    for (int i = 0; i < charcters.size(); i++) {
      names = new JLabel(" ");
      names.setText(charcters.get(i).getName());
      frame.add(names);
    }

    frame.setVisible(true);
  }


  private void buildSecond() {

    this.secondBuild = new JFrame("Guess Who");
    quest = new JButton[1][4];
    ButtonListener listener = new ButtonListener();
    final int WIDTH = 800;
    final int HEIGHT = 800;

    this.secondBuild.setSize(WIDTH + 8, HEIGHT + 30);

    this.secondBuild.setResizable(false);
    this.secondBuild.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.secondBuild.setLayout(new GridLayout(0,1));

    for (int i = 0; i < questions.size(); i++) {
      quest[0][i] = new JButton();
      quest[0][i].setText(questions.get(i).getQuestion());
      quest[0][i].addActionListener(listener);
      this.secondBuild.add(quest[0][i]);
    }

    quest[0][3] = new JButton();
    quest[0][3].setText("Would you like to guess?");
    quest[0][3].addActionListener(listener);
    this.secondBuild.add(quest[0][3]);

    JLabel localAnswers = new JLabel("Answers: " + this.enteredAnswers);

    this.secondBuild.add(localAnswers);
    this.secondBuild.setVisible(true);
  }


  private void buildQuestion(int input) {
    frame = new JFrame(questions.get(input).getQuestion());
    ArrayList<String> temp = questions.get(input).getAnswers();
    answers = new JButton[1][4];
    ButtonListener listener = new ButtonListener();
    final int WIDTH = 800;
    final int HEIGHT = 800;

    frame.setSize(WIDTH + 8, HEIGHT + 30);

    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new GridLayout(0,1));

    for (int i = 0; i < temp.size(); i++) {
      answers[0][i] = new JButton();
      answers[0][i].setText(temp.get(i));
      answers[0][i].addActionListener(listener);
      frame.add(answers[0][i]);
    }

    frame.setVisible(true);
  }


  private void buildGuess() {
    frame = new JFrame("Guess what charcter you think it is!");
    answers = new JButton[1][charcters.size()];
    ButtonListener listener = new ButtonListener();
    final int WIDTH = 800;
    final int HEIGHT = 800;

    frame.setSize(WIDTH + 8, HEIGHT + 30);

    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new GridLayout(0,1));

    for (int i = 0; i < charcters.size(); i++) {
      answers[0][i] = new JButton();
      answers[0][i].setText(charcters.get(i).getName());
      answers[0][i].addActionListener(listener);
      frame.add(answers[0][i]);
    }

    JLabel localAnswers = new JLabel("Answers: " + "\n" 
        + this.enteredAnswers);
    frame.add(localAnswers);

    frame.setVisible(true);
  }


  private void selectVictim() {
    Random selector = new Random();
    int temp = selector.nextInt(charcters.size());
    this.victim = this.charcters.get(temp);
    System.out.println(this.victim.getName());
  }


  private void tryAgainMessage() {
    JOptionPane.showMessageDialog(null, "Try a different answer.");
  }


  private void winner() {
    int gameover = JOptionPane.showConfirmDialog(null, "YOU WIN! " 
        + "Want to Play Again?", "Game Over", JOptionPane.YES_NO_OPTION, 
        JOptionPane.QUESTION_MESSAGE);
    if (gameover == JOptionPane.YES_OPTION) {
      this.frameDispose();
      GuessWho temp = new GuessWho();
    } else {
      this.frameDispose();
      this.secondBuild.dispose();
      mainScreen.mainScreen = new mainScreen();
    }
  }


  private void loser() {
    int gameover = JOptionPane.showConfirmDialog(null, "YOU LOSE! "
        + "Want to Play Again?", "Game Over", JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE);
    if (gameover == JOptionPane.YES_OPTION) {
      this.frameDispose();
      GuessWho temp = new GuessWho();
    } else {
      this.frameDispose();
      this.secondBuild.dispose();
      mainScreen.mainScreen = new mainScreen();
    }
  }


  private class ButtonListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      for (int i = 0; i < 3; i++) {
        if (e.getSource() == quest[0][i]) {
          if (filters.get(i) == true) {
            guesswho.secondBuild.dispose();
            guesswho.buildQuestion(i);
            currentQuestion = quest[0][i].getText();
          } else {
            JOptionPane.showMessageDialog(null, "You have already "
                + "guessed this!");
          }
        }
      }

      if (e.getSource() == quest[0][3]) {
        guesswho.secondBuild.dispose();
        guesswho.buildGuess();
        currentQuestion = quest[0][3].getText();
      }

      int x = (currentQuestion == nameQ) ? 5 : 4; 

      for (int i = 0; i < x; i++) {
        if (e.getSource() == answers[0][i]) {
          if (currentQuestion == hairColorQ) {
            if (answers[0][i].getText().replace(" ", "").equals(victim
                .getHairColor())) {
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

          if (currentQuestion == eyeColorQ) {
            if (answers[0][i].getText().replace(" ", "").equals(victim
                .getEyes())) {
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

          if (currentQuestion == hairLengthQ) {
            if (answers[0][i].getText().replace(" ", "")
                .equals(victim.getHair())) {
              if (!guesswho.getInstance().contains(victim.getHair())) {
                guesswho.getInstance().add(victim.getHair());
                guesswho.appendAnswers("Hair Length: " + victim
                    .getHair() + ". ");
                filters.set(2, false);
                JOptionPane.showMessageDialog(null, "Correct!");
              }
            }
          }
          if (currentQuestion == nameQ) {
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