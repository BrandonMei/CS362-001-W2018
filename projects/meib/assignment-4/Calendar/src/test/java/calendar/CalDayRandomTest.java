package calendar;


import org.junit.Test;


import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {

    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS=100;

    /**
     * Return a randomly selected method to be tests !.
     */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

        int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
    }
    /**
     * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
     */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

        int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur
    }
    /**
     * Return a randomly selected appointments to recur forever or Never recur  !.
     */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

        int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur
    }

    /**
     * Generate Random Tests that tests CalDay Class.
     */
    @Test
    public void randomtest()  throws Throwable  {

        long startTime = Calendar.getInstance().getTimeInMillis();
        long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
        int TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */

        System.out.println("Start testing...");

        try{
            for (int iteration = 0; elapsed < TestTimeout; iteration++) {
                long randomseed =System.currentTimeMillis(); //10
                //       System.out.println(" Seed:"+randomseed );
                Random random = new Random(randomseed);
                int day = 24;
                int month = 4;
                int year = 2018;
                GregorianCalendar cDay = new GregorianCalendar(year, month, day);
                CalDay c = new CalDay(cDay);

                int day2 = 23;
                int month2 = 3;
                int year2 = 2018;
                GregorianCalendar cDay2 = new GregorianCalendar(year2, month2, day2);
                CalDay c2 = new CalDay(cDay2);

                for (int i = 0; i < NUM_TESTS; i++) {
                    int startHour1 = ValuesGenerator.RandInt(random);
                    int startHour2 = ValuesGenerator.RandInt(random);

                    Appt appt1 = new Appt(startHour1, 01, 1, 1, 2018, "Birthday Party", "This is my birthday party.");
                    Appt appt2 = new Appt(startHour2, 02, 2, 2, 2018, "Birthday Party", "This is my birthday party.");
                    Appt appt3 = new Appt(0, 03, 3, 3, 2018, "Birthday Party", "This is my birthday party.");
                    Appt appt4 = new Appt(0, 04, 24, 4, 2018, "Birthday Party", "This is my birthday party.");

                    c.addAppt(appt1);
                    c.addAppt(appt2);
                    c.addAppt(appt3);
                    c2.addAppt(appt4);

                }
                elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                if((iteration%10000)==0 && iteration!=0 )
                    System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

            }

        }catch(NullPointerException e){

        }

        System.out.println("Done testing...");

    }
}
