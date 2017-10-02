package com.acme.edu.implementations;

class MathFunction {
    int overFlowCounter;

    MathFunction(int overFlowCounter) {
        this.overFlowCounter = overFlowCounter;
    }


    long isSumOverflow(int value, long sum, long maxValue, long minValue) {
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

    int getGuardianValue(int maxValue, int minValue) {
        if ( overFlowCounter < 0 ) return minValue;
        else return maxValue;
    }
}
