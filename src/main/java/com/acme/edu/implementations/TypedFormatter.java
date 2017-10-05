package com.acme.edu.implementations;

import com.acme.edu.interfaces.Formatter;

import java.util.Arrays;

public class TypedFormatter implements Formatter {
    private static final String STRING_LOG_OUTPUT_FORMAT = "%s (x%d)";
    private static final String SIMPLE_LOG_OUTPUT_FORMAT = "%s: %s";

    private static final String PRIMITIVE_DESCRIPTION_STRING = "primitive";
    private static final String STRING_DESCRIPTION_STRING = "string";
    private static final String CHAR_DESCRIPTION_STRING = "char";


    @Override
    public String formatChar(String charToFormat) {
        return String.format ( SIMPLE_LOG_OUTPUT_FORMAT, CHAR_DESCRIPTION_STRING, charToFormat );
    }

    @Override
    public String formatInt(String intToFormat) {
        return String.format ( SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_DESCRIPTION_STRING, intToFormat );
    }

    @Override
    public String formatString(String stringToFormat) {
        return String.format ( SIMPLE_LOG_OUTPUT_FORMAT, STRING_DESCRIPTION_STRING, stringToFormat );
    }

    @Override
    public String formatStringSequence(String stringToFormat, int counter) {
        return String.format ( STRING_LOG_OUTPUT_FORMAT, stringToFormat, counter );
    }

    private String getFromattedArrayString(int[] array) {
        return Arrays.toString ( array )
                .replace ( "[", "{" )
                .replace ( "]", "}" );
    }
}
