package com.acme.edu;

import java.io.File;

import static com.acme.edu.Logger.*;
import static java.io.File.separator;
import java.io.File;
import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Java Coding Style Convention (PDF)
 */
public class Logger {
    public static final String MY_SUPER_CONSTANT = "";
    private static final String PRIMITIVE_PREFIX = "primitive: ";

    private static final String REFERENCE_PREFIX = "reference: ";
    private static final String CHAR_PREFIX = "char: ";

    public static int globalState = 0;
    public int instanceState = 0;

    //region SUM_VARS
    private static byte byteSum=0;
    private static int intSum=0;
    private static String stringSum="";
    // endregion
    //region MAX_MIN_VARS
    private static int MaxValueCounterByte;
    private static int MaxValueCounterInt;
    private static int MinValueCounterByte;
    private static int MinValueCounterInt;
    // endregion
    //region STATES_FOR_LAST_CALLING_METHOD
    private  static boolean isString;
    private  static boolean isInt;
    private  static boolean isByte;
    //endregion


    //region CURRENT_VARS
    private static byte currentByte=0;
    private static int currentInt=0;
    private static String  currentString="";
    // endregion


public static int sum=0;

public static  int SumAndCheckIntMaxValue(int addingNumber)
{
    int sum=addingNumber+intSum;

    if(addingNumber>=0&&intSum>=0) {

        if(sum<0)
        {
            MaxValueCounterInt++;
            intSum=Math.abs ( addingNumber-(Integer.MAX_VALUE-sum) );
        }
    }
    if(addingNumber<=0&&intSum<=0) {

        if(sum>0)
        {
            MaxValueCounterInt--;
            intSum =  addingNumber-(Integer.MAX_VALUE-sum);
        }
    }
return intSum;
}
public static void Exit()
{
    if ( isString ){
        print(REFERENCE_PREFIX + stringSum);
    }
    if ( isInt ){
        System.out.println(PRIMITIVE_PREFIX + intSum);
    }
    if ( isByte ){
        System.out.println(PRIMITIVE_PREFIX + byteSum);
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
        sum = message;
        isString=false;
    }
    else
        if( isInt ){
            sum+=message;

        }
    isInt=true;

       // print(PRIMITIVE_PREFIX+message );

    }

    public static void log(String message) {

        if( isInt ){
            print ( PRIMITIVE_PREFIX+sum );
            sum=0;
            isInt=false;

        }
        print ( REFERENCE_PREFIX + message );
        isString = true;
    }

    public static void log(char message) {
       // print(CHAR_PREFIX + message);
    }
    /**
     * JavaDoc
     * <bold>kfdfgjkhdgjfdhg</bold>
     *
     */

    public static void log(byte message) {

        //print(PRIMITIVE_PREFIX + message);
    }


    private static void print(String message) {
        System.out.println(message);
    }
}

class Main {

    public static void main(String[] args) {
        Logger.log(1);
        Logger.log(0);
        Logger.log(-1);
        Exit();
       // System.out.println(factualMessage);
    }
}
