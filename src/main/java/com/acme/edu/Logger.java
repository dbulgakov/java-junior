package com.acme.edu;

/**
 * Java Coding Style Convention (PDF)
 */
public class Logger {
    public static final String MY_SUPER_CONSTANT = "";
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String CHAR_PREFIX = "char: ";



    //region SUM_VARS
    private static byte byteSum=0;
    private static int intSum=0;
    private static String stringSum=null;
    private static int counterString=1;
    // endregion
    //region MAX_MIN_VARS
    private static int MaxValueCounterByte=0;
    private static int MaxValueCounterInt = 0;
    private static int MinValueCounterByte;
    private static int MinValueCounterInt;
    // endregion
    //region STATES_FOR_LAST_CALLING_METHOD
    private  static boolean isString;
    private  static boolean isInt;
    private  static boolean isByte;
    //endregion





private static int SumAndCheckMaxValue(int addingNumber,int lastSum, int maxValue)
{

    int sum = addingNumber + lastSum;

    if(addingNumber > 0 && lastSum> 0) {

        if( sum < 0 || sum>maxValue)
        {
            if(maxValue==Integer.MAX_VALUE){
                MaxValueCounterInt++;
            }
            else if(maxValue==Byte.MAX_VALUE){
                MaxValueCounterByte++;
            }
            return Math.abs ( addingNumber-(maxValue-lastSum) );
        }
    }
    else if( addingNumber < 0 && lastSum < 0 ) {

        if( sum > 0 || sum < maxValue )
        {
            if(maxValue==Integer.MAX_VALUE){
            MaxValueCounterInt--;
            }
            else if(maxValue==Byte.MAX_VALUE){
                MaxValueCounterByte--;
            }

          return addingNumber-(maxValue-lastSum);
        }
    }

    return sum;


}

public static void exit()
{
    if ( isString ){
        if(stringSum != null){
            printStringAtAll ();
            isString = false;
            stringSum = null;
        }

    }
    if ( isInt ){
        printAndClearIntSumAndByteState();
    }
    if ( isByte ){
        printAndClearByteSumAndIntState();
    }


    isByte = false;

}


    public static void log(String message) {

        if( isInt ){
            printAndClearIntSumAndByteState();

        }
        else if( isByte ){

            printAndClearByteSumAndIntState();

        }
        isInt=false;
        isByte=false;
        if(stringSum==null){
            stringSum=message;
            return;
        }
        else{
            if(stringSum.equals ( message )){
                counterString++;
            }
            else {
                printStringAtAll ();
                stringSum=message;
            }


        }

        isString = true;
    }

    private static void printStringAtAll() {
        if(counterString>1){
            printStringWithCounter ();

        }
        else {
            print(STRING_PREFIX + stringSum);

        }
    }


    /**
     * JavaDoc
     * Remember number in first time
     * Add number to sum another time
     *
     */
    public static void log(int message) {
        if( isString ){
            printStringAtAll ();
            stringSum=null;
            intSum = message;
            isString=false;
        }
        else if ( isByte ) {
            printAndClearByteSumAndIntState();
        }
        else{
            intSum=SumAndCheckMaxValue(message, intSum,Integer.MAX_VALUE);
        }
        isInt=true;

    }
    public static void log(byte message) {
        if(isString){
            printStringAtAll ();
            stringSum = null;
            byteSum = message;
            isString = false;
        }
        else if ( isInt ) {
            printAndClearIntSumAndByteState();
        }
        else{
            byteSum=(byte)SumAndCheckMaxValue(message, byteSum, Byte.MAX_VALUE);
        }
        isByte=true;

    }



    public static void log(char message) {
        print(CHAR_PREFIX + message);
    }

    //
    /**
     * JavaDoc
     * <bold>kfdfgjkhdgjfdhg</bold>
     *
     */
    private static void printMaxValue(int maxValue, int counter) {
        for (int i = 0; i < counter; i++) {
            print ( PRIMITIVE_PREFIX + maxValue);
        }

    }


    private static void printAndClearByteSumAndIntState() {

        print(PRIMITIVE_PREFIX + byteSum);
        printMaxValue ( Byte.MAX_VALUE, MaxValueCounterByte );
        MaxValueCounterByte=0;
        byteSum=0;
        isInt = false;
    }

    private static void printStringState() {

        print(STRING_PREFIX + stringSum);

        MaxValueCounterByte=0;
        byteSum=0;
        isInt = false;
    }
    private static void printAndClearIntSumAndByteState() {

        print(PRIMITIVE_PREFIX + intSum);
        printMaxValue (Integer.MAX_VALUE, MaxValueCounterInt);
        MaxValueCounterInt = 0;
        intSum = 0;
        isByte = false;
    }

    private static void printStringWithCounter() {
        print ( STRING_PREFIX + stringSum + " (x" + counterString + ")" );
        counterString=1;
    }
    private static void print(String message) {
        System.out.println(message);
    }
}


