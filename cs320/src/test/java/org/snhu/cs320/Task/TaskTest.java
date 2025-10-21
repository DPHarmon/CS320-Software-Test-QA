package org.snhu.cs320.Task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;




public class TaskTest {
	
	@Test
	public void constructorTaskCreationSuccess() {
		Task t = new Task("001", "Name", "Description");
		assertAll(
				() -> assertEquals("001", t.getId()),
				() -> assertEquals("Name", t.getName()),
				() -> assertEquals("Description", t.getDescription())
		);
	}
	
	@Test
	public void InvalidTaskIdThrows() {
		String idNull = null;
		String idLong = "12345678910";
		assertTrue(idLong.length() > 10);
		assertAll(
				() -> assertThrows(IllegalArgumentException.class, () -> new Task(idNull, "Name", "Desc")),
				() -> assertThrows(IllegalArgumentException.class, () -> new Task(idLong, "Name", "Desc")),
				() -> assertThrows(IllegalArgumentException.class, () -> new Task("   ", "Name", "Desc"))
				);
		
	}
	
	@Test
	public void InvalidNameThrows() {
		String longName = "asdhjgbauiysbgvdyvavbasduvbsdubvis"; // >20 Characters
		assertTrue(longName.length() > 20);
		assertAll(
				() -> assertThrows(IllegalArgumentException.class, () -> new Task("001", null, "Des")),
				() -> assertThrows(IllegalArgumentException.class, () -> new Task("001", longName, "Des")),
				() -> assertThrows(IllegalArgumentException.class, () -> new Task("001", "   ", "Des"))
				);
	}
	
	@Test
	public void InvalidDescriptionThrows() {
		String longDesc = "D".repeat(51); // >50.
		assertTrue(longDesc.length() > 50);
		assertAll(
				() -> assertThrows(IllegalArgumentException.class, () -> new Task("001", "Name", null)),
				() -> assertThrows(IllegalArgumentException.class, () -> new Task("001", "Name", longDesc)),
				() -> assertThrows(IllegalArgumentException.class, () -> new Task("001", "Name", "   "))
				);
	}
	
	@Test
	public void SuccessfullSetName() {
		Task t = new Task("001", "Name", "Desc");
		t.setName("newName");
		assertEquals("newName", t.getName());
	}
	
	@Test
	public void InvalidSetName() {
		Task t = new Task("001", "Name", "Desc");
		assertAll(
				// Catch if Name is null
				() -> assertThrows(IllegalArgumentException.class, () -> t.setName(null)),
				// Catch if Name is blank (whitespace)
				() -> assertThrows(IllegalArgumentException.class, () -> t.setName("  ")),
				// Catch if Name is to long
				() -> assertThrows(IllegalArgumentException.class, () -> t.setName("N".repeat(21)))
			);
	}
	
	@Test
	public void SuccessfullSetDescription() {
		Task t = new Task("001", "Name", "Desc");
		t.setDescription("newDesc");
		assertEquals("newDesc", t.getDescription());
	}
	
	@Test
	public void InvalidSetDescription() {
		Task t = new Task("001", "Name", "Desc");
		assertAll(
				// Catch null description
				() -> assertThrows(IllegalArgumentException.class, () -> t.setDescription(null)),
				//Catch Empty description (whitespace)
				() -> assertThrows(IllegalArgumentException.class, () -> t.setDescription(" ")),
				// Catch too long description
				() -> assertThrows(IllegalArgumentException.class, () -> t.setDescription("D".repeat(51)))
		);
		
	}
	
	@Test
	public void IdIsImmutable() {
		// Verify Id cannot be changed
		Task t = new Task("001", "Name", "Desc");
		// Confirmed there is not setId]
		t.setName("newName");
		t.setDescription("newDesc");
		// Verify id is unchanged
		assertEquals("001", t.getId());
	}
}
