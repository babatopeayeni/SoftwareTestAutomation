package com.mobileapp.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import com.mobileapp.model.Contact;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("12345", "John", "Doe", "1234567890", "23 Mark St");
    }

    @Test
    public void testContactCreation() {
        // Validate that the fields were set correctly
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("23 Mark St", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        // Use assertThrows for exception testing
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact(null, "John", "Doe", "1234567890", "13 Main St")
        );
    }

    @Test
    public void testSetters() {
        // Update contact fields
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Elm St");

        // Validate updates
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Elm St", contact.getAddress());
    }
}
