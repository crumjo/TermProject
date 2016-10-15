package release1;

import java.util.*;

import javax.swing.*;

public class GuessWho {

	private JFrame frame;

	public GuessWho(){
	
	//arraylist for charcters to try to guess
	ArrayList<Charcter> Charcters = new ArrayList<Charcter>();
	
	//build charcters
	Charcter Patton = new Charcter();
	Charcter Josh = new Charcter("Josh", "Short", "Brown", "Brown");
	Charcter Pual = new Charcter("Pual", "Mid", "Blue", "Blonde");
	Charcter Sally = new Charcter("Sally", "Long", "Brown", "Black");
	Charcter Sue = new Charcter("Sue", "Long", "Green", "Red");
	
	//adds charcters to array list
	Charcters.add(Patton);
	Charcters.add(Josh);
	Charcters.add(Pual);
	Charcters.add(Sally);
	Charcters.add(Sue);
	
	//add random selector to pick who you must guess
	
	}
	
	
	private void Build(){
		//how should we do this
	}
}
