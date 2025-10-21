package org.snhu.cs320.Task;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class TaskServiceTest {
	
	private TaskService service;
	
	@BeforeEach
	public void setUp() {
		service = new TaskService();
	}
	
	@Test
	public void SuccessfullAddTask() {
		Task t = new Task("001", "Name", "Desc");
		service.addTask(t);
		assertEquals(t, service.getTask("001"));
	}
	
	@Test
	public void DuplicateAddTaskThrows() {
		Task t1 = new Task("001", "Name", "Desc");
		Task t2 = new Task("001", "Name", "Desc");
		service.addTask(t2);
		assertThrows(IllegalArgumentException.class, () -> service.addTask(t1));
	}
	
	@Test
	public void InvalidAddTaskNullThrows() {
		assertThrows(IllegalArgumentException.class, () -> service.addTask(null));
	}
	
	@Test
	public void SuccessfullDeletTask() {
		Task t = new Task("001", "Name", "Desc");
		service.addTask(t);
		assertAll(
			() -> assertTrue(service.deleteTask("001")),
			() -> assertNull(service.getTask("001"))
		);	
	}
	
	@Test
	public void FailedDeleteTaskNotFound() {
		assertThrows(IllegalArgumentException.class, () -> service.deleteTask(null));
	}
	
	@Test
	public void SuccessfullUpdateTaskNameAndDescription() {
		Task t = new Task("001", "Name", "Desc");
		service.addTask(t);
		service.updateTask("001", "NewName", "NewDesc");
		Task updatedTask = service.getTask("001");
		assertAll(
			() -> assertEquals("NewName", updatedTask.getName()),
			() -> assertEquals("NewDesc", updatedTask.getDescription())
		);
	}
	
	@Test
	public void SuccessfullUpdateTaskOnlyName() {
		Task t = new Task("001", "name", "Desc");
		service.addTask(t);
		service.updateTask("001", "NewName", null);
		assertAll(
			() -> assertEquals("NewName", service.getTask("001").getName()),
			() -> assertEquals("Desc", service.getTask("001").getDescription())
		);
	}
	
	public void SuccessfullUpdateTaskDescOnly() {
		Task t = new Task("001", "name", "Desc");
		service.addTask(t);
		service.updateTask("001", null, "NewDesc");
		assertAll(
			() -> assertEquals("name", service.getTask("001").getName()),
			() -> assertEquals("NewDesc", service.getTask("001").getDescription())
		);
	}
	
	@Test
	public void InvalidUpdateTaskIdThrows() {
		assertAll(
				() -> assertThrows(IllegalArgumentException.class, () -> service.updateTask(null, "Name", "Desc")),
				() -> assertThrows(IllegalArgumentException.class, () -> service.updateTask("Incorrect", "Name", "Desc"))
			);
	}
	
	@Test
	public void InvalidUpdateTaskFieldsThrows() {
		Task t = new Task("001", "name", "desc");
		service.addTask(t);
		assertAll(
				() -> assertThrows(IllegalArgumentException.class, () -> service.updateTask("001", "N".repeat(21), null)),
				() -> assertThrows(IllegalArgumentException.class, () -> service.updateTask("001", null, "D".repeat(51)))
			);
	}
}
