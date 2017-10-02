package com.acme.edu.implementations;

public class StringMessage extends MegaMessage {

    private final States.State state = States.State.previousString;

    StringMessage(MegaMessage lastMessage) {
        super ( lastMessage );

    }

    StringMessage(String message) {
        super ( message );
    }

    @Override
    public States.State getState() {
        return state;
    }

    @Override
    public String getOverFlowString() {
        return overFlowString;
    }

    @Override
    public String getMessage() {
        if(!lastMessage.overFlowString.equals ("" ))lastMessage.overFlowString+=System.lineSeparator ();
        return lastMessage.overFlowString + getSequence ();

    }

    private String getSequence() {
        if ( lastMessage.overFlow > 0 )
            return lastMessage.message + " (x" + (lastMessage.overFlow + 1) + ")" ;
        else return lastMessage.message;
    }

    @Override
    public void setMessage(String value) {
        if ( lastMessage.message != null ) {
            overFlowString = lastMessage.overFlowString;
            if ( lastMessage.message.equals ( value ) ) {
                overFlow = lastMessage.overFlow + 1;
                message = value;
            } else {
                overFlowString += getSequence ();
                message = value;
                overFlow = 0;
            }
        } else {
            overFlowString = value;
            message = value;
        }
    }
}
