package bst;

public class Person {
	/*
	 * @author Ryan Dawson
	 * Date: 10/26/2021
	 * @version 1.0
	 */

	private String name;
	private String bday;
	
	/*
	 * @param name is the name of the person in the object
	 * bday is the birthday of the person in the object
	 */
	public Person(String name, String bday) {
		this.name = name;
		this.bday = bday;
	}

	public String getName() {
		return name;
	}
	/*
	 * @return returns name of person
	 */

	/*
	 * @param name is the name to set of the new person object
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getBday() {
		return bday;
	}
	/*
	 * @return bday returns the birthday of the person object
	 */

	/*
	 * @param bday sets a new birthday of the person object
	 */
	public void setBday(String bday) {
		this.bday = bday;
	}
}
