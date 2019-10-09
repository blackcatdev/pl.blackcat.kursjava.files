//Write a program that will ask the user the name of the output file and provide his date of birth (separately day, month and year), and then save this data as three separate binary numbers.

package pl.blackcat.kursjava.files;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj ścieżkę do pliku: ");
		String filePath = scanner.nextLine();

		DataOutputStream outputStream = initializeFile(filePath);

		userInput(outputStream);
	}

	private static void userInput(DataOutputStream outputStream) throws IOException {
		System.out.print("Podaj dzień urodzenia: ");
		int day = getInteger();
		outputStream.writeInt(day);
		System.out.print("Podaj miesiąc urodzenia: ");
		int month = getInteger();
		outputStream.writeInt(month);
		System.out.print("Podaj rok urodzenia: ");
		int year = getInteger();
		outputStream.writeInt(year);
		outputStream.close();

	}

	private static int getInteger() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			try {
				return scanner.nextInt();
			} catch (InputMismatchException exception) {
				System.out.println("To co podałeś, zdecydowanie nie jest liczbą.");
				System.out.print("Spróbuj jeszcze raz: ");

			}
		}
	}

	private static DataOutputStream initializeFile(String filePath) {
		DataOutputStream outputStream = null;
		try {
			outputStream = new DataOutputStream(new FileOutputStream(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("Błędna ścieżka. Program zostanie zamknięty.");
			e.printStackTrace();
		}


		return outputStream;

	}
}
