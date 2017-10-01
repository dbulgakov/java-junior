package com.acme.edu.messages;

import com.acme.edu.formatter.HasPrefix;
import com.acme.edu.formatter.MessageFormatter;
import com.acme.edu.saver.DataSaver;

public abstract class Message implements HasPrefix{
    private Message previousMessage;

    private MessageFormatter messageFormatter;
    private DataSaver dataSaver;

    public void save() {
        if (getDataSaver() == null || getFormatter() == null) {
            throw new IllegalStateException("Saver and formatter are required to be setup!");
        }

        getDataSaver().save(getFormatter().format(this));
    }

    public Message process() {
        if (previousMessage != null) {
            processNewMessageInternal();
        }
        return this;
    }

    protected abstract void processNewMessageInternal();

    public abstract MessageType getType();

    // region saver and formatter

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

    // endregion
}
