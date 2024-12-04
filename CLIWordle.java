import java.util.Scanner;
import java.io.IOException;
//import Guess;


public class CLIWordle {
	public static String s;
	public static String name;
	public static Guess guess = new Guess();
	
	public static void run() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Player name?\t");
			name = scanner.next();
			System.out.println(String.format("Hello %s!, welcome to CLI Wordle...", name));
			System.out.println("Type \"EXIT\" or \"QUIT\" anytime to leave the game (progress will be lost).\n");
			System.out.println("~~Go ahead and start with a 5 letter word!~~");
			s = "";	
			while(!s.toLowerCase().equals("exit") && !s.toLowerCase().equals("quit")) {
				s = scanner.next();
				//System.out.println("You entered:\t" + s.toUpperCase());
				if (s.length() != 5) {
					System.out.println("--GUESSES MUST BE 5 LETTER WORDS!--");
				} else {
					guess
						.addGuess(s)
						.listGuess();
				}
			}
			System.out.println("Thanks for playing!");
			scanner.close();			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		CLIWordle.run();
	}
}
