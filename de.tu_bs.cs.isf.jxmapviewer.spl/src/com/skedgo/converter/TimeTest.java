package com.skedgo.converter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeTest {

	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		dateFormat.setTimeZone(TimeZone.getTimeZone(TimezoneMapper.latLngToTimezoneString(40.741895, -73.989308)));
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);

		if (false) {
			dateFormat.applyLocalizedPattern("H:mm");
		} else {
			dateFormat.applyLocalizedPattern("h:mm a");
		}

		System.out.println(dateFormat.format(cal.getTime()));
	}

}
