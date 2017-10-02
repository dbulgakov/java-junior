package com.acme.edu.interfaces;

public interface Formatter {
    String formatChar(char charToFormat);

    String formatInt(String intToFormat);

    String formatStringArray(String... arrayToFormat);

    String formatIntArray(int... arrayToFormat);

    String formatStringSequence(String stringToFormat);

    String formatIntMatrix(int[][] ints);
}
