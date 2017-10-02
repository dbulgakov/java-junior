package com.acme.edu.implementations;

public class IntMessage extends MegaMessage {

    private MathFunction math = new MathFunction ( lastMessage == null ? 0 : lastMessage.overFlow );

    IntMessage(MegaMessage lastMessage) {
        super ( lastMessage );
    }

    @Override
    boolean isTheSameType(MegaMessage megaMessage) {
        return megaMessage instanceof IntMessage;
    }

    public IntMessage() {
        super ();
    }

    public IntMessage(String value) {
        super ( value );

    }

    @Override
    public String getMessage() {

        return message + getOverFlowString ();
    }

    @Override
    public void setMessage(String value) {
        int number = Integer.parseInt ( message );
        int previousSum = 0;
        previousSum = Integer.parseInt ( value );
        previousSum = (int) math.isSumOverflow ( number, previousSum, Integer.MAX_VALUE, Integer.MIN_VALUE );
        overFlow = math.overFlowCounter;
        message = previousSum + "";
    }


    public String getOverFlowString() {
        String overFlowString = "";
        for (int i = 0; i < Math.abs ( overFlow ); i++) {
            overFlowString += System.lineSeparator () + math.getGuardianValue ( Integer.MAX_VALUE, Integer.MIN_VALUE );
        }
        return overFlowString;
    }
}
