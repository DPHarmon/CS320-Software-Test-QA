package org.snhu.cs320.Appointment;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {
	
	/*
	 * Returns a Date 24 in the future from current date.
	 * Is used for creating appointments for test data that guarantees
	 * the appointmentDate is in the future.
	 * */
	private Date futureDate() {
		Calendar cal = Calendar.getInstance();
		 cal.add(Calendar.DAY_OF_YEAR, 1);
		return cal.getTime();
	}
	
	@Test
	void Successfull_Constructor_CreatesAppointment() {
		Date date = futureDate();
		Appointment ap = new Appointment("007", date, "desc");
		assertAll(
			() -> assertEquals("007", ap.getId()),
			() -> assertEquals("desc", ap.getDescription()),
			() -> assertEquals(date.getTime(), ap.getAppointmentDate().getTime())
		);
	}
	
	@Test
	void Constructor_NULLInvalid_Throws() {
		Date date = futureDate();
		String longID = "01234567890";
		assertAll(
			() -> assertThrows(IllegalArgumentException.class, () -> new Appointment(null, date, "desc")),
			() -> assertThrows(IllegalArgumentException.class, () -> new Appointment("   ", date, "desc")),
			() -> assertThrows(IllegalArgumentException.class, () -> new Appointment(longID, date, "desc"))
		);
	}
	
	@Test void constructor_NullOrPast_Date_Throws() {
		Date past = new Date(0);
		assertAll(
			() -> assertThrows(IllegalArgumentException.class, () -> new Appointment("007", null, "desc")),
			() -> assertThrows(IllegalArgumentException.class, () -> new Appointment("007", past, "desc"))
		);
	}
	
	@Test
	void constructor_NullOrInvalid_Desc_Throws() {
		Date date = futureDate();
		String longDesc = "d".repeat(51);
		assertAll(
			() -> assertThrows(IllegalArgumentException.class, () -> new Appointment("007", date, null)),
			() -> assertThrows(IllegalArgumentException.class, () -> new Appointment("007", date, "   ")),
			() -> assertThrows(IllegalArgumentException.class, () -> new Appointment("007", date, longDesc))
		);
	}
	@Test
	void getAppointmentDate_ReturnsDefensiveCopy() {
		Date date = futureDate();
		Appointment ap = new Appointment("007", date, "desc");
		Date returned = ap.getAppointmentDate();
		returned.setTime(0L); // should not mutate returned date
		assertNotEquals(0L, ap.getAppointmentDate().getTime());
	}
	
	@Test
	void setters_ValidInput_DoesNotThrow() {
		Date date = futureDate();
		Appointment ap = new Appointment("007", date, "desc");
		Date newDate = futureDate();
		
		assertAll(
		//Valid input should not throw
			() -> assertDoesNotThrow(() -> ap.setAppointmentDate(newDate)),
			() -> assertDoesNotThrow(() -> ap.setDescription("New Desc")),
		
		//Invalid input inputs should throw
			() -> assertThrows(IllegalArgumentException.class, () -> ap.setAppointmentDate(new Date(0))),
			() -> assertThrows(IllegalArgumentException.class, () -> ap.setAppointmentDate(null)),
			() -> assertThrows(IllegalArgumentException.class, () -> ap.setDescription(null)),
			() -> assertThrows(IllegalArgumentException.class, () -> ap.setDescription("   ")),
			() -> assertThrows(IllegalArgumentException.class, () -> ap.setDescription("d".repeat(51)))
		);
	}
	
	@Test
	void EqualsHash_basedOnID() {
		Date date = futureDate();
		Appointment ap1 = new Appointment("007", date, "descONE");
		Appointment ap2 = new Appointment("007", date, "descDOS");
		Appointment ap3 = new Appointment("006", date, "descONE");
		
		assertAll(
			() -> assertEquals(ap1, ap2),
			() -> assertEquals(ap1.hashCode(), ap2.hashCode()),
			() -> assertNotEquals(ap1, ap3)
		);
	}
}