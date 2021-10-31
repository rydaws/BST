package bst;

import java.util.ArrayList;
import java.util.Scanner;

public class ADTPeople {
	/*
	 * @author Ryan Dawson
	 * Date: 10/26/2021
	 * @version 1.0
	 */

	/*Acts as a menu to select what happens within the address book
	 * @param book is address book that holds elements from file
	 */
	public void choice(ArrayList<Person> book) {
		int choice = 0;
		Scanner input = new Scanner(System.in);
		GenericBST g = new GenericBST();
		g.construct(book);
		while (choice != 7) {
			System.out.println("\nEnter 1 add a person");
			System.out.println("Enter 2 delete a person.");
			System.out.println("Enter 3 to modify a person.");
			System.out.println("Enter 4 to search for a person.");
			System.out.println("Enter 5 to search by criteria and list.");
			System.out.println("Enter 6 to list all people.");
			System.out.println("Enter 7 to quit.\n");
			System.out.println("Enter a choice: ");
			choice = input.nextInt();
			input.nextLine();

			switch (choice) {
			//Adds a new person to the BST and address book
			case 1:
				System.out.println("Enter the first and last name of person to be added: ");
				String name = input.nextLine();
				System.out.println("Enter the DOB of the person (xx/xx/xxxx)");
				String bday = input.nextLine();
				book.add(addPerson(name, bday, g));
				System.out.println("Success");
				break;

			case 2:
				//Deletes a person from the BST and address book
				System.out.println("Enter the full name of the person to be deleted: ");
				String fullName = input.nextLine();
				book = delete(fullName, book, g);
				System.out.println("Success");
				break;
			case 3:
				//Changes the attributes of a person and updates them respectively 
				System.out.println("Enter the full name of the person to be modified: ");
				String nameMod = input.nextLine();
				System.out.println("Enter new full name: ");
				String newName = input.nextLine();
				System.out.println("Enter new DOB: ");
				String newDOB = input.nextLine();
				book = modify(nameMod, newName, newDOB, book, g);
				delete(nameMod, book, g);
				System.out.println("Success");
				break;
			case 4:
				//Searches and returns the existence of a person based off of the search inquiry
				System.out.println("Enter the full name of the user you want to know the existence of: ");
				String searchName = input.nextLine();
				boolean exists = search(searchName, book);
				System.out.println("The existence of your person is: " + exists);
				break;
			case 5:
				//Searches by certain criteria for a person with that matching attribute
				System.out.println("Enter the criteria to search by: ");
				System.out.println("Enter 1 for first name");
				System.out.println("Enter 2 for last name");
				System.out.println("Enter 3 for birth month (XX)");
				System.out.println("Enter 4 for birth day (XX)");
				System.out.println("Enter 5 for birth year (XXXX)");
				int searchChoice = input.nextInt();
				input.nextLine();
				System.out.println("Enter criteria value: ");
				String criteria = input.nextLine();
				searchBy(searchChoice, criteria, g);
				break;
			case 6:
				//Prints out people in the BST
				System.out.println("Printing...");
				g.inorder(g.getRoot());
				break;

			}
		}
		input.close();
	}

	/* Creates a new person based off of the information from the user
	 * @param name, bday are info from user to make a new person
	 * g is the GenericBST object to reference methods from that file
	 */
	public Person addPerson(String name, String bday, GenericBST g) {
		Person p = new Person(name, bday);
		Node<Person> newPerson = new Node<Person>();
		newPerson.setData(p);
		g.addPerson(newPerson, g.getRoot());

		return p;
	}
	/*
	 * @return p returns person to be added to the address book
	 */

	/*
	 * @param fullName is the full name to be deleted
	 * book is the address book to erase the user from
	 * g is the GenericBST object to reference methods from that file
	 */
	public ArrayList<Person> delete(String fullName, ArrayList<Person> book, GenericBST g) {
		for (int i = 0; i < book.size(); i++) {
			if (fullName.equalsIgnoreCase(book.get(i).getName())) {
				book.remove(i);
			}
		}
		g.construct(book);
		return book;
	}
	/*
	 * @return book returns book to be updated in the choice method.
	 */

	/*
	 * @param nameMod is full name of person to be modified
	 * newName is the new name of the person
	 * newDOB is the new DOB of the person
	 * book is the address book to be referenced
	 */
	public ArrayList<Person> modify(String nameMod, String newName, String newDOB, ArrayList<Person> book,
			GenericBST g) {
		for (int i = 0; i < book.size(); i++) {
			if (nameMod.equalsIgnoreCase(book.get(i).getName())) {
				Person newP = new Person(newName, newDOB);
				Node<Person> modPerson = new Node<Person>();
				modPerson.setData(newP);
				book.get(i).setName(newName);
				book.get(i).setBday(newDOB);
				g.addPerson(modPerson, g.getRoot());
			}
		}
		return book;
	}
	/*
	 * @return book is returned to update in the choice method
	 */

	/*
	 * @param searchName is the name to search existence of
	 * book is the address book to be referenced
	 */
	public boolean search(String searchName, ArrayList<Person> book) {
		for (int i = 0; i < book.size(); i++) {
			if (searchName.equalsIgnoreCase(book.get(i).getName())) {
				return true;
			}
		}
		return false;
	}
	/*
	 * @return true if person is found
	 * false if person is not found
	 */

	/*
	 * @param choice is the criteria to search by
	 * criteria is the value to search by
	 * g is the GenericBST object to reference methods from that file
	 */
	public void searchBy(int choice, String criteria, GenericBST g) {
		switch (choice) {
		case 1:
			//Searches for the first name via a criteria
			g.searchFirst(g.getRoot(), criteria);
			break;
		case 2:
			//Searches for the last name via a criteria
			g.searchLast(g.getRoot(), criteria);
			break;
		case 3:
			//Searches for the birth month via a criteria
			g.searchMonth(criteria, g.getRoot());
			break;
		case 4:
			//Searches for the birth day via a criteria
			g.searchDay(criteria, g.getRoot());
			break;
		case 5:
			//Searches for the birth year via a criteria
			g.searchYear(criteria, g.getRoot());
			break;

		}
	}
}
