package com.acme.edu.implementations.messages;

import com.acme.edu.interfaces.Formatter;
import com.acme.edu.interfaces.SimpleMessage;

public abstract class MegaMessage implements SimpleMessage {
    protected String message;
    protected String overFlowString = "";
    protected int overFlow = 0;
    Formatter formatter;

    protected MegaMessage(String message, Formatter formatter) {
        this.message = message;
        this.formatter = formatter;
    }

    public String getOverFlowString() {
        return overFlowString;
    }

    public String getElementaryMessage() {
        return message;
    }

    public int getOverFlow() {
        return overFlow;
    }

}
