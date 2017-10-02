package com.acme.edu.implementations;

import com.acme.edu.implementations.messages.*;
import com.acme.edu.interfaces.LoggerOOP;
import com.acme.edu.interfaces.Saver;

import java.util.Arrays;


/**
 * Java Coding Style Convention (PDF)
 */
public class LoggerController implements LoggerOOP {

    private MegaMessage lastMessage;
    private final Saver saver;

    LoggerController(Saver saver) {
        this.saver = saver;
    }


    @Override
    public void log(IntMessage message) {

        if ( lastMessage != null ) {
            if ( !(lastMessage instanceof IntMessage) ) {
                if ( lastMessage instanceof ByteMessage ) {
                    saver.print ( lastMessage.getMessage () );
                    lastMessage = null;
                } else if ( lastMessage instanceof StringMessage ) {
                    saver.print ( lastMessage.getMessage () );
                    lastMessage = null;
                }
            } else {
                message.setMessage ( lastMessage.getElementaryMessage (), lastMessage.getOverFlowString (), lastMessage.getOverFlow () );
            }
        } else {
            message.setMessage ( 0 + "", 0 + "", 0 );
        }
        lastMessage = message;
    }

    @Override
    public void log(ByteMessage message) {

        if ( lastMessage != null ) {
            if ( !(lastMessage instanceof ByteMessage) ) {
                if ( lastMessage instanceof IntMessage ) {
                    saver.print ( lastMessage.getMessage () );
                    lastMessage = null;
                } else if ( lastMessage instanceof StringMessage ) {
                    saver.print ( lastMessage.getMessage () );
                    lastMessage = null;
                }
            } else {
                message.setMessage ( lastMessage.getElementaryMessage (), lastMessage.getOverFlowString (), lastMessage.getOverFlow () );

            }
        } else {
            message.setMessage ( 0 + "", 0 + "", 0 );
        }
        lastMessage = message;
    }


    @Override
    public void log(StringMessage message) {

        if ( lastMessage != null ) {
            if ( !(lastMessage instanceof StringMessage) ) {
                if ( lastMessage instanceof IntMessage ) {
                    saver.print ( lastMessage.getMessage () );
                    lastMessage = null;
                } else if ( lastMessage instanceof ByteMessage ) {
                    saver.print ( lastMessage.getMessage () );
                    lastMessage = null;
                }

            } else {
                message.setMessage ( lastMessage.getElementaryMessage (), lastMessage.getOverFlowString (), lastMessage.getOverFlow () );

            }
        } else {
            message.setMessage ( "", "", 0 );
        }
        lastMessage = message;
    }


    @Override
    public void log(CharMessage message) {
        saver.print ( String.valueOf ( message.getMessage () ) );
    }


    @Override
    public void log(String... messages) {
        saver.print ( Arrays.toString ( messages ).replace ( ", ", "\n" ).replace ( "[", "" ).replace ( "]", "" ) );
    }

    @Override
    public void log(int... messages) {

        //saver.print ( formatter.formatIntArray ( messages ) );
    }

    @Override
    public void log(int[][] ints) {

        //saver.print ( formatter.formatIntMatrix ( ints ) );
    }


    @Override
    public void stopLogging() {
        if ( lastMessage instanceof IntMessage ) {
            saver.print ( lastMessage.getMessage () );
        } else if ( lastMessage instanceof ByteMessage ) {
            saver.print ( lastMessage.getMessage () );
        } else if ( (lastMessage instanceof StringMessage) ) {
            saver.print ( lastMessage.getMessage () );
        }
        lastMessage = null;
    }
}

class Main {
    public static void main(String[] args) {
        //region when
        Logger.log ( 'a' );
        Logger.log ( 'b' );
        //endregion
    }
}
