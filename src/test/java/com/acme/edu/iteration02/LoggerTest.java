package com.acme.edu.iteration02;

import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.implementations.Logger;
import com.acme.edu.implementations.exceptions.LoggerException;
import com.acme.edu.implementations.exceptions.SaverException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
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



    /*
    TODO: implement Logger solution to match specification as tests */
    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException, LoggerException {
        //region when
        Logger.log("str");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        //endregion
        Logger.stopLogging ();
        //region then
        assertSysoutContains ("str" );
        assertSysoutContains ("3" );
        assertSysoutContains ("str 2");
        assertSysoutContains ("0");
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws LoggerException {
        //region when
        Logger.log("str 1");
        Logger.log(-10);
        Logger.log(Integer.MIN_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.stopLogging ();
        //endregion

        //region then
        assertSysoutContains( "str 1" );
        assertSysoutContains("-10" );
        assertSysoutContains(Integer.MIN_VALUE + "") ;
        assertSysoutContains("str 2");
        assertSysoutContains("0");
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() throws LoggerException {
        //region when
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log(Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.stopLogging ();
        //endregion

        //region then
        assertSysoutContains("str 1");
        assertSysoutContains("10" );
        assertSysoutContains(Byte.MAX_VALUE + "" );
        assertSysoutContains("str 2");
        assertSysoutContains("0");
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException, LoggerException {
        //region when
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.stopLogging ();
        //endregion

        //region then
        assertSysoutContains ("str 1");
        assertSysoutContains ("str 2 (x2)");

        assertSysoutContains ("0" );
        assertSysoutContains ( "string: str 2" );
        assertSysoutContains ( "str 3 (x3)" );
        //endregion
    }
	
	@Test(expected = LoggerException.class)
	public void shouldGetExceptionWhenLogOperationAndSavingException() throws LoggerException {
		Logger.saver = message -> {
			throw new SaverException ();
		};
		Logger.log ( "test message" );
		Logger.stopLogging ();
	}
}