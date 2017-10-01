package com.acme.edu.implementations;


import com.acme.edu.interfaces.Formatter;
import com.acme.edu.interfaces.LoggerOOP;
import com.acme.edu.interfaces.Saver;

import java.util.Arrays;

/**
 * Java Coding Style Convention (PDF)
 */
public class LoggerController implements LoggerOOP {
    private  Integer previousIntegerSum;
    private byte previousByteSum;
    private String previousString;
    private int previousStringOccuranceNumber;
    private enum State {previousInt, previousByte, previousString}
    private State state;
    private int overFlowCounter;
    private final Saver saver;
    private final Formatter formatter;

    LoggerController(Saver saver, Formatter formatter) {
        this.saver = saver;
        this.formatter = formatter;
    }

    private void clearSumAndCounterValues() {
        previousByteSum = 0;
        previousString = null;
        previousIntegerSum = 0;
        previousStringOccuranceNumber = 1;
        overFlowCounter = 0;
    }

    //region logs
    @Override
    public void log(int message) {

        if ( !(state == State.previousInt) ) {
            //если байт - печатаем байтовую сумму
            if ( state == State.previousByte ) {
                saver.print ( formatter.formatInt (previousByteSum ) );
            }
            //если строка - строковую сумму
            else if ( state == State.previousString ) {
                saver.print(formatter.formatStringSequence ( previousString, previousStringOccuranceNumber));

            }
            //обнуляем все предыдущие сообщения и счетчики
            clearSumAndCounterValues();
        }
        previousIntegerSum = (int) isSumOverflowNew ( message, previousIntegerSum, Integer.MAX_VALUE, Integer.MIN_VALUE );
        state = State.previousInt;

    }
    @Override
    public void log(byte message) {

        if ( !(state == State.previousByte) ) {
            //если байт - печатаем байтовую сумму
            if ( state == State.previousInt ) {

                printOverFlowsIfExist (getGuardianValue(Integer.MAX_VALUE, Integer.MIN_VALUE) );
                saver.print ( formatter.formatInt ( previousIntegerSum ) );

            }
            //если строка - строковую сумму
            else if ( state == State.previousString ) {
                saver.print (formatter.formatStringSequence ( previousString, previousStringOccuranceNumber )  );
            }
            //обнуляем все предыдущие сообщения и счетчики
            clearSumAndCounterValues ();
        }
        previousByteSum = (byte) isSumOverflowNew ( message, previousByteSum, Byte.MAX_VALUE, Byte.MIN_VALUE );
        state = State.previousByte;
    }
    @Override
    public  void log(String message) {

        if ( !(state == State.previousString) ) {
            if ( state == State.previousInt ) {
                printOverFlowsIfExist (getGuardianValue(Integer.MAX_VALUE, Integer.MIN_VALUE) );
                saver.print ( formatter.formatInt ( previousIntegerSum ));
            }
            if ( state == State.previousByte ) {
                printOverFlowsIfExist (getGuardianValue(Byte.MAX_VALUE, Byte.MIN_VALUE) );
                saver.print ( formatter.formatInt ( previousByteSum ) );
            }
            clearSumAndCounterValues ();
        }
        if(previousString==null){
            previousString=message;
        }
        else {
            if ( previousString.equals( message ) ) {
                previousStringOccuranceNumber++;
            }
            else {
                saver.print(formatter.formatStringSequence ( previousString, previousStringOccuranceNumber ));
                previousString = message;
            }

        }
        state = State.previousString;
    }

    @Override
    public void log(char message) {
        saver.print ( formatter.formatChar ( message ));
    }





    @Override
    public void log(String... messages) {
        saver.print ( Arrays.toString ( messages ).replace ( ", ", "\n" ).replace ( "[", "" ).replace ( "]", "" ) );
    }

    @Override
    public  void log(int... messages) {
        saver.print ( formatter.formatIntArray ( messages ) );
    }

    @Override
    public void log(int[][] ints) {
        saver.print ( formatter.formatIntMatrix(ints));
    }


    @Override
    public void stopLogging() {
        switch (state) {
            case previousByte:
                printOverFlowsIfExist ( Byte.MAX_VALUE );
                saver.print ( formatter.formatInt ( previousByteSum ) );
                break;
            case previousInt:
                printOverFlowsIfExist ( Integer.MAX_VALUE );
                saver.print ( formatter.formatInt ( previousIntegerSum ) );
                break;
            case previousString:
                saver.print(formatter.formatStringSequence ( previousString, previousStringOccuranceNumber ));
                break;

        }
        clearSumAndCounterValues ();
    }

    private int getGuardianValue(int maxValue, int minValue){
        if ( overFlowCounter < 0 ) return minValue;
        else return maxValue;
    }
    //endregion

    //region Maths
    private long isSumOverflowNew(int value, long sum, long maxValue, long minValue) {
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

    private void printOverFlowsIfExist(int guardian) {

        for (int i = 0; i < Math.abs ( overFlowCounter ); i++) {
            saver.print ( formatter.formatInt ( guardian ) );
        }
    }

}
