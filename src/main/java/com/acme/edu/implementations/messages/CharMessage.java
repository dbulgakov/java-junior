package com.acme.edu.implementations.messages;

import com.acme.edu.interfaces.Formatter;

public class CharMessage extends MegaMessage {
    public CharMessage(String message, Formatter formatter) {
        super ( message, formatter );
    }

    @Override
    public String getOverFlowString() {
        return "";
    }

    @Override
    public String getMessage() {
        return formatter.formatChar ( message );
    }

    @Override
    public void setMessage(String value, String summary, int overFlow) {
        message = value;
    }
}
