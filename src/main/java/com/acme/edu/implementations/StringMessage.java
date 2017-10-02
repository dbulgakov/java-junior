package com.acme.edu.implementations;

public class StringMessage extends MegaMessage {

    StringMessage(MegaMessage lastMessage) {
        super ( lastMessage );

    }

    @Override
    boolean isTheSameType(MegaMessage megaMessage) {
        return megaMessage instanceof StringMessage;
    }

    @Override
    public String getMessage() {
        if ( !lastMessage.overFlowString.equals ( "" ) ) lastMessage.overFlowString += System.lineSeparator ();
        return lastMessage.overFlowString + getSequence ();

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

    StringMessage(String message) {
        super ( message );
    }

    @Override
    public String getOverFlowString() {
        return overFlowString;
    }

    private String getSequence() {
        if ( lastMessage.overFlow > 0 )
            return lastMessage.message + " (x" + (lastMessage.overFlow + 1) + ")";
        else return lastMessage.message;
    }
}
