//Write a program that will ask user the path to the binary file with the date of birth from the user, and then display it on the screen.

package pl.blackcat.kursjava.files;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Exercise4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj ścieżkę do pliku: ");
		String filePath = scanner.nextLine();

		DataInputStream inputStream = openFile(filePath);

		printFile(inputStream);
	}

	private static void printFile(DataInputStream inputStream) {
		try {
			System.out.print("Data urodzenia to: ");
			System.out.print(String.format("%02d",inputStream.readInt()) + "-");
			System.out.print(String.format("%02d",inputStream.readInt()) + "-");
			System.out.println(inputStream.readInt());
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Błąd odczytu lub błędny format pliku.");
			e.printStackTrace();
		}
	}

	private static DataInputStream openFile(String filePath) {
		DataInputStream inputStream = null;
		try {
			inputStream = new DataInputStream(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("Plik nie istnieje.");
			e.printStackTrace();
		}
		return inputStream;

	}


}
