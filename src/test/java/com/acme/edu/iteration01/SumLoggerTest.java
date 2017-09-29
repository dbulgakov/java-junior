package com.acme.edu.iteration01;

import com.acme.edu.implementations.ConsolePrinter;
import com.acme.edu.implementations.SumLogger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.implementations.TypedFormatter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class SumLoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldLogInteger() throws IOException {
        //region when
        SumLogger sumLogger = new SumLogger(new ConsolePrinter(), new TypedFormatter());

        sumLogger.log(1);
        sumLogger.log(0);
        sumLogger.log(-1);
        sumLogger.stopLogging();

        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 1\nprimitive: -1\n");
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        SumLogger sumLogger = new SumLogger(new ConsolePrinter(), new TypedFormatter());

        sumLogger.log((byte)0);
        sumLogger.log((byte)-1);
        sumLogger.stopLogging();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("-1");

        //endregion
    }

//    TODO: implement SumLogger solution to match specification as tests

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        SumLogger sumLogger = new SumLogger(new ConsolePrinter(), new TypedFormatter());

        sumLogger.log('a');
        sumLogger.log('b');
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }
    /*

    @Test
    public void shouldLogString() throws IOException {
        //region when
        SumLogger.log("test string 1");
        SumLogger.log("other str");
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        SumLogger.log(true);
        SumLogger.log(false);
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        //region when
        SumLogger.log(new Object());
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }

    */
}