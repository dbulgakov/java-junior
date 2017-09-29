package com.acme.edu;

public interface Formatter {
    String formatChar(char charToFormat);

    String formatInt(int intToFormat);

    String formatStringArray(String... arrayToFormat);

    String formatIntArray(int... arrayToFormat);

    String formatStringSequence(String stringToFormat, int occurenceNumber);

    String formatIntMatrix(int[][] ints);
}
