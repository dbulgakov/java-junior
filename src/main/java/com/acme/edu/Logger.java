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
        System.out.println(PRIMITIVE_PREFIX + message);
    }


    public static void log(byte message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }
    public static void log(Object message) {
        System.out.println(REFERENCE_PREFIX + message);
    }
    public static void log(char message) {
        System.out.println(CHAR_PREFIX + message);
    }
    public static void log(String message) {
        System.out.println(STRING_PREFIX + message);
    }

    public static void log(boolean message) {
        System.out.println(PRIMITIVE_PREFIX + message);
    }

}
