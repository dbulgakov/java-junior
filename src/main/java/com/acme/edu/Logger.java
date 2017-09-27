package com.acme.edu;
/**
 * JavaDoc
 */
public class Logger {

    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String REFERENCE_PREFIX = "reference: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";


    public static void log(int message) {
        print(PRIMITIVE_PREFIX + message);
    }

    private static void print(String message) {
        System.out.println(message);
    }


    public static void log(byte message) {
        print(PRIMITIVE_PREFIX + message);
    }
    public static void log(Object message) {
        print(REFERENCE_PREFIX + message);
    }
    public static void log(char message) {
        print(CHAR_PREFIX + message);
    }
    public static void log(String message) {
        print(STRING_PREFIX + message);
    }

    public static void log(boolean message) {
       print(PRIMITIVE_PREFIX + message);
    }

}
