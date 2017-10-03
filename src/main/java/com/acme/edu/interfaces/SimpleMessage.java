package com.acme.edu.interfaces;


import com.acme.edu.implementations.messages.MegaMessage;

public interface SimpleMessage {

    String getMessage();

    void setMessage(MegaMessage lastMessage);

    boolean isTheSameType(MegaMessage anotherMessage);
}
