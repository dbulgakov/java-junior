package com.acme.edu.implementations;

import com.acme.edu.interfaces.Message;

public abstract class MegaMessage implements Message {
    protected String message;
    MegaMessage lastMessage;
    String overFlowString = "";
    int overFlow = 0;

    protected MegaMessage() {

    }
    protected MegaMessage(String message) {
        this.message = message;
    }

    protected abstract void setMessage(String message, String overFlowString, int overFlow);
    protected MegaMessage(MegaMessage lastMessage) {
        this.lastMessage = lastMessage;
    }

    abstract boolean isTheSameType(MegaMessage megaMessage);

    @Override
    public abstract void setMessage(String message);

}
