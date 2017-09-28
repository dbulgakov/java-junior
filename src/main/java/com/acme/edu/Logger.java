package com.acme.edu;


/**
 * Java Coding Style Convention (PDF)
 */
public class Logger {
    private static final String PRIMITIVE_DESCRIPTION_STRING = "primitive: ";
    private static final String CHAR_DESCRIPTION_STRING = "char: ";

    public static void log(int message) {
        print(PRIMITIVE_DESCRIPTION_STRING + message);
    }

    public static void log(String message) {
        print(message);
    }

    public static void log(char message) {
        print(CHAR_DESCRIPTION_STRING + message);
    }


    private static void print(String message) {
        System.out.println(message);
    }
}
