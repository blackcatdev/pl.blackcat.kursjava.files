//Write a program that will ask a user for a path to the text file and a few lines of text (until the user enters "-" as lines) and save them to the text file. To accomplish this task, you may find the System.lineSeparator () method useful to return a newline (if you would like to separate the lines entered by the user).

package pl.blackcat.kursjava.files;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Podaj ścieżkę do pliku: ");
		String filePath = scanner.nextLine();
		FileWriter fileWriter = initializeFile(filePath);

		userInput(fileWriter);


	}

	private static FileWriter initializeFile(String filePath) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath);
		} catch (IOException e) {
			System.out.println("Błędna ścieżka. Program został zamknięty.");
			e.printStackTrace();
		}

		return fileWriter;


	}

	private static void userInput(FileWriter fileWriter) {
		String userText = "-";
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("Podaj linię tekstu: ");
			userText = scanner.nextLine();
			if (userText.equals("-"))
				break;
			else {
				try {
					fileWriter.write(userText);
					fileWriter.write(System.lineSeparator());
				} catch (IOException e) {
					System.out.println("Nie udało się zapisać linii. Program zostanie zamknięty.");
				}

			}
		}
		try {
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("Nie udało się zamknąć pliku.");

		}


	}

}
