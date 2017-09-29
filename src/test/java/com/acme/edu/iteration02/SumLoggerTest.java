package com.acme.edu.iteration02;

import com.acme.edu.implementations.ConsoleSaver;
import com.acme.edu.implementations.SumLogger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.implementations.TypedFormatter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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


    //TODO: implement SumLogger solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        SumLogger sumLogger = new SumLogger(new ConsoleSaver(), new TypedFormatter());

        sumLogger.log("str 1");
        sumLogger.log(1);
        sumLogger.log(2);
        sumLogger.log("str 2");
        sumLogger.log(0);
        sumLogger.stopLogging();
        //endregion

        //region then
        assertSysoutContains("str 1");
        assertSysoutContains("3");
        assertSysoutContains("str 2");
        assertSysoutContains("0");
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        SumLogger sumLogger = new SumLogger(new ConsoleSaver(), new TypedFormatter());

        sumLogger.log("str 1");
        sumLogger.log(10);
        sumLogger.log(Integer.MAX_VALUE);
        sumLogger.log("str 2");
        sumLogger.log(0);
        //endregion

        //region then
        assertSysoutContains("str 1");
        assertSysoutContains("10");
        assertSysoutContains(String.valueOf(Integer.MAX_VALUE));
        assertSysoutContains("str 2");
        assertSysoutContains("0");
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        SumLogger sumLogger = new SumLogger(new ConsoleSaver(), new TypedFormatter());

        sumLogger.log("str 1");
        sumLogger.log((byte)10);
        sumLogger.log(Byte.MAX_VALUE);
        sumLogger.log("str 2");
        sumLogger.log(0);
        //endregion

        //region then
        assertSysoutContains("str 1");
        assertSysoutContains("10");
        assertSysoutContains(String.valueOf(Byte.MAX_VALUE));
        assertSysoutContains("str 2");
        assertSysoutContains("0");
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        SumLogger sumLogger = new SumLogger(new ConsoleSaver(), new TypedFormatter());

        sumLogger.log("str 1");
        sumLogger.log("str 2");
        sumLogger.log("str 2");
        sumLogger.log(0);
        sumLogger.log("str 2");
        sumLogger.log("str 3");
        sumLogger.log("str 3");
        sumLogger.log("str 3");
        sumLogger.stopLogging();
        //endregion

        //region then
        assertSysoutContains("str 1");
        assertSysoutContains("str 2 (x2)");
        assertSysoutContains("0");
        assertSysoutContains("str 2");
        assertSysoutContains("str 3 (x3)");
        //endregion
    }
}