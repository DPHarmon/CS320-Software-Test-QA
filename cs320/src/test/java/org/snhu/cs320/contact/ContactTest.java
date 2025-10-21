package org.snhu.cs320.contact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ContactTest {
	

	@Test
	public void ValidContactCreation() {
		Contact c = new Contact ("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		assertAll(
			() -> assertEquals("001", c.getId()),
			() -> assertEquals("Billy", c.getFirstName()),
			() -> assertEquals("Bob", c.getLastName()),
			() -> assertEquals("1234567890", c.getPhone()),
			() -> assertEquals("N 130 Market St", c.getAddress())
		);
	}
	
	
	@Test
	public void InvalidContactIdThrows() {
	String idIsNull = null;
	String idTooLong = "01234567890";
	
	assertAll(
			() -> assertThrows(IllegalArgumentException.class, () -> new Contact(idIsNull, "Billy", "Bob", "1234567890", "N 130 Market St")),
			() -> assertThrows(IllegalArgumentException.class, () -> new Contact(idTooLong, "Billy", "Bob", "1234567890", "N 130 Market St")),
			() -> assertThrows(IllegalArgumentException.class, () -> new Contact("    ", "Billy", "Bob", "1234567890", "N 130 Market St"))
			);
	}
	
	
	@Test
	public void FirstNameInvalidThrows() {
		String nameNull = null;
		String nameLong = "ABCDEFGHIJKL";
		
		assertAll(
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact("001", nameNull, "Bob", "1234567890", "N 130 Market St")),
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact("001", nameLong, "Bob", "1234567890", "N 130 Market St")),
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact("001", "   ", "Bob", "1234567890", "N 130 Market St"))
				);
	}
	public void LastNameInvalidThrows() {
		String nameNull = null;
		String nameLong = "ABCDEFGHIJKL";
		assertTrue(nameLong.length() > 10);
		
		assertAll(
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact("001", "Billy", nameNull, "1234567890", "N 130 Market St")),
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact("001", "Billy", nameLong, "1234567890", "N 130 Market St")),
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact("001", "Billy", "   ", "1234567890", "N 130 Market St"))
				);
	}
	
	public void PhoneInvalidThrows() {
		String phoneNull = null;
		String phoneTest9Digits = "123456789";
		String phoneTest11Digits= "12345678900";
		String phoneNotDigit = "12345abcde";
		
		assertAll(
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact("001", "Billy", "Bob", phoneNull, "N 130 Market St")),
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact("001", "Billy", "Bob", phoneTest9Digits, "N 130 Market St")),
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact("001", "Billy", "Bob", phoneTest11Digits, "N 130 Market St")),
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact("001", "Billy", "Bob", phoneNotDigit, "N 130 Market St"))
				);
	}

	public void AddressInvalidThrows() {
		String addressNull = null;
		String AddressLong = "a".repeat(31);
		
		assertAll(
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact("001", "Billy", "Bob", "1234567890", addressNull)),
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact("001", "Billy", "Bob", "1234567890", "   ")),
				() -> assertThrows(IllegalArgumentException.class, () -> new Contact("001", "Billy", "Bob", "1234567890", AddressLong))
				);
	}
	
	@Test
	public void ValidSetterUpdate() {
		Contact c = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		c.setFirstName("John");
		c.setLastName("Stockton");
		c.setPhone("3166465585");
		c.setAddress("1234 Main St");
		
		assertAll(
			() -> assertEquals("John", c.getFirstName()),
			() -> assertEquals("Stockton", c.getLastName()),
			() -> assertEquals("3166465585", c.getPhone()),
			() -> assertEquals("1234 Main St", c.getAddress())
		);
	}
	
	@Test
	public void SettersThrowWhenInvalid() {
		Contact c = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		String tooLong = "ABFASHJFBSDFIBSIDFS46484SDFJSBGDF";
		
		assertAll(
			() -> assertThrows(IllegalArgumentException.class, () -> c.setFirstName(null)),
			() -> assertThrows(IllegalArgumentException.class, () -> c.setFirstName(" ")),
			() -> assertThrows(IllegalArgumentException.class, () -> c.setFirstName("01234567890")),
			() -> assertThrows(IllegalArgumentException.class, () -> c.setLastName(null)),
			() -> assertThrows(IllegalArgumentException.class, () -> c.setLastName(" ")),
			() -> assertThrows(IllegalArgumentException.class, () -> c.setLastName("01234567890")),
			() -> assertThrows(IllegalArgumentException.class, () -> c.setPhone(null)),
			() -> assertThrows(IllegalArgumentException.class, () -> c.setPhone("123")),
			() -> assertThrows(IllegalArgumentException.class, () -> c.setPhone("phonexxxxx")),
			() -> assertThrows(IllegalArgumentException.class, () -> c.setAddress(null)),
			() -> assertThrows(IllegalArgumentException.class, () -> c.setAddress(" ")),
			() -> assertThrows(IllegalArgumentException.class, () -> c.setAddress(tooLong))
		);
	}
	
	@Test 
	public void EqualsHashBasedOnId() {
		Contact C1 = new Contact("001", "Billy", "Bob", "1234567890", "N 130 Market St");
		Contact C2 = new Contact("001", "John", "Wayne", "1234567890", "N 130 Market St");
		Contact C3 = new Contact("007", "Billy", "Bob", "1234567890", "N 130 Market St");
		
		assertAll(
				() -> assertEquals(C1, C2),
				() -> assertEquals(C1.hashCode(), C2.hashCode()),
				() -> assertNotEquals(C1,C3)
				);
	}
}

