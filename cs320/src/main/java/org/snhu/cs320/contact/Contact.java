package org.snhu.cs320.contact;

import java.util.Objects;

public class Contact {
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		
		verifyId(id);
		verifyFirstName(firstName);
		verifyLastName(lastName);
		verifyPhone(phone);
		verifyAddress(address);
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address; 
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		verifyFirstName(firstName);
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		verifyLastName(lastName);
		this.lastName = lastName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		verifyPhone(phone);
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		verifyAddress(address);
		this.address = address;
	}


	public String getId() {
		return id;
	}
	
	private static void verifyId(String id) {
		//Id cannot be null, and cannot be more than 10 characters
		if (id == null || id.isBlank() || id.length() > 10 ) {
			throw new IllegalArgumentException("Id must contain characters and be no more than 10 characters long");
		}
	}
	
	private static void verifyFirstName(String firstName) {
		if (firstName == null || firstName.isBlank() || firstName.length() > 10 ) {
			throw new IllegalArgumentException("First Name must contain characters but no more than 30\"");
		}
	}
	
	private static void verifyLastName(String lastName) {
		if (lastName == null || lastName.isBlank() || lastName.length() > 10 ) {
			throw new IllegalArgumentException("Last Name must contain characters but no more than 30");
		}
	}
	
	private static void verifyPhone(String phone) {
		if (phone == null || !phone.matches("\\d{10}")) {
			throw new IllegalArgumentException("Id must contain characters and be no more than 10 characters long");
		}
	}
	
	private static void verifyAddress(String address) {
		if (address == null || address.isBlank() || address.length() > 30) {
			throw new IllegalArgumentException("Address must contain characters but no more than 30");
		}
	}
	
	/*
	 * 	Override to compare Appointment Objects by their unique ID
	 * 	- True if compared to itself
	 *  - False if the other object is null or not the Same
	 *  - Compares only the id fields
	 */
	@Override
	public boolean equals(Object c) {
		
		if (this == c) return true;
		if (c == null || getClass() != c.getClass()) return false;
		
		Contact that = (Contact) c;
		return id.equals(that.id);
	}
	/*
	 * 	Override hash to be consistent with equals by basing hash on the
	 *	id field. Ensuring correct behavior when Appointment Instances are used 
	 * 	with the HashMap.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
}
