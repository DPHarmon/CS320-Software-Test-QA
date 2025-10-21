package org.snhu.cs320.Appointment;



import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


public class AppointmentService {
	
	private final Map<String, Appointment> appointments = new HashMap<>();
	
	/*	(Personal Reminder) synchronized ensures only one thread can execute method at a time.
	 * Verifies Date is not double booked. 													*/
	public synchronized void addAppointment(Appointment appointment) {
		if (appointment == null) {
			throw new IllegalArgumentException();
		}
		String id = appointment.getId();
		if (id == null || id.isBlank()) {
			throw new IllegalArgumentException("ID must not be null and cannot be comprised of"
					+ "blank space");
		}
		if (appointments.containsKey(id)) { 
			throw new IllegalArgumentException("ID MUST be Unique; ID already exists");
		}
		appointments.put(id, appointment);
	}
	
	public synchronized void deleteAppointment(String id) {
		if (id == null || id.isBlank()) {
			throw new IllegalArgumentException("ID must not be null or blank");
		}
		if (appointments.remove(id) == null) { 
			throw new NoSuchElementException("Appointment ID not found");
		}
	}
	
	public synchronized Appointment getAppointment(String id) {
		return appointments.get(id);
	}
	
			
}
