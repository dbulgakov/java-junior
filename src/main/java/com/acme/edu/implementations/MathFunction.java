package com.acme.edu.implementations;

public class MathFunction {

    private static int overFlowCounter;

    public static int getOverFlowCounter() {
        return overFlowCounter;
    }

    public static void setOverFlowCounter(int previousOverFlowCounter) {
        overFlowCounter = previousOverFlowCounter;
    }

    public static long isSumOverflow(int value, long sum, long maxValue, long minValue) {
        long guardian = 0;
        if ( value > 0 & sum >= 0 ) {
            if ( guardian - sum <= value ) {
                guardian = maxValue;
                if ( overFlowCounter < 0 ) {
                    sum -= 1;
                }
                overFlowCounter++;
            }
        } else if ( value < 0 & sum <= 0 ) {
            if ( guardian - sum >= value ) {
                guardian = minValue;
                if ( overFlowCounter > 0 ) {
                    sum -= 1;
                }
                overFlowCounter--;
            }
        }
        sum += value - guardian;
        if ( sum > 0 & overFlowCounter < 0 ) {
            sum = minValue + sum;
            overFlowCounter++;
        } else if ( sum < 0 & overFlowCounter > 0 ) {
            sum = maxValue + sum;
            overFlowCounter--;
        }
        return sum;
    }

    public static int getGuardianValue(int maxValue, int minValue) {
        if ( overFlowCounter < 0 ) return minValue;
        else return maxValue;
    }
}
