package com.example.demo.java8;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeStampFormatter {

	public static void convertDateTimeUsingTimeAPI() {
		// Get current time
		Instant currentTime = Instant.now();
		System.out.println("Current Date Time in UTC -->" + currentTime);

		// Set Zone as Asia/Kolkata
		ZonedDateTime zonedDateTime = currentTime.atZone(ZoneId.of("Asia/Kolkata"));

		System.out.println("Current Date Time in IST -->" + zonedDateTime);
		// Date Formatter Class
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		// Format the date in required format
		String formattedTime = zonedDateTime.format(formatter);

		System.out.println("Formatted date -->" + formattedTime);
	}

	public static void dateCalculation() {
		// Get current time
		Instant currentTime = Instant.now();
		System.out.println("Current Date Time in UTC -->" + currentTime);

		// Set Zone as Asia/Kolkata
		ZonedDateTime zonedDateTime = currentTime.atZone(ZoneId.of("Asia/Kolkata"));

		System.out.println("Current Date Time in IST -->" + zonedDateTime);

		// Minus days from current time
		ZonedDateTime minusDateTime = zonedDateTime.minusDays(20);

		System.out.println("Minus  Date Time in IST -->" + minusDateTime);

		// Add days
		ZonedDateTime plusDateTime = minusDateTime.plusDays(10);
		System.out.println("Plus  Date Time in IST -->" + plusDateTime);
		System.out.println("Plus  Seconds Time in IST -->" + plusDateTime.plusSeconds(600));

	}

	public static void main(String[] args) {
		// TimeStampFormatter.convertDateTimeUsingTimeAPI();
		TimeStampFormatter.dateCalculation();

	}

}
