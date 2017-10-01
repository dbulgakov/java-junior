package com.acme.edu.formatter;

public interface MessageFormatter {
    String format(HasPrefix dataToFormat);
    String format(HasPrefix dataToFormat, String pattern);
}
