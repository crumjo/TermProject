package release1;

import java.util.*;

public class Question {

	String question;
	ArrayList<String> answers;
	public Question(){
		question = "Do you like cheese?";
		answers = new ArrayList<String>();
		answers.add("yes"); answers.add("no");
	}
	
	//fix str later
	public Question(String AQuestion, String str){
		this.question = AQuestion;
		answers = new ArrayList<String>();
		//int for private marker
		int j = 0;
		//splits the answers into an arraylist
		for(int i = 0; i < str.length(); i++){
			
			if(str.charAt(i) == (' ')){
				//System.out.println(str.substring(j,i));
				String temp = str.substring(j, i);
				answers.add(temp);
				j = i;
			}
		}
		answers.add(str.substring(j));
	}

	public String getQuestion() {
		return question;
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}
	
	
}
