package com.acme.edu.interfaces;

public interface Formatter {
    String formatChar(String charToFormat);

    String formatInt(String intToFormat);

    String formatString(String stringToFormat);

    String formatStringSequence(String stringToFormat, int counter);
}
