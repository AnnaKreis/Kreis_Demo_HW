package com.demo.data;

public class RegistrationUserData {
    public static final String FIRST_NAME = "Helen";
    public static final String LAST_NAME = "Straus";
    public static final String EMAIL = "hatip45779@insfou.com";
    public static final String PASSWORD = "Aa!12345";
    public static final String CONFIRM_PASSWORD = "Aa!12345";

    public static String getDynamicEmail() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        return "test" + i + "@test.com";
    }
}
