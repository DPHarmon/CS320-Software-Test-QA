package org.snhu.cs320.contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

	private final Map<String, Contact> contacts = new HashMap<>();
	
	public void addContact(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("Contact must not be empty");
		}
		String id = contact.getId();
		if (contacts.containsKey(id)) {
			throw new IllegalArgumentException("Contact ID already exists");
		}
		contacts.put(id, contact);
	}
	
	public boolean deleteContact(String contactId) {
		if (contactId == null || !contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact not found");
		}
		return contacts.remove(contactId) != null;
	}
	
	public void updateFirstName(String contactId, String firstName) {
		Contact c = getExisting(contactId);
		c.setFirstName(firstName);
	}
	
	public void updateLastName(String contactId, String lastName) {
		Contact c = getExisting(contactId);
		c.setLastName(lastName);
	}
	
	public void updatePhone(String contactId, String phone) {
		Contact c = getExisting(contactId);
		c.setPhone(phone);
	}
	
	public void updateAddress(String contactId, String address) {
		Contact c = getExisting(contactId);
		c.setAddress(address);
	}
	
	public Contact getContact(String contactId) {
		return contacts.get(contactId);
	}
	
	// Added method to update contact all at once
	// For future UI implementation
	/*	Takes ID and updated info, if left null variable will not be changed	*/
	public void updateContact(String id, String updateFName, String updateLName, String updatePhone, String updateAddress) {
		if (id == null) throw new IllegalArgumentException("ID must not be null or empty");
		Contact c = contacts.get(id);
		if (c == null) {
			throw new IllegalArgumentException("Contact not found");
		}
		if (updateFName != null) {
			c.setFirstName(updateFName);
		}
		if (updateLName != null) {
			c.setLastName(updateLName);
		}
		if (updatePhone != null) {
			c.setPhone(updatePhone);
		}
		if (updateAddress != null) {
			c.setAddress(updateAddress);
		}
	}
	
	private Contact getExisting(String contactId) {
		if (contactId == null || !contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact not found");
		}
		return contacts.get(contactId);
	}
	
	

	
}
