package com.acme.edu.implementations;

public class StringMessage extends MegaMessage {

    int overFLow;

    StringMessage(String message) {
        super ( message );
        this.message = message;
    }

    @Override
    boolean isTheSameType(MegaMessage megaMessage) {
        return megaMessage instanceof StringMessage;
    }

    @Override
    public void setMessage(String message) {
        
    }

    @Override
    public String getMessage() {
        //  if ( !lastMessage.overFlowString.equals ( "" ) ) lastMessage.overFlowString += System.lineSeparator ();
        //return lastMessage.overFlowString + getSequence ();
        return overFlowString;
    }

    public void setOverFlow(int _overFLow, String value, String _overFlowString) {

        if ( value == message ) {
            overFlow = _overFLow + 1;
        } else {
            overFlowString += getSequence ( value );
            overFlow = 0;
        }
    }

    @Override
    public void setMessage(String value, String _overFlowString, int _overFlow) {

        if ( value != "" )
            setOverFlow ( overFLow, value, _overFlowString );


    }

    @Override
    public String getOverFlowString() {
        return overFlowString;
    }

    private String getSequence(String value) {
        if ( overFlow > 0 )
            return value + " (x" + (lastMessage.overFlow + 1) + ")";
        else return value;
    }
}
