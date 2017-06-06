import java.util.Random;

//Creates Player Object
public class Player {
	private String name;
	private int healthPoint;
	private int help;
	public int safePass;
	public int monsterEncounter;
	public int monsterWin;
	
	
	public Player(String name){
		this.name  = name;
		this.healthPoint = 100;
		this.help = 3;
		this.monsterEncounter = 0;
		this.monsterWin = 0;
		this.safePass = 0;
	}
	
	public void monsterEncounter(){
		this.monsterEncounter++;
	}
	
	public void monsterWin(){
		this.monsterWin++;
	}
	
	public int getMonsterEncounter(){
		return this.monsterEncounter;
	}
	
	public int getMonsterWin(){
		return this.monsterWin;
	}
	
	public void safePass(){
		safePass++;
	}
	
	public int getSafePass(){
		return this.safePass;
	}
	
	public void lifeLost(int hit){
		this.healthPoint = healthPoint - hit;
	}
	
	public int getLives(){
		return this.healthPoint;
	}
	
	public String getName(){
		return this.name;
	}
}
