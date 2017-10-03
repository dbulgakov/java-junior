package com.acme.edu.implementations.messages;

import com.acme.edu.interfaces.Formatter;

public class CharMessage extends MegaMessage {
    public CharMessage(String message, Formatter formatter) {
        super(message, formatter);
    }

    @Override
    public String getOverFlowString() {
        return overFlowString;
    }

    @Override
    public String getMessage() {
        return overFlowString;
    }

    @Override
    public void setMessage(MegaMessage megaMessage) {
        if (megaMessage != null)
            overFlowString += System.lineSeparator() + megaMessage.getOverFlowString();
        overFlowString += formatter.formatChar(message);
    }

    @Override
    public boolean isTheSameType(MegaMessage anotherMessage) {
        return anotherMessage instanceof CharMessage | anotherMessage == null;
    }
}
