package org.yogocodes.guava.examples.collect;

public class Person {
	private String firstName;

	private String lastName;

	private int id;

	public Person(int id, String firstName, String lastName) {
		this.setId(id);
		this.firstName = firstName;
		this.setLastName(lastName);
		
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
