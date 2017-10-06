package com.acme.edu.messages.types;

import com.acme.edu.exceptions.DataSaveException;
import com.acme.edu.messages.DataMessage;
import com.acme.edu.messages.Message;

public abstract class NumericMessage<MSG_TYPE extends Number> extends DataMessage<MSG_TYPE> {
    public static final String TYPE_PREFIX = "primitive";

    private long calculatedSum;
    private long overflowNumber;


    public NumericMessage(MSG_TYPE messageValue) {
        super(messageValue);
    }

    @Override
    @SuppressWarnings("unchecked cast")
    protected void processNewMessageInternal() throws DataSaveException {
        Message previousMessage = getPreviousMessage();
        if (isPreviousMessageExist()) {
            if (isSameType(previousMessage)) {

                NumericMessage<MSG_TYPE> previousDataMessage = (NumericMessage<MSG_TYPE>) previousMessage;
                calculatedSum = previousDataMessage.getCalculatedSum();
                overflowNumber = previousDataMessage.getOverflowNumber();

                calculatedSum = calculateNewSumAndCheckOverflow(getMessageValue().intValue(), calculatedSum);
            } else {
                clearState();

                previousMessage.save();

            }
        } else {
            clearState();
        }
    }

    private long calculateNewSumAndCheckOverflow(int newValue, long previousValue) {
        long checkerValue = getCheckerValue(newValue, previousValue);

        previousValue += newValue - checkerValue;

        return getFinalCorrectedSum(previousValue);
    }

    private long getCheckerValue(int newValue, long previousValue) {
        long checkerValue = 0;

        if (newValue > 0 & previousValue >= 0 && checkerValue - previousValue <= newValue) {
            checkerValue = getMaxValue();
            overflowNumber++;
        } else if (newValue < 0 & previousValue <= 0 && checkerValue - previousValue >= newValue) {
            checkerValue = getMinValue();
            overflowNumber--;
        }

        return checkerValue;
    }

    private long getFinalCorrectedSum(long unCorrectedSum) {
        if (unCorrectedSum > 0 & overflowNumber < 0) {
            unCorrectedSum = getMinValue() + unCorrectedSum;
            overflowNumber++;
        } else if (unCorrectedSum < 0 & overflowNumber > 0) {
            unCorrectedSum = getMaxValue() + unCorrectedSum;
            overflowNumber--;
        }
        return unCorrectedSum;
    }

    @Override
    public String toString() {
        String valueToPrint = String.valueOf(calculatedSum);
        if (overflowNumber != 0) {
            String overflowEdge = String.valueOf(overflowNumber > 0 ? getMaxValue() : getMinValue());
            valueToPrint = String.valueOf(getCalculatedSum()) + '\n' + new String(new char[(int) overflowNumber]).replace("\0", overflowEdge);
        }
        return String.valueOf(valueToPrint);
    }


    abstract long getMaxValue();

    abstract long getMinValue();

    private void clearState() {
        calculatedSum = getMessageValue().longValue();
        overflowNumber = 0;
    }

    public long getCalculatedSum() {
        return calculatedSum;
    }

    public long getOverflowNumber() {
        return overflowNumber;
    }

    @Override
    public String getPrefix() {
        return TYPE_PREFIX;
    }
}
