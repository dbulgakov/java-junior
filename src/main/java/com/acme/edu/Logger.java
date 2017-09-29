package com.acme.edu;

/**
 * Java Coding Style Convention (PDF)
 */
public class Logger {
    public static final String MY_SUPER_CONSTANT = "";
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String CHAR_PREFIX = "char: ";


    //region SUM_VARS
    private static byte byteSum = 0;
    private static int intSum = 0;
    private static String stringSum = null;
    private static int stringCounter = 1;
    // endregion

    //region MAX_MIN_VARS
    private static int byteMaxValueCounter = 0;
    private static int intMaxValueCounter = 0;
    // endregion

    //region STATES_FOR_LAST_CALLING_METHOD
    private static boolean isString;
    private static boolean isInt;
    private static boolean isByte;
    //endregion


    /**
     * JavaDoc
     * Вычисляется сумма или остаток от суммы при переполнении
     * и изменяется счетчик переполнений
     * @param addingNumber - число, которое хотим добавить
     * @param  lastSum - текущая сумма
     * @param maxValue число, после которого будет переполнение суммы
     * @return  Сумму или остаток от переполнения
     */
    private static int SumAndCheckMaxValue(int addingNumber, int lastSum, int maxValue) {

        int sum = addingNumber + lastSum;

        if ( addingNumber > 0 && lastSum > 0 ) {

            if ( sum < 0 || sum > maxValue ) {
                if ( maxValue == Integer.MAX_VALUE ) {
                    intMaxValueCounter++;
                } else if ( maxValue == Byte.MAX_VALUE ) {
                    byteMaxValueCounter++;
                }
                return Math.abs ( addingNumber - (maxValue - lastSum) );
            }
        } else if ( addingNumber < 0 && lastSum < 0 ) {

            if ( sum > 0 || sum < maxValue ) {
                if ( maxValue == Integer.MAX_VALUE ) {
                    intMaxValueCounter--;
                } else if ( maxValue == Byte.MAX_VALUE ) {
                    byteMaxValueCounter--;
                }

                return addingNumber - (maxValue - lastSum);
            }
        }

        return sum;

    }

    /**
     * JavaDoc
     * После выполнения этой функции
     * обнуляются поля Logger и он перестает ждать сообщения
     */
    public static void exit() {
        if ( isString ) {
            if ( stringSum != null ) {
                printStringAtAll ();
                isString = false;
                stringSum = null;
            }

        }
        if ( isInt ) {
            printAndClearIntSumAndByteState ();
        }
        if ( isByte ) {
            printAndClearByteSumAndIntState ();
        }


        isByte = false;

    }


    //region Loggers
    /**
     * JavaDoc
     * Вычисляется сумма или остаток от суммы при переполнении
     * и изменяется счетчик переполнений
     * @param message - число, которое хотим добавить
     */


    public static void log(String message) {

        if ( isInt ) {
        printAndClearIntSumAndByteState ();

    } else if ( isByte ) {

        printAndClearByteSumAndIntState ();

    }
    isInt = false;
    isByte = false;
        if ( stringSum == null ) {
        stringSum = message;
        return;
    } else {
        if ( stringSum.equals ( message ) ) {
            stringCounter++;
        } else {
            printStringAtAll ();
            stringSum = message;
        }


    }

    isString = true;
}



    /**
     * JavaDoc
     * Remember number in first time
     * Add number to sum another time
     * @param message обрабатывает интовое сообщение
     */
    public static void log(int message) {
        if ( isString ) {
            printStringAtAll ();
            stringSum = null;
            intSum = message;
            isString = false;
        } else if ( isByte ) {
            printAndClearByteSumAndIntState ();
        } else {
            intSum = SumAndCheckMaxValue ( message, intSum, Integer.MAX_VALUE );
        }
        isInt = true;

    }
    /**
     * JavaDoc
     * Remember number in first time
     * Add number to sum another time
     * @param message обрабатывает байтовое сообщение
     */
    public static void log(byte message) {
        if ( isString ) {
            printStringAtAll ();
            stringSum = null;
            byteSum = message;
            isString = false;
        } else if ( isInt ) {
            printAndClearIntSumAndByteState ();
        } else {
            byteSum = (byte) SumAndCheckMaxValue ( message, byteSum, Byte.MAX_VALUE );
        }
        isByte = true;

    }

    /**
     * JavaDoc
     * Remember number in first time
     * Add number to sum another time
     * @param message обрабатывает символьное сообщение
     */
    public static void log(char message) {
        print ( CHAR_PREFIX + message );
    }
    //endregion

    //region Printers

    /**
     * JavaDoc
     * Выводит на консоль переполнения
     * @param maxValue - максимально значение до переполнения
     * @param counter - счетчик максимального значения
     */
    private static void printMaxValue(int maxValue, int counter) {
        for (int i = 0; i < counter; i++) {
            print ( PRIMITIVE_PREFIX + maxValue );
        }

    }


    private static void printAndClearByteSumAndIntState() {

        print ( PRIMITIVE_PREFIX + byteSum );
        printMaxValue ( Byte.MAX_VALUE, byteMaxValueCounter );
        byteMaxValueCounter = 0;
        byteSum = 0;
        isInt = false;
    }

    private static void printStringState() {

        print ( STRING_PREFIX + stringSum );

        byteMaxValueCounter = 0;
        byteSum = 0;
        isInt = false;
    }

    private static void printAndClearIntSumAndByteState() {

        print ( PRIMITIVE_PREFIX + intSum );
        printMaxValue ( Integer.MAX_VALUE, intMaxValueCounter );
        intMaxValueCounter = 0;
        intSum = 0;
        isByte = false;
    }

    private static void printStringWithCounter() {
        print ( STRING_PREFIX + stringSum + " (x" + stringCounter + ")" );
        stringCounter = 1;
    }

    /**
     * JavaDoc
     * Выводит строку или строку и счетчик строк
     */
    private static void printStringAtAll() {
        if ( stringCounter > 1 ) {
            printStringWithCounter ();

        } else {
            print ( STRING_PREFIX + stringSum );

        }
    }
    private static void print(String message) {

        System.out.println ( message );
    }
    //endregion
}


