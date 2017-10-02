package com.acme.edu.implementations.messages;

import com.acme.edu.implementations.MathFunction;
import com.acme.edu.interfaces.Formatter;

public class ByteMessage extends MegaMessage {

    public ByteMessage(String message, Formatter formatter) {
        super ( message, formatter );
    }

    @Override
    public String getMessage() {
        return formatter.formatInt ( message ) + getOverFlowString ();
    }

    @Override
    public void setMessage(String value, String summary, int previousOverFlow) {
        byte number = Byte.parseByte ( message );
        int previousSum = Byte.parseByte ( value );
        MathFunction.setOverFlowCounter ( previousOverFlow );
        previousSum = (byte) MathFunction.isSumOverflow ( number, previousSum, Byte.MAX_VALUE, Byte.MIN_VALUE );
        overFlow = MathFunction.getOverFlowCounter ();
        message = previousSum + "";
    }

    @Override
    public String getOverFlowString() {
        String overFlowString = "";
        for (int i = 0; i < Math.abs ( overFlow ); i++) {
            overFlowString += System.lineSeparator ()
                    + formatter.formatInt ( String.valueOf ( MathFunction.getGuardianValue ( Byte.MAX_VALUE, Byte.MIN_VALUE ) ) );
        }
        return overFlowString;
    }

}
