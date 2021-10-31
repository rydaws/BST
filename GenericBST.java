package bst;

import java.util.ArrayList;


public class GenericBST {
	/*
	 * @author Ryan Dawson
	 * Date: 10/26/2021
	 * @version 1.0
	 */

	private Node<Person> root;
	

	public Node<Person> getRoot() {
		return root;
	}
	/*
	 * @return root returns the current root of the tree
	 */

	/*
	 * @param root is the root to be set
	 */
	public void setRoot(Node<Person> root) {
		this.root = root;
	}

	/*
	 * @param root is the root to be navigated through
	 */
	public void inorder(Node<Person> root) {
		if (root != null) {
			inorder(root.getLeft());
			System.out.print(root.getData().getName() + "\n");
			inorder(root.getRight());
		}
	}

	/*
	 * @param book is the address book to put into a tree
	 */
	public void construct(ArrayList<Person> book) {
		root = new Node<Person>(book.get(0));
		for (int i = 1; i < book.size(); i++) {
			Node<Person> person = new Node<Person>(book.get(i));
			addPerson(person, root);
		}
		inorder(root);
	}

	/*
	 * @param newPerson is the new person to be added to the tree
	 * workingNode is the node where the rest of the people are stored
	 */
	public void addPerson(Node<Person> newPerson, Node<Person> workingNode) {
		if (newPerson.getData().getName().charAt(0) < workingNode.getData().getName().charAt(0)) {
			if (workingNode.getLeft() == null) {
				workingNode.setLeft(newPerson);
			} else {
				addPerson(newPerson, workingNode.getLeft());
			}
		} else if (newPerson.getData().getName().charAt(0) > workingNode.getData().getName().charAt(0)) {
			if (workingNode.getRight() == null) {
				workingNode.setRight(newPerson);
			} else {
				addPerson(newPerson, workingNode.getRight());
			}
		} else if (newPerson.getData().getName().charAt(0) == workingNode.getData().getName().charAt(0)) {
			if (newPerson.getData().getName().charAt(1) < workingNode.getData().getName().charAt(1)) {
				if (workingNode.getLeft() == null) {
					workingNode.setLeft(newPerson);
				} else {
					addPerson(newPerson, workingNode.getLeft());
				}
			} else if (newPerson.getData().getName().charAt(1) > workingNode.getData().getName().charAt(1)) {
				if (workingNode.getRight() == null) {
					workingNode.setRight(newPerson);
				} else {
					addPerson(newPerson, workingNode.getRight());
				}
				
			}else if(newPerson.getData().getName().charAt(1) == workingNode.getData().getName().charAt(1)) {
				if (newPerson.getData().getName().charAt(2) < workingNode.getData().getName().charAt(2)) {
					if (workingNode.getLeft() == null) {
						workingNode.setLeft(newPerson);
					} else {
						addPerson(newPerson, workingNode.getLeft());
					}
				} else if (newPerson.getData().getName().charAt(2) > workingNode.getData().getName().charAt(2)) {
					if (workingNode.getRight() == null) {
						workingNode.setRight(newPerson);
					} else {
						addPerson(newPerson, workingNode.getRight());
					}
				}
			}
		}
	}
	/*
	 * @param current is the current person to search for
	 * fname is the first name of the person to search by
	 */
	public void searchFirst(Node<Person> current, String fname) {
		String[] onlyFirst;
		if (current != null) {
			onlyFirst = current.getData().getName().split(" ");
			searchFirst(current.getLeft(), fname);
			if(onlyFirst[0].equalsIgnoreCase(fname)) {
				System.out.println("Person found: " + current.getData().getName() +  " " + current.getData().getBday());
			}
			searchFirst(current.getRight(), fname);
		}
		
	}
	/*
	 * @param current is the current person to search for
	 * lname is the last name of the person to search by
	 */
	public void searchLast(Node<Person> current, String lname) {
		String[] onlyLast;
		if (current != null) {
			onlyLast = current.getData().getName().split(" ");
			searchLast(current.getLeft(), lname);
			if(onlyLast[1].equalsIgnoreCase(lname)) {
				System.out.println("Person found: " + current.getData().getName() +  " " + current.getData().getBday());
			}
			searchLast(current.getRight(), lname);
		}
		
	}
	/*
	 * @param current is the current person to search for
	 * day is the birth day of the person to search by
	 */
	public void searchDay(String day, Node<Person> current) {
		if(current != null) {
			searchDay(day, current.getLeft());
			if(day.equals(current.getData().getBday().substring(3, 5))) {
				System.out.println("Person found: " + current.getData().getName() +  " " + current.getData().getBday());
			}
			searchDay(day, current.getRight());
		}
	}
	/*
	 * @param current is the current person to search for
	 * month is the birth month of the person to search by
	 */
	public void searchMonth(String month, Node<Person> current) {
		if(current != null) {
			searchMonth(month, current.getLeft());
			if(month.equals(current.getData().getBday().substring(0, 2))) {
				System.out.println("Person found: " + current.getData().getName() +  " " + current.getData().getBday());
			}
			searchMonth(month, current.getRight());
		}
	}
	/*
	 * @param current is the current person to search for
	 * year is the birth year of the person to search by
	 */
	public void searchYear(String year, Node<Person> current) {
		if(current != null) {
			searchYear(year, current.getLeft());
			if(year.equals(current.getData().getBday().substring(6, 10))) {
				System.out.println("Person found: " + current.getData().getName() +  " " + current.getData().getBday());
			}
			searchYear(year, current.getRight());
		}
	}
	
}
