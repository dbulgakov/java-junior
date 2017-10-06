package com.acme.edu.iteration01;

import com.acme.edu.LoggerFacade;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.exceptions.IllegalMessageException;
import com.acme.edu.exceptions.LoggingException;
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

    @Test
    public void shouldLogInteger() throws LoggingException, IllegalMessageException {
        //region when
        LoggerFacade.log(1);
        LoggerFacade.log(0);
        LoggerFacade.log(-1);
        LoggerFacade.stopLogging();
        //endregion

        //region then
        assertSysoutEquals("primitive: 0\n");
        //endregion
    }

    @Test
    public void shouldLogByte() throws LoggingException, IllegalMessageException {
        //region when
        LoggerFacade.log((byte) 0);
        LoggerFacade.log((byte) -1);
        LoggerFacade.stopLogging();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("-1");

        //endregion
    }

//    TODO: implement SumLogger solution to match specification as tests

    @Test
    public void shouldLogChar() throws LoggingException, IllegalMessageException {
        //region when
        LoggerFacade.log('a');
        LoggerFacade.log('b');
        LoggerFacade.stopLogging();
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }


    @Test
    public void shouldLogString() throws LoggingException, IllegalMessageException {
        //region when
        LoggerFacade.log("test string 1");
        LoggerFacade.log("other str");
        LoggerFacade.stopLogging();
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }



    @Test
    public void shouldLogBoolean() throws LoggingException, IllegalMessageException {
        //region when
        LoggerFacade.log(true);
        LoggerFacade.log(false);
        LoggerFacade.stopLogging();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws LoggingException, IllegalMessageException {
        //region when
        LoggerFacade.log(new Object());
        LoggerFacade.stopLogging();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }

}