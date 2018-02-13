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
        int startHour = 21;
        int startMinute = 30;
        int startDay = 15;
        int startMonth = 01;
        int startYear = 2018;
        String title = "Birthday Party";
        String description = "This is my birthday party.";
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
        Appt apptCompare = new Appt(12, 10, 13, 8, 2018, "My Birthday", "Its is My Birthday This Year.");
        Appt apptCompare1 = new Appt(12, 10, 13, 8, 2018, "My Birthday", "Its is My Birthday This Year.");
        Appt apptCompare2 = new Appt(1, 1, 1, 1, 1, "", "");
        Appt apptCompare3 = new Appt(0, 1, 1, 1, 1, "", "");

        assertEquals(0, apptCompare.compareTo(apptCompare1));
        assertEquals(1, apptCompare2.compareTo(apptCompare3));
        assertEquals(apptCompare.toString(),apptCompare1.toString());
    }

    // Mutation Coverage Test
    // SetRecurrence
    @Test
    public void test06() throws Throwable {
        int startHour = 12;
        int startMinute = 30;
        int startDay = 13;
        int startMonth = 01;
        int startYear = 2018;
        String title = "Birthday Party";
        String description = "This is my birthday party.";

        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        Appt appt1 = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        int recurDays[]={3,4,5};
        int recurBy = 4;
        int recurIncrement = 3;
        int recurNumber = 5;
        appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);

        assertEquals(5,appt.getRecurNumber());
        assertEquals(4,appt.getRecurBy());
        assertEquals(3,appt.getRecurIncrement());

        assertTrue(appt.isRecurring());

        recurNumber=0;
        appt.setRecurrence(recurDays, recurBy, recurIncrement, recurNumber);
        assertFalse(appt.isRecurring());
        assertEquals(appt1.toString(),appt.toString());
        assertNotEquals("test",appt.toString());
        assertEquals(recurDays, appt.getRecurDays());
    }

    @Test
    public void test07()  throws Throwable  {
        int startHour=24;
        int startMinute=60;
        int startDay=32;
        int startMonth=02;
        int startYear=2018;
        String title=null;
        String description=null;
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(15, 00, 01, 01, 2018, "New Years Party", "This is the New Years day");
        assertTrue(appt.getValid());

        appt.setStartHour(startHour);
        assertFalse(appt.getValid());
        assertEquals(24, appt.getStartHour());
        appt.setStartHour(15);

        appt.setStartMinute(startMinute);
        assertFalse(appt.getValid());
        assertEquals(60, appt.getStartMinute());
        appt.setStartMinute(00);

        appt.setStartDay(startDay);
        assertEquals(32, appt.getStartDay());
        appt.setStartDay(29);
        appt.setStartMonth(startMonth);
        assertEquals(02, appt.getStartMonth());


        appt.setStartYear(startYear);
        assertEquals(2018, appt.getStartYear());
        assertTrue(appt.getValid());

        appt.setTitle(title);
        assertEquals("", appt.getTitle());

        appt.setDescription(description);
        assertEquals("", appt.getDescription());

    }

    // test recurrence
    @Test
    public void test08() throws Throwable {
        int startHour=21;
        int startMinute=31;
        int startDay=15;
        int startMonth=02;
        int startYear=2018;
        String title="Birthday Party";
        String description="This is my birthday party.";
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        int[] recurDaysArr = {1};

        appt.setRecurrence(recurDaysArr, appt.RECUR_BY_WEEKLY, 2, 1000);

        appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        assertEquals(0,appt.getRecurNumber());
        assertEquals(2,appt.getRecurBy());
        assertEquals(0,appt.getRecurIncrement());

        assertFalse(appt.isRecurring());

        // assertions
        assertTrue(appt.getValid());
        assertEquals(21, appt.getStartHour());
        assertEquals(31, appt.getStartMinute());
        assertEquals(15, appt.getStartDay());
        assertEquals(02, appt.getStartMonth());
        assertEquals(2018, appt.getStartYear());
        assertEquals("Birthday Party", appt.getTitle());
        assertEquals("This is my birthday party.", appt.getDescription());

    }
    // test valid
    @Test
    public void test09() throws Throwable {
        int startHour = 12;
        int startMinute = 30;
        int startDay = 15;
        int startMonth = 02;
        int startYear = 2018;
        String title = "Birthday Party";
        String description = "This is my birthday party.";
        Appt appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);

        int[] recurDaysArr = {1};
        appt.setRecurrence(recurDaysArr, appt.RECUR_BY_WEEKLY, 3, 100);

        appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);

        assertEquals(0, appt.getRecurNumber());
        assertEquals(2, appt.getRecurBy());
        assertEquals(0, appt.getRecurIncrement());
        assertFalse(appt.isRecurring());

        assertTrue(appt.getValid());
        assertEquals(12, appt.getStartHour());
        assertEquals(30, appt.getStartMinute());
        assertEquals(15, appt.getStartDay());
        assertEquals(02, appt.getStartMonth());
        assertEquals(2018, appt.getStartYear());
        assertEquals("Birthday Party", appt.getTitle());
        assertEquals("This is my birthday party.", appt.getDescription());

        int startHour_1 = 11;
        int startMinute_1 = 30;
        int startDay_1 = 15;
        int startMonth_1 = 02;
        int startYear_1 = 2018;
        String title_1 = "Birthday Party";
        String description_1 = "This is my birthday party.";
        Appt appt_1 = new Appt(startHour_1,
                startMinute_1,
                startDay_1,
                startMonth_1,
                startYear_1,
                title_1,
                description_1);

        int startHour_2 = 10;
        int startMinute_2 = 29;
        int startDay_2 = 14;
        int startMonth_2 = 01;
        int startYear_2 = 2017;
        String title_2 = "Birthday Party";
        String description_2 = "This is my birthday party.";
        Appt appt_2 = new Appt(startHour_2,
                startMinute_2,
                startDay_2,
                startMonth_2,
                startYear_2,
                title_2,
                description_2);

        assertEquals(5, appt_1.compareTo(appt_2));

        startHour = 25;
        title = null;
        description = null;
        Appt appt1 = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);

        assertFalse(appt1.getValid());
        appt1.setStartHour(-1);
        assertFalse(appt1.getValid());

        appt1.setStartHour(0);
        assertTrue(appt1.getValid());

        appt1.setStartHour(11);
        assertTrue(appt1.getValid());

        appt1.setStartHour(23);
        assertTrue(appt1.getValid());

        appt1.setStartMinute(-1);
        assertFalse(appt1.getValid());
        appt1.setStartMinute(0);
        assertTrue(appt1.getValid());

        appt1.setStartMinute(11);
        assertTrue(appt1.getValid());

        appt1.setStartMinute(59);
        assertTrue(appt1.getValid());

        appt1.setStartDay(-1);
        assertFalse(appt1.getValid());

        appt1.setStartDay(1);
        assertTrue(appt1.getValid());

        appt1.setStartDay(11);
        assertTrue(appt1.getValid());

        appt1.setStartDay(31);
        appt1.setStartDay(32);
        assertFalse(appt1.getValid());

        appt1.setStartDay(21);

        appt1.setStartMonth(1);
        assertTrue(appt1.getValid());
        appt1.setStartMonth(5);
        assertTrue(appt1.getValid());
        appt1.setStartMonth(11);
        assertTrue(appt1.getValid());

        appt1.setStartMinute(-1);
        assertEquals(null, appt1.toString());

    }

    // Testing appt
    @Test
    public void test010() throws Throwable {
        Appt appt = new Appt(00, 00, 01, 01, 2018, "Birthday Party", "This is the New Years day");
        assertEquals(true, appt.getValid());

        Appt appt1 = new Appt(1,1,1,1,1, "Birthday Party", "This is my birthday party");
        Appt appt2 = new Appt(1,1,1,12,1, "Birthday Party", "This is my birthday party");
        assertEquals(true, appt1.getValid());
        assertEquals(true, appt2.getValid());

        Appt appt3 = new Appt(23,1,1,1,1, "Birthday Party", "This is my birthday party");
        Appt appt4 = new Appt(0,1,1,1,1, "Birthday Party", "This is my birthday party");
        assertEquals(true, appt3.getValid());
        assertEquals(true, appt4.getValid());

        Appt appt5 = new Appt(1,0,1,1,1, "Birthday Party", "This is my birthday party");
        Appt appt6 = new Appt(1,59,1,1,1, "Birthday Party", "This is my birthday party");
        assertEquals(true, appt5.getValid());
        assertEquals(true, appt6.getValid());

        Appt appt7 = new Appt(1,1,1,1,1, "Birthday Party", "This is my birthday party");
        Appt appt8 = new Appt(1,1,28,2,2018, "Birthday Party", "This is my birthday party");
        assertEquals(true, appt7.getValid());
        assertEquals(true, appt8.getValid());

        //invalid appointments
        Appt appt9 = new Appt(24,1,1,1,1, "Birthday Party", "This is my birthday party");
        Appt appt10 = new Appt(-1,1,1,1,1, "Birthday Party", "This is my birthday party");
        assertEquals(false, appt9.getValid());
        assertEquals(false, appt10.getValid());

        Appt appt11 = new Appt(2,60,1,1,1, "Birthday Party", "This is my birthday party");
        Appt appt12 = new Appt(2,-1,1,1,1, "Birthday Party", "This is my birthday party");
        assertEquals(false, appt11.getValid());
        assertEquals(false, appt12.getValid());

    }

    // test get recur
    @Test
    public void test011()  throws Throwable {
        Appt appt = new Appt(15, 00, 01, 01, 2018, "Birthday Party", "This is my birthday party");
        int[] RecurDay = {1,1,1};
        assertEquals(2, appt.getRecurBy());
        assertEquals(0, appt.getRecurIncrement());
        appt.setRecurrence(RecurDay, 1, 1, 1);
        assertEquals(1, appt.getRecurDays()[0]);
        appt.setRecurrence(null, 1,1,0);
        assertEquals(0, appt.getRecurDays().length);
        assertEquals(1, appt.getRecurIncrement());
    }

    // test represtationapp
    @Test
    public void test012()  throws Throwable  {
        Appt appt1 = new Appt(21, 10, 12, 01, 2018, "A Birthday Party", "My birthday party.");
        String strRepresntation = "\t" + 01 + "/" + 12 + "/" + 2018 +" at " + 9 + ":" + 10 + "pm" + " ," + "A Birthday Party" + ", " + "My birthday party." + "\n";
        assertEquals(strRepresntation, appt1.toString());

        Appt appt2 = new Appt(0, 10, 12, 01, 2018, "A Birthday Party", "My birthday party.");
        String strRepresntation2 = "\t" + 01 + "/" + 12 + "/" + 2018 +" at " + 12 + ":" + 10 + "am" + " ," + "A Birthday Party" + ", " + "My birthday party." + "\n";
        assertEquals(strRepresntation2, appt2.toString());

        Appt appt3 = new Appt(11, 10, 12, 01, 2018, "A Birthday Party", "My birthday party.");
        String strRepresntation3 = "\t" + 01 + "/" + 12 + "/" + 2018 +" at " + 11 + ":" + 10 + "am" + " ," + "A Birthday Party" + ", " + "My birthday party." + "\n";
        assertEquals(strRepresntation3, appt3.toString());

        Appt appt4 = new Appt(12, 10, 12, 01, 2018, "A Birthday Party", "My birthday party.");
        String strRepresntation4 = "\t" + 01 + "/" + 12 + "/" + 2018 +" at " + 12 + ":" + 10 + "pm" + " ," + "A Birthday Party" + ", " + "My birthday party." + "\n";
        assertEquals(strRepresntation4, appt4.toString());

        Appt invalid = new Appt(24,1,1,1,1, "", "");
        assertEquals(null, invalid.toString());
    }
}

