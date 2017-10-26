package com.hello.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HadoopTest {
	
	public static void main(String[] args) {
		System.out.println("HadoopTest");
		
		
//		LocalDate localDate = LocalDate.parse("1949-10-01 14:21:02");
//		System.err.println(localDate.toString());
		
		DateTimeFormatter basicIsoDate = DateTimeFormatter.BASIC_ISO_DATE;
		System.err.println(basicIsoDate);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		LocalDateTime localDateTime = LocalDateTime.parse("1949-10-01 14:21:02",format);
		System.err.println("localDateTime" + localDateTime.toString());
		
		System.err.println("year: " + localDateTime.getYear());
		System.err.println("month: " + localDateTime.getMonthValue());
		System.err.println("month: " + localDateTime.getMonth().toString());
		
		System.err.println("day: " + localDateTime.getDayOfMonth());
		System.err.println("day: " + localDateTime.getDayOfYear());
		System.err.println("day: " + localDateTime.getDayOfWeek().toString());
		
		
	}
	
}
