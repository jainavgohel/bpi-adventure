import java.util.*;

//Use for experimentation
public class Sandbox {
	public static void main(String args[]) {
//		System.out.println("This is a sandbox");
//		System.out.println("This is a cmd sandbox");
		Scanner console = new Scanner(System.in);
		System.out.print(ynMenu(console));
		System.out.print(numMenu(console,4));
	}
	
	public static Monster createMon(){
		Monster m1 = new Monster("September");
		String[] path = new String[10];
		m1.setPaths("You see a path that leads to a clearing, filled with flowers, and a path that leads "
				+ "deeper into the woods. You hear the rush of a waterfall from the one that leads deeper into "
				+ "the woods. Do you take the path into the woods or head towards the waterfall?");
		m1.setPaths("You see a wooden bridge ahead and you cross  it. The birds are chirping and "
				+ "there is a light breeze in the air… the weather is perfect and you almost want "
				+ "to take a picture of the moment. You walk on contently. The bridge snaps, and "
				+ "you grab onto a rope. Your life is spared but not without damage-- you have "
				+ "sprained your wrist, and you know the rest of the journey will be very difficult because of this injury.");
		m1.setPaths("You see a rock in front of you, with a giant handle of something embedded in. "
				+ "On the rock is a note which says “The pen may be mightier than the sword.. "
				+ "but a key opens any door.” Do you pull the handle or walk on?");
		m1.setPaths("You walk past the suspicious rock and continue on your journey. "
				+ "As you walk past, the rock disappears, and you’re glad you avoided "
				+ "that trap. You’re safe.. For now.");
		m1.setPaths("You pull the handle, and you find out that it is a large key. "
				+ "The key flies out of your hand and transforms into a large sword, "
				+ "and the note transforms into a giant knight made out of paper. ");
		return m1;
	}
	
	public static int numMenu(Scanner console, int options){
		return -1;
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
