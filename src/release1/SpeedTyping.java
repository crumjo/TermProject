package release1;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class SpeedTyping {

  private ArrayList<String> adverbs;
  private ArrayList<String> nouns;
  private ArrayList<String> other;
  private ArrayList<String> pronouns;
  private ArrayList<String> sentence;
  private ArrayList<String> verbs;
  private JFrame frame;



  public SpeedTyping() {
    this.adverbs = new ArrayList<String>();
    this.nouns = new ArrayList<String>();
    this.other = new ArrayList<String>();
    this.pronouns = new ArrayList<String>();
    this.sentence = new ArrayList<String>();
    this.verbs = new ArrayList<String>();
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
  
  
  private String buildSentence(ArrayList list) {
    String temp = "";
    //Add words from the instance ArrayLists to the sentence.
    return temp;
  }
  
  
  private void buildFrame() {
    frame = new JFrame("Speed Typing");
    final JTextField typingPrompt = new JTextField(sentence.size());
  }


}
