package com.acme.edu.implementations;

public class Logger {
    private  static final LoggerController loggerController = new LoggerController ( new ConsoleSaver (),new TypedFormatter () );

    public static void log(int message){
        loggerController.log ( message );
    }
    public static void log(String message){
        loggerController.log ( message );
    }
    public static void log(byte message){
        loggerController.log ( message );
    }
    public static void log(char message){
        loggerController.log ( message );
    }
    public static void log(String... messages){
        loggerController.log ( messages );
    }
    public static void log(int... messages){
        loggerController.log ( messages );
    }
    public static void log(int[][] messages){
        loggerController.log ( messages );
    }
    public static void stopLogging(){
        loggerController.stopLogging ();
    }
}
