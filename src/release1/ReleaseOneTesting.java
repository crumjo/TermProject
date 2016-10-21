package release1;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import org.junit.Test;

public class ReleaseOneTesting {

  @Test
  public void testDefaultCharacterNameConstructor() {
    Character test = new Character();
    String testString = "Patton";
    assertEquals(test.getName(), testString);
  }


  @Test
  public void testDefaultCharacterHairLengthConstructor() {
    Character test = new Character();
    String testString = "Short";
    assertEquals(test.getHair(), testString);
  }


  @Test
  public void testDefaultCharacterEyeColorConstructor() {
    Character test = new Character();
    String testString = "Blue";
    assertEquals(test.getEyes(), testString);
  }


  @Test
  public void testCharacterHairColorConstructor() {
    Character test = new Character();
    String testString = "Blonde";
    assertEquals(test.getHairColor(), testString);
  }



  @Test
  public void testGetHair() {
    Character test = new Character("test", "long", "green", "red");
    assertEquals("long", test.getHair());
  }


  @Test
  public void testGetEyes() {
    Character test = new Character("test", "long", "green", "red");
    assertEquals("green", test.getEyes());
  }


  @Test
  public void mainTest() {
    Main test = new Main();
    assertTrue(Main.class.equals(test.getClass()));
  }


  @Test
  public void mainMethodScreenTest() {
    Main test = new Main();
    MainScreen testScreen = new MainScreen();
    assertTrue(MainScreen.class.equals(testScreen.getClass()));
  }


  @Test
  public void testQuestionConstructor() {
    Question test = new Question();
    assertEquals(test.getQuestion(), "Do you like cheese?");
  }


  @Test
  public void testAnswerConstructor() {
    Question test = new Question();
    ArrayList<String> testAl = new ArrayList<String>();
    testAl.add("yes");
    testAl.add("no");
    assertEquals(test.getAnswers(), testAl);
  }


  @Test
  public void testCustomQuestion() {
    Question test = new Question("Some question?", "Answer");
    assertEquals(test.getQuestion(), "Some question?");
  }


  @Test
  public void testCustomQuestionWithSpace() {
    Question test = new Question("Question?", "Here is some space!");
    assertEquals(test.getQuestion(), "Question?");
  }
  
  
  @Test
  public void testSimonConstructor() {
    Simon test = new Simon();
    assertTrue(Simon.class.equals(test.getClass()));
  }
  
  
  @Test
  public void testFrameDispose() {
    Simon test = new Simon();
    test.frameDispose();
    assertTrue(test.getClass().equals(Simon.class));
  }
  
  
  @Test
  public void testFrameDispose2() {
    GuessWho test = new GuessWho();
    test.frameDispose();
    assertTrue(GuessWho.class.equals(test.getClass()));
  }
  
  
  @Test
  public void testGetInstance() {
    GuessWho test = new GuessWho();
    ArrayList<String> testList = new ArrayList<String>();
    assertEquals(test.getInstance(), testList);
  }
  
  
  @Test
  public void testAppendAnswers() {
    GuessWho test = new GuessWho();
    ArrayList<String> testList = new ArrayList<String>();
    test.appendAnswers("hi");
    testList.add("hi");
  }
  
  
}