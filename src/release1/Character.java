package release1;

/*****************************************************************
 * @author Patton Finley, Josh Crum, Paul Magee
 * 
 * 
 *         A Charcater class to be used in a game of guess who.
 *     ***********************************************************/
public class Character {

  /**
   * a string that represents the character name.
   */
  private String name;
  /**
   * a string that represents the characters hair length.
   */
  private String hair;
  /**
   * a string that represents the characters eye color.
   */
  private String eyes;
  /**
   * a string that represents the characters hair color.
   */
  private String hairColor;

  /*****************************************************************
   * A character constructor method to make a default character.
   *****************************************************************/
  public Character() {
    this.name = "Patton";
    this.hair = "Short";
    this.eyes = "Blue";
    this.hairColor = "Blonde";
  }

  /*****************************************************************
   * A character constructor method to make a customized character.
   * 
   * @param cName
   *          the name of the character
   * @param cHair
   *          the length of the hair of the character
   * @param cEyes
   *          the color of the eyes of the character
   * @param cHairColor
   *          the color of the hair of the character
   *     ***********************************************************/
  public Character(final String cName, final String cHair, final String cEyes, 
      final String cHairColor) {
    this.name = cName;
    this.hair = cHair;
    this.eyes = cEyes;
    this.hairColor = cHairColor;
  }

  /*****************************************************************
   * A getter class for a characters name.
   * @return name
   *          gets the name.
   *****************************************************************/
  public final String getName() {
    return name;
  }

  /*****************************************************************
   * A getter class for a characters hair length.
   * @return hair
   *          gets the hair.
   *****************************************************************/
  public final String getHair() {
    return hair;
  }

  /*****************************************************************
   * A getter class for a characters eye color.
   * @return eyes
   *          gets the eyes.
   *****************************************************************/
  public final String getEyes() {
    return eyes;
  }

  /*****************************************************************
   * A getter class for a characters hair color.
   * @return hairColor
   *          gets the hair color.
   *****************************************************************/
  public final String getHairColor() {
    return hairColor;
  }
}