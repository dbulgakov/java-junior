package com.acme.edu.implementations;


import com.acme.edu.interfaces.Formatter;
import com.acme.edu.interfaces.Logger;
import com.acme.edu.interfaces.Printer;

/**
 * Java Coding Style Convention (PDF)
 */
public class SumLogger implements Logger {
    private Integer previousNumber;
    private String previousString;
    private int previousStringOccuranceNumber;

    private final Printer printer;
    private final Formatter formatter;

    public SumLogger(Printer printer, Formatter formatter) {
        this.printer = printer;
        this.formatter = formatter;
    }

    @Override
    public void log(int message) {
        printPreviousStringLogMessageIfExist();
        if (previousNumber != null) {
            logNumber(message, isSumOverflow(previousNumber, message));
            previousNumber = null;
        } else {
            previousNumber = message;
        }
    }

    @Override
    public void log(byte message) {
        printPreviousStringLogMessageIfExist();
        if (previousNumber != null) {
            logNumber(message, isSumOverflow(previousNumber.byteValue(), message));
        } else {
            previousNumber = (int) message;
        }
    }

    @Override
    public void log(String message) {
        printPreviousNumberIfExist();

        if (!message.equals(previousString)) {
            printPreviousStringLogMessageIfExist();
        } else {
            previousStringOccuranceNumber += 1;
        }

        previousString = message;
    }

    @Override
    public void log(char message) {
        printer.print(formatter.formatChar(message));
    }

    @Override
    public void log(String... messages) {
        printer.print(formatter.formatStringArray(messages));
    }

    @Override
    public void log(int... messages) {
        printer.print(formatter.formatIntArray(messages));
    }

    @Override
    public void log(int[][] ints) {
        printer.print(formatter.formatIntMatrix(ints));
    }

    @Override
    public void stopLogging() {
        printPreviousNumberIfExist();
        printPreviousStringLogMessageIfExist();
    }

    private void logNumber(int message, boolean isOverflow) {
        if (previousNumber != null) {
            if (!isOverflow) {
                printer.print(formatter.formatInt(message + previousNumber));
            } else {
                printer.print(formatter.formatInt(previousNumber));
                printer.print(formatter.formatInt(message));
            }
        }
    }

    private boolean isSumOverflow(byte a, byte b) {
        long result = (long) a + b;
        return !(result == (byte) result);
    }

    private boolean isSumOverflow(int a, int b) {
        long result = (long) a + b;
        return !(result == (int) result);
    }

    private void printPreviousNumberIfExist() {
        if (previousNumber != null) {
            printer.print(formatter.formatInt(previousNumber));
        }

        previousNumber = null;
    }

    private void printPreviousStringLogMessageIfExist() {
        String previousStringMessage = formatter.formatStringSequence(previousString, previousStringOccuranceNumber + 1);

        if (previousStringMessage != null) {
            printer.print(previousStringMessage);
        }

        previousString = null;
        previousStringOccuranceNumber = 0;
    }
}
