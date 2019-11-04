package Baaz.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	public static String DAY_MONTH_YEAR = "dd/MM/yyyy";
	public static String MONTH_DAY_YEAR = "MM/dd/yyyy";
	public static String YEAR_MONTH_DAY = "yyyy/MM/dd";

	/**
	 * @param numberOfDays
	 *            get number of days to move after , before or stay in the current
	 *            day from story
	 * @param format
	 *            get the date format from class to set the date type
	 * @return the past,future or stay in current date
	 */
	public static String getDateInThePastOrFuture(int numberOfDays, String format) {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, numberOfDays);
		Date pastOrFeautureDate = cal.getTime();
		String dateInThePastOrFuture = getDateFormat(format).format(pastOrFeautureDate);
		return dateInThePastOrFuture;

	}

	public static DateFormat getDateFormat(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);

		return dateFormat;

	}

}