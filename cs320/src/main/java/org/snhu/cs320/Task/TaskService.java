package org.snhu.cs320.Task;


import java.util.HashMap;
import java.util.Map;


public class TaskService {
	
	//Use HashTable/HashMap to store task objects
	private final Map<String, Task> tasks = new HashMap<>();
	
	/*	Verify object is not null, verify object is not repeated, add to Hash		*/
	public void addTask(Task task) {
		if (task == null) throw new IllegalArgumentException("Task is empty");
		String id = task.getId();
		if (tasks.containsKey(id)) {
			throw new IllegalArgumentException("Task ID already Exists");
		}
		tasks.put(id, task);
	}
	
	public boolean deleteTask(String id) {
		if (id == null) throw new IllegalArgumentException("Id is empty");
		return tasks.remove(id) != null;
	}
	
	/*	Update name and/or description	
	 * @Param: Id, desired name, desired description
	 * 
	 * If updateName or updateDescription is null, object will be unchanged
	 * */
	public void updateTask(String id, String updateName, String updateDescription) {
		if (id == null) throw new IllegalArgumentException("Id is empty");
		Task task = tasks.get(id);
		if (task == null) {
			throw new IllegalArgumentException("Task not found");
		}
		
		if (updateName != null) {
			task.setName(updateName);
		}
		if (updateDescription != null) {
			task.setDescription(updateDescription);
		}
	}
	
	public Task getTask(String id) {
		return tasks.get(id);
	}
}
