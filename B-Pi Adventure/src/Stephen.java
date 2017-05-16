import java.util.ArrayList;

//Reservoir for Stephen's dialogue 
public class Stephen {
	public ArrayList<String> dialogueList;
	public int index;
	public Stephen(){
		index = 0;
	}
	public void setDialogue(String dialogue){
		dialogueList.add(dialogue);
	}
	public String getDialogue(){
		String dialogue =  dialogueList.get(index);
		index++;
		return dialogue;
	}
}
