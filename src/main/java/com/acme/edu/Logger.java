package com.acme.edu;

public interface Logger {
    void log(int message);

    void log(byte message);

    void log(String message);

    void log(char message);

    void log(String... messages);

    void log(int... messages);

    void log(int[][] ints);

    void stopLogging();
}
