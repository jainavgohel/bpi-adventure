import java.util.Random;
import java.util.Scanner;

//Client 
public class Story {
	public static int lives = 3;
	public static int help = 3;
	public static void main(String args[]) {
		Scanner console = new Scanner(System.in);
		Random r1 = new Random();
		Player p1 = new Player(name(console));
		
		
	}
	
	public static void lifeCheck(){
		if(lives == 0) {
			System.out.print("Game over");
		}
		System.exit(0);
	}
		
	public static String name(Scanner console) {
		System.out.print(" Hello! I am mage Stephen, your guide on this journey. \n"
				+ "Our kingdom has been ransacked by monsters the last year, and \n"
				+ "our residents have thus been unable to submit projects via \n"
				+ "Hypergrade, something which is ruining our kingdom’s economy. \n"
				+ "But first, tell me, what is your name? \n");
		boolean correct = false;
		String name = "";
		while(!correct){
			System.out.print("Enter your name: ");
			name = console.next();
			System.out.print(name+" Is this name correct?");
			correct = ynMenu(console);
		}
		
		System.out.print("Nice to meet you, "
				+ name
				+ "! Let’s get this journey started. If you look to your left, \n"
				+ "you’ll see that you have your laptop, which allows you to engage \n"
				+ "in battles with monsters, and has the main controls. In your bag, \n"
				+ "you have a map and a progress tracker, which shows what you decided \n"
				+ "to do. You can call me three times to give you hints, but after that, \n"
				+ "I cannot spend anymore time as I must help other adventures too. Oh \n"
				+ "look! We’re nearing the forest now. \n");
		
		return name;

	}

	public static boolean ynMenu(Scanner console) {
		System.out.print("\n(Y/N): ");
		boolean robust = false;
		while (!robust) {

			String input = console.next();
			if (input.equalsIgnoreCase("Y")) {
				robust = true;
				return true;
			} else if (input.equalsIgnoreCase("N")) {
				robust = true;
				return false;
			}
			System.out.print("Invalid input. Try Again.\n(Y/N): ");

		}
		return false;
	}
	
	
}
