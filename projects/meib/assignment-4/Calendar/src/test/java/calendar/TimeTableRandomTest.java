package calendar;

import java.util.Calendar;
import java.util.Random;
import java.sql.Time;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


import static org.junit.Assert.*;


/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

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
	 * Generate Random Tests that tests TimeTable Class.
	 */
	@Test
	public void randomtest()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing...");
		try{
			for (int iteration = 0; iteration < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis();
				Random random = new Random(randomseed);

				int day2 = ValuesGenerator.RandInt(random);
				int day = 1;
				int month = 01;
				int year = 2018;
				int month2 = 02;
				int year2 = 2018;

				int[] recur = new int[]{1};
				int[] recur2 = new int[]{2};
				int[] recur3 = new int[]{3};

				TimeTable time = new TimeTable();

				for (int i = 0; i < NUM_TESTS; i++) {
					int startHour1 = ValuesGenerator.RandInt(random);
					int startHour2 = ValuesGenerator.RandInt(random);
					int startDay1 = ValuesGenerator.RandInt(random);
					int startDay2 = ValuesGenerator.RandInt(random);
					int startDay3 = ValuesGenerator.RandInt(random);
					int startDay4 = ValuesGenerator.RandInt(random);
					int startDay5 = ValuesGenerator.RandInt(random);

					Appt appt1 = new Appt(startHour1, 01, startDay1, 01, 2018, "Birthday Party", "This is my birthday party.");
					Appt appt2 = new Appt(startHour2, 01, startDay2, 01, 2018, "Birthday Party", "This is my birthday party.");
					Appt appt3 = new Appt(startHour1, 01, startDay3, 01, 2018, "Birthday Party", "This is my birthday party.");
					Appt appt4 = new Appt(startHour2, 01, startDay4, 01, 2018, "Birthday Party", "This is my birthday party.");
					Appt appt5 = new Appt(startHour2, 01, startDay5, 01, 2018, "Birthday Party", "This is my birthday party.");


					appt1.setRecurrence(recur, 2, 2, appt1.RECUR_NUMBER_FOREVER);
					appt2.setRecurrence(recur2, 3, 1, appt2.RECUR_NUMBER_FOREVER);
					appt3.setRecurrence(recur3, 4, 1, appt3.RECUR_NUMBER_FOREVER);
					appt4.setRecurrence(recur3, 3, 2, appt4.RECUR_NUMBER_FOREVER);
					appt5.setRecurrence(recur3, 1, 3, 0);

					LinkedList<Appt> listAppts1 = new LinkedList<Appt>();
					LinkedList<Appt> listAppts2 = null;

					GregorianCalendar cDay = new GregorianCalendar(year, month, day);
					GregorianCalendar cDay2 = new GregorianCalendar(year2, month2, day2);

					listAppts1.add(appt1);
					listAppts1.add(appt2);
					listAppts1.add(appt3);
					listAppts1.add(appt4);
					listAppts2.add(appt5);

					try {
						time.getApptRange(listAppts1, cDay, cDay2);

					} catch (DateOutOfRangeException e) {
						continue;
					}

					time.deleteAppt(listAppts1, appt1);
					time.deleteAppt(listAppts2, appt1);
					time.deleteAppt(listAppts1, appt4);
					time.deleteAppt(listAppts2, appt5);
					time.deleteAppt(listAppts1, null);
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