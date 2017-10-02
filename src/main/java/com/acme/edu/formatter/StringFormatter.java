package com.acme.edu.formatter;

public interface StringFormatter {
    String format(HasPrefix dataToFormat);
    String format(HasPrefix dataToFormat, String pattern);
}
