package com.acme.edu.implementations;

import com.acme.edu.interfaces.Message;

public abstract class MegaMessage implements Message {
    protected String message;
    MegaMessage lastMessage;
    String overFlowString = "";
    int overFlow = 0;

    protected MegaMessage(String message) {
        this.message = message;
    }

    protected MegaMessage(MegaMessage lastMessage) {
        this.lastMessage = lastMessage;
    }

    abstract boolean isTheSameType(MegaMessage megaMessage);


}
