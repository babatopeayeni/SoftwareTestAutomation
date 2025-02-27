package com.mobileapp.model;

/**
 * Represents a Contact object with unique ID, name, phone, and address.
 */
public class Contact {
	private final String contactId; // Unique ID for the contact
	private String firstName; // first name
	private String lastName; // last name

	private String phone; // phone number (10 digits)
	private String address; // address

	/**
	 * Constructor for creating a new Contact object. Validates all input parameters
	 * according to the requirements.
	 */
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		// Validate contact ID
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		// Validate first name
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		// Validate last name
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		// Validate phone number
		if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		// Validate address
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}

		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	// Getter contact ID
	public String getContactId() {
		return contactId;
	}

	// Getter n setter for first name
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}

	// Getter n setter for last name
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}

	// Getter n setter for phone number
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phone = phone;
	}

	// Getter n setter for address
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}
}
