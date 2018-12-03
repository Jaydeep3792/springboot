package com.assignment.util;

import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_TIME);

	/**
	 * Get UTC Timestamp of the current date
	 *
	 * @return timestamp
	 */
	public static Timestamp getCurrentUTCTimeStamp() {
		LocalDateTime utcTime = LocalDateTime.now(Clock.systemUTC());
		return Timestamp.valueOf(utcTime.format(dateFormat));
	}

}
