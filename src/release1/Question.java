package release1;

import java.util.ArrayList;

/*****************************************************************
 * @author Patton Finley, Josh Crum, Pual Magee
 * 
 * 
 *         A Question class for guess who.
 *****************************************************************/
public class Question {

  // a string that holds the question
  private String question;
  //an arraylist of strings that holds the answers
  private ArrayList<String> answers;

  /*****************************************************************
   * A default constructer.
   *****************************************************************/
  public Question() {
    question = "Do you like cheese?";
    answers = new ArrayList<String>();
    answers.add("yes");
    answers.add("no");
  }

  /*****************************************************************
   * A constructor method that creates a question with.
   * Specific answers
   * 
   * @param aquestion is the question being asked
   * @param ans a string being split into an arraylist for answers
   *****************************************************************/
  public Question(String aquestion, String ans) {
    this.question = aquestion;
    answers = new ArrayList<String>();
    // int for private marker
    int splitter = 0;
    // splits the answers into an arraylist
    for (int i = 0; i < ans.length(); i++) {
      if (ans.charAt(i) == (' ')) {
        // System.out.println(str.substring(j,i));
        String temp = ans.substring(splitter, i);
        answers.add(temp);
        splitter = i;
      }
    }
    answers.add(ans.substring(splitter));
  }

  /*****************************************************************
   * A getter method that returns the question.
   *****************************************************************/
  public String getQuestion() {
    return question;
  }

  /*****************************************************************
   * A getter method that returns an arraylist holding the answers.
   *****************************************************************/
  public ArrayList<String> getAnswers() {
    return answers;
  }
 
}
