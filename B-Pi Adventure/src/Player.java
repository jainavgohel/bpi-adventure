import java.util.Random;

//Creates Player Object
public class Player {
	private String name;
	
	public Player(String name){
		this.name  = name;
	}
	
	public String fight(Monster o){
		return o.getFight();
	}
	
	public String run(Monster o){
		Random rnd = new Random();
		if(rnd.nextInt(100) < 33){
			return o.getRun();
		} else {
			return "You are forced to fight/n" + this.fight(o);
		}

	}
	
}
