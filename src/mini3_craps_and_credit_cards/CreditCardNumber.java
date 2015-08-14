package mini3_craps_and_credit_cards;

public class CreditCardNumber {
	/*
	 * (Financial: credit card number validation) Credit card numbers follow
	 * certain patterns. A credit card number must have between 13 and 16
	 * digits.In 1954, Hans Luhn of IBM proposed an algorithm for validating
	 * credit card numbers. The algorithm is useful to determine whether a card
	 * number is entered correctly or whether a credit card is scanned correctly
	 * by a scanner. Credit card numbers are generated following this validity
	 * check, commonly known as the Luhn check or the Mod 10 check.Write a
	 * program that prompts the user to enter a credit card number as a long
	 * integer. Display whether the number is valid or invalid.
	 */
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		// unos broja kreditne kartice
		System.out.println("Enter credit card number: ");
		long cardNumber = input.nextLong();
		// pozivamo metodu isValid za provjeru ispravnosti unesenog broja
		// ispisujemo rezultat
		if (isValid(cardNumber) == true) {
			System.out.println("\n\tYour card is valid!");
		} else {
			System.out.println("\n\tYour card is not valid!");
		}

	}

	// metoda za konacnu provjeru ispravnosti broja kreditne kartice
	// Broj provjeravamo koristeci "Luhn check", odnosno "Mod 10 check"
	public static boolean isValid(long number) {

		int total = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);

		if ((total % 10 == 0) && (prefixMatched(number, 1) == true)) {
			return true;
		} else {
			return false;
		}
	}

	// metoda koja vraca proslijedjeni broj ako je broj jednocifren, u
	// suprotnom, vraca sumu cifara proslijedjenog broja
	public static int getDigit(int number) {

		if (number <= 9) {
			return number;
		} else {
			int n = (number / 10) + (number % 10);

			return n;
		}
	}

	// metoda koja vraca sumu cifara proslijedjenog broja na neparnim mjestima
	public static int sumOfOddPlace(long number) {
		int sum = 0;

		while (number > 0) {
			sum += (int) (number % 10);
			number = number / 100;
		}

		return sum;
	}

	// metoda za mnozenje svake druge cifre broja brojem 2
	// metoda vraca sumu pomnozenih cifara
	public static int sumOfDoubleEvenPlace(long number) {

		int sum = 0;
		long temp = 0;

		while (number > 0) {
			temp = number % 100;
			sum += getDigit((int) (temp / 10) * 2);
			number = number / 100;
		}

		return sum;
	}

	// metoda koja provjerava da li je broj d odgovarajuci prefix broja kartice,
	// te ispisuje vrstu kartice u zavisnosti od prefixa
	public static boolean prefixMatched(long number, int d) {

		if ((getPrefix(number, d) == 3) || (getPrefix(number, d) == 4)
				|| (getPrefix(number, d) == 5) || (getPrefix(number, d) == 6)) {

			if (getPrefix(number, d) == 3) {
				System.out.println("\n>> American Express Card");
			} else if (getPrefix(number, d) == 4) {
				System.out.println("\n>> Visa Card");
			} else if (getPrefix(number, d) == 5) {
				System.out.println("\n>> Master Card");
			} else if (getPrefix(number, d) == 6) {
				System.out.println("\n>> Discover Card");
			}

			return true;

		} else {

			return false;

		}
	}

	// metoda koja vraca broj cifara u proslijedjenom broju
	public static int getSize(long d) {

		int count = 0;

		while (d > 0) {
			d = d / 10;

			count++;
		}

		return count;

	}

	// metoda vraca prvih "k" cifara broja "number"(broja kartice)
	public static long getPrefix(long number, int k) {

		if (getSize(number) < k) {
			return number;
		} else {

			int size = (int) getSize(number);

			for (int i = 0; i < (size - k); i++) {
				number = number / 10;
			}

			return number;

		}
	}
}