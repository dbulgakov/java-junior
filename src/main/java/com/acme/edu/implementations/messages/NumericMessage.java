package com.acme.edu.implementations.messages;

import com.acme.edu.interfaces.Formatter;
import com.acme.edu.interfaces.Saver;

public abstract class NumericMessage extends MegaMessage {


    protected NumericMessage(String message, Formatter formatter, Saver saver) {
        super(message, formatter, saver);
    }

    protected long isSumOverflow(int value, long sum, long maxValue, long minValue) {
        long guardian = 0;

        if (value > 0 & sum >= 0) {
            if (guardian - sum <= value) {
                guardian = maxValue;
                if (overFlow < 0) {
                    sum -= 1;
                }
                overFlow++;
            }
        } else if (value < 0 & sum <= 0) {
            if (guardian - sum >= value) {
                guardian = minValue;
                if (overFlow > 0) {
                    sum -= 1;
                }
                overFlow--;
            }
        }
        sum += value - guardian;
        if (sum > 0 & overFlow < 0) {
            sum = minValue + sum;
            overFlow++;
        } else if (sum < 0 & overFlow > 0) {
            sum = maxValue + sum;
            overFlow--;
        }
        return sum;
    }

    public int getGuardianValue(int maxValue, int minValue) {
        if (overFlow < 0) return minValue;
        else return maxValue;
    }
}
