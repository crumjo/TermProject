package release1;

public class Charcter {

	private String Name;
	private String Hair;
	private String Eyes;
	private String HairColor;
	
	public Charcter(){
		this.Name = "Patton";
		this.Hair = "short";
		this.Eyes = "Blue";
		this.HairColor = "Blonde";
	}
	
	public String getName() {
		return Name;
	}

	public String getHair() {
		return Hair;
	}

	public String getEyes() {
		return Eyes;
	}

	public String getHairColor() {
		return HairColor;
	}

	public Charcter(String Name, String Hair, String Eyes, String HairColor){
		this.Name = Name;
		this.Hair = Hair;
		this.Eyes = Eyes;
		this.HairColor = HairColor;
	}
}
