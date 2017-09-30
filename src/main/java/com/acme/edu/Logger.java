package com.acme.edu;


import org.omg.CORBA.INTERNAL;

import java.util.Arrays;

/**
 * Java Coding Style Convention (PDF)
 */
public class Logger {

    //region format
    private static final String STRING_LOG_OUTPUT_FORMAT = "%s (x%d)";
    private static final String SIMPLE_LOG_OUTPUT_FORMAT = "%s: %s";
    private static final String MATRIX_LOG_OUTPUT_FORMAT = "%s: {\n%s}";
    //endregion

    //region PREFIX CONSTANT
    private static final String STRING_DESCRIPTION_STRING = "string";
    private static final String PRIMITIVE_DESCRIPTION_STRING = "primitive";
    //private static final String PRIMITIVE_ARRAY_DESCRIPTION_STRING = "primitives array";
    //private static final String PRIMITIVE_MATRIX_DESCRIPTION_STRING = "primitives matrix";
    //private static final String PRIMITIVE_MULTIMATRIX_DESCRIPTION_STRING = "primitives multimatrix";
    private static final String CHAR_DESCRIPTION_STRING = "char";
    //endregion

    private enum State {previousInt, previousByte, previousString}
    private static State state;
    private static int overFlowCounter;
    //region Summators
    private static Integer previousIntegerSum;
    private static byte previousByteSum;
    private static String previousString;
    private static int samePreviousStringSequenceCounter;
    //endregion

    private static void clearSumAndCounterValues() {
        previousByteSum = 0;
        previousString = null;
        previousIntegerSum = 0;
        samePreviousStringSequenceCounter = 0;
        overFlowCounter = 0;
    }

    //region logs
    public static void log(int message) {

        if ( !(state == State.previousInt) ) {
            //если байт - печатаем байтовую сумму
            if ( state == State.previousByte ) {
                print ( String.format ( SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_DESCRIPTION_STRING, previousByteSum ) );
            }
            //если строка - строковую сумму
            else if ( state == State.previousString ) {
                print(getPreviousStringLogMessage ());

            }
            //обнуляем все предыдущие сообщения и счетчики
            clearSumAndCounterValues();
        }
        previousIntegerSum = (int) isSumOverflowNew ( message, previousIntegerSum, Integer.MAX_VALUE, Integer.MIN_VALUE );
        state = State.previousInt;

    }


    public static void log(byte message) {

        if ( !(state == State.previousByte) ) {
            //если байт - печатаем байтовую сумму
            if ( state == State.previousInt ) {

                printOverFlowsIfExist ( Integer.MAX_VALUE );
                print ( String.format ( SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_DESCRIPTION_STRING, previousIntegerSum ) );

            }
            //если строка - строковую сумму
            else if ( state == State.previousString ) {
                print ( getPreviousStringLogMessage () );
            }
            //обнуляем все предыдущие сообщения и счетчики
            clearSumAndCounterValues ();
        }
        previousByteSum = (byte) isSumOverflowNew ( message, previousByteSum, Byte.MAX_VALUE, Byte.MIN_VALUE );
        state = State.previousByte;
    }

    public static void log(String message) {

        if ( !(state == State.previousString) ) {
            if ( state == State.previousInt ) {
                printOverFlowsIfExist ( Integer.MAX_VALUE );
                print ( String.format ( SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_DESCRIPTION_STRING, previousIntegerSum ) );
            }
            if ( state == State.previousByte ) {
                printOverFlowsIfExist ( Byte.MAX_VALUE );
                print ( String.format ( SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_DESCRIPTION_STRING, previousByteSum ) );
            }
            clearSumAndCounterValues ();
        }
        if(previousString==null){
            previousString=message;
        }
        else {
            if ( previousString.equals( message ) ) {
                samePreviousStringSequenceCounter++;
            }
            else {
                print(getPreviousStringLogMessage ());
                previousString = message;
            }

        }
        state = State.previousString;
    }


    public static void log(char message) {
        print ( String.format ( SIMPLE_LOG_OUTPUT_FORMAT, CHAR_DESCRIPTION_STRING, message ) );
    }

    /*
    public static void log(String... messages) {
        print ( Arrays.toString ( messages ).replace ( ", ", "\n" ).replace ( "[", "" ).replace ( "]", "" ) );
    }

    public static void log(int... messages) {
        print ( String.format ( SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_ARRAY_DESCRIPTION_STRING, getFromattedArrayString ( messages ) ) );
    }

    public static void log(int[][] ints) {
        StringBuilder sb = new StringBuilder ();

        for (int[] innerArray : ints) {
            sb.append ( String.format ( "%s\n", getFromattedArrayString ( innerArray ) ) );
        }

        print ( String.format ( MATRIX_LOG_OUTPUT_FORMAT, PRIMITIVE_MATRIX_DESCRIPTION_STRING, sb.toString () ) );
    }

*/
    //endregion

    public static void stopLogging() {
        switch (state) {
            case previousByte:
                printOverFlowsIfExist ( Byte.MAX_VALUE );
                print ( String.format ( SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_DESCRIPTION_STRING, previousByteSum ) );
                break;
            case previousInt:
                printOverFlowsIfExist ( Integer.MAX_VALUE );
                print ( String.format ( SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_DESCRIPTION_STRING, previousIntegerSum ) );
                break;
            case previousString:
                print(String.format ( SIMPLE_LOG_OUTPUT_FORMAT, STRING_DESCRIPTION_STRING, previousString ));
                break;

        }
        clearSumAndCounterValues ();
    }

    //region Maths
    private static long isSumOverflowNew(int value, long sum, long maxValue, long minValue) {
        long guardian = 0;

//region если положительное переполнение, то увеличиваем счетчик
        if ( value > 0 & sum >= 0 ) {
            guardian = maxValue;

//если выполняется - переполнение
            if ( guardian - sum <= value ) {
                if ( overFlowCounter >= 0 ) {
                    overFlowCounter++;
                } else {
                    overFlowCounter++;
                    sum -= 1;//пока считаем, что тут нет переполнения
                }
            } else {
                guardian = 0;
            }
        }
//endregion
//region если отрицательное переполнение, то уменьшаем счетчик
        else if ( value < 0 & sum <= 0 ) {
            guardian = minValue;
            if ( guardian - sum >= value ) {
                if ( overFlowCounter > 0 ) {
                    overFlowCounter--;
                    sum -= 1;
                } else {
                    overFlowCounter--;

                }
            } else {
                guardian = 0;
            }
        }
//endregion
        sum += value - guardian;
        if ( sum > 0 & overFlowCounter < 0 ) {
            sum = minValue + sum;
            overFlowCounter++;
        } else if ( sum < 0 & overFlowCounter > 0 ) {
            sum = maxValue + sum;
            overFlowCounter--;
        }
        return sum;
    }
//endregion

    private static void printOverFlowsIfExist(int maxValue) {
        if ( overFlowCounter < 0 ) maxValue = -1 - maxValue;
        for (int i = 0; i < Math.abs ( overFlowCounter ); i++) {
            print ( String.format ( SIMPLE_LOG_OUTPUT_FORMAT, PRIMITIVE_DESCRIPTION_STRING, maxValue ) );
        }
    }




    private static String getPreviousStringLogMessage() {
        if ( previousString != null && samePreviousStringSequenceCounter >0 ) {
            return String.format ( STRING_LOG_OUTPUT_FORMAT, previousString, samePreviousStringSequenceCounter + 1 );
        } else {
            return String.format ( SIMPLE_LOG_OUTPUT_FORMAT, STRING_DESCRIPTION_STRING, previousString );
        }
    }

    private static void print(String message) {
        System.out.println ( message );
    }

    private static String getFromattedArrayString(int[] array) {
        return Arrays.toString ( array )
                .replace ( "[", "{" )
                .replace ( "]", "}" );
    }

}

class Main {
    public static void main(String[] args) {
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log(Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.stopLogging ();
    }
}