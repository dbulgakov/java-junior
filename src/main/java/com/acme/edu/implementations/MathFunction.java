package com.acme.edu.implementations;

class MathFunction {

    MathFunction(int overFlowCounter) {
        this.overFlowCounter = overFlowCounter;
    }

    int overFlowCounter;
//работает позже рефакторинг
// @Deprecated
    long isSumOverflowNew(int value, long sum, long maxValue, long minValue) {
        long guardian = 0;

//region если положительное переполнение, то увеличиваем счетчик
        if ( value > 0 & sum >= 0 ) {


//если выполняется - переполнение
            if ( guardian - sum <= value ) {
                guardian = maxValue;
                if ( overFlowCounter >= 0 ) {
                    overFlowCounter++;
                } else {
                    overFlowCounter++;
                    sum -= 1;//пока считаем, что тут нет переполнения
                }
            }
        }
//endregion
//region если отрицательное переполнение, то уменьшаем счетчик
        else if ( value < 0 & sum <= 0 ) {

            if ( guardian - sum >= value ) {
                guardian = minValue;
                if ( overFlowCounter > 0 ) {
                    overFlowCounter--;
                    sum -= 1;
                } else {
                    overFlowCounter--;
                }
            }
        }
//endregion
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
