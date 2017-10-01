package com.acme.edu.messages.types;

import com.acme.edu.messages.DataMessage;
import com.acme.edu.messages.Message;
import com.acme.edu.messages.MessageType;

public class IntegerMessage extends DataMessage<Integer> {
    public static final String TYPE_PREFIX = "primitive";

    private Integer calculatedSum;
    private String calculatedValue;
    private boolean isSumOverflow;

    public IntegerMessage(Integer messageValue) {
        super(messageValue);
    }

    @Override
    protected void processNewMessageInternal() {
        Message previousMessage = getPreviousMessage();
        if (previousMessage.getType() == MessageType.INTEGER) {
            DataMessage dataMessage = (DataMessage) previousMessage;
            Integer previousValue = (Integer) dataMessage.getMessageValue();
            isSumOverflow = isSumOverflow(previousValue, getMessageValue());
            calculatedSum = previousValue + getMessageValue();
        } else {
            calculatedValue = String.valueOf(getMessageValue());
        }
    }

    @Override
    public MessageType getType() {
        return MessageType.INTEGER;
    }

    @Override
    public String getPrefix() {
        return TYPE_PREFIX;
    }

//    @Override
//    public String toString() {
//        String valueToPrint;
//        if (calculatedSum != null) {
//            if (isSumOverflow) {
//                valueToPrint = getPreviousMessage().getPreviousMessage() + "\n" + getMessageValue();
//            } else {
//
//            }
//        } else {
//
//        }
//    }

    private boolean isSumOverflow(int a, int b) {
        long result = (long) a + b;
        return !(result == (int) result);
    }
}
