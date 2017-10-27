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
		System.err.println(basicIsoDate);//ParseCaseSensitive(false)Value(Year,4)Value(MonthOfYear,2)Value(DayOfMonth,2)[Offset(+HHMMss,'Z')]
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		LocalDateTime localDateTime = LocalDateTime.parse("1949-10-01 14:21:02",format);
		System.err.println("localDateTime" + localDateTime.toString());//localDateTime1949-10-01T14:21:02
		
		System.err.println("year: " + localDateTime.getYear());//year: 1949
		System.err.println("month: " + localDateTime.getMonthValue());//month: 10
		System.err.println("month: " + localDateTime.getMonth().toString());//month: OCTOBER
		
		System.err.println("day: " + localDateTime.getDayOfMonth());//day: 1
		System.err.println("day: " + localDateTime.getDayOfYear());//day: 274
		System.err.println("day: " + localDateTime.getDayOfWeek().toString());//day: SATURDAY
		
		
	}
	
}
