package com.acme.edu.implementations.messages;

import com.acme.edu.interfaces.Formatter;

public class ByteMessage extends NumericMessage {

    public ByteMessage(String message, Formatter formatter) {
        super(message, formatter);
    }

    @Override
    public String getMessage() {
        return formatter.formatInt(message) + getOverFlowString();
    }

    @Override
    public void setMessage(MegaMessage lastMessage) {
        if (lastMessage != null) {
            byte number = Byte.parseByte(message);
            int previousSum = Byte.parseByte(lastMessage.getElementaryMessage());
            overFlow = lastMessage.getOverFlow();
            previousSum = (byte) isSumOverflow(number, previousSum, Byte.MAX_VALUE, Byte.MIN_VALUE);
            message = previousSum + "";
        }
    }

    @Override
    public boolean isTheSameType(MegaMessage anotherMessage) {

        return anotherMessage instanceof ByteMessage | anotherMessage == null;
    }

    @Override
    public String getOverFlowString() {
        String overFlowString = "";
        for (int i = 0; i < Math.abs(overFlow); i++) {
            overFlowString += System.lineSeparator()
                    + formatter.formatInt(String.valueOf(getGuardianValue(Byte.MAX_VALUE, Byte.MIN_VALUE)));
        }
        return overFlowString;
    }

}
