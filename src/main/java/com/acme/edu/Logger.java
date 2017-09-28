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




public static  void checkIntMaxValue(int addingNumber)
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

}
public static void Exit()
{
    if(isString)System.out.println(stringSum);
    if(isInt)System.out.println(intSum);
    if(isByte)System.out.println(byteSum);

}
    public static void log(int message) {

        //если были байты а теперь инты просто все сбрасываем
        if(isByte&!isString)//cбрасываем байты и
        {
            System.out.println(byteSum);
            isString=false;
            isByte=false;
        }
        else{
            //если была строка и не было инта запоминаем инт
            if(isString&!isInt){
            currentInt=message;
            }
            //если была строка и был инт сбрасываем строку и начинаем суммирвать инты
            if(isString&isInt)
            {
                System.out.println(stringSum);
                stringSum="";
                intSum+=currentInt+message;
                currentInt=0;
                isString=false;
            }
        }
        isInt=true;

       //пока ничего не делаем
       // print(PRIMITIVE_PREFIX+message );

    }
    /**
     * JavaDoc
     * <bold>kfdfgjkhdgjfdhg</bold>
     *
     */
    public static void log(byte message) {
        if(isInt&!isString){
            System.out.println(intSum);
            isInt=false;
        }
        else{
            if(isString&!isByte)
            {
                currentByte=message;

            }
            if ( isString & isByte ) {
                System.out.println ( stringSum );
                stringSum = "";
                byteSum += currentByte + message;
                currentByte = 0;
                isString = false;

            }
        }
        isByte=true;

        //print(PRIMITIVE_PREFIX + message);
    }

    /**
     * public API
     */
    public static void log(String message) {

    if(!isString)
    {
        isString=true;
        if(isByte){
            isByte=false;
            System.out.println(byteSum);
            byteSum=0;
        }
        if(isInt) {
            isInt=false;
            System.out.println(intSum);
            intSum=0;
        }
    }

        stringSum+=message;
        isString=true;



       // print(PRIMITIVE_PREFIX + message);
    }

    public static void log(char message) {
       // print(CHAR_PREFIX + message);
    }


    public static void main(String... args) {
        int local = 0;
        //kdjfhgkjfgh
        log(1);
//        Main.main();
//        Main.counter = 1;
    }

    private static void print(String message) {
        System.out.println(message);
    }
}

class Main {
    public static int counter = 0;

    static {
        System.out.println("Hello!");
        counter = 1;
    }

    public void m() {

    }

    /**
     * java -Xss2m -Xms4G -Xmx4G
     */
    public static void main(String[] args) {

Logger.log("str");
log(1);
log(2);
        Logger.log("str");
        Logger.log(0);
Exit();
       // System.out.println(factualMessage);
    }
}
