package com.acme.edu.implementations.messages;

import com.acme.edu.implementations.MathFunction;
import com.acme.edu.interfaces.Formatter;

public class IntMessage extends MegaMessage {

    public IntMessage(String value, Formatter formatter) {
        super ( value, formatter );
    }

    @Override
    public String getMessage() {
        return formatter.formatInt ( message ) + getOverFlowString ();
    }

    @Override
    public void setMessage(String value, String summary, int previousOverFlow) {
        int number = Integer.parseInt ( message );
        int previousSum = Integer.parseInt ( value );
        MathFunction.setOverFlowCounter ( previousOverFlow );
        previousSum = (int) MathFunction.isSumOverflow ( number, previousSum, Integer.MAX_VALUE, Integer.MIN_VALUE );
        overFlow = MathFunction.getOverFlowCounter ();
        message = previousSum + "";
    }

    @Override
    public String getOverFlowString() {
        String overFlowString = "";
        for (int i = 0; i < Math.abs ( overFlow ); i++) {
            overFlowString += System.lineSeparator ()
                    + formatter.formatInt ( String.valueOf ( MathFunction.getGuardianValue ( Integer.MAX_VALUE, Integer.MIN_VALUE ) ) );
        }
        return overFlowString;
    }
}
