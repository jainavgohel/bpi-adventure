import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
		// TODO Auto-generated method stub
		
	}

	public static void monsterMap(ArrayList<Monster> monsterList, Scanner console, Player p1) {
		for(int i = 0; i < monsterList.size(); i++){
			monsterApproach(monsterList.get(i), console, p1);
		}
		
	}

	public static void monsterGenerator(ArrayList<Monster> monsterList) throws FileNotFoundException {
		ArrayList<String> monsterData = new ArrayList<String>();
		File f = new File("MonsterData.txt");
		Scanner input = new Scanner(f);
		input.useDelimiter("/");
		while (input.hasNext()) {
			monsterData.add(input.next());
		}

		for (int i = 0; i < monsterData.size(); i++) {
			Monster mTemp = new Monster(monsterData.get(i));
			i++;
			mTemp.setMonth(monsterData.get(i));
			i++;
			for (int j = 0; j < 5; j++) {
				mTemp.setPaths(monsterData.get(i));
				i++;
			}
			
			mTemp.setFight(monsterData.get(i), monsterData.get(i + 1), monsterData.get(i + 2), monsterData.get(i + 3),
					monsterData.get(i + 4));
			i = i + 5;
			System.out.println("blank " + monsterData.get(i));
			mTemp.setWin(monsterData.get(i));
			monsterList.add(mTemp);
		}
	}

	public static void monsterApproach(Monster m, Scanner console, Player p) {
		System.out.println(m.getMonth());
		System.out.println(m.getEncounter());
		int selection = numMenu(console);
		if (selection == 1) {
			System.out.println(m.getSafePath());
			selection = 0;
			selection = numMenu(console);
			if (selection == 1) {
				System.out.println(m.getFightPath());
				monsterFight(m, console, p);
			} else if (selection == 2) {
				p.safePass();
				System.out.println(m.getSafePassage());
			}
		} else if (selection == 2) {
			p.lifeLost(8);
			System.out.println(m.getHarmedPath());
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
		System.out.print(" Hello! I am mage Stephen, your guide on this journey. \n"
				+ "Our kingdom has been ransacked by monsters the last year, and \n"
				+ "our residents have thus been unable to submit projects via \n"
				+ "Hypergrade, something which is ruining our kingdom’s economy. \n"
				+ "But first, tell me, what is your name? \n");
		boolean correct = false;
		String name = "";
		while (!correct) {
			System.out.print("Enter your name: ");
			name = console.next();
			System.out.print(name + " Is this name correct?");
			correct = ynMenu(console);
		}

		System.out.print("Nice to meet you, " + name + "! Let’s get this journey started. If you look to your left, \n"
				+ "you’ll see that you have your laptop, which allows you to engage \n"
				+ "in battles with monsters, and has the main controls. In your bag, \n"
				+ "you have a map and a progress tracker, which shows what you decided \n"
				+ "to do. You can call me three times to give you hints, but after that, \n"
				+ "I cannot spend anymore time as I must help other adventures too. Oh \n"
				+ "look! We’re nearing the forest now. \n");

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
