package com.acme.edu.implementations.messages;

import com.acme.edu.interfaces.Formatter;

public class StringMessage extends MegaMessage {

    public StringMessage(String message, Formatter formatter) {
        super(message, formatter);
    }

    @Override
    public String getMessage() {
        if (overFlowString.equals("")) return getSequence(message);
        else return overFlowString + System.lineSeparator() + getSequence(message);
    }


    @Override
    public void setMessage(MegaMessage lastMessage) {
        if (lastMessage != null) {
            overFlow = lastMessage.getOverFlow();
            overFlowString = lastMessage.getOverFlowString();
            String value = lastMessage.getElementaryMessage();
            if (!value.equals(""))
                if (value.equals(message)) {
                    overFlow++;
                } else {
                    if (overFlowString.equals("")) {
                        overFlowString += getSequence(value);
                    } else {
                        overFlowString += System.lineSeparator() + getSequence(value);
                    }
                    overFlow = 0;
                }
        }
    }

    @Override
    public boolean isTheSameType(MegaMessage anotherMessage) {

        return anotherMessage instanceof StringMessage | anotherMessage == null;
    }

    private String getSequence(String value) {
        if (overFlow > 0)
            return formatter.formatStringSequence(value, (overFlow + 1));
        else return formatter.formatString(value);
    }

}
