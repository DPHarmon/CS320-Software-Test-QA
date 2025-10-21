package org.snhu.cs320.Appointment;

import java.util.Date;
import java.util.Objects;


public class Appointment {
	
	/*	Reminder (Personal) private final for  initialization per instance
	 * Cannot be changed. - Unique ID per object							*/
	private final String id; 
	private Date appointmentDate;
	private String description;
	
	// Public Constructor
	public Appointment(String id, Date appointmentDate, String description) {
		
		verifyId(id);
		verifyAppointmentDate(appointmentDate);
		verifyDescription(description);
		
		this.id = id;
		this.appointmentDate = new Date(appointmentDate.getTime());
		this.description = description;
	}
	
	// Verify Variables fit parameters prior to setting
	private static void verifyId(String id) {
		if (id == null || id.isBlank() || id.length() > 10) {
			throw new IllegalArgumentException("ID must not be whitespace, and must contain"
					+ "at most 10 characters.");
		}
	}
	
	private static void verifyAppointmentDate(Date appointmentDate) {
		if (appointmentDate == null || appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Appointment Date must not be in the past.");
		}
	}
	
	private static void verifyDescription(String description) {
		if (description == null || description.isBlank() || description.length() > 50) {
			throw new IllegalArgumentException("Description must not be blank and be at most"
					+ "50 characters.");
		}
	}
	
	//Getter no Setter for ID
	public String getId() {
		return id;
	}
	
	//Getter and Setter for Appointment Date
	public Date getAppointmentDate() {
		return new Date(appointmentDate.getTime());
	}
	
	public void setAppointmentDate(Date appointmentDate) {
		verifyAppointmentDate(appointmentDate);
		this.appointmentDate = appointmentDate;
	}
	
	// Setters and Getters for Description
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		verifyDescription(description);
		this.description = description;
	}
	
	/*
	 * 	Override to compare Appointment Objects by their unique ID
	 * 	- True if compared to itself
	 *  - False if the other object is null or not the Same
	 *  - Compares only the id fields
	 */
	@Override
	public boolean equals(Object a) {
		
		if (this == a) return true;
		if (a == null || getClass() != a.getClass()) return false;
		
		Appointment that =  (Appointment) a;
		return id.equals(that.id);
	}
	
	/*
	 * 	Override hash to be consistent with equals by basing hash on the
	 *	id field. Ensuring correct behavior when Appointment Instances are used 
	 * 	with the HashMap.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
}
