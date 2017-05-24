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
