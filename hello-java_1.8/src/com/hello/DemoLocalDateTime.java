package com.hello;

public class DemoLocalDateTime {

    public static void main(String[] args) {

        localDateTime();

        dateTimeFormatter();

    }

    private static void localDateTime() {

        // 当前日期时间,UTC(世界协调时间格式)
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        System.out.println("Current DateTime=" + now); // Current DateTime=2019-04-13T15:00:37.344

        // 当前日期时间
        now = java.time.LocalDateTime.of(java.time.LocalDate.now(), java.time.LocalTime.now());
        System.out.println("Current DateTime=" + now); // Current DateTime=2019-04-13T15:00:37.344


    }

    private static void dateTimeFormatter() {

        java.time.LocalDateTime now = java.time.LocalDateTime.now();

        java.time.format.DateTimeFormatter dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        String string = dateTimeFormatter.format(now);

        System.out.println(string);

    }

    /*
    // 01. java.util.Date --> java.time.LocalDateTime
    private static void DateToLocalDateTime() {
        java.util.Date date = new java.util.Date();
        java.time.Instant instant = date.toInstant();
        java.time.ZoneId zone = java.time.ZoneId.systemDefault();
        java.time.LocalDateTime localDateTime = java.time.LocalDateTime.ofInstant(instant, zone);
    }

    // 02. java.util.Date --> java.time.LocalDate
    private static void DateToLocalDate() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
    }

    // 03. java.util.Date --> java.time.LocalTime
    private static void DateToLocalTime() {
        java.util.Date date = new java.util.Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalTime localTime = localDateTime.toLocalTime();
    }


    // 04. java.time.LocalDateTime --> java.util.Date
    private static void LocalDateTimeToDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
    }


    // 05. java.time.LocalDate --> java.util.Date
    private static void LocalDateToDate() {
        LocalDate localDate = LocalDate.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
    }

    // 06. java.time.LocalTime --> java.util.Date
    private static void LocalTimeToDate() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        java.util.Date date = Date.from(instant);
    }
    */
}
