
public class Monster {
	public String name;
	public String dialogueFight;
	public String dialogueRun;
	public String dialogueTaunt;
	public Monster(String name){
		this.name = name;
	}
	
	public void setDialogue(String dialogueFight, String dialogueRun, String dialogueTaunt){
		this.dialogueFight = dialogueFight;
		this.dialogueRun = dialogueRun;
		this.dialogueTaunt = dialogueTaunt;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getFight(){
		return dialogueFight;
	}
	
	public String getRun(){
		return dialogueRun;
	}
	public String getTaunt(){
		return dialogueTaunt;
	}
}
