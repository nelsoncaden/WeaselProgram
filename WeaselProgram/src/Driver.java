import java.util.Scanner;

/**
 * 
 */

/**
 * The following is an implementation of the "weasel program." This is a program 
 * invented by Richard Dawkins which intends to show how a highly random event 
 * (i.e. a specific string of characters) can arise quite likely in a relatively
 * small number of "generations" if the "fittest" of each generation acts as the 
 * "parent" of each offspring in the next generation. There is a 5% probability
 * that any given letter will mutate from one generation to the next.
 * @author Caden Nelson
 */
public class Driver {

	/**
	 * Main method drives the program
	 * @param args
	 */
	public static void main(String[] args) {
		Offspring parent = new Offspring("", "");
		Offspring fittest = null;
		Scanner in = new Scanner(System.in);
		System.out.print("Please input your target phrase: ");
		String target = in.nextLine();
		System.out.println();
		System.out.print("Please input how many offspring you want per generation: ");
		int number = Integer.parseInt(in.nextLine());
		System.out.println();
		int generation = 0;
		do {
			Offspring[] offspring = new Offspring[number];
			for (int i = 0; i < offspring.length; i++) {
				offspring[i] = new Offspring(parent.genetics, target);
			}
			fittest = findFittest(offspring);
			print(generation, fittest.toString());
			parent = fittest;
			generation++;
		} while (!(isMatch(target, fittest.toString())));
	}
	
	/**
	 * Returns the fittest offspring of a generation (an array of offspring)
	 * @param offspring The array of offspring from a given generation
	 * @return The fittest offspring
	 */
	public static Offspring findFittest(Offspring[] offspring) {
		Offspring fittest = offspring[0];
		for (Offspring off : offspring) {
			if (off.score > fittest.score) {
				fittest = off;
			}
		}
		return fittest;
	}
	
	/**
	 * Determines whether the target offspring and the fittest offspring are identical
	 * @param target The genetic code of the target
	 * @param fittest The genetic code of the fittest
	 * @return Returns true if there is a match
	 */
	public static boolean isMatch(String target, String fittest) {
		int count = 0;
		for (int i = 0; i < target.length(); i++) {
			if (target.charAt(i) == fittest.charAt(i)) {
				count++;
			}
		}
		if (count == target.length()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Prints the string representation of the fittest offspring in some generation
	 * @param generation int 
	 * @param fittest String
	 */
	public static void print(int generation, String fittest) {
		String printing = String.format("%3d: %s", generation, fittest);
		System.out.println(printing);
	}

}
