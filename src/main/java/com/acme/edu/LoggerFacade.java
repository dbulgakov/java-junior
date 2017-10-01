package com.acme.edu;

import com.acme.edu.controller.LoggerController;
import com.acme.edu.controller.SequenceLoggerController;
import com.acme.edu.formatter.PrefixMessageFormatter;
import com.acme.edu.messages.types.*;
import com.acme.edu.saver.ConsoleDataSaver;

import java.util.Arrays;

import static com.acme.edu.utils.BoxingUtils.boxArray;
import static com.acme.edu.utils.BoxingUtils.boxMatrix;

public class LoggerFacade {
    private static final LoggerController loggerController = new SequenceLoggerController(new PrefixMessageFormatter(), new ConsoleDataSaver());

    public static void log(int message) {
        loggerController.logMessage(new IntegerMessage(message));
    }

    public static void log(byte message) {
        loggerController.logMessage(new ByteMessage(message));
    }

    public static void log(String message) {
        loggerController.logMessage(new StringMessage(message));
    }

    public static void log(char message) {
        loggerController.logMessage(new CharMessage(message));
    }

    public static void log(String... message) {
        loggerController.logMessage(new StringArrayMessage(message));
    }

    public static void log(int... message) {
        loggerController.logMessage(new IntegerArrayMessage(boxArray(message)));
    }

    public static void log(int[][] message) {
        loggerController.logMessage(new IntegerMatrixMessage(boxMatrix(message)));
    }

    public static void stopLogging() {
        loggerController.logMessage(new StopMessage());
    }
}
