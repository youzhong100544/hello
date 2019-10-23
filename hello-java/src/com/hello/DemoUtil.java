package com.hello;

import java.util.UUID;

public class DemoUtil {

    private DemoUtil(){}

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

}
