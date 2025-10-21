package org.snhu.cs320.Appointment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {
	
	private AppointmentService service;
	
	@BeforeEach
	void setUp() {
		service = new AppointmentService();
	}
	
	private Date futureDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		return calendar.getTime();
	}
	
	@Test
	void addAppointment_NULL_Throws() {
		assertThrows(IllegalArgumentException.class, () -> service.addAppointment(null));
	}
	
	@Test 
	void addAppt_InvalidID_Throws() {
		Appointment ap = new Appointment("validID", futureDate(), "desc") {
			@Override
			public String getId() {return "";} // simulates bad ID
		};
		assertThrows(IllegalArgumentException.class, () -> service.addAppointment(ap));
	}
	@Test
	void addAppointment_duplicateID_Throws() {
		Appointment ap1 = new Appointment("007", futureDate(), "descONE");
		Appointment ap2 = new Appointment("007", futureDate(), "descDos");
		service.addAppointment(ap1);
		assertThrows(IllegalArgumentException.class, () -> service.addAppointment(ap2));
	}
	
	@Test
	void addAndGetAppointment_Successfull(){
		Appointment ap = new Appointment("007", futureDate(), "desc");
		service.addAppointment(ap);
		Appointment found = service.getAppointment("007");
		assertAll(
			() -> assertNotNull(found),
			() -> assertEquals("007", found.getId()),
			() -> assertEquals("desc", found.getDescription())
		);
		
	}
	
	@Test
	void getAppointment_missing_ReturnNull() {
		assertNull(service.getAppointment("missing"));
	}
	
	@Test
	void deleteAppt_InvalidID_Throws() {
		assertAll(
			() -> assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment(null)),
			() -> assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("   "))
		);
	}
	
	@Test
	void deleteAppointment_notFound_ThrowsNoSuch() {
		assertThrows(NoSuchElementException.class, () -> service.deleteAppointment("none"));
	}
	
	@Test
	void deleteAppt_Exists_Remove_Success() {
		Appointment ap = new Appointment("007", futureDate(), "desc");
		service.addAppointment(ap);
		assertAll(
			() -> assertNotNull(service.getAppointment("007")),
			() ->service.deleteAppointment("007"),
			() -> assertNull(service.getAppointment("007"))
		);
	}
}
