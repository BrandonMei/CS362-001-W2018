package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;


import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import java.util.LinkedList;
import java.util.Calendar;
import org.junit.Test;

public class CalDayTest {

	//add more unit tests as you needed

	@Test
	public void test01()  throws Throwable  {
		int year;
		int month;
		int day;
		int startHour = 12;
		int startMinute = 30;
		int startDay = 13;
		int startMonth = 8;
		int startYear = 2018;
		String title = "My Birthday";
		String description = "This is My Birthday.";
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH)+1;
		day = cal.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar gregCal = new GregorianCalendar(year,month,day);
		CalDay calDay = new CalDay(gregCal);
		CalDay calDay2 = new CalDay();

		//Construct a new Appointment object with the initial data
		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		Appt appt2 = new Appt( 23,1,1,1,1,"Birthday","A Birthday");

		calDay.addAppt(appt1);
		assertEquals(1, calDay.getSizeAppts());
		calDay.addAppt(appt2);
		assertEquals(2, calDay.getSizeAppts());
		assertEquals(null, calDay2.iterator());

		// returns a string representation of the date represented in a format.
		StringBuilder sb = new StringBuilder();
		String todayDate = month + "/" + day + "/" + year;
		sb.append("\t --- " + todayDate + " --- \n");
		sb.append(" --- -------- Appointments ------------ --- \n");
		Iterator<Appt> iterator = calDay.appts.iterator();
		while(iterator.hasNext())
		{
			Object element = iterator.next();
			sb.append(element + " ");
		}
		//sb.append(this.appts);
		sb.append("\n");
		assertNotEquals(sb.toString(),calDay.toString());

	}


	@Test
	public void test02()  throws Throwable  {
		int month;
		int day;
		int year;
		Calendar cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH)+1;
		day = cal.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar gregCal = new GregorianCalendar(year,month,day);
		CalDay calDay = new CalDay(gregCal);
		Appt appt1 = new Appt(23,1,1,1,1,"Birthday","A Birthday");
		calDay.addAppt(appt1);
		calDay.iterator();
		Iterator<Appt> iterator = calDay.appts.iterator();
		assertTrue(iterator.hasNext());

		Appt appt2 = new Appt(25,1,1,1,1,"Birthday","A Birthday");
		calDay.addAppt(appt2);
		assertEquals(1, calDay.getSizeAppts());

		Appt appt3 = new Appt(23,5,5,5,5,"Birthday","A Birthday");
		calDay.addAppt(appt3);
		assertEquals(2, calDay.getSizeAppts());
	}

	/*
	 * Testing toString() method
	 */
	@Test
	public void test03()  throws Throwable {
		int startHour = 23;
		int startMinute = 11;
		int startDay = 1;
		int startMonth = 1;
		int startYear = 2018;
		String title = " My Birthday";
		String description = "A Birthday.";
		GregorianCalendar gregorianCal = new GregorianCalendar(1,1,1);
		CalDay calendarDay1 = new CalDay(gregorianCal);
		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		Appt appt2 = new Appt(10,11,1,1,2018," My Birthday","A Birthday");
		calendarDay1.addAppt(appt1);
		calendarDay1.addAppt(appt2);
		assertEquals(appt2, calendarDay1.getAppts().get(0));
	}
}
