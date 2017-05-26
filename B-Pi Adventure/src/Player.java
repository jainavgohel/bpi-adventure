import java.util.Random;

//Creates Player Object
public class Player {
	private String name;
	private int healthPoint;
	private int help;
	public int safePass;
	
	
	public Player(String name){
		this.name  = name;
		this.healthPoint = 3;
		this.help = 3;
	}
	
	public void safePass(){
		safePass++;
	}
	
	public void lifeLost(int hit){
		this.healthPoint = healthPoint - hit;
	}
	
	public int getLives(){
		return this.healthPoint;
	}

	
}
