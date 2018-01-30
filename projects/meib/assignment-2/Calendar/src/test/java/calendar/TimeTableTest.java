package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {
	//add more unit tests as you needed

	/*
     * Testing getApptRange with getApptOccurences and GetNextApptoccurrence method
     */
	@Test
	public void test01() throws Throwable {
		TimeTable time = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();

		Appt appt1 = new Appt(1, 1, 1, 1, 1, "1", "1st appointment");
		Appt appt2 = new Appt(2, 2, 2, 2, 2, "2", "2nd appointment");
		Appt appt3 = new Appt(3, 3, 3, 3, 3, "3", "3rd appointment");
		Appt appt4 = new Appt(4, 4, 4, 4, 4, "4", "4th appointment");
		Appt appt5 = new Appt(5, 5, 5, 5, 5, "5", "5th appointment");

		LinkedList<Appt> List1 = new LinkedList<Appt>();
		List1.add(appt1);
		List1.add(appt2);
		List1.add(appt3);
		List1.add(appt4);
		List1.add(appt5);

		Appt appt7 = new Appt(7, 7, 7, 7, 7, "7", "7th appointment");
		LinkedList<Appt> ListAppts2 = new LinkedList<Appt>();
		ListAppts2.add(appt7);
		ListAppts2.add(appt2);

		Appt appt_invalid = new Appt(26, 1, 1, 1, 1, null, null);
		LinkedList<Appt> ListAppts3 = new LinkedList<Appt>();
		ListAppts3.add(appt_invalid);
		ListAppts3.add(appt2);

		int[] s = {0};

		Appt appt_recurMonthly = new Appt(2, 2, 11, 1, 4, "Monthly", "Monthly");
		appt_recurMonthly.setRecurrence(s, appt_recurMonthly.RECUR_BY_MONTHLY, 1, 2);
		LinkedList<Appt> ListAppts4 = new LinkedList<Appt>();
		ListAppts4.add(appt_recurMonthly);

		Appt appt_recurWeekly = new Appt(2, 2, 4, 1, 4, "Weekly", "Weekly");
		appt_recurWeekly.setRecurrence(s, appt_recurWeekly.RECUR_BY_WEEKLY, 1, 2);
		LinkedList<Appt> ListAppts5 = new LinkedList<Appt>();
		ListAppts5.add(appt_recurWeekly);

		Appt appt_recurYearly = new Appt(2, 2, 11, 2, 3, "Yearly", "Yearly");
		appt_recurYearly.setRecurrence(s, appt_recurYearly.RECUR_BY_YEARLY, 1, 2);
		LinkedList<Appt> ListAppts6 = new LinkedList<Appt>();
		ListAppts6.add(appt2);
		ListAppts6.add(appt_recurYearly);

		GregorianCalendar Day1 = new GregorianCalendar(1, 1, 1);
		GregorianCalendar Day2 = new GregorianCalendar(2, 2, 2);
		GregorianCalendar Day3 = new GregorianCalendar(4, 2, 12);

		try {
			calDays = time.getApptRange(List1, Day2, Day1);
			fail("Second date specified is not before the first date specified.");
		} catch (DateOutOfRangeException e) {
		}

		assertEquals(appt2, time.getApptRange(List1, Day2, Day3).get(0).appts.get(0));
		assertNotSame(appt7, time.getApptRange(ListAppts2, Day2, Day3).get(0).appts.get(0));
		assertNotSame(appt_invalid, time.getApptRange(ListAppts3, Day2, Day3).get(0).appts.get(0));
		assertEquals(appt_recurMonthly, time.getApptRange(ListAppts4, Day1, Day3).getLast().appts.get(0));

	}

	/*
     * Testing DeleteAppt method
     */
	@Test
	public void test02() throws Throwable {
		TimeTable time = new TimeTable();
		LinkedList<Appt> ApptList2 = new LinkedList<Appt>();

		Appt getApptRange1 = new Appt(12, 01, 01, 01, 2018, "Appointment 1", "The 1st Appointment");
		Appt getApptRange2 = new Appt(12, 01, 02, 02, 2019, "Appointment 2", "The 2st Appointment");
		Appt getApptRange3 = new Appt(12, 01, 03, 03, 2020, "Appointment 3", "The 3st Appointment");
		Appt getApptRange4 = new Appt(12, 01, 04, 04, 2021, "Appointment 4", "The 4st Appointment");
		Appt getApptRange5 = new Appt(12, 01, 05, 05, 2022, "Appointment 5", "The 5st Appointment");
		Appt getApptRange6 = new Appt(12, 01, 06, 06, 2023, "Appointment 6", "The 6st Appointment");
		Appt getApptRange7 = new Appt(12, 01, 07, 07, 2024, "Appointment 7", "The 7st Appointment");

		Appt invalid = new Appt(26, 01, 13, 01, 01, null, null);
		Appt apptNull2 = new Appt(6, 01, 13, 01, 01, null, null);
		Appt apptNull3 = new Appt(1, 01, 13, 01, 01, null, null);

		LinkedList<Appt> ApptList3 = new LinkedList<Appt>();

		ApptList3.add(getApptRange1);
		ApptList3.add(getApptRange2);
		ApptList3.add(getApptRange3);
		ApptList3.add(getApptRange4);
		ApptList3.add(getApptRange5);
		ApptList3.add(getApptRange6);
		ApptList3.add(getApptRange7);

		assertNull(time.deleteAppt(null, getApptRange1));
		assertNull(time.deleteAppt(ApptList3, null));
		assertNull(time.deleteAppt(ApptList3, invalid));
		assertNull(time.deleteAppt(ApptList3, apptNull2));

		try {
			apptNull3 = time.deleteAppt(ApptList3, getApptRange1).get(0);
			fail("Expecting Expection: NullPointerException");
		} catch (NullPointerException e) {
		}

	}

	/*
     * Testing permute method
     */
	@Test
	public void test03() throws Throwable {
		TimeTable time = new TimeTable();

		Appt appt1 = new Appt(12, 28, 13, 8, 2018, "Birthday", "My Birthday");
		LinkedList<Appt> appts = new LinkedList<Appt>();

		appts.add(appt1);
		appt1.setStartDay(12);

		appts.add(appt1);

		appt1.setStartDay(13);
		appts.add(appt1);

		// make sure that first day is before the last day.
		int[] inorder = {0, 1, 2};
		time.permute(appts, inorder);

	}
}
