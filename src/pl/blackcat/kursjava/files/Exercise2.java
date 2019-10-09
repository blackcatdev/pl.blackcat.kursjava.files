//Write a program that will ask the user for the path to the file and display the content of the along with information about how many lines are in the file.

package pl.blackcat.kursjava.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Exercise2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj ścieżkę do pliku: ");
		String filePath = scanner.nextLine();

		BufferedReader bufferedReader = openFile(filePath);

		printFile(bufferedReader);

		try {
			System.out.println("\nIlość linii w pliku: " + Files.lines(Paths.get(filePath)).count());
		}
		catch (IOException e) {
			System.out.println("Błąd odczytu ilości linii.");
			e.printStackTrace();
		}



	}

	private static void printFile(BufferedReader bufferedReader) {
		String fileLine;
		try {
			while ((fileLine = bufferedReader.readLine()) != null) {
				System.out.println(fileLine);

			}
		} catch (IOException e) {
			System.out.println("Błąd odczytu pliku.");
			e.printStackTrace();
		}


	}

	private static BufferedReader openFile(String filePath) {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("Plik nie istnieje.");
			e.printStackTrace();
		}
		return bufferedReader;
	}
}
