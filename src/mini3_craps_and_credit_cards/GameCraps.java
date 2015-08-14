package mini3_craps_and_credit_cards;

public class GameCraps {
	/*
	 * (Game: craps) Craps is a popular dice game played in casinos. Write a
	 * program to play a variation of the game, as follows: Roll two dice. Each
	 * die has six faces representing values 1, 2, …, and 6, respectively. Check
	 * the sum of the two dice. If the sum is 2, 3, or 12 (called craps), you
	 * lose; if the sum is 7 or 11 (called natural), you win; if the sum is
	 * another value (i.e., 4, 5, 6, 8, 9, or 10), a point is established.
	 * Continue to roll the dice until either a 7 or the same point value is
	 * rolled. If 7 is rolled, you lose. Otherwise, you win. Your program acts
	 * as a single player.
	 */
	public static void main(String[] args) {
		// kreiramo dvije varijable koje predstavljaju dvije kocke
		// varijable imaju nasumicnu vrijednost od 1 do 6
		int die1 = (int) (Math.random() * 6) + 1;
		int die2 = (int) (Math.random() * 6) + 1;
		int sum = die1 + die2;// suma vrijednosti kocki
		int tie = 1;// nerijesen rezultat

		System.out.println("You rolled " + die1 + " + " + die2 + " = " + sum);
		// u zavisnosti od dobijene sume, ispisujemo rezultat, odnosno poruku
		if (sum == 2 || sum == 3 || sum == 12) {
			System.out.println("You lose!");

		} else if (sum == 7 || sum == 11) {
			System.out.println("You win!");

		} else {
			System.out.println("Point is " + sum + "\n");
			System.out.println("Rolling again...\n");
			tie = sum;
			// u slucaju nerijesenog rezultata, nastavljamo bacati kocke
			do {
				die1 = (int) (Math.random() * 6) + 1;
				die2 = (int) (Math.random() * 6) + 1;
				sum = die1 + die2;
				System.out.println("You rolled " + die1 + " + " + die2 + " = "
						+ sum);
				// ako je ponovo dobijena ista suma, ili je suma=7, program
				// zavrsava s radom
				// ispisujemo poruku
				if (sum == tie) {
					System.out.println("You win!");
				} else if (sum == 7) {
					System.out.println("You lose!");
					break;
				} else {
					System.out.println("Point is " + sum + "\n");
					System.out.println("Rolling again...\n");

				}
			} while (tie != sum);// petlja radi dok ne dobijemo ponovo istu
									// sumu, ili broj 7
		}

	}
}
