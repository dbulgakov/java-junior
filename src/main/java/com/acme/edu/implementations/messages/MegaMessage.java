package com.acme.edu.implementations.messages;

import com.acme.edu.interfaces.Formatter;
import com.acme.edu.interfaces.SimpleMessage;

public abstract class MegaMessage implements SimpleMessage {
    String message;
    String overFlowString = "";
    int overFlow = 0;
    Formatter formatter;

    protected MegaMessage(String message, Formatter formatter) {
        this.message = message;
        this.formatter = formatter;
    }

    protected String getOverFlowString() {
        return overFlowString;
    }

    protected String getElementaryMessage() {
        return message;
    }

    protected int getOverFlow() {
        return overFlow;
    }

}
