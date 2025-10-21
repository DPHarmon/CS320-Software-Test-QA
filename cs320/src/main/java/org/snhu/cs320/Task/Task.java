package org.snhu.cs320.Task;



public class Task {
	
	private final String id;
	private String name;
	private String description;
	
	//Constructor
	public Task(String id, String name, String description) {
		validateId(id);
		validateName(name);
		validateDescription(description);
		
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	private void validateId(String id) {
		// ID cannot be null, and must not exceed 10 characters
		if (id == null || id.isBlank() || id.length() > 10) {
			throw new IllegalArgumentException("Invalid Id");
		}
	}
	
	private void validateName(String name) {
		//Name cannot be null, and must not exceed 20 characters
		 if (name == null || name.isBlank() || name.length() > 20) {
			throw new IllegalArgumentException("Invalid Name") ;
		}
	}
	
	private void validateDescription(String description) {
		// Description must not be null, and must not exceed 50 Characters
		if (description == null || description.isBlank() || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		validateName(name);
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		validateDescription(description);
		this.description = description;
	}

	public String getId() {
		return id;
	}
	
	
}

