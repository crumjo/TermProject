package release1;

public class Charcter {

  private String name;
  private String hair;
  private String eyes;
  private String hairColor;
  
  

  public Charcter() {
    this.name = "Patton";
    this.hair = "Short";
    this.eyes = "Blue";
    this.hairColor = "Blonde";
  }
  

  public String getName() {
    return name;
  }
  

  public String getHair() {
    return hair;
  }
  

  public String getEyes() {
    return eyes;
  }
  

  public String getHairColor() {
    return hairColor;
  }
  

  public Charcter(String name, String hair, String eyes, 
      String hairColor) {
    this.name = name;
    this.hair = hair;
    this.eyes = eyes;
    this.hairColor = hairColor;
  }
}