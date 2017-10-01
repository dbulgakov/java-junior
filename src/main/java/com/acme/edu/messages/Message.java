package com.acme.edu.messages;

import com.acme.edu.formatter.MessageFormatter;
import com.acme.edu.saver.DataSaver;

public abstract class Message {
    private Message previousMessage;

    private MessageFormatter messageFormatter;
    private DataSaver dataSaver;


    protected abstract void processNewMessageInternal();

    public abstract void save();

    public abstract MessageType getType();

    public abstract String getTypePrefixName();

    public Message process() {
        if (previousMessage != null) {
            processNewMessageInternal();
        }
        return this;
    }

    public Message getPreviousMessage() {
        return previousMessage;
    }

    public void setPreviousMessage(Message previousMessage) {
        this.previousMessage = previousMessage;
    }

    public MessageFormatter getFormatter() {
        return messageFormatter;
    }

    public void setFormatter(MessageFormatter messageFormatter) {
        this.messageFormatter = messageFormatter;
    }

    public DataSaver getDataSaver() {
        return dataSaver;
    }

    public void setDataSaver(DataSaver dataSaver) {
        this.dataSaver = dataSaver;
    }
}
