package bst;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Driver {
	/*
	 * @author Ryan Dawson
	 * Date: 10/26/2021
	 * @version 1.0
	 */

	public static void main(String[] args) throws IOException {
		List<String> file = new ArrayList<String>(); //Holds elements from file
		ArrayList<Person> book = new ArrayList<Person>();
		try {
			//Reads elements from the file and stores them in a list
			file = Files.readAllLines(Paths.get("people"), StandardCharsets.UTF_8);
		} catch (NoSuchFileException e) {
			System.out.println("No file found with that name!");
		}
		ADTPeople run = new ADTPeople();
		//Splits person name and birthday from the file
		for (int i = 0; i < file.size(); i++) {
			String[] info = file.get(i).split(",", 2);
			String name = info[0];
			String bday = info[1];
			Person working = new Person(name, bday);
			//Adds completed people to an array list
			book.add(working);

		}
		//Enters the menu to alter the address book
		run.choice(book);

	}

}
