package com.hello;

public enum DemoEnum {

    DISABLED(0, "禁用"),
    ENABLED(1, "启用"),
    ;

    private final int code;
    private final String description;


    private DemoEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }


    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }


    public static DemoEnum getElementByCode(int code){
        for(DemoEnum element: DemoEnum.values()) {
            if(element.code == code) {
                return element;
            }
        }
        return null;
    }


    public static void main(String[] args) {

    }

}
