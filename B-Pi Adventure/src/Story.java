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
		Player p1 = new Player(name(console));
		ArrayList<Monster> monsterList = new ArrayList<Monster>();
		monsterGenerator(monsterList);
		monsterMap(monsterList, console, p1);
		finalBoss();
	}

	private static void finalBoss() {
		parsePrint(
				"You walk in the throne room, ready to see the man you owe your life for, King Bruck. "
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
				+ "“Hey <user input name>, looks like we meet again! Need any more hints?” Stephen laughs. "
				+ "The AP Test grasps you and lifts you into the air, throwing you on the ground."
				+ "Picking yourself up, you take out your dented laptop and prepare for the final battle.");
		
		
		
	}

	public static void parsePrint(String output) {
		String[] s3 = output.split(" ");
		int i;
		for (i = 0; i < s3.length; i++) {
			System.out.print(s3[i] + " ");
			try {
				TimeUnit.MILLISECONDS.sleep(80);
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
			monsterList.add(mTemp);
		}
	}

	public static void monsterApproach(Monster m, Scanner console, Player p) {
		System.out.println("\n\n" + m.getMonth());
		parsePrint(m.getEncounter());
		int selection = numMenu(console);
		if (selection == 1) {
			parsePrint(m.getSafePath());
			selection = 0;
			selection = numMenu(console);
			if (selection == 1) {
				parsePrint(m.getFightPath());
				monsterFight(m, console, p);
			} else if (selection == 2) {
				p.safePass();
				parsePrint(m.getSafePassage());
			}
		} else if (selection == 2) {
			p.lifeLost(8);
			parsePrint(m.getHarmedPath());
		}
	}

	public static void monsterFight(Monster m, Scanner console, Player p) {
		System.out.print("\nYou have entered battle. Your opponent is " + m.getName()
				+ ".\nYou may chose to run, but you may not succeed." + "Fight(1) or Run(2)");
		int selection = numMenu(console);
		Random r1 = new Random();
		if (selection == 1) {
			System.out.println(m.getFight());
			boolean correct = false;
			String answer = "";
			while (!correct) {
				System.out.print("Enter answer: ");
				answer = console.next();
				System.out.print(answer + " Is this answer correct? (Y/N) ");
				correct = ynMenu(console);
			}
			if (answer.equals(m.getWinCondition())) {
				System.out.println(m.getFightWin());
			} else {
				p.lifeLost(9);
				System.out.println(m.getFightLose());
			}
		} else if (selection == 2) {
			if (r1.nextInt(100) < 33) {
				System.out.println(m.getRun());
			} else {
				System.out.print("You have failed to run. You must fight.");
				System.out.print(m.getFight());
				boolean correct = false;
				String answer = "";
				while (!correct) {
					System.out.print("Enter answer: ");
					answer = console.next();
					System.out.print(answer + " Is this answer correct? (Y/N) ");
					correct = ynMenu(console);
				}
				if (answer.equals(m.getWinCondition())) {

					System.out.print(m.getFightWin());
				} else {
					p.lifeLost(10);
					System.out.print(m.getFightLose());
				}
			}
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
			System.out.print("Invalid input. Try Again.\n(Y/N): ");

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
