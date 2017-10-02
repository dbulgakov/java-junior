package com.acme.edu.implementations;

import com.acme.edu.interfaces.Message;

public abstract class MegaMessage implements Message {
    protected String message;
    MegaMessage lastMessage;
    String overFlowString = "";
    int overFlow = 0;

    MegaMessage(String message) {
        this.message = message;

    }

    MegaMessage(MegaMessage lastMessage) {
        this.lastMessage = lastMessage;
    }

     boolean EqualsStates(States.State state) {
         return getState () == state;
     }


}
