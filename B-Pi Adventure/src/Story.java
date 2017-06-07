import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//Client 
public class Story {

	public static void main(String args[]) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		boolean replay = true;
		while (replay) {
			Player p1 = new Player(name(console));
			ArrayList<Monster> monsterList = new ArrayList<Monster>();
			monsterGenerator(monsterList);
			monsterMap(monsterList, console, p1);
			finalBoss(p1, console);
			replay = endMenu(p1, console);
		}
	}

	public static boolean endMenu(Player p1, Scanner console) {
		boolean replay = false;
		System.out.print("\n\nEND");
		System.out.print("\nMonster encounters: " + p1.getMonsterEncounter());
		System.out.print("\nBattle Wins: " + p1.getMonsterWin());
		System.out.print("\nPLAY AGAIN?");
		replay = ynMenu(console);
		return replay;
	}

	public static void finalBoss(Player p1, Scanner console) {
		Random r1 = new Random();
		System.out.println("/n/n");
		System.out.println("MAY");

		parsePrint("You walk in the throne room, ready to see the man you owe your life for, King Bruck. "
				+ "Opening the large doors leading into the room, you are surprised to find out that "
				+ "the entire room is dark. Suddenly, a light turns on and you see King Bruck tied up "
				+ "and dangling from the ceiling, struggling with the rope. You run over and cut the "
				+ "ropes to free your King using your laptop. Gagged, King Bruck gestures his thanks "
				+ "and you tell him not to worry, that you would track down whoever did this to him. Suddenly, "
				+ "his eyes widen and King Bruck points to something behind you.You ready your laptop. You whirl around. "
				+ "In front of you is the monster that parents tell their kids to be wary of, the monster"
				+ " that instills nightmares in every citizen of BPi. It is the AP Computer Science A AP test,"
				+ " and standing behind it is Stephen. Thankful, you run over and ask Stephen for his help to "
				+ "defeat the monster, but he only smirks and pushes you back, into the grasps of the monster. "
				+ "You understand now. All along, Stephen had been the one who unleashed all of the monsters onto the kingdom. "
				+ "“Hey " + p1.getName() + ", looks like we meet again! Need any more hints?” Stephen laughs. "
				+ "The AP Test grasps you and lifts you into the air, throwing you on the ground."
				+ " Picking yourself up, you take out your dented laptop and prepare for the final battle.");

		System.out.println("It is time for the final battle. In this battle, your skills will help you\n"
				+ " and your lack of skills will hurt you. \n To win this battle you must enter a number higher than Stephen. \n Enter a number between 1 and 10.");
		int sbNum = (r1.nextInt(10));
		int slNum = sbNum+2;
		int suNum = sbNum-2;
		int pNum = 314;
		boolean robust = false;
		while (!robust) {
			pNum = console.nextInt();
			if (((pNum <= 10) && (pNum > 0))) {
				robust = true;
			} else {
				System.out.print("Invalid input. Try Again.\nEnter a number between 1 and 10: ");
			}
		}

		System.out.println("Stephens Number: " + sbNum);
		if ((slNum <= pNum && suNum >= pNum) || (p1.getName().equals("BPI")) || ((p1.getSafePass() < 5)) || (p1.getMonsterWin() > 5)) {
			parsePrint("The AP Test falls apart, and crumbles to the ground. "
					+ "Shocked, Stephen stares at you and backs towards the wall, "
					+ "whimpering. “Please, I’m sorry,” he begs. You knock him out "
					+ "and ask King Bruck what to do with the unconscious Stephen. "
					+ "King Bruck gestures to you to carry him out of the room.");
			System.out.println("EPILOGUE");
			parsePrint("5 years have passed. King Bruck has officially given you the title of Highest TA, "
					+ "the most significant title below him. Stephen has been banished from the kingdom, and nobody has heard from him since. "
					+ "The kingdom, now at peace, thanks you for the high percentage of 5’s and 4’s"
					+ " you have brought upon the people-- a good omen. You retire to the edge of "
					+ "the kingdom with your own house and reunited with your old dog. You’ve donated "
					+ "your laptop to the nation of Mission to house in its museum.");
		} else {
			parsePrint("AP Test snarls and lunges for your laptop, destroying it. "
					+ "Your only chance of winning is gone. “Good boy,” Stephen "
					+ "says, and throws AP Test a treat. Delighted, AP Test lies "
					+ "down and crushes your body, making you gasp for air. “Why,” "
					+ "you gasp, “why did you do this?”Stephen smiles. “Why do you "
					+ "think? It’s time for an overthrow--King Bruck has too much "
					+ "power for too long a time.”The last thing you see is "
					+ "Stephen’s horrible smile as you black out.");
		}
	}

	public static void parsePrint(String output) {
		String[] s3 = output.split(" ");
		int i;
		for (i = 0; i < s3.length; i++) {
			System.out.print(s3[i] + " ");
			try {
				TimeUnit.MILLISECONDS.sleep(120);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if ((i + 2) % 10 == 0) {
				System.out.println();
			}
		}
	}

	public static void monsterMap(ArrayList<Monster> monsterList, Scanner console, Player p1) {
		for (int i = 0; i < monsterList.size(); i++) {
			monsterApproach(monsterList.get(i), console, p1);
			System.out.println();
		}

	}

	public static void monsterGenerator(ArrayList<Monster> monsterList) throws FileNotFoundException {
		ArrayList<String> monsterData = new ArrayList<String>();
		File f = new File("MonsterData.txt");
		Scanner input = new Scanner(f);
		input.useDelimiter("/");
		while (input.hasNext()) {
			String withLine = input.next();
			if (withLine.contains("\n")) {
				withLine = withLine.replaceAll("\n", "").replaceAll("\r", "");
			}
			monsterData.add(withLine);
		}

		for (int i = -1; i < monsterData.size() - monsterList.size();) {
			i++;
			Monster mTemp = new Monster(monsterData.get(i));
			i++;
			mTemp.setMonth(monsterData.get(i));
			i++;
			mTemp.setPaths(monsterData.get(i));
			i++;
			mTemp.setPaths(monsterData.get(i));
			i++;
			mTemp.setPaths(monsterData.get(i));
			i++;
			mTemp.setPaths(monsterData.get(i));
			i++;
			mTemp.setPaths(monsterData.get(i));
			i++;
			mTemp.setFight(monsterData.get(i), monsterData.get(i + 1), monsterData.get(i + 2), monsterData.get(i + 3),
					monsterData.get(i + 4));
			i++;
			i++;
			i++;
			i++;
			i++;
			mTemp.setWin(monsterData.get(i));
			i++;
			mTemp.setTree(Integer.parseInt(monsterData.get(i)));
			i++;
			mTemp.setTree(Integer.parseInt(monsterData.get(i)));
			i++;
			mTemp.setTree(Integer.parseInt(monsterData.get(i)));
			i++;
			mTemp.setTree(Integer.parseInt(monsterData.get(i)));
			
			
			monsterList.add(mTemp);
		}
	}

	public static void monsterApproach(Monster m, Scanner console, Player p) {
		System.out.println("\n\n" + m.getMonth());
		parsePrint(m.getEncounter());
		int selection = numMenu(console);
		if (selection == m.getTree(0)) {
			parsePrint(m.getSafePath());
			selection = 0;
			selection = numMenu(console);
			if (selection == m.getTree(2)) {
				parsePrint(m.getFightPath());
				monsterFightMenu(m, console, p);
			} else if (selection == m.getTree(3)) {
				p.safePass();
				parsePrint(m.getSafePassage());
			}
		} else if (selection == m.getTree(1)) {
			p.lifeLost(8);
			parsePrint(m.getHarmedPath());
		}
	}

	public static void monsterFightMenu(Monster m, Scanner console, Player p) {
		
		System.out.print("\nYou have entered battle. Your opponent is " + m.getName()
				+ ".\nYou may chose to run, but you may not succeed." + "\nFight(1) or Run(2): ");
		int selection = numMenu(console);
		Random r1 = new Random();
		if (selection == 1) {
			monsterFight(m,console,p);
		} else if (selection == 2) {
			if (r1.nextInt(100) < 33) {
				System.out.println(m.getRun());
			} else {
				System.out.print("You have failed to run. You must fight.");
				monsterFight(m,console,p);
			}
		}

	}

	public static void monsterFight(Monster m, Scanner console, Player p){
		p.monsterEncounter();
		System.out.println(m.getFight());
		boolean correct = false;
		int answer = -1;
		while (!correct) {
			System.out.print("Enter answer: ");
			answer = fightOptionMenu(console);
			System.out.print( m.getFightOption(answer) + " Is this your final answer? ");
			correct = ynMenu(console);
		} 
		
		if (m.getFightOption(answer).equals(m.getWinCondition())) {
			p.monsterWin();
			System.out.println(m.getFightWin());
		} else {
			p.lifeLost(9);
			System.out.println(m.getFightLose());
		}
	}
	
	public static String name(Scanner console) {
		parsePrint("Hello! I am mage Stephen, your guide on this journey. "
				+ "Our kingdom has been ransacked by monsters the last year, "
				+ "and our residents have thus been unable to submit projects "
				+ "via Hypergrade, something which is ruining our kingdom’s economy. "
				+ "But first, tell me, whats your name?");
		boolean correct = false;
		String name = "";
		while (!correct) {
			System.out.print("\nEnter your name: ");
			name = console.next();
			System.out.print(name + " Is this name correct?");
			correct = ynMenu(console);
		}

		parsePrint("Nice to meet you, " + name + "! " + "Let’s get this journey started. If you look to your left, "
				+ "you’ll see that you have your laptop, which allows you to "
				+ "engage in battles with monsters, and has the main controls. "
				+ "In your bag, you have general guidelines about your status "
				+ "and HP as well a progress tracker, which shows what "
				+ "month you’re in. Oh look! We’re nearing the forest now. ");

		return name;

	}

	public static int fightOptionMenu(Scanner console) {
		boolean robust = false;
		while (!robust) {
			String input = console.next();
			if (input.equalsIgnoreCase("1")) {
				robust = true;
				return 1;
			} else if (input.equalsIgnoreCase("2")) {
				robust = true;
				return 2;
			}else if (input.equalsIgnoreCase("3")) {
				robust = true;
				return 3;
			}else if (input.equalsIgnoreCase("4")) {
				robust = true;
				return 4;
			}
			System.out.print("Invalid input. Try Again.");
		}
		return 0;
	}
	
	public static int numMenu(Scanner console) {
		boolean robust = false;
		while (!robust) {

			String input = console.next();
			if (input.equalsIgnoreCase("1")) {
				robust = true;
				return 1;
			} else if (input.equalsIgnoreCase("2")) {
				robust = true;
				return 2;
			}
			System.out.print("Invalid input. Try Again. ");

		}
		return 0;
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
