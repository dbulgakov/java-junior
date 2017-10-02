package com.acme.edu.implementations;

import com.acme.edu.interfaces.Formatter;

import java.util.Arrays;

public class TypedFormatter implements Formatter {
    private static final String STRING_LOG_OUTPUT_FORMAT = "%s (x%d)";
    private static final String SIMPLE_LOG_OUTPUT_FORMAT = "%s: %s";
    private static final String MATRIX_LOG_OUTPUT_FORMAT = "%s: {\n%s}";

    private static final String PRIMITIVE_DESCRIPTION_STRING = "primitive";
    private static final String STRING_DESCRIPTION_STRING = "string";
    private static final String PRIMITIVE_ARRAY_DESCRIPTION_STRING = "primitives array";
    private static final String PRIMITIVE_MATRIX_DESCRIPTION_STRING = "primitives matrix";
    private static final String PRIMITIVE_MULTIMATRIX_DESCRIPTION_STRING = "primitives multimatrix";
    private static final String CHAR_DESCRIPTION_STRING = "char";


    @Override
    public String formatChar(char charToFormat) {
        return String.format(SIMPLE_LOG_OUTPUT_FORMAT, CHAR_DESCRIPTION_STRING, charToFormat);
    }

    @Override
    public String formatStringArray(String... messages) {
        return Arrays.toString(messages).replace(", ", "\n").replace("[", "").replace("]", "");
    }

    @Override
    public String formatIntArray(int... arrayToFormat) {
        return String.format(SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_ARRAY_DESCRIPTION_STRING, getFromattedArrayString(arrayToFormat));
    }


    @Override
    public String formatIntMatrix(int[][] ints) {
        StringBuilder sb = new StringBuilder();

        for (int[] innerArray : ints) {
            sb.append(String.format("%s\n", getFromattedArrayString(innerArray)));
        }

        return String.format(MATRIX_LOG_OUTPUT_FORMAT, PRIMITIVE_MATRIX_DESCRIPTION_STRING, sb.toString());
    }

    @Override
    public String formatInt(String intToFormat) {
        return String.format(SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_DESCRIPTION_STRING, intToFormat);
    }

    @Override
    public String formatStringSequence(String stringToFormat) {


            return String.format ( SIMPLE_LOG_OUTPUT_FORMAT, STRING_DESCRIPTION_STRING, stringToFormat );

    }

    private String getFromattedArrayString(int[] array) {
        return Arrays.toString(array)
                .replace("[", "{")
                .replace("]", "}");
    }
}
