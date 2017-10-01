package com.acme.edu.messages.types;

import com.acme.edu.messages.DataMessage;
import com.acme.edu.messages.MessageType;

public class ByteMessage extends DataMessage<Byte>{
    public static final String TYPE_PREFIX = "primitive";

    public ByteMessage(Byte messageValue) {
        super(messageValue);
    }

    @Override
    protected void processNewMessageInternal() {

    }

    @Override
    public void save() {

    }

    @Override
    public MessageType getType() {
        return MessageType.BYTE;
    }

    @Override
    public String getTypePrefixName() {
        return TYPE_PREFIX;
    }
}
