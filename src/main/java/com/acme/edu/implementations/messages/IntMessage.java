package com.acme.edu.implementations.messages;

import com.acme.edu.interfaces.Formatter;

public class IntMessage extends NumericMessage {

    public IntMessage(String value, Formatter formatter) {
        super(value, formatter);
    }

    @Override
    public String getMessage() {
        return formatter.formatInt(message) + getOverFlowString();
    }

    @Override
    public void setMessage(MegaMessage lastMessage) {
        if (lastMessage != null) {
            int number = Integer.parseInt(message);
            int previousSum = Integer.parseInt(lastMessage.getElementaryMessage());
            overFlow = lastMessage.getOverFlow();
            previousSum = (int) isSumOverflow(number, previousSum, Integer.MAX_VALUE, Integer.MIN_VALUE);
            message = previousSum + "";
        }
    }

    @Override
    public boolean isTheSameType(MegaMessage anotherMessage) {
        return anotherMessage instanceof IntMessage | anotherMessage == null;
    }

    @Override
    public String getOverFlowString() {
        String overFlowString = "";
        for (int i = 0; i < Math.abs(overFlow); i++) {
            overFlowString += System.lineSeparator()
                    + formatter.formatInt(String.valueOf(getGuardianValue(Integer.MAX_VALUE, Integer.MIN_VALUE)));
        }
        return overFlowString;
    }
}
