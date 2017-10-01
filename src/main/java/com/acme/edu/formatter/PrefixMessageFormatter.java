package com.acme.edu.formatter;

public class PrefixMessageFormatter implements MessageFormatter {

    private static final String STRING_WITH_PREFIX_FORMAT = "%s: %s";

    @Override
    public String format(HasPrefix dataToFormat) {
        String prefix = dataToFormat.getPrefix();
        if (prefix != null) {
            return String.format(STRING_WITH_PREFIX_FORMAT, dataToFormat.getPrefix(), dataToFormat);
        } else {
            return dataToFormat.toString();
        }
    }

    @Override
    public String format(HasPrefix dataToFormat, String pattern) {
        return String.format(pattern, dataToFormat);
    }
}
