package com.acme.edu.implementations.messages;

import com.acme.edu.interfaces.Formatter;
import com.acme.edu.interfaces.Saver;

public class StringMessage extends MegaMessage {

    public StringMessage(String message, Formatter formatter, Saver saver) {
        super(message, formatter, saver);
    }

    @Override
    public void getMessage() {
       saver.print(getSequence(message));
    }

    @Override
    public void setMessage(MegaMessage lastMessage) {
        if (lastMessage == null) {
            return;
        }
        overFlow = lastMessage.getOverFlow();
        String value = lastMessage.getElementaryMessage();

        if (!this.isTheSameType(lastMessage)) {
            lastMessage.getMessage();
            return;
        }
        if (value.equals(message)) {
            overFlow++;
        } else {
            lastMessage.getMessage();
            overFlow = 0;
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
