package com.hello;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class IDUtil {

    public static void main(String[] args) {
        getNameId();
    }


    public static String getNameId() {
        return DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now()) + String.format("%04d", new Random().nextInt(9999));
    }




}
