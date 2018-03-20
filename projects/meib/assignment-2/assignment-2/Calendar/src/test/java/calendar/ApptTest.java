package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test01()  throws Throwable  {
		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		// assertions
		assertTrue(appt.getValid());
		assertEquals(21, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());
	}

	/*
	 * Testing sets, gets for appointment
	 */
	@Test
	public void test02()  throws Throwable  {
		int startHour = 12;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = null;
		String description = null;
		//make a new Appointment object with the initial data
		Appt appt = new Appt(15, 00, 01, 01, 2018, "Exam", "This is a exam day");

		//change the appointment member variables.
		appt.setStartHour(startHour);
		appt.setStartMinute(startMinute);
		appt.setStartDay(startDay);
		appt.setStartMonth(startMonth);
		appt.setStartYear(startYear);
		appt.setTitle(title);
		appt.setDescription(description);

		// asserting the getting appointment
		assertTrue(appt.getValid());
		assertEquals(12, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("", appt.getTitle());
		assertEquals("", appt.getDescription());
	}

//add more unit tests as you needed

	/*
	 * Testing isValid Method
	 */
	@Test
	public void test03() throws Throwable {
		Appt isValid = new Appt(12, 00,13, 8,2018, "My Birthday", "This is My Birthday");
		Appt isValid1 = new Appt(12, 00,11, 01, 2018, "My Brother Birthday", "This is My Brother Birthday");
		Appt isValid2 = new Appt(12, 00,13, 8,1994, "The Year I Born", "This is The Year I Born");
		Appt isValid3 = new Appt(-1, 1,1, 1,1, "", "");
		Appt isValid4 = new Appt(24, 1,1, 1,1, "", "");
		Appt isValid5 = new Appt(1, 60,1, 1,1, "", "");
		Appt isValid6 = new Appt(1, 1,-1, 1,1, "", "");
		Appt isValid7 = new Appt(1, 1,33, 1,1, "", "");
		Appt isValid8 = new Appt(1, -1,1, 1,1, "", "");

		assertEquals(true, isValid.getValid());
		assertEquals(true, isValid1.getValid());
		assertEquals(true, isValid2.getValid());
		assertEquals(false, isValid3.getValid());
		assertEquals(false, isValid4.getValid());
		assertEquals(false, isValid5.getValid());
		assertEquals(false, isValid6.getValid());
		assertEquals(false, isValid7.getValid());
		assertEquals(false, isValid8.getValid());
		//Doesn't test Title and Description.
	}

	/*
   * Testing representationApp method
   */
	@Test
	public void test04() throws Throwable {
		Appt apptRepresentation = new Appt(12, 30, 13, 8, 2018, "My Birthday", "Its My Birthday This Year.");
		String stringRepresentation = "\t" + 8 + "/" + 13 + "/" + 2018 + " at " + 12 + ":" + 30 + "pm" + " ," + "My Birthday" + ", " + "Its My Birthday This Year." + "\n";

		Appt apptRepresentation1 = new Appt(0, 30, 12, 01, 2018, "My Birthday", "Its My Birthday This Year.");
		String stringRepresentation1 = "\t" + 01 + "/" + 12 + "/" + 2018 + " at " + 12 + ":" + 30 + "am" + " ," + "My Birthday" + ", " + "Its My Birthday This Year." + "\n";

		Appt apptRepresentation2 = new Appt(21, 30, 15, 01, 2018, "My Birthday", "Its My Birthday This Year.");
		String stringRepresentation2 = "\t" + 01 + "/" + 15 + "/" + 2018 + " at " + 9 + ":" + 30 + "pm" + " ," + "My Birthday" + ", " + "Its My Birthday This Year." + "\n";

		assertEquals(stringRepresentation, apptRepresentation.toString());
		assertEquals(stringRepresentation1, apptRepresentation1.toString());
		assertEquals(stringRepresentation2, apptRepresentation2.toString());

	}

	/*
	 * Testing CompareTo method
	 */
	@Test
	public void test05() throws Throwable {
		Appt apptCompare = new Appt(12, 00, 13, 8, 2018, "My Birthday", "Its is My Birthday This Year.");
		Appt apptCompare1 = new Appt(12, 00, 13, 8, 2018, "My Birthday", "Its is My Birthday This Year.");
		Appt apptCompare2 = new Appt(1, 1, 1, 1, 1, "", "");
		Appt apptCompare3 = new Appt(0, 1, 1, 1, 1, "", "");

		assertEquals(0, apptCompare.compareTo(apptCompare1));
		assertEquals(1, apptCompare2.compareTo(apptCompare3));
	}

}


