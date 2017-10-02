package com.acme.edu.implementations;

public class ByteMessage extends MegaMessage {

    private MathFunction math = new MathFunction ( lastMessage == null ? 0 : lastMessage.overFlow );

    ByteMessage(MegaMessage lastMessage) {
        super ( lastMessage );
    }

    @Override
    boolean isTheSameType(MegaMessage megaMessage) {
        return megaMessage instanceof ByteMessage;
    }

    ByteMessage(String message) {
        super ( message );
    }

    @Override
    public String getMessage() {

        return message + getOverFlowString ();
    }

    @Override
    public void setMessage(String value) {
        byte number = Byte.parseByte ( message );
        int previousSum = 0;
        previousSum = Byte.parseByte ( value );
        previousSum = (byte) math.isSumOverflow ( number, previousSum, Integer.MAX_VALUE, Integer.MIN_VALUE );
        overFlow = math.overFlowCounter;
        message = previousSum + "";
    }

    @Override
    public String getOverFlowString() {
        String overFlowString = "";
        for (int i = 0; i < Math.abs ( overFlow ); i++) {
            overFlowString += System.lineSeparator () + math.getGuardianValue ( Byte.MAX_VALUE, Byte.MIN_VALUE );
        }
        return overFlowString;
    }

    //endregion

}
