package com.acme.edu.implementations;

import com.acme.edu.interfaces.Formatter;
import com.acme.edu.interfaces.LoggerOOP;
import com.acme.edu.interfaces.Saver;

import java.util.Arrays;


/**
 * Java Coding Style Convention (PDF)
 */
public class LoggerController implements LoggerOOP {

    private MegaMessage lastMessage;
    private final Saver saver;
    private final Formatter formatter;

    LoggerController(Saver saver, Formatter formatter) {
        this.saver = saver;
        this.formatter = formatter;
    }


    //region logs
    @Override
    public void log(IntMessage message) {

        if ( lastMessage != null ) {
            if ( !(lastMessage instanceof IntMessage) ) {
                //если байт - печатаем байтовую сумму
                if ( lastMessage instanceof ByteMessage ) {
                    saver.print ( formatter.formatInt ( lastMessage.getMessage () ) );
                    lastMessage = null;
                }
                //если строка - строковую сумму
                else if ( lastMessage instanceof StringMessage ) {
                    saver.print ( formatter.formatStringSequence ( lastMessage.getMessage () ) );
                    lastMessage = null;
                }
            } else {
                message.setMessage ( lastMessage.message );
            }
        }
        message.setMessage ( 0 + "" );
        lastMessage = message;
    }

    @Override
    public void log(ByteMessage message) {

        if ( lastMessage != null ) {
            if ( !(lastMessage instanceof ByteMessage) ) {
                if ( lastMessage instanceof IntMessage ) {
                    saver.print ( formatter.formatInt ( lastMessage.getMessage () ) );
                    lastMessage = null;
                } else if ( lastMessage instanceof StringMessage ) {
                    saver.print ( formatter.formatStringSequence ( lastMessage.getMessage () ) );
                    lastMessage = null;
                }
            } else {
                message.setMessage ( lastMessage.message );
            }
        } else {
            message.setMessage ( 0 + "" );
        }
        lastMessage = message;
    }


    @Override
    public void log(StringMessage message) {

        if ( lastMessage != null ) {
            if ( !(lastMessage instanceof StringMessage) ) {
                if ( lastMessage instanceof IntMessage ) {
                    saver.print ( formatter.formatInt ( lastMessage.getMessage () ) );
                    lastMessage = null;
                } else if ( lastMessage instanceof ByteMessage ) {
                    saver.print ( formatter.formatInt ( lastMessage.getMessage () ) );
                    lastMessage = null;
                }

            } else {
                message.setMessage ( lastMessage.message );

            }
        } else {
            message.setMessage ( "" );
        }
        lastMessage = message;
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
        if ( lastMessage instanceof IntMessage ) {
            saver.print ( formatter.formatInt ( lastMessage.getMessage () ) );
        } else if ( lastMessage instanceof ByteMessage ) {
            saver.print ( formatter.formatInt ( lastMessage.getMessage () ) );
        } else if ( (lastMessage instanceof StringMessage) ) {
            saver.print ( formatter.formatStringSequence ( lastMessage.getMessage () ) );
        }

        lastMessage = null;

    }


}

class Main {
    public static void main(String[] args) {
        //region when
        Logger.log ( "test string 1" );
        Logger.log ( "other str" );
        Logger.stopLogging ();
        //endregion
    }
}
