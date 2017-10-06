package com.acme.edu.iteration04;

import com.acme.edu.LoggerFacade;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.controller.LoggerController;
import com.acme.edu.controller.SequenceLoggerController;
import com.acme.edu.encoder.ShaStringEncoder;
import com.acme.edu.exceptions.DataSaveException;
import com.acme.edu.exceptions.IllegalMessageException;
import com.acme.edu.exceptions.LoggingException;
import com.acme.edu.formatter.PrefixFormatter;
import com.acme.edu.messages.Message;
import com.acme.edu.messages.types.IntegerMessage;
import com.acme.edu.messages.types.StopMessage;
import com.acme.edu.saver.ConsoleDataSaver;
import com.acme.edu.saver.ThrowDataSaver;
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
    public void shouldThrowMessageExceptionWhenNullMessage() throws LoggingException, IllegalMessageException {
        LoggerFacade.log((Object) null);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldCorrectlyManageNoSaverException() throws IllegalMessageException, DataSaveException {
        Message intMessage = new IntegerMessage(1);
        intMessage.setFormatter(new PrefixFormatter());
        intMessage.save();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldCorrectlyManageNoFormatterException() throws IllegalMessageException, DataSaveException {
        Message intMessage = new IntegerMessage(1);
        intMessage.setDataSaver(new ConsoleDataSaver());
        intMessage.save();
    }

    @Test(expected = DataSaveException.class)
    public void shouldCorrectlyThrowDataExceptionWhenIoError() throws IllegalMessageException, DataSaveException {
        Message intMessage = new IntegerMessage(1);
        intMessage.setDataSaver(new ThrowDataSaver());
        intMessage.setFormatter(new PrefixFormatter());
        intMessage.save();
    }

    @Test(expected = LoggingException.class)
    public void shouldThrowLoggingExceptionWhenIoException() throws IllegalMessageException, LoggingException {
        LoggerController lc = new SequenceLoggerController(new PrefixFormatter(), new ThrowDataSaver(), new ShaStringEncoder());
        lc.logMessage(new IntegerMessage(1));
        lc.logMessage(new StopMessage());
    }
}
