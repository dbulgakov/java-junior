package com.acme.edu.implementations;

import com.acme.edu.interfaces.Formatter;
import com.acme.edu.interfaces.LoggerOOP;
import com.acme.edu.interfaces.Saver;

import java.util.Arrays;


/**
 * Java Coding Style Convention (PDF)
 */
public class LoggerController implements LoggerOOP {


    private MegaMessage megaMessage;
    private final Saver saver;
    private final Formatter formatter;

    LoggerController(Saver saver, Formatter formatter) {
        this.saver = saver;
        this.formatter = formatter;
    }


    //region logs
    @Override
    public void log(int message) {


        if ( megaMessage != null ) {
            if ( !(megaMessage instanceof IntMessage) ) {
                //если байт - печатаем байтовую сумму
                if ( megaMessage instanceof ByteMessage ) {
                    saver.print ( formatter.formatInt ( megaMessage.getMessage () ) );
                    megaMessage = null;
                }
                //если строка - строковую сумму
                else if ( megaMessage instanceof StringMessage ) {
                    saver.print ( formatter.formatStringSequence ( new StringMessage ( megaMessage ).getMessage () ) );
                    megaMessage = null;

                }

            } else {

                megaMessage = new IntMessage ( megaMessage );
                megaMessage.setMessage ( String.valueOf ( message ) );
            }
        }
        if ( megaMessage == null ) {
            megaMessage = new IntMessage ( String.valueOf ( message ) );
        }
    }

    @Override
    public void log(byte message) {

        if ( megaMessage != null ) {
            if ( !(megaMessage instanceof ByteMessage) ) {
                //если байт - печатаем байтовую сумму
                if ( megaMessage instanceof IntMessage ) {

                    saver.print ( formatter.formatInt ( megaMessage.getMessage () ) );
                    megaMessage = null;

                }
                //если строка - строковую сумму
                else if ( megaMessage instanceof StringMessage ) {
                    saver.print ( formatter.formatStringSequence ( new StringMessage ( megaMessage ).getMessage () ) );
                    megaMessage = null;
                }
                //обнуляем все предыдущие сообщения и счетчики
            } else {


                megaMessage = new ByteMessage ( megaMessage );
                megaMessage.setMessage ( String.valueOf ( message ) );
            }
        }
        if ( megaMessage == null ) {
            megaMessage = new ByteMessage ( String.valueOf ( message ) );
        }
    }

    @Override
    public void log(String message) {

        if ( megaMessage != null ) {
            if ( !(megaMessage instanceof StringMessage) ) {
                if ( megaMessage instanceof IntMessage ) {
                    saver.print ( formatter.formatInt ( megaMessage.getMessage () ) );
                    megaMessage = null;
                } else if ( megaMessage instanceof ByteMessage ) {
                    saver.print ( formatter.formatInt ( megaMessage.getMessage () ) );
                    megaMessage = null;
                }

            } else {

                megaMessage = new StringMessage ( megaMessage );
                megaMessage.setMessage ( message );
            }
        }
        if ( megaMessage == null ) {
            megaMessage = new StringMessage ( message );
        }

    }


    @Override
    public void log(char message) {
        saver.print ( formatter.formatChar ( message ) );
    }


    @Override
    public void log(String... messages) {
        saver.print ( Arrays.toString ( messages ).replace ( ", ", "\n" ).replace ( "[", "" ).replace ( "]", "" ) );
    }

    @Override
    public void log(int... messages) {
        saver.print ( formatter.formatIntArray ( messages ) );
    }

    @Override
    public void log(int[][] ints) {
        saver.print ( formatter.formatIntMatrix ( ints ) );
    }


    @Override
    public void stopLogging() {
        if ( megaMessage instanceof IntMessage ) {
            saver.print ( formatter.formatInt ( megaMessage.getMessage () ) );
        } else if ( megaMessage instanceof ByteMessage ) {
            saver.print ( formatter.formatInt ( megaMessage.getMessage () ) );
        } else if ( (megaMessage instanceof StringMessage) ) {
            saver.print ( formatter.formatStringSequence ( new StringMessage ( megaMessage ).getMessage () ) );
        }

        megaMessage = null;

    }


}

class Main {
    public static void main(String[] args) {
        //region when
        Logger.log ( "str 1" );
        Logger.log ( "str 2" );
        Logger.log ( "str 2" );
        Logger.log ( 0 );
        Logger.log ( "str 2" );
        Logger.log ( "str 3" );
        Logger.log ( "str 3" );
        Logger.log ( "str 3" );
        Logger.stopLogging ();
        //endregion
    }
}
