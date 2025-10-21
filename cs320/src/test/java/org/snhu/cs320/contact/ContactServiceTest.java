package org.snhu.cs320.contact;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;


public class ContactServiceTest {
	
	private ContactService service;
	
	@BeforeEach
	void setUp() {
		service = new ContactService();
	}
	
	@Test
	public void testSuccessfullAddContact() {
		
		Contact c = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		service.addContact(c);
		assertEquals(c, service.getContact("001"));
		
		
	}
	
	@Test
	public void testAddContactNULLThrows() {
		assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
	}
	
	@Test
	public void testDuplicateAddContactThrows() {
		Contact c1 = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		Contact c2 = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		service.addContact(c1);
		assertThrows(IllegalArgumentException.class, () -> service.addContact(c2));
	}
	
	@Test
	public void testDeleteContactNullThrows() {
		assertThrows(IllegalArgumentException.class, () -> service.deleteContact(null));
	}
	
	@Test
	public void testSuccessfullContactDeletion() {
		
		Contact c = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		service.addContact(c);
		
		assertAll(
			() -> assertTrue(service.deleteContact(c.getId())),
			() -> assertNull(service.getContact(c.getId())),
			() -> assertThrows(IllegalArgumentException.class, () -> service.deleteContact(c.getId()))
		);
	}

	@Test
	public void testUpdateFirstNameSuccessfull() {
		
		Contact c = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		service.addContact(c);
		service.updateFirstName("001", "Willy");
		assertEquals("Willy", service.getContact("001").getFirstName());
		
	}
	
	@Test
	public void testUpdateFirstNameOnMissingContact() {
		assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("no-id", "Name"));
		
	}
	
	@Test
	public void testUpdateLastNameSuccessfull() {
		Contact c = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		service.addContact(c);
		service.updateLastName("001", "Thorton");
		Contact updatedLastName = service.getContact("001");
		
		assertEquals("Thorton",updatedLastName.getLastName());
		
	}
	
	@Test
	public void testUpdateLastNameOnMissingContact() {
		assertThrows(IllegalArgumentException.class, () -> service.updateLastName("no-id", "Name"));
		
	}
	
	@Test
	public void testUpdatePhoneSuccess() {
		Contact c = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		service.addContact(c);
		service.updatePhone("001", "3165464987");
		assertEquals("3165464987", service.getContact("001").getPhone());
		
	}
	
	@Test
	public void testUpdatePhoneOnMissingContact() {
		assertThrows(IllegalArgumentException.class, () -> service.updatePhone("001", "Phone"));
		
	}
	
	@Test
	public void testUpdateAddressSuccess() {
		Contact c = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		service.addContact(c);
		service.updateAddress("001", "1234 Main St");
		assertEquals("1234 Main St", service.getContact("001").getAddress());
	}
	
	@Test
	public void testUpdateAddressOnMissingContact() {
		assertThrows(IllegalArgumentException.class, () -> service.updateAddress("no-id", "Addy"));
		
	}
	
	@Test
	public void testGetContactReturnsNull() { //Returns null if contact missing
		assertEquals(null, service.getContact("no-id"));
		
	}
	
	@Test
	public void testUpdateContacSuccess() {
		Contact c = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		service.addContact(c);
		service.updateContact("001", "John", "Gwayne", "9315546852", "123 Home Ave");
		Contact cNew = new Contact("001", "John", "Gwayne", "9315546852", "123 Home Ave");
		assertAll(
				() -> assertEquals("John", cNew.getFirstName()),
				() -> assertEquals("Gwayne", cNew.getLastName()),
				() -> assertEquals("9315546852", cNew.getPhone()),
				() -> assertEquals("123 Home Ave", cNew.getAddress())
			);
	}
	
	@Test
	public void SuccessfulUpdateFirstNameOnly() {
		Contact c = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		service.addContact(c);
		service.updateContact("001", "John", null, null, null);
		Contact cNew = new Contact("001", "John", "Bob", "1234567890", "N 130 Market St");
		assertAll(
				() -> assertEquals("John", cNew.getFirstName()),
				() -> assertEquals("Bob", cNew.getLastName()),
				() -> assertEquals("1234567890", cNew.getPhone()),
				() -> assertEquals("N 130 Market St", cNew.getAddress())
			);
	}
	
	@Test
	public void SuccessfullUpdateLastNameOnly() {
		Contact c = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		service.addContact(c);
		service.updateContact("001", null, "Gwayne", null, null);
		Contact cNew = new Contact("001", "Billy", "Gwayne", "1234567890", "N 130 Market St");
		assertAll(
				() -> assertEquals("Billy", cNew.getFirstName()),
				() -> assertEquals("Gwayne", cNew.getLastName()),
				() -> assertEquals("1234567890", cNew.getPhone()),
				() -> assertEquals("N 130 Market St", cNew.getAddress())
			);
	}
	
	@Test
	public void SuccessfullUpdatePhoneOnly() {
		Contact c = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		service.addContact(c);
		service.updateContact("001", null, null, "9315546852", null);
		Contact cNew = new Contact("001", "Billy", "Bob", "9315546852", "N 130 Market St");
		assertAll(
				() -> assertEquals("Billy", cNew.getFirstName()),
				() -> assertEquals("Bob", cNew.getLastName()),
				() -> assertEquals("9315546852", cNew.getPhone()),
				() -> assertEquals("N 130 Market St", cNew.getAddress())
			);
	}
	
	@Test
	public void SuccessfullUpdateAddressOnly() {
		Contact c = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		service.addContact(c);
		service.updateContact("001", null, null, null, "123 Home Ave");
		Contact cNew = new Contact("001", "Billy", "Bob", "1234567890", "123 Home Ave");
		assertAll(
				() -> assertEquals("Billy", cNew.getFirstName()),
				() -> assertEquals("Bob", cNew.getLastName()),
				() -> assertEquals("1234567890", cNew.getPhone()),
				() -> assertEquals("123 Home Ave", cNew.getAddress())
			);
	}
	
	@Test
	public void testGetExistingPrivateHelper() {

		Contact c = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		service.addContact(c);
		assertAll(
			() -> assertThrows(IllegalArgumentException.class, () -> service.updateFirstName(null, "X")),
			() -> assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("no-id", "X"))
		);
	}
}
