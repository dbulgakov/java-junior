package com.acme.edu;


import java.util.Arrays;

/**
 * Java Coding Style Convention (PDF)
 */
public class Logger {
    private static final String STRING_LOG_OUTPUT_FORMAT = "%s (x%d)";
    private static final String SIMPLE_LOG_OUTPUT_FORMAT = "%s: %s";
    private static final String MATRIX_LOG_OUTPUT_FORMAT = "%s: {\n%s}";

    private static final String PRIMITIVE_DESCRIPTION_STRING = "primitive";
    private static final String PRIMITIVE_ARRAY_DESCRIPTION_STRING = "primitives array";
    private static final String PRIMITIVE_MATRIX_DESCRIPTION_STRING = "primitives matrix";
    private static final String PRIMITIVE_MULTIMATRIX_DESCRIPTION_STRING = "primitives multimatrix";
    private static final String CHAR_DESCRIPTION_STRING = "char";

    private static Integer previousNumber;
    private static String previousString;
    private static int samePreviousStringSequenceCounter;


    public static void log(int message) {
        printPreviousStringLogMessageIfExist();
        if (previousNumber != null) {
            logNumber(message, isOverflow(previousNumber, message));
            previousNumber = null;
        } else {
            previousNumber = message;
        }
    }

    public static void log(byte message) {
        printPreviousStringLogMessageIfExist();
        if (previousNumber != null) {
            logNumber(message, isOverflow(previousNumber.byteValue(), message));
        } else {
            previousNumber = (int) message;
        }
    }

    public static void log(String message) {
        printPreviousNumberIfExist();

        if (!message.equals(previousString)) {
            printPreviousStringLogMessageIfExist();
        } else {
            samePreviousStringSequenceCounter += 1;
        }

        previousString = message;
    }


    public static void log(char message) {
        print(String.format(SIMPLE_LOG_OUTPUT_FORMAT, CHAR_DESCRIPTION_STRING, message));
    }

    public static void log(String... messages) {
        print(Arrays.toString(messages).replace(", ", "\n").replace("[", "").replace("]", ""));
    }

    public static void log(int... messages) {
        print(String.format(SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_ARRAY_DESCRIPTION_STRING, getFromattedArrayString(messages)));
    }

    public static void log(int[][] ints) {
        StringBuilder sb = new StringBuilder();

        for (int[] innerArray : ints) {
            sb.append(String.format("%s\n", getFromattedArrayString(innerArray)));
        }

        print(String.format(MATRIX_LOG_OUTPUT_FORMAT, PRIMITIVE_MATRIX_DESCRIPTION_STRING, sb.toString()));
    }


    public static void stopLogging() {
        printPreviousNumberIfExist();
        printPreviousStringLogMessageIfExist();
    }

    private static void logNumber(int message, boolean isOverflow) {
        if (previousNumber != null) {
            if (!isOverflow) {
                print(String.format(SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_DESCRIPTION_STRING, message + previousNumber));
            } else {
                print(String.format(SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_DESCRIPTION_STRING, previousNumber));
                print(String.format(SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_DESCRIPTION_STRING, message));
            }
        }
    }

    private static boolean isOverflow(byte a, byte b) {
        long result = (long) a + b;
        return !(result == (byte) result);
    }

    private static boolean isOverflow(int a, int b) {
        long result = (long) a + b;
        return !(result == (int) result);
    }

    private static void printPreviousNumberIfExist() {
        if (previousNumber != null) {
            print(String.format(SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_DESCRIPTION_STRING, previousNumber));
        }

        previousNumber = null;
    }

    private static void printPreviousStringLogMessageIfExist() {
        String previousStringMessage = getPreviousStringLogMessage();

        if (previousStringMessage != null) {
            print(previousStringMessage);
        }

        previousString = null;
        samePreviousStringSequenceCounter = 0;
    }

    private static String getPreviousStringLogMessage() {
        if (previousString != null && samePreviousStringSequenceCounter >= 1) {
            return String.format(STRING_LOG_OUTPUT_FORMAT, previousString, samePreviousStringSequenceCounter + 1);
        } else {
            return previousString;
        }
    }

    private static String getFromattedArrayString(int[] array) {
        return Arrays.toString(array)
                .replace("[", "{")
                .replace("]", "}");
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
