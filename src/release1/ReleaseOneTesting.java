package release1;

import static org.junit.Assert.*;

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
  
  

}
