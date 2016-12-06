package release1; //release.1

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
/**
 * 
 * @author Patton Finley, Josh Crum, Paul Magee
 *
 */
public class ReleaseOneTesting {

  /**
   * Testing default character name constructor.
   */
  @Test
  public final void testDefaultCharacterNameConstructor() {
    Character test = new Character();
    String testString = "Patton";
    assertEquals(test.getName(), testString);
  }

  /**
   * Testing default character hair length constructor.
   */
  @Test
  public final void testDefaultCharacterHairLengthConstructor() {
    Character test = new Character();
    String testString = "Short";
    assertEquals(test.getHair(), testString);
  }

  /**
   * Testing default character eye color constructor.
   */
  @Test
  public final void testDefaultCharacterEyeColorConstructor() {
    Character test = new Character();
    String testString = "Blue";
    assertEquals(test.getEyes(), testString);
  }

  /**
   * Testing default character hair color constructor.
   */
  @Test
  public final void testCharacterHairColorConstructor() {
    Character test = new Character();
    String testString = "Blonde";
    assertEquals(test.getHairColor(), testString);
  }


  /**
   * Testing getHair method.
   */
  @Test
  public final void testGetHair() {
    Character test = new Character("test", "long", "green", "red");
    assertEquals("long", test.getHair());
  }

  /**
   * Testing getEyes method.
   */
  @Test
  public final void testGetEyes() {
    Character test = new Character("test", "long", "green", "red");
    assertEquals("green", test.getEyes());
  }

  /**
   * Testing the main class.
   */
  @Test
  public final void mainTest() {
    Main test = new Main();
    assertTrue(Main.class.equals(test.getClass()));
  }

  /**
   * Testing the mainScreen class.
   */
  @Test
  public final void mainMethodScreenTest() {
    Main test = new Main();
    MainScreen testScreen = new MainScreen();
    assertTrue(MainScreen.class.equals(testScreen.getClass()));
  }

  /**
   * Testing the questions constructor.
   */
  @Test
  public final void testQuestionConstructor() {
    Question test = new Question();
    assertEquals(test.getQuestion(), "Do you like cheese?");
  }

  /**
   * Testing the answer constructor.
   */
  @Test
  public final void testAnswerConstructor() {
    Question test = new Question();
    ArrayList<String> testAl = new ArrayList<String>();
    testAl.add("yes");
    testAl.add("no");
    assertEquals(test.getAnswers(), testAl);
  }

  /**
   * Testing the custom question.
   */
  @Test
  public final void testCustomQuestion() {
    Question test = new Question("Some question?", "Answer");
    assertEquals(test.getQuestion(), "Some question?");
  }

  /**
   * Testing the custom question with space.
   */
  @Test
  public final void testCustomQuestionWithSpace() {
    Question test = new Question("Question?", "Here is some space!");
    assertEquals(test.getQuestion(), "Question?");
  }
  
  /**
   * Testing the Simon constructor.
   */
  @Test
  public final void testSimonConstructor() {
    Simon test = new Simon();
    assertTrue(Simon.class.equals(test.getClass()));
  }
  
  /**
   * Testing the frame dispose method for Simon.
   */
  @Test
  public final void testFrameDispose() {
    Simon test = new Simon();
    test.frameDispose();
    assertTrue(test.getClass().equals(Simon.class));
  }
  
  /**
   * Testing the frame dispose method for GuessWho.
   */
  @Test
  public final void testFrameDispose2() {
    GuessWho test = new GuessWho();
    test.frameDispose();
    assertTrue(GuessWho.class.equals(test.getClass()));
  }
  
  /**
   * Testing the getInstance method.
   */
  @Test
  public final void testGetInstance() {
    GuessWho test = new GuessWho();
    ArrayList<String> testList = new ArrayList<String>();
    assertEquals(test.getInstance(), testList);
  }
  
  /**
   * Testing the append answers method.
   */
  @Test
  public final void testAppendAnswers() {
    GuessWho test = new GuessWho();
    ArrayList<String> testList = new ArrayList<String>();
    test.appendAnswers("hi");
    testList.add("hi");
  }
  
  
}