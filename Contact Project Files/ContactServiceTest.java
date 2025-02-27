package com.mobileapp.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mobileapp.model.Contact;
import com.mobileapp.service.ContactService;

/**
 * Unit tests for the ContactService class (JUnit 5).
 */
public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        // Initialize ContactService before each test
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        // Test adding a new contact
        Contact contact = new Contact("12345", "Tope", "Ayeni", "6784567890", "114 Gravel St");
        contactService.addContact(contact);
        assertNotNull(contactService.getContacts().get("12345"));
    }

    @Test
    public void testAddDuplicateContact() {
        // Test adding a contact with a duplicate ID
        Contact contact = new Contact("12345", "Tope", "Ayeni", "4444456789", "123 Lump St"); // Fixed phone number
        contactService.addContact(contact);
        
        // Use assertThrows for exception testing
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact));
    }

    @Test
    public void testDeleteContact() {
        // Test deleting a contact
        Contact contact = new Contact("12345", "Peter", "Omaha", "2345667789", "12 Charl St"); // Fixed phone number
        contactService.addContact(contact);
        contactService.deleteContact("12345");

        // Ensure the contact is removed from the map
        assertFalse(contactService.getContacts().containsKey("12345"));
    }

    @Test
    public void testUpdateContact() {
        // Add a contact
        Contact contact = new Contact("12345", "Jude", "Saint", "1234599999", "123 Main St");
        contactService.addContact(contact);

        // Update the contact fields
        contactService.updateContact("12345", "Wales", "Yale", "0453556667", "456 Elm St"); // Fixed phone number

        // Verify the fields are updated correctly
        Contact updatedContact = contactService.getContacts().get("12345");
        assertEquals("Wales", updatedContact.getFirstName());
        assertEquals("Yale", updatedContact.getLastName());
        assertEquals("0453556667", updatedContact.getPhone());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }
}
