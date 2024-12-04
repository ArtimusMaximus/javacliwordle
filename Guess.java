import java.util.HashMap;
import java.util.Map;

public class Guess {
	public Map<Integer, String> guesses = new HashMap<>();
	public String correctLetters;
	public int guess;
	public String lines = "\n----- ----- ----- ----- -----\n";	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static String wotd;

	
	public Guess() {
		this.correctLetters = "";
		this.guess = 1;
		this.wotd = "blaze";
	}

	public Guess addGuess(String word) {
		if (guess == 6) {
			System.out.println("\nYour guesses have been used up!\n");
			return this;
		}
		guesses.put(guess, word);
		this.guess += 1;
		return this;
	}
	public void listGuess() {
		System.out.print(lines);
		guesses.forEach((attempt, word) -> 
			drawGuess(word)
		);
	}
	public void drawGuess(String word) {
		for (int i = 0; i<word.length(); i++) {
			System.out.print(" ");
			System.out.print(String.format(" %s  ", word.toUpperCase().charAt(i)));	
			System.out.print(" ");
		}
		System.out.print(lines);
	}
// 10/31/2024 - HAPPY HALLOWEEN!
// leaving off with needing the logic to color the guesses based on word of the day.
// wotd needs to be set as well from a random list.
// color codes: https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

}
