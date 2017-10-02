package com.acme.edu.implementations;

public class IntMessage extends MegaMessage {

    private States.State state = States.State.previousInt;

    private MathFunction math = new MathFunction ( lastMessage == null ? 0 : lastMessage.overFlow );

    IntMessage(MegaMessage lastMessage) {
        super ( lastMessage );
    }

    IntMessage(String value) {
        super ( value );

    }

    @Override
    public String getMessage() {

        return message + getOverFlowString ();
    }

    public String getOverFlowString() {
        String overFlowString =  "";
        for (int i = 0; i < Math.abs ( overFlow ); i++) {
            overFlowString += System.lineSeparator () +math.getGuardianValue ( Integer.MAX_VALUE, Integer.MIN_VALUE );
        }
        return overFlowString;
    }

    @Override
    public void setMessage(String value) {
        int number = Integer.parseInt ( value );
        int previousSum = 0;
        if ( lastMessage.EqualsStates ( States.State.previousInt ) )
            previousSum = Integer.parseInt ( lastMessage.message );
        previousSum = (int) math.isSumOverflowNew ( number, previousSum, Integer.MAX_VALUE, Integer.MIN_VALUE );
        overFlow = math.overFlowCounter;
        message = previousSum + "";
    }

    @Override
    public States.State getState() {
        return state;
    }

}
