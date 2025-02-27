package com.mobileapp.service;

import java.util.HashMap;
import java.util.Map;

import com.mobileapp.model.Contact;

/**
 * Service for managing Contact objects in an in-memory data structure.
 */
public class ContactService {
	private final Map<String, Contact> contacts = new HashMap<>(); // Stores contacts by their unique ID

	/**
	 * Adds a new contact to the service. Ensures the contact ID is unique.
	 */
	public void addContact(Contact contact) {
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID already exists");
		}
		contacts.put(contact.getContactId(), contact);
	}

	/**
	 * Deletes a contact by its unique ID.
	 */
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID does not exist");
		}
		contacts.remove(contactId);
	}

	/**
	 * Updates specific fields of an existing contact by its ID. Fields to update:
	 * firstName, lastName, phone, and address.
	 */
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		// Check if contactId exists
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID not found.");
		}

		// Validate input parameters
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name.");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name.");
		}
		if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
			throw new IllegalArgumentException("Invalid phone number.");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address.");
		}

		// contact fields updater
		Contact contact = contacts.get(contactId);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setPhone(phone);
		contact.setAddress(address);
	}

	/**
	 * Returns every stored contacts.
	 */
	public Map<String, Contact> getContacts() {
		return contacts;
	}
}
