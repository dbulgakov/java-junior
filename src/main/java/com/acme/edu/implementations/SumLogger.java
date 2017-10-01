package com.acme.edu.implementations;


/**
 * Java Coding Style Convention (PDF)
 */
public class SumLogger {
//    private Integer previousNumber;
//    private String previousString;
//    private int previousStringOccuranceNumber;
//
//    private final DataSaver saver;
//    private final Formatter formatter;
//
//    public SumLogger(DataSaver saver, Formatter formatter) {
//        this.saver = saver;
//        this.formatter = formatter;
//    }
//
//    @Override
//    public void log(int message) {
//        printPreviousStringLogMessageIfExist();
//        if (previousNumber != null) {
//            logNumber(message, isSumOverflow(previousNumber, message));
//            previousNumber = null;
//        } else {
//            previousNumber = message;
//        }
//    }
//
//    @Override
//    public void log(byte message) {
//        printPreviousStringLogMessageIfExist();
//        if (previousNumber != null) {
//            logNumber(message, isSumOverflow(previousNumber.byteValue(), message));
//        } else {
//            previousNumber = (int) message;
//        }
//    }
//
//    @Override
//    public void log(String message) {
//        printPreviousNumberIfExist();
//
//        if (!message.equals(previousString)) {
//            printPreviousStringLogMessageIfExist();
//        } else {
//            previousStringOccuranceNumber += 1;
//        }
//
//        previousString = message;
//    }
//
//    @Override
//    public void log(char message) {
//        saver.print(formatter.formatChar(message));
//    }
//
//    @Override
//    public void log(String... messages) {
//        saver.print(formatter.formatStringArray(messages));
//    }
//
//    @Override
//    public void log(int... messages) {
//        saver.print(formatter.formatIntArray(messages));
//    }
//
//    @Override
//    public void log(int[][] ints) {
//        saver.print(formatter.formatIntMatrix(ints));
//    }
//
//    @Override
//    public void stopLogging() {
//        printPreviousNumberIfExist();
//        printPreviousStringLogMessageIfExist();
//    }
//
//    private void logNumber(int message, boolean isOverflow) {
//        if (previousNumber != null) {
//            if (!isOverflow) {
//                saver.print(formatter.formatInt(message + previousNumber));
//            } else {
//                saver.print(formatter.formatInt(previousNumber));
//                saver.print(formatter.formatInt(message));
//            }
//        }
//    }
//
//    private boolean isSumOverflow(byte a, byte b) {
//        long result = (long) a + b;
//        return !(result == (byte) result);
//    }
//
//    private boolean isSumOverflow(int a, int b) {
//        long result = (long) a + b;
//        return !(result == (int) result);
//    }
//
//    private void printPreviousNumberIfExist() {
//        if (previousNumber != null) {
//            saver.print(formatter.formatInt(previousNumber));
//        }
//
//        previousNumber = null;
//    }
//
//    private void printPreviousStringLogMessageIfExist() {
//        String previousStringMessage = formatter.formatStringSequence(previousString, previousStringOccuranceNumber + 1);
//
//        if (previousStringMessage != null) {
//            saver.print(previousStringMessage);
//        }
//
//        previousString = null;
//        previousStringOccuranceNumber = 0;
//    }
}
