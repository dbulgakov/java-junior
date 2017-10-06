package com.acme.edu.iteration03;

import com.acme.edu.LoggerFacade;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.exceptions.IllegalMessageException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException, IllegalMessageException {
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
    public void shouldLogIntegersArray() throws IOException, IllegalMessageException {
        //region when
        LoggerFacade.log(new int[]{-1, 0, 1});
        LoggerFacade.stopLogging();
        //endregion

        //region then
        assertSysoutEquals(
                "primitives array: {-1, 0, 1}\n"
        );
        //endregion
    }

    @Test
    public void shouldLogIntegersMatrix() throws IOException, IllegalMessageException {
        //region when
        LoggerFacade.log(new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        LoggerFacade.stopLogging();
        //endregion

        //region then

        assertSysoutEquals(
                "primitives matrix: {\n" +
                        "{-1, 0, 1}\n" +
                        "{1, 2, 3}\n" +
                        "{-1, -2, -3}\n" +
                        "}\n"
        );
        //endregion
    }

//    @Test
//    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
//        //region when
//        SumLogger.log(new int[][][][] {{{{0}}}});
//        //endregion
//
//        //region then
//        assertSysoutEquals(
//            "primitives multimatrix: {\n" +
//                "{\n" + "{\n" + "{\n" +
//                    "0\n" +
//                "}\n" + "}\n" + "}\n" +
//            "}\n"
//        );
//        //endregion
//    }

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException, IllegalMessageException {
        //region when
        LoggerFacade.log("str1", "string 2", "str 3");
        LoggerFacade.stopLogging();
        //endregion

        //region then
        assertSysoutContains("str1\nstring 2\nstr 3");
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException, IllegalMessageException {
        //region when
        LoggerFacade.log(-1, 0, 1, 3);
        LoggerFacade.stopLogging();
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }

    @Test
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException, IllegalMessageException {
        //region when
        LoggerFacade.log(1);
        LoggerFacade.log("str");
        LoggerFacade.log(Integer.MAX_VALUE - 10);
        LoggerFacade.log(11);
        LoggerFacade.stopLogging();
        //endregion

        //region then
        assertSysoutContains("1");
        assertSysoutContains("str");
        assertSysoutContains("1");
        assertSysoutContains(String.valueOf(Integer.MAX_VALUE));
        //endregion
    }
}