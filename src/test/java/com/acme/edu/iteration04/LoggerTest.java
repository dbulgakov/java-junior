package com.acme.edu.iteration04;

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
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test(expected = IllegalMessageException.class)
    public void shouldThrowExceptionWhenNullMessage() throws IllegalMessageException{
        LoggerFacade.log((Object) null);
    }
}
