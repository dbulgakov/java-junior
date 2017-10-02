package com.acme.edu.interfaces;

import com.acme.edu.implementations.States;

public interface Message {
     String getMessage();
     void setMessage(String message);
     States.State getState();
     String getOverFlowString();
}
