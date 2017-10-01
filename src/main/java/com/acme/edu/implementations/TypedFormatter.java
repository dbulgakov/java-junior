package com.acme.edu.implementations;

public class TypedFormatter {
    private static final String STRING_LOG_OUTPUT_FORMAT = "%s (x%d)";
    private static final String SIMPLE_LOG_OUTPUT_FORMAT = "%s: %s";
    private static final String MATRIX_LOG_OUTPUT_FORMAT = "%s: {\n%s}";


//    @Override
//    public String formatStringArray(String... messages) {
//        return Arrays.toString(messages).replace(", ", "\n").replace("[", "").replace("]", "");
//    }

//    @Override
//    public String formatIntArray(int... arrayToFormat) {
//        return String.format(SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_ARRAY_DESCRIPTION_STRING, getFromattedArrayString(arrayToFormat));
//    }

//    @Override
//    public String formatIntMatrix(int[][] ints) {
//        StringBuilder sb = new StringBuilder();
//
//        for (int[] innerArray : ints) {
//            sb.append(String.format("%s\n", getFromattedArrayString(innerArray)));
//        }
//
//        return String.format(MATRIX_LOG_OUTPUT_FORMAT, PRIMITIVE_MATRIX_DESCRIPTION_STRING, sb.toString());
//    }

//    @Override
//    public String formatInt(int intToFormat) {
//        return String.format(SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_DESCRIPTION_STRING, intToFormat);
//    }
//
//    @Override
//    public String formatStringSequence(String stringToFormat, int stringOccuranceNumber) {
//        if (stringToFormat != null && stringOccuranceNumber >= 2) {
//            return String.format(STRING_LOG_OUTPUT_FORMAT, stringToFormat, stringOccuranceNumber);
//        } else {
//            return stringToFormat;
//        }
//    }

//    private String getFromattedArrayString(int[] array) {
//        return Arrays.toString(array)
//                .replace("[", "{")
//                .replace("]", "}");
//    }
}
