import java.util.ArrayList;

//Reservoir for Dialogue  
public class Dialogue {
	public ArrayList<String> dialogueList;
	public int index;
	public Dialogue(){
		index = 0;
	}
	public void addDialogue(String dialogue){
		dialogueList.add(dialogue);
	}
	public String getDialogue(){
		String dialogue =  dialogueList.get(index);
		index++;
		return dialogue;
	}
}
