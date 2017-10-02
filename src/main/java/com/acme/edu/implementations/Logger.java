package com.acme.edu.implementations;

public class Logger {

    private final static LoggerController loggerController = new LoggerController ( new ConsoleSaver (), new TypedFormatter () );

    public static void log(int message) {
        IntMessage megaMessage = new IntMessage ( String.valueOf ( message ) );
        loggerController.log ( megaMessage );
    }

    public static void log(byte message) {
        ByteMessage megaMessage = new ByteMessage ( String.valueOf ( message ) );
        loggerController.log ( megaMessage );
    }

    public static void log(String message) {
        StringMessage megaMessage = new StringMessage ( message );
        loggerController.log ( megaMessage );
    }

    public static void log(char message) {
        loggerController.log ( message );
    }

    public static void log(String... messages) {
        loggerController.log ( messages );
    }

    public static void log(int... messages) {
        loggerController.log ( messages );
    }

    public static void log(int[][] ints) {
        loggerController.log ( ints );
    }

    public static void stopLogging() {
        loggerController.stopLogging ();
    }
}
