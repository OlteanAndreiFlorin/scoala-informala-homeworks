package ro.sci.my_age;

import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 * Simple class that calculates the days between my birth date and the current
 * date; to do this is uses the joda-time library @see <a href="http://www.joda.org/joda-time/">Joda</a>
 * 
 * @author Oltean Andrei-Florin
 *
 */
public class MyAgeInDays {

	LocalDate birthDate = new LocalDate(1992, 8, 27);
	LocalDate now = new LocalDate();
	Days daysThatPassed = Days.daysBetween(birthDate, now);

	@Override
	public String toString() {
		return "My age is: " + daysThatPassed.getDays() + " days";
	}

}
