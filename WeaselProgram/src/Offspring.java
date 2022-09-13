/**
 * This is the abstract class for the Offspring data type. Its instances properties are genetics and score
 * which describe the genetic makeup and fitness score of some Offspring. 
 * @author Caden Nelson
 *
 */
public class Offspring {
	// Instances properties
	public String genetics = "";
	public int score = 0;
	
	/**
	 * Constructor Offspring data type
	 * @param parent String which acts as a basis from which an offspring may mutate
	 * @param target String which acts as measurement of fitness for each string
	 */
	public Offspring(String parent, String target) {
		if (parent == null || parent.equals("")) {
			for (int i = 0; i < target.length(); i++) {
				this.genetics += "" + randomChar();
			}
		} else {
			String newCode = "";
			for (int i = 0; i < target.length(); i++) {
				double random = 100 * Math.random();
				if (random < 5) {
					newCode += "" + randomChar();
				} else {
					newCode += parent.charAt(i);
				}
			}
			this.genetics = newCode;
		}
		int countScore = 0;
		for (int i = 0; i < target.length(); i++) {
			if (genetics.charAt(i) == target.charAt(i)) {
				countScore++;
			}
		}
		this.score = countScore;
	}
	
	/**
	 * Returns a random character
	 * @return char Some random uppercase letter or space
	 */
	public char randomChar() {
		int random = (int)((36 * Math.random()) + 65);
		if (random > 90) {
			random = 32;
		}
		return (char) random;
	}
	
	/**
	 * Returns a string representation of an Offspring object
	 * @return String which represents Offspring object
	 */
	public String toString() {
		return String.format("%s -- score: %d  ", genetics, score);
	}
}
